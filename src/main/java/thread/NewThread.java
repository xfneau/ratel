package thread;

public class NewThread implements Runnable {

	private static int n = 1;

	public static void main(String[] args) {
		NewThread t = new NewThread();
		Thread t1 = new Thread(t, "奇数");
		Thread t2 = new Thread(t, "偶数");
		t1.start();
		t2.start();
	}

	private int i = 0;;

	@Override
	public void run() {
		int j = 0;
		while (i++ < 20) {
			synchronized (this) {
				System.out.println(n++ + ":" + Thread.currentThread().getName());
				notifyAll();
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+":"+j++);
		}

	}

	public void print() {

	}

}
