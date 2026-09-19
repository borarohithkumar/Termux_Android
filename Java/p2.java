import java.util.Scanner;
import java.util.ArrayList;
class P3 {
	static void perm(String str, StringBuilder sb, boolean used[], ArrayList<String> list) {
		if (sb.length() == str.length()) {
			list.add(sb.toString());
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			if (used[i] || i > 0 && str.charAt(i) == str.charAt(i - 1) && !used[i - 1]) {
				continue;
			}
			sb.append(str.charAt(i));
			used[i] = true;
			perm(str, sb, used, list);
			used[i] = false;
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		boolean used[] = new boolean[str.length()];
		ArrayList<String> list = new ArrayList<String>();
		perm(str, sb, used, list);
		for (String s : list) {
			System.out.println(s);
		}
		sc.close();
	}
}
