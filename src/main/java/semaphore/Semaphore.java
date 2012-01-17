package semaphore;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Semaphore {

	private int c;
	private Lock lock;
	private Condition isPositive;

	public Semaphore() {
		c = 0;
		lock = new ReentrantLock();
		isPositive = lock.newCondition();
	}

	public void increase() {
		lock.lock();
		c++;
		System.out.println(Thread.currentThread().getName()
				+ " increased c to " + c);
		isPositive.signalAll();
		lock.unlock();
	}

	public void decrease() {
		lock.lock();
		while (c == 0)
			try {
				System.out.println("c is zero, "
						+ Thread.currentThread().getName() + " is waiting");
				isPositive.await();
				System.out.println("some thread increased c, "
						+ Thread.currentThread().getName()
						+ " is running again");
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		c--;
		System.out.println(Thread.currentThread().getName()
				+ " decreased c to " + c);

		lock.unlock();
	}

}
