class MulDigs {
	public static void main(String[] args) {
		int arr[] = { 102, 305, 47 };
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			int mul = 1;
			while (temp > 0) {
				if (temp % 10 != 0) {
					mul *= temp % 10;
				}
				temp = temp / 10;
			}
			arr[i] = mul;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
