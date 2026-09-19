import java.util.Scanner;
class LexCompStr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = sc.nextInt();
		String sSubStr = s.substring(0, n);
		String lSubStr = s.substring(0, n);
		String rSubStr;
		for (int i = 1; i <= s.length() - n ; i++) {
			rSubStr = s.substring(i, i + n);
			if (sSubStr.compareTo(rSubStr) > 0) {
				sSubStr = rSubStr;
			}
			if (lSubStr.compareTo(rSubStr) < 0) {
				lSubStr = rSubStr;
			}
		}
		System.out.println(sSubStr);
		System.out.println(lSubStr);
		sc.close();
	}
}
