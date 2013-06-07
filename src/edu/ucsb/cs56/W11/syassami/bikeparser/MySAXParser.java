package edu.ucsb.cs56.W11.syassami.bikeparser;

import java.util.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

/**
 * This class is our actual parser, which is an extension of the default handler already provided by xml libraries within java.
 * We are going to be using Apache's Xerces parser to complete our tasks and make XML parsing life easier, below are comments that will make comprehending the file much easier.
 */


public class MySAXParser extends DefaultHandler {
  LinkedList<Bike> bikeList; // List of Bike's
  LinkedList<String> componentList; // List of components
  String owner; // Bike Owner 
  String type;
  StringBuffer b = new StringBuffer(); // collects text

/**
 * Args are passed in via the build.xml already, so the program already parses bike.xml
 */  
  public static void main(String[] args) {
    // main receives the name of an XML file 
    if (args.length > 0) {
      MySAXParser mp = new MySAXParser();
      try {
        mp.processFile(args[0]);
        mp.listBikes();
      } catch (Exception e) {e.printStackTrace();}
    }
  }  

/**
 * This uses the XERCES parser on apache's website
 */
  
  public void processFile(String file) throws Exception {
    // Parse an XML file and 
    // return a list of bikes's
    bikeList = new LinkedList<Bike>();
    XMLReader parser = XMLReaderFactory.createXMLReader();
    parser.setContentHandler(this);
    parser.parse(file);
  }
/**
 *uri and local name are used with namespaces, something that our xml file doesnt really contain, so we are just skipping to the basics
qname is the name of the element found, ie, bike or owner etc.
* attributes are within the tags, and here we have none in our xml file, so lets continue.
*/
  public void startElement(String uri, String localName, String qname, 
                           Attributes attributes) {
    System.out.println("startElement:" + qname);
    b.setLength(0); // empty character buffer
    if (qname.equals("bike")) {
      componentList = new LinkedList<String>();
    }  
  } 
  /**
 * for each start element, there is an endElement, that closes the tag off.
 */
  public void endElement(String uri, String localName, String qname) { 
    System.out.println("endElement:" + qname+":" + b.toString());
    if (qname.equals("owner")) {
      owner = b.toString();
    } else if (qname.equals("type")) {
      type = b.toString();
    } else if (qname.equals("components")) {
      String components = b.toString();
      componentList.add(components);
    } else if (qname.equals("bike")) {
      bikeList.add(new Bike(owner, type, componentList));       
    }  
    b.setLength(0); // empty character buffer
   
  }
/**
 *This will handle the characters or "values" in the xml file, and will print them specified like the System.out argument seen in the code
*/
  public void characters(char[] chars, int start, int length) { 
    // collect the characters
    System.out.println("characters:" + new String(chars, start, length));
    b.append(chars, start, length);
  }
/**
 * This will list all the bikes, components, and types using the getters defined in our Bike.xml
 */
  public void listBikes() {
    // List Bike's on System.out
      for (Bike bike : bikeList) {
          System.out.println(bike.getOwner() + "/" +
                  bike.getType() + "/" + bike.getComponents());
      }
  }  
/**
 * Returns list of bikes
 */
  public List getBikes() {
    return bikeList;
  }
 
}
