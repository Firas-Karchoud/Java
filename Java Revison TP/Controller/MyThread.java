/**
 * @(#)MyThread.java
 *
 *
 * @author 
 * @version 1.00 2024/12/22
 */

package Controller;

import View.MyList;
import Model.MyDataBase;

public class MyThread extends Thread {
	MyDataBase mdb;
	MyList list;
    public MyThread(MyList list) {
    	this.list=list;
    	mdb=new MyDataBase();
    }
    
    public void run() {
    	while(true) {
    		mdb.fillTable(list.model);
    		try {
    			sleep(1000);
    		}
    		catch(Exception e) {}
    	}
    }
    
    
    
}