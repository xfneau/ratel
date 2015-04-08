   public class ReturnThreadInfo extends Thread {
    	    private String str;

    	    public ReturnThreadInfo() {
    	        this.str = "Hello";
    	    }
    	    
    	    public void run(){
    	        try{
    	        	this.setPriority(10);
    	            this.str = "Hello World!";
    	            
    	        }catch(Exception ex){
    	            
    	        }
    	    }
    	    
    	    /*返回线程信息：str变量的值*/
    	    public String getThreadInfo(){
    	        return this.str;
    	    }
    	}