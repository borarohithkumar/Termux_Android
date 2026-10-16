class sql {
	static int avg(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum / arr.length;
	}
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= avg(arr)) {
				System.out.println(arr[i]);
			}
	}
}
