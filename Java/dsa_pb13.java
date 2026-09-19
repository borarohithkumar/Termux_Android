import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
class CatogItem {
	public static ArrayDeque<String> categorizeItemsByPriority(ArrayList<String> inStrList) {
		List<String> highPriorityList = new ArrayList<>();
		List<String> lowPriorityList = new ArrayList<>();
		ArrayDeque<String> outStrQueue = new ArrayDeque<>();
		for (String i : inStrList) {
			if (i.endsWith("-A")) {
				outStrQueue.offer(i);
			}
			else if (i.endsWith("-B")) {
				highPriorityList.add(i);
			}
			else if (i.endsWith("-C")) {
				lowPriorityList.add(i);
			}
		}
		for (String i : highPriorityList) {
			outStrQueue.offer(i);
		}
		for (String i : lowPriorityList) {
			outStrQueue.offer(i);
		}
		return outStrQueue;
	}
	public static void main(String[] args) {
		ArrayList<String> inStrList = new ArrayList<>();
		inStrList.add("Pencil-C");
		inStrList.add("Notebook-B");
		inStrList.add("Eraser-C");
		inStrList.add("Stapler-A");
		inStrList.add("Pen-A");
		inStrList.add("Folder-B");
		inStrList.add("Paper-C");
		System.out.println(categorizeItemsByPriority(inStrList));
	}
}
