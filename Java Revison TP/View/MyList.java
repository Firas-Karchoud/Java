/**
 * @(#)MyList.java
 *
 *
 * @author 
 * @version 1.00 2024/12/22
 */
package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.MyThread;

public class MyList extends JFrame{
	String entete[]={"Id", "Nom", "Adresse"};
	DefaultTableModel model=new DefaultTableModel(entete,0);
	JTable tab=new JTable(model);
	JScrollPane sp=new JScrollPane(tab);
	
    public MyList() {
    	setTitle("Liste");
    	setSize(800,700);
    	setLocationRelativeTo(getParent());
    	Container c=getContentPane();
    	c.setLayout(new BorderLayout());
    	c.add("Center", sp);
    	
    	setVisible(true);
    	
    	//Thread ----------------------
    	MyThread th=new MyThread(this);
    	th.start();
    } 
    
}