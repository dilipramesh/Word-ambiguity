/**
 * 
 */
package ambiguity;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * @author Dilip, Srimukh
 *
 */
public class Xml {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub
		String word;
		System.out.println("Enter a word: ");
		Scanner a = new Scanner(System.in);
		word = a.nextLine();
		a.close();
		GetXml.getxml(word);
		String location = "xmlFiles/"+word+".xml";
		@SuppressWarnings("unused")
		String[] syn = ReadXMLFile.parseXML(location, word);
	}
}
