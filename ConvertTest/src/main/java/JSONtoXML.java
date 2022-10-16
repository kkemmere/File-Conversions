import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class JSONtoXML {

	public void convert(String toConvert) throws Exception
	{	
		String str = "";
		
		File file = new File(toConvert);
		FileReader fr = new FileReader(file);
       	BufferedReader br=new BufferedReader(fr);
            
        String sCurrentLine=null;
        String temp="";
        
        while ((sCurrentLine = br.readLine()) != null) {
        	
         //System.out.println(sCurrentLine);
         temp +=sCurrentLine;
         
        }
      
        fr.close();
        
        JSONObject json = new JSONObject(temp);
        String xmlPrettyPrint = XML.toString(json);
        // System.out.println(xmlPrettyPrint);
        str = toConvert.replace(".json",".xml");
        FileWriter fw=new FileWriter(str);
        fw.write(xmlPrettyPrint);
        fr.close();
	}
}
