class SumDigs {
	public static void main(String[] args) {
		int arr[] = {123, 99, 1001, 7};
		int min = Integer.MAX_VALUE;
		int	max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			int sum = 0;
			while (temp > 0) {
				sum += temp % 10;
				temp /= 10;
			}
			if (sum < min) {
				min = sum;
			}
			if (sum > max) {
				max = sum;
			}
		}
		System.out.println(max - min);
	}
}
