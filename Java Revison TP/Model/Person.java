/**
 * @(#)Personne.java
 *
 *
 * @author 
 * @version 1.00 2024/12/22
 */
package Model;

public class Person {
	private String name;
	private int id;
	private String gender;
	
    public Person() {
    	this.name="";
    	this.id=0;
    	this.gender="Homme";
    }
    public Person(int id, String name, String gender) {
    	this.name=name;
    	this.id=id;
    	this.gender=gender;
    }
    public Person(String name, String gender) {
    	this.name=name;
    	this.gender=gender;
    }
    
    public void setId(int id)			{ this.id=id; }
    public void setName(String name)	{ this.name=name; }
    public void setGender(String gender){ this.gender=gender; }
    
    public int getId()					{ return this.id; }
    public String getName()				{ return this.name; }
    public String getGender()			{ return this.gender; }
    
    @Override
    public String toString() {
    	return this.id+" "+this.name+" "+this.gender; 
    }
    
}