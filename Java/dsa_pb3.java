import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.List;
import java.util.LinkedList;
class QArr {
	public static ArrayDeque<Integer> getSquareCubeMatches(ArrayList<Integer> inIntList, ArrayDeque<Integer> inIntQueue) {
		List<Integer> inIntQList = new LinkedList<>(inIntQueue);
		List<Integer> tempData = new LinkedList<>();
		boolean used[] = new boolean[inIntQList.size()];
		ArrayDeque<Integer> outIntQueue = new ArrayDeque<>();
		for(int i : inIntList) {
			for(int j = 0; j < inIntQList.size(); j++) {
				if (!used[j]) {
					if (i * i == j * j * j) {
						tempData.add(i);
						tempData.add(j);
						used[j] = true;
					}
				}
			}
		}
		for(int i : tempData) {
			outIntQueue.offer(i);	
		}
		return outIntQueue;
	}
	public static void main(String args[]) {
		ArrayList<Integer> inIntList = new ArrayList<>();
		inIntList.add(2);
		inIntList.add(3);
		inIntList.add(4);
		inIntList.add(8);
		inIntList.add(9);
		ArrayDeque<Integer> inIntQ = new ArrayDeque<>();
		inIntQ.offer(4);
		inIntQ.offer(8);
		inIntQ.offer(27);
		inIntQ.offer(64);
		inIntQ.offer(125);
		System.out.println(getSquareCubeMatches(inIntList, inIntQ));
	}
}
