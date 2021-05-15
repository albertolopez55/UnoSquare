package readdata;

import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class ReadData {
	
	//Declare the dynamic array
	private static String[] valuesDataSource;

	public void readJson(String [] arrayValues ) {
		JSONParser parser = new JSONParser();
		{

			try {
				//Read Json File
				Object obj = parser.parse(new FileReader("src\\main\\resources\\data\\sourceData.json"));
				JSONObject jsonObject = (JSONObject) obj;
				
				//determine the size of the array to return
				valuesDataSource = new String[arrayValues.length];
				
				//Read values and asign them to valuesDataSource
				for (int x=0; x < arrayValues.length; x++ ) {
					valuesDataSource[x] = (String) jsonObject.get(arrayValues[x]);
					System.out.println("VALUETOSEARCH: " + valuesDataSource[x] );
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Return the read values of the Json File
	public String[] getValues() {		
		return valuesDataSource;
	}
	
	


}