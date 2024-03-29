package generateData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import model.Country;

public class generateCountry {
	
	private static int nCountries = 10;
	public static Country[] getListCountries() {
		Country countries[] = new Country[100];
		try {
    	  	
    	  	File fileDir = new File("COUNTRY.txt");
			
    	  	BufferedReader sc = new BufferedReader(
    	            new InputStreamReader(
    	                       new FileInputStream(fileDir), "UTF8"));
			
				for(int i = 0; i < nCountries; i++) {
					countries[i] = new Country();
					countries[i].setIdentifier(sc.readLine());
					countries[i].setName(sc.readLine());
					countries[i].setDescription(sc.readLine());
				}
				
			sc.close();
			
	    }
	    catch (Exception e) {
	    	 System.out.println(e);
	    }
		return countries;
	}
}
