import java.util.Scanner;
class DigStr {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		boolean num = false;
		int n = 0;
		for(int i = 0; i <= str.length(); i++) {
			if (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				num = true;
				sb.append(str.charAt(i));
				n = n * 10 + (int)(str.charAt(i) - '0');
			}
			else if (num) {
				sum += n;
				num = false;
				n = 0;
			}
		}
		System.out.println(sb.append(sum).toString()); 
		sc.close();
	}
}
