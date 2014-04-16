project history
===============
```
 N/A
```

*Shayan Yassami & Tong Wu*
# How To Use SAX XML Parsing in Java
Many people enter the java programming language with some ideas of parsing files coming on from other languages; yet the choice of deciding which method to use can be difficult, and the beginner might not know the pro’s and con’s of each. There are two popular XML parsing methods in java, DOM (Document Object Model), and SAX (Simple API for XML). In this tutorial, we will go ahead and use SAX Parser, a faster and more memory efficient mechanism. So lets get straight to it.

Here we have a basic part of an XML file.

```` XML
<?xml version = “1.0”?>
<bike>
        <owner>Shayan</owner>
        <type>Colnago</type>
</bike>

````

Here we have 3 startElements, `<bike>` `<owner>` and `<type>` (open tags), 3 endElements `</owner>` `</type>` `</bike>` (close tags), and two characters, “Shayan” and “Colnago”

## What does this all mean to SAX?
Good thing you asked, SAX is an event-based parser, meaning that when it reads the XML file, it’ll call various methods in your program when certain events occur. These methods are called “call-back” methods & there are four SAX interfaces that support them.

## How does SAX see it?
1. First, the startElement method is called - and SAX will tell you that it found the `<bike>` start tag.
2. startElement is then called again, now seeing the `<owner>` tag
3. Now, the characters have been called
4. Then we are told “Shayan” has been read from the XML file.
5. endElement is now called, and SAX informs us that this was the end of the `<owner>` tag.
6. Now it is obvious that “Shayan” is the value for the `<owner>` tag.

## What do The Most of the things within the file’s below mean?
Check the [Javadoc] (http://www.cs.ucsb.edu/~syassami/cs56/W11/issues/0000015/javadoc)

## Example XML Parser (Taken From Apache’s Website)
```` java
import java.util.*;
        import org.xml.sax.*;
        import org.xml.sax.helpers.*;
        
        public class MySAXParser extends DefaultHandler {
          static final String PARSER = "org.apache.xerces.parsers.SAXParser";
          StringBuffer b = new StringBuffer(); // collects text
          List list; // holds parsed results
          . . .
          public static void main(String[] args) {
            // main receives the name of an XML file 
            if (args.length > 0) {
              MySAXParser mp = new MySAXParser();
              try {
                mp.processFile(args[0]);
                mp.listData();
              } catch (Exception e) {e.printStackTrace();};
            }
          }  
          
          public void processFile(String file) throws Exception {
            // Parse an XML file 
            list = new LinkedList();
            XMLReader parser = 
                      XMLReaderFactory.createXMLReader(PARSER); // ***2***
            parser.setContentHandler(this); // ***3***
            parser.parse(file); // ***4***
          }
          
          // ***1*** 
          public void startElement(String uri, String localName, String qname, 
                                   Attributes attributes) {
            b.setLength(0); // empty character buffer
            . . .
          } 
          
          // ***1*** 
          public void endElement(String uri, String localName, String qname) { 
            b.setLength(0); // empty character buffer
            . . .   // ***5***
          }
        
          // ***1*** 
          public void characters(char[] chars, int start, int length) { 
            // collect the characters
            b.append(chars, start, length); // ***5***
          }
          
          public void listData() {
            //List Data
            . . .
          }  
        }      
````

## The End Result
````
startElement:collection
        characters:
          
        startElement:bike
        characters:
            
        startElement:owner
        characters:Shayan
        endElement:owner:Shayan
        characters:
            
        startElement:type
        characters:Colnago
        endElement:type:Colnago
        characters:
            
        startElement:components
        characters:Shimano
        endElement:components:Shimano
        characters:	
            
        startElement:components
        characters:FSA
        endElement:components:FSA
        characters:
            
          
        endElement:bike:
````
and then will continue to parse the rest of our XML file.
