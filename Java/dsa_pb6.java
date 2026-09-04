import java.util.ArrayList;
import java.util.ArrayDeque;
class MatChar {
	public static ArrayDeque<String> matchCharacters(ArrayList<String> inStrList, ArrayDeque<String> inStrQueue) {
		ArrayDeque<String> outStrQueue = new ArrayDeque<>();
		String elem1;
		int elem2;
		for(String i : inStrList) {
			if (inStrQueue.size() < 2) {
				break;
			}
			elem1 = inStrQueue.poll();
			elem2 = Integer.parseInt(inStrQueue.poll());
			if (elem2 > 0 && elem1.length() >= elem2 && String.valueOf(elem1.charAt(elem2 - 1)).equals(i)) {
				outStrQueue.offer(i);
			}
			else {
				outStrQueue.offer("-1");
			}
		}
		return outStrQueue;
	}
	public static void main(String args[]) {
		ArrayList<String> inStrList = new ArrayList<>();
        inStrList.add("a");
        inStrList.add("p");
        inStrList.add("c");
        ArrayDeque<String> inStrQ = new ArrayDeque<>();
        inStrQ.offer("apple");
        inStrQ.offer("0");
        inStrQ.offer("bannana");
        inStrQ.offer("2");
        inStrQ.offer("cat");
        inStrQ.offer("3");
        System.out.println(matchCharacters(inStrList, inStrQ));
	}
}
