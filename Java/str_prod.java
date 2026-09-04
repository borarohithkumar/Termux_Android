import java.util.Scanner;
class StrProd {
	public static String prodStr(String inStr) {
		if (inStr.length() < 3) {
			return "Y";
		}
		int ascii = 0;
		int temp = 0;
		int prod = 1;
		StringBuilder outStr = new StringBuilder();
		for(int i = 0; i < inStr.length(); i++) {
			ascii = (int) inStr.charAt(i);
			temp = ascii;
			prod = 1;
			while (temp > 0) {
				prod *= temp % 10;
				temp /= 10;
			}
			if (prod > 32) {
				outStr.append((char) prod);
			}
			else {
				outStr.append("%");
			}
		}
		return outStr.toString();
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter String: ");
		String str = sc.next();
		System.out.println(prodStr(str));
	}
}
