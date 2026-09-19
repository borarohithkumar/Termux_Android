import java.util.Scanner;
class ReplaceChar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String s = sc.nextLine();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				sb.append('@');
			}
			else {
				sb.append(s.charAt(i));
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
