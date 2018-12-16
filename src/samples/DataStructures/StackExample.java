package samples.DataStructures;

import java.util.NoSuchElementException;

public class StackExample {

	public static void main(String[] args) {
		StackImplementation si = new StackImplementation(3);

		System.out.println(si.isStackEmpty());
		System.out.println(si.isStackFull());
		System.out.println("*********************************");

		si.push(6);
		si.display();
		System.out.println("*********************************");

		System.out.println(si.peek());

		System.out.println("*********************************");

		si.push(15);
		si.display();

		System.out.println("*********************************");

		si.pop();
		si.display();
		System.out.println("*********************************");

		si.push(33);
		si.display();

		System.out.println("*********************************");

		si.push(456);
		si.display();

		System.out.println("*********************************");

		si.push(567);
		si.display();

		System.out.println("*********************************");
	}
}

class StackImplementation {

	int top, length, stackSize;
	int data[];

	public StackImplementation(int stackSize) {
		super();
		this.stackSize = stackSize;
		top = -1;
		length = 0;
		data = new int[stackSize];
	}

	public boolean isStackEmpty() {
		return -1 == top;
	}

	public boolean isStackFull() {
		return length == stackSize;
	}

	public int getSize() {
		return length;
	}

	public int peek() {

		if (!isStackEmpty()) {
			return data[top];
		} else {
			throw new NoSuchElementException("Stack is Empty");
		}
	}

	public void push(int newData) {

		if (!isStackFull()) {
			length++;
			data[++top] = newData;
		} else {
			throw new IndexOutOfBoundsException("Stack is filled");
		}
	}

	public int pop() {
		if (!isStackEmpty()) {
			length--;
			return data[top--];
		} else {
			throw new NoSuchElementException("Stack is Empty");
		}
	}

	public void display() {

		for (int i = top; i >= 0; i--) {
			System.out.println(data[i]);
		}
	}
}