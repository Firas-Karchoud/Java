/**
 * @(#)MyDataBase.java
 *
 *
 * @author 
 * @version 1.00 2024/12/22
 */
package Model;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class MyDataBase {
	private Connection cn;
	private Statement stm;
	
    public MyDataBase() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	}
    	catch(ClassNotFoundException e) {
    		System.err.println("Exception: Erreur Driver");
    	}
    	try {
    		cn=DriverManager.getConnection("jdbc:mysql://localhost/base","root","");
    	}
    	catch(Exception e) {
    		System.err.println("Exception: Erreur Connection"+e);
    	}
    	try {
    		stm=cn.createStatement();
    	}
    	catch(Exception e) {
    		System.err.println("Exception: Erreur Statement");
    	}
    }
    
    
    public int add(Person p) {
    	String req="INSERT INTO user (nom, genre) VALUES ('"+p.getName()+"', '"+p.getGender()+"')";
    	try {
    		return stm.executeUpdate(req);
    	}
    	catch(Exception e) {
    		System.err.println("Exception: Erreur SQL Query");
    	}
    	return -1;
    }
    
    public int delete(Person p) {
    	String req="DELETE FROM user WHERE id="+p.getId();
    	try {
    		return stm.executeUpdate(req);
    	}
    	catch(Exception e) {
    		System.err.println("Exception: Erreur SQL Query");
    	}
    	return -1;
    }
    
    public int update(Person p) {
    	String req="UPDATE user SET nom='"+p.getName()+"', genre='"+p.getGender()+"' WHERE id="+p.getId();
    	try {
    		return stm.executeUpdate(req);
    	}
    	catch(Exception e) {
    		System.err.println("Exception: Erreur SQL Query");
    	}
    	return -1;
    }
    
    public void fillTable(DefaultTableModel model) {
    	model.setRowCount(0);
    	String req="SELECT * FROM user";
    	try {
    		ResultSet res=stm.executeQuery(req);
    		while(res.next()) {
    			model.addRow(new Object[]{res.getInt(1), res.getString(2), res.getString(3)});
    		}
    	}
    	catch(Exception e) {
    		System.err.println("Exception: Erreur SQL Query");
    	}
    }
    
    
}