/**
 * @(#)TP1.java
 *
 *
 * @Belguith 
 * @version 1.00
 */

import java.awt.*;
import javax.swing.*;

//----------------------
import java.awt.event.*;
//----------------------

public class TP1 extends JFrame /*--->*/ implements ActionListener /*<---*/
{
	//Les Libelles
	JLabel idL=new JLabel("Id");
	JLabel nomL=new JLabel("Nom");
	JLabel prenomL=new JLabel("Prenom");
	JLabel adresseL=new JLabel("Adresse");
	//Les champs de texte
	JTextField idT=new JTextField();
	JTextField nomT=new JTextField();
	JTextField prenomT=new JTextField();
	//Les zones de texte deroulants
	String liste[]={"Ville A","Ville B","Ville C"};
	//Les bouttons
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JComboBox adresseT=new JComboBox(liste);
	
    public TP1()
    {
    	super("TP1");
    	
    	Container c=getContentPane();
    	c.setLayout(new GridLayout(5,2));
    	c.add(idL);			c.add(idT);
    	c.add(nomL);		c.add(nomT);
    	c.add(prenomL);		c.add(prenomT);
    	c.add(adresseL);	c.add(adresseT);
    	c.add(valider);		c.add(annuler);
    	
    	setSize(500,200);
    	setLocationRelativeTo(getParent());
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	show();
    	
    	
    	//Les ecouteurs-------------------
	gestionEvenement evt=new gestionEvenement();
    	valider.addActionListener(evt);
    	annuler.addActionListener(evt);
    	//--------------------------------
    }
    


/**
 * @(#)gestionEvenement.java
 *
 *
 * @Belguith 
 * @version 1.00
 */
 
class gestionEvenement implements ActionListener
{

    
    //Gestionnaire des évenements--------------------------------------------------------------------------------------------------------------
    public void actionPerformed(ActionEvent e)
    {
    	//Si l'action sur le boutton "Valider"
    	if(e.getSource()==valider)
    	{
    		//Boite de message
    		javax.swing.JOptionPane.showMessageDialog(null,"Votre nom est "+nomT.getText()+", "+prenomT.getText()+"\nAdresse: "+adresseT.getSelectedItem());
    	}
    	
    	//Si l'action sur le boutton "Annuler"
    	if(e.getSource()==annuler)
    	{
    		idT.setText("");
    		nomT.setText("");
    		prenomT.setText("");
    		adresseT.setSelectedIndex(0);
    	}
    }
    //------------------------------------------------------------------------------------------------------------------------------------------
    
}



    //Méthode principale
    public static void main (String[] args)
    {
    	new TP1();
	}
}