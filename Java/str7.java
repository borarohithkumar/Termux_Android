import java.util.Scanner;
class RmDup {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		boolean visited[] = new boolean[256];
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			if (!(visited[str.charAt(i)])) {
				sb.append(str.charAt(i));
				visited[str.charAt(i)] = true;
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}
}
