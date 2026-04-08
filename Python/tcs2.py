def fraud_trans(arr, timer):
    trans_map = {}
    c=0
    for t in arr:
        c+=1
        send, receive, amount, timestamp = t
        key = (send, receive, amount)
        if key in trans_map and timestamp - trans_map[key] <= timer:
            return f"Fraud Transaction_{c}: {t}"
        trans_map[key] = timestamp
    return "No Fraud Detected"
n = int(input("Enter no. of Transactions: "))
trans = []
timer = int(input("Enter Timeframe: "))
for i in range(n):
    print(f"Transaction_{i+1}")
    s = input("Sender?: ")
    r = input("Receiver?: ")
    a = int(input("Amount?: "))
    t = int(input("Timestamp?: "))
    trans.append([s, r, a, t])
print(fraud_trans(trans, timer))
