import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.List;
class UniqSort {
	public static void quickSort(int flag, List<Integer> list, int low, int high) {
		if (low >= high) {
			return;
		}
		int i = low;
		int j = high;
		int pivot = list.get((i + j) / 2);
		while (i <= j) {
			if (flag == 0) {
				while (list.get(i) < pivot) {
					i++;
				}
				while (list.get(j) > pivot) {
					j--;
				}
			}
			else {
				while (list.get(i) > pivot) {
					i++;
				}
				while (list.get(j) < pivot) {
					j--;
				}
			}
			if (i <= j) {
				int temp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, temp);
				i++;
				j--;
			}
		}
		quickSort(flag, list, low, j);
		quickSort(flag, list, i, high);
	}
	public static ArrayDeque<Integer> getSortedUnion(int inputNum, ArrayList<Integer> inputList, ArrayDeque<Integer> inputQueue) {
		List<Integer> tempData = new ArrayList<>();
		for(int i : inputList) {
			if(!tempData.contains(i)) {
				tempData.add(i);
			}
		}
		for (int i : inputQueue) {
			if(!tempData.contains(i)) {
				tempData.add(i);
			}
		}
		quickSort(inputNum, tempData, 0, tempData.size() - 1);
		return new ArrayDeque<>(tempData);
	}
	public static void main(String[] args) {
		int inputNum = 1;
		ArrayList<Integer> inputList = new ArrayList<>();
		inputList.add(1);
		inputList.add(3);
		inputList.add(4);
		inputList.add(6);
		ArrayDeque<Integer> inputQueue = new ArrayDeque<>();
		inputQueue.offer(1);
		inputQueue.offer(2);
		inputQueue.offer(4);
		inputQueue.offer(5);
		System.out.println(getSortedUnion(inputNum, inputList, inputQueue));
	}
}
