import java.util.Scanner;
import java.util.Arrays;
class RotArr {
	public static void rotArr(int l, int r, char arr[]) {
		char temp;
		while (l < r) {
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			l++;
			r--;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char arr[] = new char[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.next().charAt(0);
		}
		if (n < 2 || m == n || m < 1) {
			System.out.println("Rot Arr: " + arr);
		}
		m %= n;
		rotArr(0, n - 1, arr);
		rotArr(0, m - 1, arr);
		rotArr(m, n - 1, arr);
		System.out.print("Rot Arr: ");
		System.out.println(Arrays.toString(arr));
		sc.close();
	}
}
