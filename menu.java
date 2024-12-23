/**
 * @(#)TP5.java
 *
 *
 * @Belguith 
 * @version 1.00 2016/11/5
 */

import java.awt.*;
import javax.swing.*;

public class TP5 extends JFrame
{
	JMenuBar menuBar=new JMenuBar();
	
	JMenu fichier=new JMenu("Fichier");
		JMenuItem ouvrir=new JMenuItem("Ouvrir");
		JMenu enregistrer=new JMenu("Enregistrer");
			JMenuItem enregistr=new JMenuItem("Enregistrer");
			JMenuItem enregistrSous=new JMenuItem("Enregistrer Sous");
		JMenuItem quitter=new JMenuItem("Quitter");
	JMenu edition=new JMenu("Edition");
		JMenuItem coupier=new JMenuItem("Coupier");
		JMenuItem couper=new JMenuItem("Couper");
		JMenuItem coller=new JMenuItem("Coller");
	JMenu aide=new JMenu("Aide");
		JMenuItem aproposde=new JMenuItem("A Propos de..");
    public TP5()
    {
    	super("TP5");
    	
    	//Menu Fichier------------------
    	enregistrer.add(enregistr);
    	enregistrer.add(enregistrSous);
    	fichier.add(ouvrir);
    	fichier.add(enregistrer);
    	fichier.add(quitter);
    	
    	//Menu Edition------------------
    	edition.add(coupier);
    	edition.add(couper);
    	edition.add(coller);
    	
    	//Menu Aide---------------------
    	aide.add(aproposde);
    	
    	//Barre de menu
    	menuBar.add(fichier);
    	menuBar.add(edition);
    	menuBar.add(aide);
    	
    	setJMenuBar(menuBar);
    	
    	setSize(500,400);
    	setLocationRelativeTo(getParent());
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	show();
    }
    
    
    //Méthode principale
    public static void main (String[] args)
    {
    	new TP5();
	}
}