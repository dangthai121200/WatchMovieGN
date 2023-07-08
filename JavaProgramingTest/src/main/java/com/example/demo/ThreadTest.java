package com.example.demo;

public class ThreadTest {
	

	static Integer x = 1;
	
	synchronized static void testThread (String test) {
		try {
			System.out.println(test);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		

		Thread thread1 = new Thread(() -> {
			System.out.println(x);
		});
		Thread thread2 = new Thread(() -> {
			x = 2;
			System.out.println(x);

		});
		Thread thread3 = new Thread(() -> {
			x = 3;
			System.out.println(x);
		});
				
		thread1.start();
		thread2.start();
		thread3.start();
	}
}
