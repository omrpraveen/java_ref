package concurrency.threadpkg;

public class ThreadEx1 {

	public class MyThread extends Thread {
		public void run() {
			System.out.println("My thread");
		}
	}

	public static void main(String args[]) {
		MyThread thread1 = new ThreadEx1().new MyThread();
		thread1.start();

		Thread thread = new Thread() {
			public void run() {
				System.out.println("Thread Running");
			}
		};
		thread.start();
		
		Runnable r = () -> {System.out.println("Runable interface");};
		Thread thread2 = new Thread(r);
		thread2.start();

	}

}
