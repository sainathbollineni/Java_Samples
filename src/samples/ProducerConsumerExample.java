package samples;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerExample {

	List<Integer> data = new ArrayList<>();

	public static void main(String[] args) {

		ProducerConsumerExample pc = new ProducerConsumerExample();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					pc.consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();

		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void producer() throws InterruptedException {
		System.out.println("Producer Method has been called");

		synchronized (this) {
			boolean isControlReturned = false;
			for (int i = 0; i < 20; i++) {
				data.add(i + 1);
				System.out.println("Value Created is :: " + (i + 1));

				if (data.size() > 10 && !isControlReturned) {
					System.out.println("List Size before calling wait method is :: " + data.size());
					wait();
					isControlReturned = true;
					System.out.println("Controled is returned back by the Consumer");
				}
			}

			System.out.println("List Size at the end is :: " + data.size());
		}
	}

	public void consumer() throws InterruptedException {

		Thread.sleep(5000);

		System.out.println("Consumer Method has been called");
		synchronized (this) {
			int res = 0;

			for (int i = 0; i < data.size(); i++) {
				res = res + data.get(i);
			}
			System.out.println("Result is :: " + res);
			notify();
		}
	}

}