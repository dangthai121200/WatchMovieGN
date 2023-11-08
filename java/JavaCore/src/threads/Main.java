package threads;

import java.util.concurrent.ThreadPoolExecutor;

public class Main {
	public static void main(String[] args) {
		
		ThreadTest threadTest = new ThreadTest();

		Thread runnableTest = new Thread(new RunnableTest());
		
		threadTest.start();
		runnableTest.start();
		
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 0, 0, null, null);
		
		System.out.println("---------" + Constan.number);
	}
}
