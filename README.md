Shayan Yassami & Tong Wu

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

**What does this all mean to SAX?**
Good thing you asked, SAX is an event-based parser, meaning that when it reads the XML file, it’ll call various methods in your program when certain events occur. These methods are called “call-back” methods & there are four SAX interfaces that support them.

**How does SAX see it?**
1. First, the startElement method is called - and SAX will tell you that it found the `<bike>` start tag.
2. startElement is then called again, now seeing the `<owner>` tag
3. Now, the characters have been called
4. Then we are told “Shayan” has been read from the XML file.
5. endElement is now called, and SAX informs us that this was the end of the `<owner>` tag.
6. Now it is obvious that “Shayan” is the value for the `<owner>` tag.

**What do The Most of the things within the file’s below mean?**
Check the [Javadoc] (http://www.cs.ucsb.edu/~syassami/cs56/W11/issues/0000015/javadoc)
