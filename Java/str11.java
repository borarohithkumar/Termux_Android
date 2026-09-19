import java.util.Scanner;
class LongSubStr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		boolean seen[] = new boolean[256];
		int l = 0;
		int	maxL = 0;
		for (int r = 0; r < str.length(); r++) {
			while (seen[str.charAt(r)]) {
				seen[str.charAt(l)] = false;
				l++;
			}
			seen[str.charAt(r)] = true;
			if (maxL < (r - l + 1)) {
				maxL = r - l + 1;
			}
		}
		System.out.println(maxL);
		sc.close();
	}
}
