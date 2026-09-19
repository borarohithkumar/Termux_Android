import java.util.Scanner;
class Palindrome {
	public static boolean isPalindrome(String s) {
		if (s == null || s.length() < 2) {
			return true;
		}
		int l = 0;
		int r = s.length() - 1;
		while (l < r) {
			while (l < r && s.charAt(l) == ' ') {
				l++;
			}
			while (l < r && s.charAt(r) == ' ') {
				r--;
			}
			if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if (isPalindrome(s)) {
			System.out.println("A Palindrome");
		} else {
			System.out.println("Not a Palindrome");
		}
		sc.close();
	}
}
