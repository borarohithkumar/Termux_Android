class MaxSubFreq {
	static int countFreq(int[] arr) {
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[i - 1]) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int[] arr1 = {1,1,5,100,-20,6,0,0};
		int[] arr2 = {5,6,6,6, 12, 1,1,0, 0};
		System.out.println(countFreq(arr1));
		System.out.println(countFreq(arr2));
	}
}
