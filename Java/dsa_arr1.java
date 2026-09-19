import java.util.Stack;
import java.util.ArrayList;
import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
class ItemIDList {
	public static Queue<String> buildOutQueue(Stack<String> inStack, ArrayList<String> inArr) {
		String code1;
		String code2;
		Queue<String> outQueue = new LinkedList<>();
		List<String> tempData = new LinkedList<>();
		while (!inStack.isEmpty()) {
			code1 = inStack.pop();
			code2 = inStack.pop();
			boolean match = false;
			for(String i : inArr) {
				if (i.contains(code1 + code2)) {
					outQueue.offer(code1 + code2);
					match = true;
					break;
				}
			}
			if (!match) {
				tempData.add(code1);
			}
		}
		for(String i : tempData) {
			outQueue.offer(i);
		}
		return outQueue;
	}
	public static void main(String args[]) {
		Stack<String> inStack = new Stack<>();
		inStack.push("F6");
		inStack.push("A6");
	    inStack.push("F6");
    	inStack.push("E5");
	    inStack.push("D4");
    	inStack.push("C3");
	    inStack.push("B2");
    	inStack.push("A1");
	    ArrayList<String> inArr = new ArrayList<>();
    	inArr.add("X-A1B2-Y");
	    inArr.add("Z-C4D4");
    	inArr.add("Q-E4D4-W");
	    inArr.add("Z-E5F6-P");
		System.out.println("OutQueue: " + buildOutQueue(inStack, inArr));
	}
}
