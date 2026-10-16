class PopulNums {
	public static void main(String[] args) {
		int n1 = -20;
		int n2 = 30;
		if (n1 < 0) {
			n1 = 1;
			if (n2 < n1) {
				System.out.println("Invalid Range");
				return;
			}
		}
		int arr[] = new int[n2 - n1 + 1];
		int j = 0;
		for (int i = n1; i <= n2; i++) {
			if (i % 3 == 0 && (i % 10 == 0 || i % 10 == 5)) {
				arr[j++] = i;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
