package generateData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

import model.Location;
import model.Organization;

public class generateOrganization {
	public static Organization[] getListOrganizations(int n) {
		Organization[] orgs = new Organization[n + 5];
		try {
    	  	
    	  	File fileDir = new File("ORGANIZATION.txt");
			
    	  	BufferedReader sc = new BufferedReader(
    	            new InputStreamReader(
    	                       new FileInputStream(fileDir), "UTF8"));
			
    	  	List<String> loc = getListId.getListLocationId();
    	  	int nLocation = loc.size();
    	  	String[] f = new String[105];
    	  	String[] m = new String[105];
    	  	String l[] = {"Company", "Inc.", "Corporation", "Corp.", "Group", "Jsc.", "Co. ltd", "PLC"};
    	  	
			for(int i = 0; i < 100; i++) 
				f[i] = sc.readLine();
			for(int i = 0; i < 100; i++)
				m[i] = sc.readLine();
			Random rd = new Random();
			for(int i = 0; i < n; i++)
			{
				orgs[i] = new Organization();
				String rF = f[rd.nextInt(100)];
				String rM = m[rd.nextInt(100)];
				String rL = l[rd.nextInt(8)];
				orgs[i].setIdentifier("ORGANIZATION" + i);
				orgs[i].setName(rF + " " + rM + " " + rL);
				Location location = new Location();
				location.setIdentifier(loc.get(rd.nextInt(nLocation)));
				orgs[i].setLocation(location);
				orgs[i].setDescription("Tổ chức có tên " + orgs[i].getName() + ", có địa chỉ tại địa điểm có định danh " + orgs[i].getLocation().getIdentifier());
			}
			sc.close();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return orgs;
	}
}
