class demo3 {
	public static void main(String[] args) {
		String s = "";
		int arr[] = { 121, 234, 7, 1234321 };
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 10) {
				continue;
			}
			if (arr[i] % 10 == 0) {
				s += "NA";
				continue;
			}
			int temp = arr[i];
			int rev = 0;
			int d = 0;
			while (rev < temp) {
				d += 1;
				rev = rev * 10 + temp % 10;
				temp /= 10;
			}
			if (rev == temp) {
				d *= 2;
				s += "" + d;
			}
			else if (rev / 10 == temp) {
				d *= 2;
				s += "" + (d - 1);
			}
			else {
				s += "NA";
			}
		}
		System.out.println(s);
	}
}
