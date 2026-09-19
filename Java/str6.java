import java.util.Scanner;
class MaxFreqChar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] freq = new int[256];
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i)]++;
		}
		int maxFreq = freq[0];
		int freqElem = 0;
		for (int i = 1; i < freq.length; i++) {
			if (freq[i] > maxFreq) {
				maxFreq = freq[i];
				freqElem = i;
			}
		}
		System.out.println((char) freqElem + ": " + maxFreq);
		sc.close();
	}
}
