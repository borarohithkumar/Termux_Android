import java.util.Scanner;
class Div2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter n1: ");
		int n1 = sc.nextInt();
		System.out.print("Enter n2: ");
		int n2 = sc.nextInt();
		int temp = n1;
		int dig = 0;
		int count = 0;
		while (temp > 0) {
			dig = temp % 10;
			if (dig % n2 == 0) {
				count++;
			}
			temp /= 10;
		}
		if ((count & 1) == 1) {
			System.out.println("count: " + count + "\no/p: " + (2 * n2));
		}
		else {
			System.out.println("count: " + count + "\no/p: " + (2 * count));
		}
		sc.close();
	}
}
