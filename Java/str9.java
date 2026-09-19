import java.util.Scanner;
class DigStr {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		char ch;
		boolean num = false;
		int n = 0;
		for(int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch >= '0' && ch <= '9') {
				num = true;
				sb.append(ch);
				n = n * 10 + (int)(ch - '0');
			}
			else if (num){
				sum += n;
				num = false;
				n = 0;
			}
		}
		if (num) {
			    sum += n;
		}
		System.out.println(sb.append(sum).toString()); 
		sc.close();
	}
}
