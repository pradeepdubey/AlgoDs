package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread123 {
	private static int count = 1;
	
	public static void main(String args[]) {
		final Lock lock= new ReentrantLock();
		final Condition condition = lock.newCondition();
		
		ThreadId tdId = new Thread123.ThreadId();
		tdId.setId(1);
		Thread t1 = SetThread(lock,condition,1,2,tdId);
		Thread t2 = SetThread(lock,condition,2,3,tdId);
		Thread t3 = SetThread(lock,condition,3,1,tdId);
		
		t1.start();
		t2.start();
		t3.start();
	
		
	}
	private static class ThreadId {
		private int id;
		public ThreadId(){}
		public int getId(){
			return id;
		}
		public void setId(int id){
			this.id = id;
		}
	}
	private static Thread SetThread(final Lock lock, final Condition condition, final int actTdId, final int nextThId, final ThreadId tdId) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				while(count < 10){
					lock.lock();
					System.out.println("Taking Lock TDID:" + tdId.getId()+ "ActID" + actTdId + "NExt:" + nextThId);
					try {
						while(tdId.getId() != actTdId)
							try{
								condition.await();
							} catch (InterruptedException e){
								e.printStackTrace();
							}
						count++;
						System.out.println(" " + actTdId);
						tdId.setId(nextThId);
						condition.signalAll();
						} finally {
							System.out.println("Going to Unlock TDID:" + tdId.getId()+ "ActID" + actTdId + "NExt:" + nextThId);
							lock.unlock();
							System.out.println("Unlocked TDID:" + tdId.getId() + "ActID" + actTdId + "NExt:" + nextThId);
						}
					}
				}
			};
		
		return thread;
	}

}

