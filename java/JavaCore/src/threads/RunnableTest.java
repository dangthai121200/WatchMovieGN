package threads;

public class RunnableTest implements Runnable {

	@Override
	public void run() {
		
		do {
			System.out.println(Constan.number++);
		} while (Constan.number < 1000000);
		System.out.println("Result RunnableTest:" + Constan.number);
	}

}
