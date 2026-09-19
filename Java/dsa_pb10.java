import java.util.ArrayDeque;
import java.util.ArrayList;
class CommSort {
	public static void quickSort(ArrayList<Integer> list, int l, int h) {
		if (l >= h) {
			return;
		}
		int pivot = list.get((l + h)/2);
		int i = l;
		int j = h;
		int temp;
		while (i <= j) {
			while (list.get(i) > pivot) {
				i++;
			}
			while (list.get(j) < pivot) {
				j--;
			}
			if (i <= j) {
				temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
				i++;
				j--;
			}
		}
		quickSort(list, l, j);
		quickSort(list, i, h);
	}
	public static ArrayList<Integer> getNonCommonElementsDescending(ArrayDeque<Integer> inputQueue1, ArrayDeque<Integer> inputQueue2) {
		ArrayList<Integer> outList = new ArrayList<>();
		for(int i : inputQueue1) {
			if (!inputQueue2.contains(i)) {
				outList.add(i);
			}
		}
		for(int i : inputQueue2) {
			if (!inputQueue1.contains(i)) {
				outList.add(i);
			}
		}
		quickSort(outList, 0, outList.size() - 1);
		return outList;
	}
	public static void main(String[] args) {
		ArrayDeque<Integer> inputQueue1 = new ArrayDeque<>();
		inputQueue1.offer(6);
		inputQueue1.offer(5);
		inputQueue1.offer(3);
		inputQueue1.offer(1);
		ArrayDeque<Integer> inputQueue2 = new ArrayDeque<>();
		inputQueue2.offer(5);
		inputQueue2.offer(4);
		inputQueue2.offer(2);
		inputQueue2.offer(1);
		System.out.println(getNonCommonElementsDescending(inputQueue1, inputQueue2));
	}
}
