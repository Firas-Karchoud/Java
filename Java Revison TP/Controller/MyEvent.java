/**
 * @(#)MyEvent.java
 *
 *
 * @author 
 * @version 1.00 2024/12/22
 */
package Controller;
 
import java.awt.event.*;
import javax.swing.*;

import View.MyForm;
import Model.MyDataBase;

public class MyEvent implements ActionListener {
	
	MyDataBase mdb;
	MyForm form;
    public MyEvent(MyForm form) {
    	mdb=new MyDataBase();
    	this.form=form;
    }
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource()==form.addBtn) {
    		Person p=new Person(form.getName(), form.getGender());
    		int res=mdb.add(p);
    		if(res>0) {
    			JOptionPane.showMessageDialog(null, "Your form was successfully submitted", "Information", JOptionPane.INFORMATION_MESSAGE);
    		}
    		else {
    			JOptionPane.showMessageDialog(null, "Unable to submit form", "Warning", JOptionPane.WARNING_MESSAGE);
    		}
    	}
    }
    
    
}