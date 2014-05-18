package ambiguity;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
/**
 * @author Dilip, Srimukh
 *
 */
public class GetXml {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	public static void getxml(String word) throws IOException{
		//URL website = new URL("http://www.dictionaryapi.com/api/v1/references/thesaurus/xml/"+word+"?key=2d11b0e1-ff73-4279-a0ad-8652e859df31");
		try{URL website = new URL("http://www.dictionaryapi.com/api/v1/references/collegiate/xml/"+word+"?key=680e0f02-8020-4a05-bac1-be33f0f618f7");
		ReadableByteChannel rbc = Channels.newChannel(website.openStream());
		FileOutputStream fos = new FileOutputStream("xmlFiles/"+word+".xml");
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();}
		catch(Exception e){
			
		}
		
		
		
	}

}
