package generateData;

import java.beans.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

import connectDB.ConnectionUtils;
import model.Country;
import model.Location;

public class generateLocation {
	
	  public static Location[] getListLocations() {
		  Location[] location = new Location[300];
	      try {
	    	  	
	    	  	File fileDir = new File("LOCATION.txt");
				
	    	  	BufferedReader sc = new BufferedReader(
	    	            new InputStreamReader(
	    	                       new FileInputStream(fileDir), "UTF8"));
				
				for(int i = 0; i < 236; i++) {
						location[i] = new Location();
						Country ct = new Country();
						location[i].setIdentifier("Location"+ i);
						location[i].setName(sc.readLine());
						if (i < 64) {	
							location[i].setDescription(location[i].getName() + ", Việt Nam");
							ct.setIdentifier("COUNTRY01");
						}
						if (i >= 64 && i < 84) {
							location[i].setDescription(location[i].getName() + ", Hoa Kỳ");
							ct.setIdentifier("COUNTRY06");
						}
						if (i >= 84 && i < 104) {
							location[i].setDescription(location[i].getName() + ", Vương Quốc Anh");
							ct.setIdentifier("COUNTRY07");
						}
						if (i >= 104 && i < 124) {
							location[i].setDescription(location[i].getName() + ", Nhật Bản");
							ct.setIdentifier("COUNTRY04");
						}
						if (i >= 124 && i < 134) {
							location[i].setDescription(location[i].getName() + ", Hàn Quốc");
							ct.setIdentifier("COUNTRY03");
						}
						if (i >= 134 && i < 156) {
							location[i].setDescription(location[i].getName() + ", Trung Quốc");
							ct.setIdentifier("COUNTRY02");
						}
						if (i >= 156 && i < 166) {
							location[i].setDescription(location[i].getName() + ", Tây Ban Nha");
							ct.setIdentifier("COUNTRY10");
						}
						if (i >= 166 && i < 186) {
							location[i].setDescription(location[i].getName() + ", Đức");
							ct.setIdentifier("COUNTRY09");
						}
						if (i >= 186 && i < 216) {
							location[i].setDescription(location[i].getName() + ", Pháp");
							ct.setIdentifier("COUNTRY08");
						}
						if (i >= 216) {
							location[i].setDescription(location[i].getName() + ", Liên Bang Nga");
							ct.setIdentifier("COUNTRY05");
						}
						location[i].setCountry(ct);
					}
					
				sc.close();
	      }
	      catch (Exception e) {
	    	  System.out.println(e);
	      }
	      return location;
	  }
}
