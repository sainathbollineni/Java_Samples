package samples.DataStructures;

class Node {
	private int data;
	private Node prevPtr;
	private Node nextPtr;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getPrevPtr() {
		return prevPtr;
	}

	public void setPrevPtr(Node prevPtr) {
		this.prevPtr = prevPtr;
	}

	public Node getNextPtr() {
		return nextPtr;
	}

	public void setNextPtr(Node nextPtr) {
		this.nextPtr = nextPtr;
	}
}

public class DoublyLinkedList {

	static Node headNode = null;

	public static void main(String[] args) {

		DoublyLinkedList.addFirst(5);
		DoublyLinkedList.displayList();
		System.out.println("**************************");

		DoublyLinkedList.addFirst(15);
		DoublyLinkedList.displayList();
		System.out.println("**************************");

		DoublyLinkedList.addFirst(9);
		DoublyLinkedList.displayList();
		System.out.println("**************************");

		DoublyLinkedList.addLast(13);
		DoublyLinkedList.addLast(113);
		DoublyLinkedList.displayList();

		System.out.println("**************************");

		DoublyLinkedList.middleNode();

		System.out.println("**************************");

		DoublyLinkedList.insertAt(67, 4);
		DoublyLinkedList.displayList();

		System.out.println("**************************");
		DoublyLinkedList.middleNode();

		System.out.println("**************************");
	}

	public static void displayList() {

		Node n = headNode;
		while (n != null) {
			System.out.println(n.getData());
			n = n.getNextPtr();
		}

	}

	public static void addFirst(int newData) {

		Node newNode = new Node();
		newNode.setData(newData);
		newNode.setNextPtr(null);
		newNode.setPrevPtr(null);

		if (null == headNode) {
			headNode = newNode;
		} else {
			newNode.setNextPtr(headNode);
			headNode.setPrevPtr(newNode);
			headNode = newNode;
		}
	}

	public static void addLast(int newData) {

		Node n = new Node();
		n.setData(newData);
		n.setNextPtr(null);
		n.setPrevPtr(null);

		if (null == headNode) {
			headNode = n;
		} else {
			Node temp = headNode;
			while (null != temp.getNextPtr()) {
				temp = temp.getNextPtr();
			}

			temp.setNextPtr(n);
		}
	}

	public static void middleNode() {

		Node fastPtr = headNode;
		Node slowPtr = headNode;

		while (null != fastPtr && fastPtr.getNextPtr() != null) {
			slowPtr = slowPtr.getNextPtr();
			fastPtr = fastPtr.getNextPtr().getNextPtr();
		}

		System.out.println(slowPtr.getData());
	}

	public static void insertAt(int data, int pos) {

		Node newNode = new Node();
		newNode.setData(data);
		newNode.setNextPtr(null);
		newNode.setPrevPtr(null);

		Node n = headNode;

		int count = 1;

		while (count < (pos - 1)) {
			if (n.getNextPtr() != null) {
				n = n.getNextPtr();
				count = count + 1;
			}
		}

		if (count == pos - 1) {
			Node temp = n.getNextPtr();
			n.setNextPtr(newNode);
			newNode.setPrevPtr(n);
			if (null != temp) {
				newNode.setNextPtr(temp);
				temp.setPrevPtr(newNode);
			} else {
				newNode.setNextPtr(null);
			}
		} else {
			System.out.println("Count value " + count);
			System.out.println("Position given doesnot exist");
		}
	}
}