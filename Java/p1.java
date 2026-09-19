class P2 {
	public static void main(String[] args) {
		String wordArr[] = { "apple" , "code", "sky" };
		String str;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < wordArr.length; i++) {
			str = wordArr[i];
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'a' || str.charAt(j) == 'e' || str.charAt(j) == 'i' || str.charAt(j) == 'o' || str.charAt(j) == 'u') {
					if (sb.length() > 0) {
						sb.append("-");
					}
					sb.append(j + 1);
				}
			}
		}
		if (sb.length() > 0) {
			System.out.println(sb.toString());
		}
		else {
			System.out.println("No Vowels");
		}
	}
}
