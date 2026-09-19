import java.util.Scanner;
class DigCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for (int i = 0; i < s.length(); i++) {
			if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) >= 'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
				System.out.println("False");
				return;
			}
		}
		System.out.println("True");
		sc.close();
	}
}
