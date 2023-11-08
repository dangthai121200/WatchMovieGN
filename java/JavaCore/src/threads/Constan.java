package threads;

public class Constan {
	public static int number = 0;
	synchronized void increment() {
		number++;
	}
}
