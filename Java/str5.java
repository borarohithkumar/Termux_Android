import java.util.Scanner;
class Anagram {
	public static String isAngm(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return "Not Anagram";
		}
		int freq[] = new int[256];
		for(int i = 0; i < str1.length(); i++) {
			freq[(int) str1.charAt(i)]++;
			freq[(int) str2.charAt(i)]--;
		}
		for(int i : freq) {
			if (i > 0) {
				return "Not Anagram";
			}
		}
		return "Anagram";
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println(isAngm(s1, s2));
		sc.close();
	}
}
