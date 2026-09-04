import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
class PairPrime {
	public static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for(int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static Queue<Integer> buildOutQ(Queue<Integer> inQ1, Queue<Integer> inQ2) {
		Queue<Integer> outQ = new LinkedList<>();
		if (inQ1.isEmpty() || inQ2.isEmpty()) {
			return outQ;
		}
		List<Integer> tempArr = new ArrayList<>();
		List<Integer> inList2 = new ArrayList<>(inQ2);
		boolean paired[] = new boolean[inList2.size()];
		for(int i : inQ1) {
			for(int j = 0; j < inList2.size(); j++) {
				if (!paired[j]) {
					if (isPrime(i + inList2.get(j))) {
						tempArr.add(i);
						tempArr.add(inList2.get(j));
						paired[j] = true;
						break;
					}
				}
			}
		}
		for(int i : tempArr) {
			outQ.offer(i);
		}
		return outQ;
	}
	public static void main(String args[]) {
		Queue<Integer> inQ1 = new LinkedList<>();
		inQ1.offer(2);
		inQ1.offer(7);
		inQ1.offer(5);
		Queue<Integer> inQ2 = new LinkedList<>();
		inQ2.offer(11);
		inQ2.offer(4);
		inQ2.offer(8);
		System.out.println("OutQueue: " + buildOutQ(inQ1, inQ2));
	}
}
