class CntLeftRyt {
	static String procStr(String str) {
		int alpCnt = 0;
		int digCnt = 0;
		int ind = str.indexOf(':');
		for (int i = 0; i < ind; i++) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				alpCnt++;
			}
		}
		for (int i = ind + 1; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				digCnt++;
			}
		}
		return alpCnt + ":" + digCnt;
	}
	public static void main(String[] args) {
		String str1 = "abC123:9xyz";
		String str2 = "2025-09-03:Room42B";
		String str3 = "Hi5There:CallMe@10";
		System.out.println(procStr(str1));
		System.out.println(procStr(str2));
		System.out.println(procStr(str3));
	}
}
