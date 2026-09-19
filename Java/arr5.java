class ModStrArr {
	public static void main(String[] args) {
		String[] arr = { "892", "40", "1574" };
		StringBuilder sb = new StringBuilder();
		String str;
		for (int i = 0; i < arr.length; i++) {
			str = arr[i];
			sb.append(str.charAt(str.length() - 1));
			for (int j = 1; j < str.length() - 1; j++) {
				sb.append(str.charAt(j));
			}
			sb.append(arr[i].charAt(0));
			arr[i] = sb.toString();
			sb.setLength(0);
		}
		for (String i : arr) {
			System.out.print(i + " ");
		}
	}
}
