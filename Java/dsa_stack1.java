import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
class PriorVehNo {
	public static Queue<String> buildOutQueue(Stack<String> inStack, Queue<String> inQueue) {
		String data1;
		String data2;
		Queue<String> outQueue = new LinkedList<>();
		Stack<String> tempStack = new Stack<>();
		while (!inStack.isEmpty()) {
			data1 = inStack.pop();
			data2 = inQueue.poll();
			if (data2.charAt(0) == 'M') {
				outQueue.offer(data1 + "-" + data2);
			}
			else {
				tempStack.push(data1 + "-" + data2);
			}
		}
		while (!tempStack.isEmpty()) {
			outQueue.offer(tempStack.pop());
		}
		return outQueue;
	}
	public static void main(String args[]) {
		Stack<String> inStack = new Stack<>();
		inStack.push("KA-87");
        inStack.push("TN-01");
        inStack.push("WB-56");
        inStack.push("AP-23");
        inStack.push("KE-18");
        Queue<String> inQueue = new LinkedList<>();
        inQueue.offer("C-2570");
        inQueue.offer("M-8635");
        inQueue.offer("M-1255");
        inQueue.offer("C-4583");
        inQueue.offer("C-1246");
		System.out.println("OutQueue: " + buildOutQueue(inStack, inQueue));
	}
}
