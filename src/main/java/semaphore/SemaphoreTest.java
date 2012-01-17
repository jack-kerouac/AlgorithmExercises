package semaphore;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SemaphoreTest {

	private Thread thread1, thread2, thread3;

	class Increaser implements Runnable {

		private final Semaphore semaphore;

		public Increaser(Semaphore semaphore) {
			super();
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			Random rand = new Random();

			while (true) {
				semaphore.increase();
				try {
					Thread.sleep(rand.nextInt(500));
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	class Decreaser implements Runnable {

		private final Semaphore semaphore;

		public Decreaser(Semaphore semaphore) {
			super();
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			Random rand = new Random();

			while (true) {
				semaphore.decrease();
				try {
					Thread.sleep(rand.nextInt(1000));
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}

	}

	@Before
	public void setUp() throws Exception {
		Semaphore semaphore = new Semaphore();

		thread1 = new Thread(new Increaser(semaphore), "t1");
		thread1.start();

		thread2 = new Thread(new Decreaser(semaphore), "t2");
		thread2.start();
		thread3 = new Thread(new Decreaser(semaphore), "t3");
		thread3.start();
	}

	@Test
	public void test() throws InterruptedException {
		Thread.sleep(10000);
	}

}
