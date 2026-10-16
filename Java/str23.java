import java.util.Set;
import java.util.HashSet;
class PassPow {
	public static void main(String[] args) {
		String str = "A2b1&7v9!";
		boolean flag[] = new boolean[6];
		String outStr;
		Set<Character> set = new HashSet<>();
		if (str.length() < 8) {
			outStr = "Invalid";
			System.out.println(outStr);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				flag[0] = true;
			}
			else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				flag[1] = true;
			}
			else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				flag[2] = true;
			}
			else if (str.charAt(i) != ' ') {
				flag[3] = true;
			}
			if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
				flag[4] = true;
			}
			if (set.contains(str.charAt(i))) {
				flag[5] = true;
			}
			set.add(str.charAt(i));
		}
		if (flag[0] && flag[1] && flag[2] && flag[3] && !flag[4]) {
			outStr = "Strong";
		}
		else if (flag[0] && flag[2] && flag[3] && !flag[5]) {
			outStr = "Partly Strong";
		}
		else if (flag[0] || flag[1] || flag[2]) {
			outStr = "Weak";
		}
		else {
			outStr = "Invalid";
		}
		System.out.println(outStr);
	}
}
