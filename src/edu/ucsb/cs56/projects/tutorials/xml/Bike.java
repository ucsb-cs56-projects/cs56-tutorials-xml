package edu.ucsb.cs56.projects.tutorials.xml;

	import java.util.*;

/**
 *  this is a basic class that includes getters and a default constructor of the stuff we want to parse in our xml file.
 * Previous author: syassami
 * @author Fanny Kuang
 * @version UCSB CS56 Spring 2013
 */	
	public class Bike {
	  String owner;
	  String type;
	  List<String> components;

    /** Constructor
     * @param owner Owner of the bike
     * @param type  Type of bike
     * @param components List of bike components (Strings)
     */
	  public Bike(String owner, String type, List<String> components) {
	    this.owner = owner;
	    this.type = type;
	    this.components = components;
	  }

    /** Returns the owner of bike */
	  public String getOwner() {return owner;}

    /** Returns the type of bike */
	  public String getType() {return type;}

    /** Returns the full list of bike components */
	  public String getComponents() {
	    StringBuilder s = new StringBuilder();
          for (String component : components) {
              if (s.length() != 0) s.append(", ");
              s.append(component);
          }
	    return s.toString();
	  }
	
	}

