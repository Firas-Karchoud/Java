/**
 * @(#)TP3.java
 *
 *
 * @Belguith 
 * @version 1.00
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Importer la bibliothèque SQL------
import java.sql.*;
//----------------------------------

public class TP1 extends JFrame implements ActionListener
{
	//Les variables BD-----------------------------------
	Connection maConnection=null; //Variable de connexion
	Statement stm=null; //Requete
	ResultSet res;     //Resultat de la requete Select
	//---------------------------------------------------
	
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
	JComboBox adresseT=new JComboBox(liste);
	
	//Les bouttons
	JButton ajouter=new JButton("Ajouter");
	JButton supprimer=new JButton("Supprimer");
	JButton modifier=new JButton("Modifier");
	JButton Rechercher=new JButton("Rechercher");
	JButton annuler=new JButton("Annuler");
	
	
    public TP1()
    {
    	super("TP1");
    	
    	JPanel p1=new JPanel();
    	p1.setLayout(new GridLayout(4,2));
    	p1.add(idL);		p1.add(idT);
    	p1.add(nomL);		p1.add(nomT);
    	p1.add(prenomL);	p1.add(prenomT);
    	p1.add(adresseL);	p1.add(adresseT);
    	
    	JPanel p2=new JPanel();
    	p2.setLayout(new GridLayout(1,5));
    	p2.add(ajouter);	p2.add(supprimer);
    	p2.add(modifier);	p2.add(Rechercher);
    	p2.add(annuler);
    	
    	Container c=getContentPane();
    	c.setLayout(new BorderLayout());
    	c.add("Center",p1);
    	c.add("South",p2);
    	
    	setSize(600,200);
    	setLocationRelativeTo(getParent());
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	show();
    	
    	
    	//-------------
    	connexion_BD();
    	//-------------
    	
    	
    	//Les ecouteurs
    	ajouter.addActionListener(this);
    	supprimer.addActionListener(this);
    	modifier.addActionListener(this);
    	Rechercher.addActionListener(this);
    	annuler.addActionListener(this);
    }
    
    
    
    public void actionPerformed(ActionEvent e)
    {
    	//Boutton Ajouter
    	if(e.getSource()==ajouter)
    	{
    		if(Ajouter(nomT.getText(), prenomT.getText(), adresseT.getSelectedItem().toString())>0)
    			JOptionPane.showMessageDialog(null, "Insertion effectuée");
    		else
    			JOptionPane.showMessageDialog(null, "Echec d'insertion");
    	}
    	//Boutton Supprimer
    	if(e.getSource()==supprimer)
    	{
    		if(Supprimer(Integer.parseInt(idT.getText()))>0)
    			JOptionPane.showMessageDialog(null, "Suppression effectuée");
    		else
    			JOptionPane.showMessageDialog(null, "Echec de Suppression");
    	}
    	//Boutton Modifier
    	if(e.getSource()==modifier)
    	{
    		if(Modifier(Integer.parseInt(idT.getText()), nomT.getText(), prenomT.getText(), adresseT.getSelectedItem().toString())>0)
    			JOptionPane.showMessageDialog(null, "Modification effectuée");
    		else
    			JOptionPane.showMessageDialog(null, "Echec de Mise à jour");
    	}
    	//Boutton Rechercher
    	if(e.getSource()==Rechercher)
    	{
    		if(Rechercher(Integer.parseInt(idT.getText()))==false)
    			JOptionPane.showMessageDialog(null, "Enregistrement n'existe pas dans la base");
    	}
    }
    
/*
				  ||		||		||
				 _||_	   _||_	   _||_
				 \  /	   \  /	   \  /
				  \/	    \/	    \/
*/    
    
    //----------------------------------------------------------------------------------------------------------------------------------------
    //Requete Insert--------------------------------------------------------------------------------------------------------------------------
    
    int Ajouter(String nom, String prenom, String adresse)
    {
    	try
    	{
    		int resUpd=stm.executeUpdate("INSERT INTO utilisateurs (nom, prenom, adresse) VALUES ('"+nom+"','"+prenom+"','"+adresse+"')");
    		return resUpd;
    	}
    	catch(SQLException e)
    	{
    		System.err.println("Error executing query: " + e); 
    	}
    	return 0;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------
 
 
/*
				  ||		||		||
				 _||_	   _||_	   _||_
				 \  /	   \  /	   \  /
				  \/	    \/	    \/
*/ 
 
    //----------------------------------------------------------------------------------------------------------------------------------------
    //Requete Delete--------------------------------------------------------------------------------------------------------------------------
    
    int Supprimer(int id)
    {
    	try
    	{
    		int resUpd=stm.executeUpdate("DELETE FROM utilisateurs WHERE id="+id);
    		return resUpd;
    	}
    	catch(SQLException e)
    	{
    		System.err.println("Error executing query: " + e); 
    	}
    	return 0;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------
  
 
/*
				  ||		||		||
				 _||_	   _||_	   _||_
				 \  /	   \  /	   \  /
				  \/	    \/	    \/
*/ 
 
    //----------------------------------------------------------------------------------------------------------------------------------------
    //Requete Update--------------------------------------------------------------------------------------------------------------------------
    
    int Modifier(int id, String nom, String prenom, String adresse)
    {
    	try
    	{
    		int resUpd=stm.executeUpdate("UPDATE utilisateurs set nom='"+nom+"', prenom='"+prenom+"', adresse='"+adresse+"' WHERE id="+id);
    		return resUpd;
    	}
    	catch(SQLException e)
    	{
    		System.err.println("Error executing query: " + e); 
    	}
    	return 0;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------
    
    
/*
				  ||		||		||
				 _||_	   _||_	   _||_
				 \  /	   \  /	   \  /
				  \/	    \/	    \/
*/    
    
    //----------------------------------------------------------------------------------------------------------------------------------------
    //Requete Select--------------------------------------------------------------------------------------------------------------------------
    
    boolean Rechercher(int id)
    {
    	try
    	{
    		res=stm.executeQuery("SELECT * FROM utilisateurs WHERE id="+id);
    		while(res.next())
    		{
    			nomT.setText(res.getString("nom"));
    			prenomT.setText(res.getString("prenom"));
    			adresseT.setSelectedItem(res.getString("adresse"));
    			return true;
    		}
    	}
    	catch(SQLException e)
    	{
    		System.err.println("Error executing query: " + e); 
    	}
    	return false;
    }
    //----------------------------------------------------------------------------------------------------------------------------------------    
  
  
/*
				  ||		||		||
				 _||_	   _||_	   _||_
				 \  /	   \  /	   \  /
				  \/	    \/	    \/
*/    
    
    //----------------------------------------------------------------------------------------
    //Méthode de connexion--------------------------------------------------------------------
    void connexion_BD()
    {
    	String pilote="com.mysql.jdbc.Driver";
    	String url="jdbc:mysql://localhost/mabase";
    	String nom_utilisateur="root";
    	String motdepasse="";
    	
    	//1)Etape 1:	Charger un pilote driver ==>
    	try
    	{
    		Class.forName (pilote);
    	}
    	catch(ClassNotFoundException e)
    	{
    		System.err.println("Driver loading error: " + e); 
    	}
    	
    	//2)Etape 2:	Etablir une connexion ==>
    	try
    	{
    		maConnection = DriverManager.getConnection(url,nom_utilisateur,motdepasse);
    	}
    	catch(SQLException e)
    	{
    		System.err.println("Error opening SQL connection: " + e); 
    	}
    	
    	
    	//3)Etape 3:	Créer un objet Statement ==>
    	try
    	{
    		stm = maConnection.createStatement();
    	}
    	catch(SQLException e)
    	{
    		System.err.println("Error creating SQL statement: " + e); 
    	}
    }
    //----------------------------------------------------------------------------------------
    
    
    
    
    
    
    
    //Méthode principale
    public static void main (String[] args)
    {
    	new TP1();
	}
}