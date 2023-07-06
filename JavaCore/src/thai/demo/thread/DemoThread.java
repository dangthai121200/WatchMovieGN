package thai.demo.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DemoThread {
	public static void main(String[] args) {
		ThreadPoolExecutor executorService = new ThreadPoolExecutor(100, 1, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>());

		executorService.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("executorService");
			}
		});
		while (true) {
			executorService.submit(new Runnable() {
				@Override
				public void run() {
					try {
						System.out.println("Hello");
						System.out.println(executorService.getQueue().toArray().toString());
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}
}
