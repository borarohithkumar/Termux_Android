class AngmPair {
	public static String isAngm(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return "Not Anagram";
		}
		int freq[] = new int[256];
		for(int i = 0; i < str1.length(); i++) {
			freq[(int) str1.charAt(i)]++;
			freq[(int) str2.charAt(i)]--;
		}
		for(int i : freq) {
			if (i > 0) {
				return "Not Anagram";
			}
		}
		return "Anagram";
	}
	public static void main(String args[]) {
		String arr[][] = {
			{"agree", "eager"},
			{"asleep", "please"},
			{"heart", "earth"},
			{"recall", "cellar"}
		};
		for(String i[] : arr) {
			System.out.println(i[0] + " - " + i[1] + ": " + isAngm(i[0], i[1]));
		}
	}
}
