import java.util.Scanner;
class Demo {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter sc: ");
		char sc = s.next().charAt(0);
		System.out.println("Enter lc: ");
		char lc = s.next().charAt(0);
		for(int i = sc; i <= lc; i++) {
			System.out.println(i);
		}
	}
}
