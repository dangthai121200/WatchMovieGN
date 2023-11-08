package threads;

public class ThreadTest extends Thread {

	@Override
	public void run() {
		
		do {
			System.out.println(Constan.number++);
		} while (Constan.number < 1000000);
		System.out.println("Result ThreadTest:" + Constan.number);
	}

}
