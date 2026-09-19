import java.util.Scanner;
class LowUpCh {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				sb.append(Character.toUpperCase(s.charAt(i)));
			}
			else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				sb.append(Character.toLowerCase(s.charAt(i)));
			}
			else {
				sb.append(s.charAt(i));
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
