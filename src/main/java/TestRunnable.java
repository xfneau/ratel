



public class TestRunnable implements Runnable{

	  int total;

	  public static void main(String[] args) {
		  	
	        ReturnThreadInfo returnThreadInfo = new ReturnThreadInfo();
	        returnThreadInfo.start();
	        System.out.println(returnThreadInfo.getThreadInfo());
	    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
      
   
}

