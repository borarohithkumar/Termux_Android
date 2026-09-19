class D2 {
	public static void main(String[] args) {
		int arr1[] = {0, 2, 4, 6};
		int arr2[] = {0, 1, 3, 4, 5, 6, 7, 8, 9};
		for (int i = 0; i < arr1.length; i++) {
			int found = -1;
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					found = i;
					break;
				}
			}
			if (found == -1) {
				System.out.println(-1);
			}
			else {
				System.out.println(arr1[found]);
			}
		}
	}
}
