class demo {
	public static void main(String[] args) {
		int arr[] = {1, 2, 1, 2, 1, 2, 4, 3, 3, 4, 5, 6};
		for (int i = 0; i < arr.length; i++) {
			boolean seen = false;
			for (int k = 0; k < i; k++) {
				if (arr[i] == arr[k]) {
					seen = true;
				}
			}
			if (seen) {
				continue;
			}
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			System.out.println(arr[i] + " has " + count);
		}
	}
}
