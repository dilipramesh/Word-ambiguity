package ambiguity;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * @author Dilip, Srimukh
 *
 */
public class ReadXMLFile {
 
	public static String[] parseXML(String location, String word) throws ParserConfigurationException, SAXException, IOException{
	GetXml.getxml(word);
	File fXmlFile = new File(location);
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
	doc.getDocumentElement().normalize();
 
	NodeList nList = doc.getElementsByTagName("entry");
	String[] syn = null;
	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
		NamedNodeMap attributes = nNode.getAttributes();
		if(attributes.item(0).getNodeValue().toLowerCase().startsWith(word)){
			Element eElement = (Element) nNode;
			if(eElement.getElementsByTagName("dt").getLength()==1)
				System.out.println("'"+attributes.item(0).getNodeValue().toUpperCase()+"'"+" when used as "+eElement.getElementsByTagName("fl").item(0).getTextContent() +" is NOT ambiguous \n");
			else if(eElement.getElementsByTagName("dt").getLength()>1)
				System.out.println("'"+attributes.item(0).getNodeValue().toUpperCase()+"'"+" when used as "+eElement.getElementsByTagName("fl").item(0).getTextContent() +" is ambiguous. Here are the different meanings: \n");
			System.out.println(eElement.getElementsByTagName("fl").item(0).getTextContent().toUpperCase() + " : "+attributes.item(0).getNodeValue());
			System.out.println("-------------------");
			for(int i = 0; i <eElement.getElementsByTagName("dt").getLength(); i++){
			syn = eElement.getElementsByTagName("dt").item(i).getTextContent().split(", ");
			System.out.println(syn[0]);
			}
			System.out.println("");
		}
  }
	return syn;
 
}
}