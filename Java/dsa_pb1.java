import java.util.ArrayDeque;
import java.util.ArrayList;
class QStrArr {
	public static ArrayList<String> processIntegerQueueAndStringList(ArrayDeque<Integer> inIntQueue, ArrayList<String> inStrList) {
		int elem1;
		String elem2;
		ArrayList<String> outStrList = new ArrayList<>();
		for(int i = 0; i < inStrList.size(); i++) {
			if (inIntQueue.isEmpty()) {
				break;
			}
			elem1 = inIntQueue.poll();
			elem2 = inStrList.get(i);
			if (elem2.length() <= elem1) {
				outStrList.add(0, elem2 + ":" + elem1);
			}
			else {
				outStrList.add(0, elem2.substring(0, elem1) + elem2.length());
			}
		}
		return outStrList;
	}
	public static void main(String args[]) {
		ArrayDeque<Integer> inIntQ = new ArrayDeque<>();
		inIntQ.offer(4);
		inIntQ.offer(2);
		inIntQ.offer(5);
		ArrayList<String> inStrList = new ArrayList<>();
		inStrList.add("hello");
		inStrList.add("xy");
		inStrList.add("programming");
		System.out.println(processIntegerQueueAndStringList(inIntQ, inStrList));
	}
}
