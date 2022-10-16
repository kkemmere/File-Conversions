import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class XMLtoJSON {
	
	 public static int PRETTY_PRINT_INDENT_FACTOR = 4;

	 
	public void convert(String toConvert) throws Exception
	{		    
		String str = "";
		
		File file = new File(toConvert);
		FileReader fr = new FileReader(file);
       	BufferedReader br=new BufferedReader(fr);
       
        //System.out.println( br.toString());
     
        String sCurrentLine=null;
        String temp="";
        
        while ((sCurrentLine = br.readLine()) != null) {
        	
         //System.out.println(sCurrentLine);
         temp +=sCurrentLine;
         
        }
      
        fr.close();
        
       	
        JSONObject xmlJSONObj = XML.toJSONObject(temp);
        String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
        // System.out.println(jsonPrettyPrintString);
        str = toConvert.replace(".xml",".json");
        FileWriter fw=new FileWriter(str);
        fw.write(jsonPrettyPrintString);
        fw.close();
	}
}
