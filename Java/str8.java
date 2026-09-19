import java.util.Scanner;
class RmDup {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!(ch == 'a' || ch == 'A' || ch == 'b' || ch == 'B')) {
				sb.append(ch);
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
