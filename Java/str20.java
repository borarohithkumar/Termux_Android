class Abbrev {
	public static void main(String[] args) {
		String s = "Info Learn Plat";
		StringBuilder sb = new StringBuilder();
		int r = 0;
		while (r < s.length()) {
			while (r < s.length() && s.charAt(r) == ' ') {
				r++;
			}
			int i = r;
			char ch = ' ';
			if (r < s.length()) {
				ch = s.charAt(r);
			}
			while (r < s.length() && s.charAt(r) != ' ') {
				r++;
			}
			int c = r - i;
			if (ch != ' ' && c == 2) {
				sb.append(Character.toLowerCase(ch));
			}
			else if (ch != ' ' && c > 2) {
				sb.append(Character.toUpperCase(ch));
			}
		}
		System.out.println(sb.toString());
	}
}
