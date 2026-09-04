import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;
class SumDig {
	public static ArrayList<Integer> manipulateNumbersByDigitSum(ArrayList<Integer> inIntList) {
		Deque<Integer> tempData1 = new ArrayDeque<>();
		List<Integer> tempData2 = new ArrayList<>();
		int temp;
		int digSum;
		ArrayList<Integer> outIntList = new ArrayList<>();
		for(int i : inIntList) {
			digSum = 0;
			temp = i;
			while (temp > 0) {
				digSum += temp % 10;
				temp /= 10;
			}
			if ((digSum & 1) == 1) {
				tempData1.push(i);
			}
			else {
				tempData2.add(i);
			}
		}
		while (!tempData1.isEmpty()) {
			outIntList.add(tempData1.pop());
		}
		for(int i : tempData2) {
			outIntList.add(i);
		}
		return outIntList;
	}
	public static void main(String args[]) {
		ArrayList<Integer> inIntList = new ArrayList<>();
		inIntList.add(34);
        inIntList.add(56);
        inIntList.add(12);
        inIntList.add(29);
        inIntList.add(81);
		System.out.println(manipulateNumbersByDigitSum(inIntList));

	}
}
