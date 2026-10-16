import java.util.Arrays;
class prefixsum {
	public static void main(String[] args) {
		int arr[] = { 8, 2, 14 };
		int outArr[] = new int[arr.length];
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			outArr[i] = sum;
		}
		System.out.println(Arrays.toString(outArr));
	}
}
