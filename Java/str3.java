import java.util.Scanner;
class CharCount {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int alphaC = 0;
		int vowelC = 0;
		int ch;
		for(char i = 0; i < s.length(); i++) {
			ch = Character.toLowerCase(s.charAt(i));
			if (ch == 97 || ch == 101 || ch == 105 || ch == 111 || ch == 117) {
				vowelC++;
			}
			else if (ch >= 97 && ch <= 122) {
				alphaC++;
			}
			
		}
		System.out.println("No.of Vowels: " + vowelC);
		System.out.println("No.of Consonants: " + alphaC);
		sc.close();
	}
}
