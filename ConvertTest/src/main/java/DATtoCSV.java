import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

public class DATtoCSV {

	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	public void convert(String toConvert) throws Exception
	{
		String str = "";
		
		File file = new File(toConvert);
		FileWriter fw = null;
		
		ArrayList<String> data = new ArrayList<String>();
		
		try {
			
				// read from .dat
				String[] lines = Files.readAllLines(new File(toConvert).toPath()).toArray(new String[0]);
				for (String s:lines)
				{
					data.add(s);
				}
		
				// Write to new .csv
				str = toConvert.replace(".dat",".csv");
				fw = new FileWriter(str);
				
				for (String data1 : data) {
					
					String datafinal[]= data1.split("#");
					String[] fixedArray = Arrays.copyOfRange(datafinal, 1, datafinal.length); // Remove spaces
					
					for (String dat1 : fixedArray)
					{
						String[] temp = dat1.split(" ");
						
//						for (int i = 0; i <temp.length;i++)
//						{
//							System.out.println(temp[i]);
//						}
						
						for (String tempfinal : temp) {
							tempfinal = tempfinal+COMMA_DELIMITER;
							fw.append(tempfinal);
						}
					}
					fw.append(NEW_LINE_SEPARATOR);
				}
				System.out.println("CSV file created...");
				 fw.close();
		    } 
		catch (IOException e) {
		    e.printStackTrace();
		}
	}
}
