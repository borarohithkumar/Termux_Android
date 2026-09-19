class IntArryStr {
	public static void main(String[] args) {
		int arr[] = { 22, 11, 405, 9, 100 };
		StringBuilder sb = new StringBuilder();
		int temp;
		int sum;
		for (int i = 0; i < arr.length; i++) {
			temp = arr[i];
			sum = 0;
			while (temp > 0) {
				sum += temp % 10;
				temp /= 10;
			}
			if ((sum & 1) == 0) {
				if (sb.length() > 0) {
					sb.append("?");
				}
				sb.append(arr[i]);
			}
		}
		if (sb.length() == 0) {
			System.out.println("0");
		}
		else {
			System.out.println(sb.toString());
		}
	}
}
