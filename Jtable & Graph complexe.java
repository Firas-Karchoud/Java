/**
 * @(#)TP4.java
 *
 *
 * @Belguith 
 * @version 1.00 2016/11/5
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TP4 extends JFrame
{
	//Les Libelles
	JLabel formulaire=new JLabel("Formulaire d'inscription");
	JLabel idL=new JLabel("Id");
	JLabel nomL=new JLabel("Nom");
	JLabel prenomL=new JLabel("Prenom");
	JLabel adresseL=new JLabel("Adresse");
	JLabel image=new JLabel(new ImageIcon("image1.png"));
	
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
	JButton annuler=new JButton("Annuler");
	
	//Le tableau
	String entete[]={"Id","Nom","Prenom","Adresse"};
	DefaultTableModel model=new DefaultTableModel(entete,3);
	JTable table=new JTable(model);
	JScrollPane sp=new JScrollPane();
	
	
    public TP4()
    {
    	super("TP4");
    	
    	//Mise en forme de JLabel "formulaire"
    	formulaire.setHorizontalAlignment(SwingConstants.CENTER);
    	formulaire.setForeground(Color.green);
    	formulaire.setFont(new Font("Time New Roman", Font.BOLD, 25));
    	
    	sp.getViewport().add(table);
    	
    	
    	//--------------->
    	JPanel panelFormulaire=new JPanel();
    	panelFormulaire.setLayout(new GridLayout(5,2));
    	panelFormulaire.add(idL);		panelFormulaire.add(idT);
    	panelFormulaire.add(nomL);		panelFormulaire.add(nomT);
    	panelFormulaire.add(prenomL);	panelFormulaire.add(prenomT);
    	panelFormulaire.add(adresseL);	panelFormulaire.add(adresseT);
    	
    	//--------------->
    	JPanel panelBouttons=new JPanel();
    	panelBouttons.setLayout(new FlowLayout(FlowLayout.RIGHT));
    	panelBouttons.add(ajouter);
    	panelBouttons.add(supprimer);
    	panelBouttons.add(modifier);
    	panelBouttons.add(annuler);
    	
    	//--------------->
    	JPanel panelAssemblage=new JPanel();
    	panelAssemblage.setLayout(new BorderLayout());
    	panelAssemblage.add("Center",sp);
    	panelAssemblage.add("South",panelBouttons);
    	
    	//Fixer la taille de JScrollPane "sp"
    	sp.setPreferredSize(new Dimension(600,200));
    	
    	//Fixer la taille de JPanel "panelFormulaire"
    	image.setPreferredSize(new Dimension(300,200));
    	
    	//--------------->
    	Container c=getContentPane();
    	c.setLayout(new BorderLayout());
    	c.add("North",formulaire);
    	c.add("South",panelAssemblage);
    	c.add("West",image);
    	c.add("Center",panelFormulaire);
    	
    	setSize(600,400);
    	setLocationRelativeTo(getParent());
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	show();
    }
    
    
    //Méthode principale
    public static void main (String[] args)
    {
    	new TP4();
	}
}