class Node {
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}
class reverseArray {
	public static Node buildList(int arr[]) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		Node head = new Node(arr[0]);
		Node current = head;
		for(int i = 1; i < arr.length; i++) {
			current.next = new Node(arr[i]);
			current = current.next;
		}
		return head;
	}
	public static Node reversedList(Node node) {
		Node prev = null;
		Node curr = node;
		Node nextNode;
		while (curr != null) {
			nextNode = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextNode;
		}
		return prev;
	}
	public static String displayList(Node node) {
		if (node == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		while (node != null) {
			sb.append(node.data).append(" ");
			node = node.next;
		}
		return sb.deleteCharAt(sb.length() - 1).toString();
	}
	public static void main(String args[]) {
		int inArray[] = {1, 2, 3, 4, 5};
		Node node = buildList(inArray);
		Node nodeList = reversedList(node);
		String arrList = displayList(nodeList);
		System.out.println(arrList);
	}
}
