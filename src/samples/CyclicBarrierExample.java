package samples;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class SampleExecution1 implements Runnable {

	final CyclicBarrier cyclicBarrier;

	public SampleExecution1(CyclicBarrier barrier) {
		this.cyclicBarrier = barrier;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("************************************");
		}

		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

class SampleExecution2 implements Runnable {

	final CyclicBarrier cyclicBarrier;

	public SampleExecution2(CyclicBarrier barrier) {
		this.cyclicBarrier = barrier;
	}

	@Override
	public void run() {
		for (int i = 0; i < 15; i++) {
			System.out.println(i);
		}
		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}

class FinalExecution implements Runnable {
	@Override
	public void run() {
		System.out.println("Cyclic Barrier Execution is Done");
	}
}

public class CyclicBarrierExample {
	static CyclicBarrier newBarrier = new CyclicBarrier(2, new FinalExecution());

	public static void main(String[] args) {

		Thread t1 = new Thread(new SampleExecution1(newBarrier));
		Thread t2 = new Thread(new SampleExecution2(newBarrier));

		t1.start();
		t2.start();
	}
}
