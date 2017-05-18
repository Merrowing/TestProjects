package main;

import java.math.BigInteger;

public class paralel extends Thread{
	public void run(){
		int n2 =1000 ;
        boolean[] paralelArray2 = new boolean[n2];
        paralelArray2[0] = true;
        paralelArray2[1] = true;
        for (int i = 0; i < paralelArray2.length; i++) {
            if (!paralelArray2[i]) {
                for (int j = 2 * i; j < paralelArray2.length; j += i) {
                	paralelArray2[j] = true;
                }
            }
        }
        
        for (int i=0;i<paralelArray2.length;i++) {
            if (!paralelArray2[i]) {
                System.out.println(i);
            }
        }
        verifyArray2(paralelArray2);
        
       
    }
    
    public void verifyArray2(boolean[] primeArray2) {
        for (int i=0;i<primeArray2.length;i++) {
            BigInteger bi = new BigInteger(i+"");
            if (primeArray2[i]==bi.isProbablePrime(20)) {
                System.out.println("Error: "+i+" flag is wrong");
            }
        }
    }
		
	
	static paralel thread1 = new paralel();
	static Thread thread2 = new Thread(new Runnable()	{
		public void run(){
			int n1 = 1000;
	        startTime = System.currentTimeMillis();
	        boolean[] paralelArray1 = new boolean[n1];
	        paralelArray1[0] = true;
	        paralelArray1[1] = true;
	        for (int i = 0; i < paralelArray1.length; i++) {
	            if (!paralelArray1[i]) {
	                for (int j = 2 * i; j < paralelArray1.length; j += i) {
	                	paralelArray1[j] = true;
	                }
	            }
	        }
	        
	        for (int i=0;i<paralelArray1.length;i++) {
	            if (!paralelArray1[i]) {
	                System.out.println(i);
	            }
	        }
	        verifyArray(paralelArray1);
	        
	        
	    }
	    
	    public void verifyArray(boolean[] primeArray1) {
	        for (int i=0;i<primeArray1.length;i++) {
	            BigInteger bi = new BigInteger(i+"");
	            if (primeArray1[i]==bi.isProbablePrime(20)) {
	                System.out.println("Error: "+i+" flag is wrong");
	            }
		}
	}});
	static long startTime = 0;
    public static void main(String[] args) {
    	
    	
    	 
         thread1.start();
         try{
     		Thread.sleep(1000);
     	} catch (InterruptedException e){}
         thread2.start();
        
         
         try{
        	 thread1.join();
        	 thread2.join();
         } catch (InterruptedException e){}
         
         
         long currentTime1=(long)(System.currentTimeMillis()-startTime);
         System.out.println(currentTime1 + "ms");
    }
   
    
}