import org.json.JSONObject;
import org.json.XML;
import org.json.JSONException;


	
public class app {

	    public static void main(String[] args) throws Exception {
	    	
	    	// XML ------> JSON
//	    	XMLtoJSON convert = new XMLtoJSON();
//	    	convert.convert("testXML2.xml");
	    	
	    	
	    	// JSON -----> XML
//	    	JSONtoXML convertBack = new JSONtoXML();
//	    	convertBack.convert("testXML.txt");
	    	
	    	// DAT -----> CSV
	    	DATtoCSV convertCSV = new DATtoCSV();
	    	convertCSV.convert("test.dat");
	    	
	      
	    }
}
