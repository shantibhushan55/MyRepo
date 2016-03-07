/*
 * BatchTester.java
 * Created on 15 2004
 *
 * Entitlement Service Project
 */
package com.hp.es.test.batchEntitlement;



public class BatchTester extends Thread{
    private Object sync = new Object();
    /**
     * 
     */
    public BatchTester() {
        super();
    }

    public static void main(String[] args)  {
        // We are going to craete a service hndler and then we will wait for ever
       // EsServiceHandler handler= new EsServiceHandler();
        
        // Now we wait
        BatchTester b = new BatchTester();
        b.start();
        try {
            b.join();
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
    }
    
    
    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
        try {
            synchronized(sync) {
                sync.wait(1000);
            }
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        
    }
}
