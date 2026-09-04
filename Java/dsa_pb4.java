import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
class EmpRank {
	public static void sort(List<String> inStrList) {
		String s1;
		String s2;
		String temp;
		int r1;
		int r2;
		for (int i = 0; i < inStrList.size() - 1; i++) {
			for (int j = 1; j < inStrList.size() - i; j++) {
				s1 = inStrList.get(j - 1).substring(0, inStrList.get(j - 1).indexOf(':'));
				s2 = inStrList.get(j).substring(0, inStrList.get(j).indexOf(':'));
				r1 = Integer.parseInt(inStrList.get(j - 1).substring(inStrList.get(j - 1).indexOf(':') + 1));
				r2 = Integer.parseInt(inStrList.get(j).substring(inStrList.get(j).indexOf(':') + 1));
				if (r1 > r2 || (r1 == r2 && s1.compareTo(s2) > 0)) {
					temp = inStrList.get(j - 1);
					inStrList.set(j - 1, inStrList.get(j));
					inStrList.set(j, temp);
				}
			}
		}
	}
	public static ArrayDeque<String> getEmployeeRanking(ArrayDeque<String> inStrQueue) {
		List<String> inStrList = new ArrayList<>(inStrQueue);
		sort(inStrList);
		return new ArrayDeque<>(inStrList);
	}
	public static void main(String args[]) {
		ArrayDeque<String> inStrQ = new ArrayDeque<>();
		inStrQ.offer("Charlie:2");
		inStrQ.offer("David:1");
		inStrQ.offer("Anna:3");
		inStrQ.offer("Bob:2");
		inStrQ.offer("Grace:1");
		System.out.println(getEmployeeRanking(inStrQ));
	}
}
