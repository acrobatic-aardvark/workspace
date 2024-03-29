//Clay Howell
//CS 350
//3/25/2015

package Default;

import java.lang.Thread;
import java.util.concurrent.*;

public class ThreadSync
{
    private static boolean runFlag = true;
	static Semaphore asterisk = new Semaphore(1);
	static Semaphore num = new Semaphore(1);
	static Semaphore letter = new Semaphore(0);
	
    public static void main( String[] args ) {
     	Runnable[] tasks = new Runnable[17];
    	Thread[] threads = new Thread[17];
    	// create 10 digit threads
    	for (int d=0; d<10; d++) {
    		tasks[d] = new PrintDigit((char)('0'+d));
    		threads[d] = new Thread( tasks[d] );
    		threads[d].start();
    	}
    	// create 6 letter threads
    	for (int d=0; d<6; d++) {
    		tasks[d+10] = new PrintLetter((char)('A'+d));
    		threads[d+10] = new Thread( tasks[d+10] );
    		threads[d+10].start();
    	}
       	// create a thread to print asterisk(*)
		tasks[16] = new PrintSymbol('*');
		threads[16] = new Thread( tasks[16] );
		threads[16].start();

		// Let the threads to run for a period of time
        try {
        	Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
        	ex.printStackTrace();
        }
        
        runFlag = false;
        // Interrupt the threads
        for (int i=0; i<17; i++) threads[i].interrupt();
    }
    
    public static class PrintDigit implements Runnable 
    {
    	private char c;
    	public PrintDigit(char c) { this.c=c; }
        public void run(){
    	    while (runFlag) {
    	    	try{
    	    		num.acquire(1);

    	    	}catch(InterruptedException e){
    	    		e.printStackTrace();
    	    	}
       	        
       	        System.out.printf( "%c\n", c);
       	        letter.release(1);
       	        
    	    }
        }
    }
    public static class PrintLetter implements Runnable 
    {
    	private char c;
    	public PrintLetter(char c) { this.c=c; }
        public void run(){
    	    while (runFlag) {
    	    	try{
    	    		letter.acquire(1);
    	    	}
				catch(InterruptedException e){
    	    		e.printStackTrace();
    	    }
    	    System.out.printf( "%c\n", c);
			asterisk.release(1);
    	    }
        }
    }
    public static class PrintSymbol implements Runnable 
    {
    	private char c;
    	public PrintSymbol(char c) { this.c=c; }
        public void run(){
    	    while (runFlag) {
    	    	try{
					asterisk.acquire();
    	    	}
				catch(InterruptedException e){
    	    		e.printStackTrace();
    	    	}
    	    	System.out.printf( "%c\n", c);
				num.release(1);
    	    }
        }
    }
}