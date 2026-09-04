import java.util.Scanner;
class DigFreq {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter No.: ");
		long n = sc.nextLong();
		int freq[] = new int[10];
		long temp = n;
		int dig = 0;
		while (temp > 0) {
			dig = (int) (temp % 10);
			freq[dig]++;
			temp /= 10;
		}
		for(int i = 0; i < 10; i++) {
			if (freq[i] > 0) {
				System.out.println(i + " : " + freq[i]);
			}
		}
		sc.close();
	}
}
