class D6 {

	static int procDigs(int n) {
		int temp = n;
		int lastDig;
		int sum = 0;
		while (temp > 0) {
			lastDig = temp % 10;
			sum = sum + lastDig;
			temp = temp / 10;
		}
		if ((sum & 1) == 0) {
			return n;
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = { 22, 170, 34, 1771 };
		int outArr[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			outArr[i] = procDigs(arr[i]);
			System.out.print(outArr[i] + " ");
		}
	}
}

