class Reorder {
	static void reOrderArr(int arr[]) {
		if (arr.length <= 1) {
			System.out.println(arr[0]);
			return;
		}
		int midIndex = arr.length / 2;
		int j = 0;
		int outIntArr[] = new int[arr.length];
		if ((midIndex & 1) == 0) {
			for (int i = midIndex + 1; i < arr.length; i++) {
				outIntArr[j++] = arr[i];
			}
			outIntArr[j++] = arr[midIndex];
			for (int i = 0; i < midIndex; i++) {
				outIntArr[j++] = arr[i];
			}
		}
		else {
			for (int i = 1; i < arr.length; i += 2) {
				outIntArr[j++] = arr[i];
			}
			for (int i = 0; i < arr.length; i += 2) {
				outIntArr[j++] = arr[i];
			}
		}
		for (int i = 0; i < outIntArr.length; i++) {
			System.out.print(outIntArr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int inIntArr1[] = {10, 15, 20, 25, 30};
		int inIntArr2[] = {1, 2, 3, 4, 5, 6, 7};
		reOrderArr(inIntArr1);
		reOrderArr(inIntArr2);
	}
}
