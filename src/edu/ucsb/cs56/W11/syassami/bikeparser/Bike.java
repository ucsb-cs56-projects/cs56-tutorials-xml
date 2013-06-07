package edu.ucsb.cs56.W11.syassami.bikeparser;

	import java.util.*;

/**
 *  this is a basic class that includes getters and a default constructor of the stuff we want to parse in our xml file.
 *  
 */	
	public class Bike {
	  String owner;
	  String type;
	  List<String> components;
	  
	  public Bike(String owner, String type, List<String> components) {
	    this.owner = owner;
	    this.type = type;
	    this.components = components;
	  }
	  
	  public String getOwner() {return owner;}
	  
	  public String getType() {return type;}
	  
	  public String getComponents() {
	    StringBuilder s = new StringBuilder();
          for (String component : components) {
              if (s.length() != 0) s.append(", ");
              s.append(component);
          }
	    return s.toString();
	  }
	
	}

