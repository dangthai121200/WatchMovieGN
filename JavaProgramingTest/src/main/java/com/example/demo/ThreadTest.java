package com.example.demo;

public class ThreadTest {
	public static void main(String[] args) {

		Account account = new Account();

		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 1000000; i++) {
				account.increase();
				System.out.println(account.getCount());
			}
		});
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 1000000; i++) {
				account.deincrease();
				System.out.println(account.getCount());
			}
		});
		thread1.setPriority(2);
		thread1.start();
		thread2.start();

		System.out.println(account.getCount());

	}

	static class Account {
		private int count = 0;

		public synchronized void increase() {
			this.count++;
			notify();
		}

		public synchronized void deincrease() {
			if(this.count < 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} this.count--;
		}

		public int getCount() {
			return count;
		}

	}
}
