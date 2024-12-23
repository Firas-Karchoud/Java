/**
 * @(#)MyForm.java
 *
 *
 * @author 
 * @version 1.00 2024/12/22
 */
package View;

import java.awt.*;
import javax.swing.*;

import Controller.MyEvent


public class MyForm extends JFrame {
	
	JButton listBtn=new JButton("Liste");
	JButton addBtn=new JButton("Ajouter");
	
	JLabel formL=new JLabel("Formulaire");
	JLabel nameL=new JLabel("Nom");
	JLabel addressL=new JLabel("Adresse");
	
	JTextField nameT=new JTextField();
	JRadioButton hommeR=new JRadioButton("Homme", true);
	JRadioButton femmeR=new JRadioButton("Femme");
	
	ButtonGroup bg=new ButtonGroup();	
    public MyForm() {
    	setTitle("Formulaire");
    	setSize(400,180);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setLocationRelativeTo(getParent());
    	formL.setHorizontalAlignment(SwingConstants.CENTER);
    	setAlwaysOnTop(true);
    	
    	bg.add(hommeR);
    	bg.add(femmeR);
    	
    	JPanel pGenre=new JPanel(new GridLayout(1,2));
    	pGenre.add(hommeR); pGenre.add(femmeR);
    	
    	JPanel pForm=new JPanel(new GridLayout(2,2));
    	pForm.setBorder(BorderFactory.createTitledBorder("Inscription"));
    	pForm.add(nameL); 		pForm.add(nameT);
    	pForm.add(addressL); 	pForm.add(pGenre);
    	
    	JPanel pBtn=new JPanel(new FlowLayout(FlowLayout.RIGHT));
    	pBtn.add(listBtn); pBtn.add(addBtn);
    	
    	
    	
    	Container c=getContentPane();
    	c.setLayout(new BorderLayout());
    	c.add("North", formL);
    	c.add("Center", pForm);
    	c.add("South", pBtn);
    	
    	setVisible(true);
    	
    	//Listeners --------------------------------
    	MyEvent evt=new MyEvent(this);
    	addBtn.addActionListener(evt);
    	listBtn.addActionListener(e->new MyList());
    }
    
    
    //Getters
    public String getName() {
    	return this.nameT.getText();
    }
    public String getGender() {
    	String gender="Homme";
    	if(this.femmeR.isSelected()) {
    		gender="Femme";
    	}
    	return gender;
    }
    
    
}