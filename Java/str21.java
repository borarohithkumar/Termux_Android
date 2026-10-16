class SymbsEnd {
	static String process(String s) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >=  'a' && s.charAt(i) <= 'z' || s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				sb1.append(s.charAt(i));
			}
			else {
				sb2.append(s.charAt(i));
			}
		}
		return sb1.append(sb2).toString();
	}
	public static void main(String[] args) {
		String s1 = "He@#$llo!*&";
		String s2 = "%$Wel*&come!";
		System.out.println(process(s1));
		System.out.println(process(s2));
	}	
}
