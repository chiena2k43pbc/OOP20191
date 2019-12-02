package generateData;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Random;

import model.Agreement;

public class GenerateAgreement {
	
	public static Agreement[] getListAgreements(int n) {
		String[] aggNames = new String[100];
		Agreement aggs[] = new Agreement[n + 5];
		try {
			File fileDir = new File("AGGREMENT.txt");
			BufferedReader sc = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(fileDir), "UTF8"));
			
			int nAggrements = 74;
			for(int i = 0; i < 74; i++) {
				aggNames[i] = sc.readLine();
				
			}
			
			Random rd = new Random();
			int ranAgg;
			for(int i = 0; i < n; i++) {
				aggs[i] = new Agreement();
				ranAgg = rd.nextInt(nAggrements);
				aggs[i].setIdentifier("AGGREMENT" + Integer.toString(i));
				aggs[i].setName(aggNames[ranAgg] + " - Số: " + Integer.toString(i + 1) + "/HĐ");
				aggs[i].setDescription(aggs[i].getName());
			}
			sc.close();
					
		}
		catch (Exception e) {
			 System.out.println(e);
		}
		return aggs;
	}
}
