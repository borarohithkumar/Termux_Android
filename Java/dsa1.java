class Node {
    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public String getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public void addAtEnd(String data) {
        Node node = new Node(data);

        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    public void addAtBeginning(String data) {
        Node node = new Node(data);

        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
    }

    public void display() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public Node find(String data) {
        Node temp = this.head;

        while (temp != null) {
            if (temp.getData().equals(data)) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public void insert(String data, String dataBefore) {
        Node node = new Node(data);

        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            Node nodeBefore = this.find(dataBefore);
            if (nodeBefore != null) {
                node.setNext(nodeBefore.getNext());
                nodeBefore.setNext(node);
                if (nodeBefore == this.tail) {
                    this.tail = node;
                }
            } else {
                System.out.println("Node not found");
            }
        }
    }

    public void delete(String data) {
        if (this.head == null) {
            System.out.println("List is empty");
        } else {
            Node node = this.find(data);

            if (node == null) {
                System.out.println("Node not found");
            }

            if (node == this.head) {
                this.head = this.head.getNext();
                node.setNext(null);

                if (node == this.tail) {
                    tail = null;
                }
            } else {
                Node nodeBefore = null;
                Node temp = this.head;
                while (temp != null) {
                    if (temp.getNext() == node) {
                        nodeBefore = temp;
                        break;
                    }
                    temp = temp.getNext();
                }

                nodeBefore.setNext(node.getNext());

                if (node == this.tail) {
                    this.tail = nodeBefore;
                }
                node.setNext(null);
            }
        }
    }
}

class Tester {

    // Trainee
    public static void shiftListLeft(LinkedList linkedList, int n) {
		if (n < 1 || linkedList.getHead() == null || linkedList.getHead() == linkedList.getTail()) {
			return;
		}
		while (n > 0) {
			String data = linkedList.getHead().getData();
			linkedList.delete(data);
			linkedList.addAtEnd(data);
			n--;
		}
    }

	// Trainee
    public static void shiftListRight(LinkedList linkedList, int n) {
        if (n < 1 || linkedList.getHead() == null || linkedList.getHead() == linkedList.getTail()) {
			return;
		}
		while (n > 0) {
			String data = linkedList.getTail().getData();
			linkedList.delete(data);
			linkedList.addAtBeginning(data);
			n--;
		}
    }

	public static void main(String[] args) {
        // Test Case 1: Right Shift n = 2
        LinkedList list1 = new LinkedList();
        list1.addAtEnd("ABC");
        list1.addAtEnd("DFG");
        list1.addAtEnd("XYZ");
        list1.addAtEnd("EFG");

        shiftListRight(list1, 2);
        System.out.println("Right Shift by 2:");
        list1.display();
        System.out.println();

        // Test Case 2: Left Shift n = 3 (Sample 2)
        LinkedList list2 = new LinkedList();
        list2.addAtEnd("ABC");
        list2.addAtEnd("DFG");
        list2.addAtEnd("XYZ");
        list2.addAtEnd("EFG");

        shiftListLeft(list2, 3);
        System.out.println("Left Shift by 3:");
        list2.display();
    }
}
