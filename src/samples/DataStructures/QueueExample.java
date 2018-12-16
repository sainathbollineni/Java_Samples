package samples.DataStructures;

public class QueueExample {

	public static void main(String[] args) {

		QueueImplementation queue = new QueueImplementation(10);

		queue.addElement(10);
		queue.addElement(20);
		queue.addElement(30);
		queue.addElement(40);

		queue.display();

		System.out.println(queue.isQueueEmpty());

		System.out.println(queue.isQueueFull());

		queue.removeElement();

		queue.display();
	}
}

class QueueImplementation {

	int front, rear, length, queueSize;
	int[] data;

	public QueueImplementation(int queueSize) {
		this.queueSize = queueSize;
		length = 0;
		rear = queueSize - 1;
		front = 0;
		data = new int[queueSize];
	}

	public boolean isQueueEmpty() {
		return 0 == length;
	}

	public boolean isQueueFull() {
		return length == queueSize;
	}

	public void addElement(int newData) {

		if (!isQueueFull()) {
			this.rear = (this.rear + 1) % queueSize;
			data[this.rear] = newData;
			this.length = length + 1;
		}
	}

	public int removeElement() {

		int res = -1;
		if (!isQueueEmpty()) {
			res = data[this.front];
			this.front = (this.front + 1) % queueSize;
			this.length = this.length - 1;
		}

		return res;
	}

	public void display() {

		for (int i = 0; i < length; i++) {
			System.out.println(data[i]);
		}
	}
}