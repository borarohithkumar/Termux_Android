import java.util.Scanner;
class InCh2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < 254) {
				sb.append((char)(s.charAt(i) + 2));
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
