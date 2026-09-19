class RmVowels {
	public static String rmVows(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			char c = Character.toLowerCase(s.charAt(i));
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				continue;
			}
			else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String s = "Mysore";
		System.out.println(rmVows(s));
	}
}
