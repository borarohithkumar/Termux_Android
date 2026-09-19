import java.util.Scanner;
class VowStrCon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		if (str.length() > 1 && str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u' || str.charAt(0) == 'A' || str.charAt(0) == 'E' || str.charAt(0) == 'I' || str.charAt(0) == 'O' || str.charAt(0) == 'U' && str.charAt(str.length() - 1) >= 'b' && str.charAt(str.length() - 1) <= 'z' || str.charAt(str.length() - 1) >= 'B' && str.charAt(str.length() - 1) <= 'Z' && str.charAt(str.length() - 1) != 'e' && str.charAt(str.length() - 1) != 'i' && str.charAt(str.length() - 1) != 'o' && str.charAt(str.length() - 1) != 'u' && str.charAt(str.length() - 1) != 'E' && str.charAt(str.length() - 1) != 'I' && str.charAt(str.length() - 1) != 'O' && str.charAt(str.length() - 1) != 'U') {
			System.out.println("True");
			return;
		}
		System.out.println("False");
		sc.close();
	}
}
