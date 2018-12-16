package samples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SampleTask implements Runnable {

	private String name;
	private int result = 0;

	public SampleTask(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			result = result + i;
		}

		System.out.println("Task " + name + " completed with result as " + result);
		
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class ExecutorFrameworkExample {

	public static void main(String[] args) {

		Runnable r1 = new SampleTask("T1");
		Runnable r2 = new SampleTask("T2");
		Runnable r3 = new SampleTask("T3");
		Runnable r4 = new SampleTask("T4");
		Runnable r5 = new SampleTask("T5");
		Runnable r6 = new SampleTask("T6");

		//ExecutorService pool = Executors.newFixedThreadPool(3);
		ExecutorService pool = Executors.newCachedThreadPool();

		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		pool.execute(r4);
		pool.execute(r5);
		pool.execute(r6);

		pool.shutdown();
	}
}
