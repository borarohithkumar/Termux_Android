class D3 {
	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		int arr2[] = { 9, 13, 3, 11, 7 };
		int outArr[] = new int[arr2.length];
		int k = 0;
		for (int i = 0; i < arr1.length - 1; i += 2) {
			int found = -1;
			for (int j = 0; j < arr2.length; j++) {
				if ((arr1[i] + arr1[i + 1]) == arr2[j]) {
					found = j;
					break;
				}
			}
			if (found == -1) {
				outArr[k] = -1;
			}
			else {
				outArr[k] = arr2[found];
			}
			k++;
		}
	}
}
