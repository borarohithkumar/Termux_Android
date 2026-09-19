import java.util.Scanner;
class SepDigCAlp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' || s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				sb1.append(s.charAt(i));
			}
			else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				sb2.append(s.charAt(i));
			}
		}
		System.out.println(sb1.toString());
		System.out.println(sb2.toString());
		sc.close();
	}
}
