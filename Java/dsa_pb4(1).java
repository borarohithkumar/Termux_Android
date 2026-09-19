import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
class EmpRank {
	public static void sort(List<String> inStrList) {
		inStrList.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (Integer.parseInt(s1.split(":")[1]) != Integer.parseInt(s2.split(":")[1])) {
					return Integer.compare(Integer.parseInt(s1.split(":")[1]), Integer.parseInt(s2.split(":")[1]));
				}
				return s1.split(":")[0].compareTo(s2.split(":")[0]);
			}
		});
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
