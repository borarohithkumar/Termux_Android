class PriorNotifs {
	public static void main(String[] args) {
		String arr[] = { "A1", "C4", "B7", "D2" };
		int oArr[] = new int[arr.length];
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i].charAt(arr[i].length() - 1) - '0') < 5) {
				oArr[j++] = (arr[i].charAt(arr[i].length() - 1) - '0') * (arr[i].charAt(0) - 'A' + 1);
			}
		}
		for (int i = 0; i < j; i++) {
			System.out.print(oArr[i] + " ");
		}
	}
}
