import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*
 * Note: 0 = up = (y = y - 10)
 * 1 = down = (y = y + 10)
 * 2 = right = (x = x + 10)
 * 3 = left = (x = x - 10)
 * */
public class CarQueue {
	
	private Queue<Integer> queue;
	private Random random;
	private final int ITERATION = 5;
	
	public CarQueue() {
		queue = new LinkedList<>();
		random = new Random();
		
		// random numbers enqueued
		for (int i = 0; i < ITERATION; i++) {
			queue.add(random.nextInt(4));
		}
	}
	
	public void addToQueue() {
		class QueueRunnable implements Runnable {

			@Override
			public void run() {
				try {
					while (!Thread.interrupted()) {
						queue.add(random.nextInt(4));
						Thread.sleep(100);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		QueueRunnable queueRunnable = new QueueRunnable();
		Thread thread = new Thread(queueRunnable);
		thread.start();
	}
	
	public int deleteQueue() {
		if (!(queue.size() == 0)) {
			return queue.remove();
		}
		return 0;
	}
	
}
