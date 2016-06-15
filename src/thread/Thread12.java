package thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Prod implements Runnable{
	private Integer i = 0;
	private final BlockingQueue<Integer> bq;
	Prod(BlockingQueue<Integer> BQ) {
		this.bq = BQ;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true) {
			System.out.println("In Producer");
			try {
				bq.put(i++);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
class Cons implements Runnable {
	private final BlockingQueue<Integer> bq;
	Cons(BlockingQueue<Integer> BQ) {
		this.bq = BQ;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("In Consumer");
			int res;
			try {
				res = bq.take();
				
				System.out.println("Removed " + res);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
public class Thread12 {
	static BlockingQueue<Integer> shareQ = new LinkedBlockingQueue<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread tP = new Thread(new Prod(shareQ));
		Thread tC = new Thread(new Cons(shareQ));
		tP.start();
		tC.start();
	}
	

}
