package edu.ucsb.cs56.W11.syassami.bikeparser;

	import java.util.*;

/**
 *  this is a basic class that includes getters and a default constructor of the stuff we want to parse in our xml file.
 *  
 */	
	public class Bike {
	  String owner;
	  String type;
	  List components;
	  
	  public Bike(String owner, String type, List components) {
	    this.owner = owner;
	    this.type = type;
	    this.components = components;
	  }
	  
	  public String getOwner() {return owner;}
	  
	  public String getType() {return type;}
	  
	  public String getComponents() {
	    StringBuffer s = new StringBuffer();
	    for (Iterator i = components.iterator(); i.hasNext();) {
	      if (s.length() != 0) s.append(", ");
	      s.append((String)i.next());
	    }  
	    return s.toString();
	  }
	
	}

