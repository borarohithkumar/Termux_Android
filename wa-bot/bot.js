const dotenv = require('dotenv');
dotenv.config();
const { default: makeWASocket, useMultiFileAuthState, DisconnectReason } = require('@whiskeysockets/baileys');
const pino = require('pino');

// 1. YOUR phone number (with country code, no + or spaces)
const myNumber = process.env.wa_self_no;

// 2. HER phone number (with country code, no + or spaces)
const herNumber = process.env.wa_dest_no;

// Load messages and filter out any undefined/empty ones
const messages = [
    process.env.one,
    process.env.two,
    process.env.three,
    process.env.four,
    process.env.five,
    process.env.six,
    process.env.seven,
    process.env.eight,
    process.env.nine,
].filter(Boolean);

const intervalTime = 10000; // in milliseconds
let messageInterval; // Declare globally so we can clear it on reconnects

async function startBot() {
    const { state, saveCreds } = await useMultiFileAuthState('auth_session');

    const sock = makeWASocket({
        auth: state,
        printQRInTerminal: false,
        logger: pino({ level: 'silent' }) // Keeps terminal clean
    });

    sock.ev.on('creds.update', saveCreds);

    // Request pairing code ONLY if not registered.
    // A 3-second timeout is standard for Baileys to ensure the socket is initialized.
    if (!sock.authState.creds.registered) {
        setTimeout(async () => {
            try {
                const code = await sock.requestPairingCode(myNumber);
                console.log(`\n[!] ACTION REQUIRED:`);
                console.log(`1. Open WhatsApp -> Linked Devices -> Link a Device -> Link with phone number`);
                console.log(`2. Enter this Pairing Code: ${code}\n`);
            } catch (err) {
                console.log('[-] Pairing code error:', err.message);
            }
        }, 3000);
    }

    sock.ev.on('connection.update', async (update) => {
        const { connection, lastDisconnect } = update;

        if (connection === 'close') {
            // STOP the loop if the connection drops to prevent sending errors
            if (messageInterval) clearInterval(messageInterval);

            const shouldReconnect = lastDisconnect.error?.output?.statusCode !== DisconnectReason.loggedOut;
            console.log('\n[-] Connection closed.', shouldReconnect ? 'Reconnecting...' : 'Logged out.');
            
            if (shouldReconnect) {
                startBot();
            } else {
                console.log('[-] Logged out. Delete the "auth_session" folder and restart.');
            }
        } else if (connection === 'open') {
            console.log('[+] Connected successfully! Starting the background loop...');

            // Clear any existing intervals just in case to prevent duplicates
            if (messageInterval) clearInterval(messageInterval);

            const targetJid = `${herNumber}@s.whatsapp.net`;

            // Start the message loop
            messageInterval = setInterval(async () => {
                if (messages.length === 0) {
                    console.log('[-] Error: No messages found in .env file.');
                    return;
                }

                // Pick a random message
                const msg = messages[Math.floor(Math.random() * messages.length)];

                try {
                    await sock.sendMessage(targetJid, { text: msg });
                    console.log(`[+] Sent: ${msg}`);
                } catch (err) {
                    console.log(`[-] Failed to send: ${err.message}`);
                }
            }, intervalTime);
        }
    });
}

// Basic check to make sure you didn't forget your .env variables
if (!myNumber || !herNumber) {
    console.error("[-] FATAL ERROR: wa_self_no or wa_dest_no is missing in your .env file!");
} else {
    startBot();
}
