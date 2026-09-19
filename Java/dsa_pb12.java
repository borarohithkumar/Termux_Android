import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
class QPairs {
	public static ArrayDeque<Integer> processQueuePairs(ArrayDeque<Integer> inIntQueue1, ArrayDeque<Integer> inIntQueue2) {
		List<Integer> tempData = new ArrayList<>();
		ArrayDeque<Integer> outIntQueue = new ArrayDeque<>();
		int elem1, elem2;
		while (!inIntQueue1.isEmpty() && !inIntQueue2.isEmpty()) {
			elem1 = inIntQueue1.poll();
			elem2 = inIntQueue2.poll();
			if ((elem2 & 1) == 0) {
				tempData.add(elem1 + elem2);
			} else {
				tempData.add(Math.abs(elem1 - elem2));
			}
		}
		while (!inIntQueue1.isEmpty()) {
			outIntQueue.add(inIntQueue1.poll());
		}
		while (!inIntQueue2.isEmpty()) {
			outIntQueue.add(inIntQueue2.poll());
		}
		for(int i : tempData) {
			outIntQueue.offer(i);
		}
		return outIntQueue;
	}
	public static void main(String[] args) {
		ArrayDeque<Integer> inIntQueue1 = new ArrayDeque<>();
		inIntQueue1.offer(10);
		inIntQueue1.offer(3);
		inIntQueue1.offer(6);
		inIntQueue1.offer(1);
		inIntQueue1.offer(8);
		inIntQueue1.offer(2);
		inIntQueue1.offer(5);
		ArrayDeque<Integer> inIntQueue2 = new ArrayDeque<>();
		inIntQueue2.offer(5);
		inIntQueue2.offer(7);
		inIntQueue2.offer(2);
		inIntQueue2.offer(9);
		inIntQueue2.offer(4);
		inIntQueue2.offer(11);
		System.out.println(processQueuePairs(inIntQueue1, inIntQueue2));
	}
}
