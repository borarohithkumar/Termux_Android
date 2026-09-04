import java.util.Scanner;
class EMS {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		int arr[][] = new int[r][c];
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int count = 0;
		for(int i = 0; i < r; i++) {
			count = 0;
			for(int j = 0; j < c; j++) {
				if (arr[i][j] == 1) {
					count++;
				}
			}
			if (count > c/2) {
				str.append(i).append(',');
			}
		}
		str.toString();
		if (str.equals("")) {
			System.out.println("No Employee Eligible");
		}
		else {
			System.out.println("Eligible Employees: " + str.substring(0, str.length() - 1));
		}
		sc.close();
	}
}
