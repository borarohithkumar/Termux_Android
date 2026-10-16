class ValiDate {
	static int valiDay(int[] arr) {
		if (arr.length != 3 || arr[0] < 1 || arr[0] > 31 || arr[1] < 1 || arr[1] > 12 || arr[2] < 1000 || arr[2] > 9999) {
			return -1;
		}
		int q = arr[0];
		int m = arr[1];
		int y = arr[2];
		if (m == 4 && q > 30 || m == 6 && q > 30 || m == 9 && q > 30 || m == 11 && q > 30) {
			return -1;
		}
		if (m == 2) {
			boolean isLeap = ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0);
			if (q > 28 && !isLeap) {
				return -1;
			}
			if (q > 29 && isLeap) {
				return -1;
			}

		}
		if (arr[1] == 1) {
			m = 13;
			y--;
		}
		else if (arr[1] == 2) {
			m = 14;
			y--;
		}
		int K = y % 100;
		int J = y / 100;
		int h = (q + ((13 * (m + 1)) / 5) + K + (K / 4) + (J / 4) + (5 * J)) % 7;
		return h;
	}
	public static void main(String[] args) {
		int arr1[] = {31, 12, 2001};
		int arr2[] = {29, 2, 2001};
		System.out.println(valiDay(arr1));
		System.out.println(valiDay(arr2));
	}
}
