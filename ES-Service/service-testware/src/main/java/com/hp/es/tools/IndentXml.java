package com.hp.es.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.LinkedList;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class IndentXml {

    static int childCount = 0;

    private LinkedList format(String uri) throws SAXException, IOException {
        DOMParser parser = new DOMParser();
        parser.parse(uri);
        Document document = parser.getDocument();
        LinkedList formatedString = new LinkedList();
        internalFormatRecursive(document, "", formatedString);
        return formatedString;
    }


    private Integer internalFormatRecursive(Node node, String indent, LinkedList formatedString) {

        int attributesCount = 0;
        int subchildCount = 0;
        Integer textLength = null;

        if (node == null) {
            return null;
        }

        int type = node.getNodeType();

        switch (type) {
            case Node.DOCUMENT_NODE: {
                String toAppend = indent;
                toAppend += "<?xml version=\"1.0\" encoding=\"" + "UTF-8" + "\"?>";
                formatedString.add(toAppend);
                internalFormatRecursive(((Document)node).getDocumentElement(), "", formatedString);
                break;
             }
             case Node.ELEMENT_NODE: {
                 String toAppend = indent;
                 toAppend += "<";
                 toAppend += node.getNodeName();
                 attributesCount = (node.getAttributes() != null) ? node.getAttributes().getLength() : 0;

                 Attr attributes[] = new Attr[attributesCount];

                 for (int loopIndex = 0; loopIndex < attributesCount; loopIndex++) {
                     attributes[loopIndex] =
                     (Attr)node.getAttributes().item(loopIndex);
                 }

                  for (int loopIndex = 0; loopIndex < attributes.length; loopIndex++) {
                     Attr attribute = attributes[loopIndex];
                     toAppend += " ";
                     toAppend += attribute.getNodeName();
                     toAppend += "=\"";
                     toAppend += attribute.getNodeValue();
                     toAppend += "\"";
                 }
                 toAppend += ">";
                 NodeList childNodes = node.getChildNodes();
                 if (childNodes != null) {
                     formatedString.add(toAppend);
                     subchildCount = childNodes.getLength();
                     indent += "    ";
                     for (int loopIndex = 0; loopIndex < subchildCount; loopIndex++ ) {
                        textLength = internalFormatRecursive(childNodes.item(loopIndex), indent, formatedString);
                     }
                     if ( (subchildCount != 1) || (childNodes.item(0).getNodeType() != Node.TEXT_NODE) ) {
                         textLength = null;
                     }
                 }
                 break;
             }
             case Node.CDATA_SECTION_NODE: {
                 String toAppend = indent;
                 toAppend += "<![CDATA[";
                 toAppend += node.getNodeValue();
                 toAppend += "]]>";
                 formatedString.add(toAppend);
                 break;
             }
             case Node.TEXT_NODE: {
                 String newText = node.getNodeValue().trim();
                 textLength = new Integer(newText.length());
                 String toAppend = (String) formatedString.removeLast();
                 toAppend += newText;
                 formatedString.add(toAppend);
                 break;
             }
             case Node.PROCESSING_INSTRUCTION_NODE: {
                 String toAppend = indent;
                 toAppend += "<?";
                 toAppend += node.getNodeName();
                 String text = node.getNodeValue();
                 if (text != null && text.length() > 0) {
                     toAppend += text;
                 }
                 toAppend += "?>";
                 formatedString.add(toAppend);
                 break;
            }
        }

        if (type == Node.ELEMENT_NODE) {
            // displayStrings[numberDisplayLines] = indent.substring(0, indent.length() - 4);
            // check if we have an empty tag or a text taf
            String toAppend;
            if ( (textLength != null) || (subchildCount == 0) ) {
                toAppend = (String) formatedString.removeLast();
            } else {
                toAppend = indent.substring(0, indent.length() - 4);
            }
            toAppend += "</";
            toAppend += node.getNodeName();
            toAppend += ">";
            formatedString.add(toAppend);
        }

        return textLength;

    }

    private void writeFormattedFile(String fileName, LinkedList formatedString) {
        // delete the file
        File file = new File(fileName);
        file.delete();
        // create the new file
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            for(Iterator it = formatedString.iterator(); it.hasNext();) {
                osw.write(it.next() + "\n");
            }
            osw.close();
            fos.close();
        } catch(IOException ioe) {
            System.out.println("IOException!");
        }
    }

    
    
    public String writeFormattedString(String xml) {
    	String formatedString;
    	StringReader sr = new StringReader(xml);
        DOMParser parser = new DOMParser();
        try {
			parser.parse(new InputSource(sr));
	        Document document = parser.getDocument();
	        LinkedList linkedString = new LinkedList();
	        internalFormatRecursive(document, "", linkedString);
	        
	        
	        StringWriter sw = new StringWriter();
	        for(Iterator it = linkedString.iterator(); it.hasNext();) {
	            sw.write(it.next() + "\n");
	        }        
	        formatedString = sw.toString();			
		} catch (SAXException e) {
			e.printStackTrace();
			formatedString =e.getMessage();
		} catch (IOException e) {
			e.printStackTrace();
			formatedString =e.getMessage();
		}

        return formatedString;
      }
    
    private void printUsage() {
        System.out.println("Usage: IndentXml <file>");
    }

    public static void main(String args[]) {

        IndentXml indentXml = new IndentXml();

        if(args.length != 1) {
            indentXml.printUsage();
            System.exit(1);
        }

        System.out.println("Formatting " + args[0] + " ...");
        try {
            File f = new File(args[0]);
            if (f.isDirectory()) {
                File [] files = f.listFiles();
                if (files != null) {
                    for (int i=0; i<files.length; i++) {
                        File theFile = files[i];
                        System.out.println("Formatting " + theFile.getPath() + " ...");
                        LinkedList result = indentXml.format(theFile.getPath());
                        //write the new file
                        indentXml.writeFormattedFile(theFile.getPath(), result);
                    }
                }
            } else {
                LinkedList result = indentXml.format(args[0]);
                //write the new file
                indentXml.writeFormattedFile(args[0], result);
            }
        } catch(SAXException se) {
            System.out.println("Parsing exception: " + se.getMessage());
            System.out.println("No change to the file...");
            System.exit(1);
        } catch(IOException io) {
            System.out.println("IOException: " + io.getMessage());
            System.exit(1);
        }
    }
}