import java.util.Set;
import java.util.HashSet;
class P3A {
	public static void main(String[] args) {
		String s = "aab";
		StringBuilder sb = new StringBuilder();
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < s.length(); j++) {
				if (i == j) {
					continue;
				}
				for (int k = 0; k < s.length(); k++) {
					if (i == k || j == k) {
						continue;
					}
					set.add(sb.append(s.charAt(i)).append(s.charAt(j)).append(s.charAt(k)).toString());
					sb.setLength(0);
				}
			}
		}
		for (String s1 : set) {
			System.out.println(s1);
		}
	}
}
