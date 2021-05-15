package readdata;
//GetInfoAPI

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class GetInfoAPI {
	
	private static String name;

	public static void executeApi() throws IOException {

		//do a Get to the API page
		URL urlForGetRequest = new URL("http://dummy.restapiexample.com/api/v1/employee/1");
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		conection.setRequestMethod("GET");
		int responseCode = conection.getResponseCode();

		//If connection is true, bring the info
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = in.readLine()) != null) {
				response.append(readLine);
			}
			in.close();
			System.out.println("JSON String Result " + response.toString());
			String[] array = response.toString().split(",");
			name = array[2].replace("employee_name\":\"", "").replace("\"", "");

		} else {
			System.out.println("GET was not possible");
		}

	}
	
	
	//Return the name of the API
	public String getName() {		
		return name;
	}
}