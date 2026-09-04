import java.util.ArrayList;
import java.util.List;
import java.util.ArrayDeque;
class Pythagoras{
	public static ArrayDeque<Integer> getPythagoreanTriplets(ArrayList<Integer> inIntList1, ArrayList<Integer> inIntList2) {
		List<Integer> tempData = new ArrayList<>();
		for(int i : inIntList1) {
			for(int j : inIntList2) {
				for(int k : inIntList2) {
					if (j != k && (i * i + j * j) == k * k) {
						tempData.add(i);
						tempData.add(j);
						tempData.add(k);
					}
				}
			}
		}
		ArrayDeque<Integer> outIntQueue = new ArrayDeque<>(tempData);
		return outIntQueue;
	}
	public static void main(String args[]) {
		ArrayList<Integer> inIntList1 = new ArrayList<>();
        inIntList1.add(3);
        inIntList1.add(6);
		ArrayList<Integer> inIntList2 = new ArrayList<>();
        inIntList2.add(4);
        inIntList2.add(5);
        inIntList2.add(8);
        inIntList2.add(10);
		System.out.println(getPythagoreanTriplets(inIntList1, inIntList2));
	}
}
