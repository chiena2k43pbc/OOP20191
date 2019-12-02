package testTime;

import java.sql.SQLException;

public class CalculateGenTime {
	public static long cal(int n, int m) throws ClassNotFoundException, SQLException {
		long start = System.currentTimeMillis();
		int nPerson = 5*n/12;
		int nOrganization = n/12;
		int nAgreement = n/6;
		int Article = n/4;
		int nTime = n/12;
		
		insertData.InsertTimeIntoDB.insert(nTime);
		
		insertData.InsertCountryIntoDB.insert();
		insertData.InsertLocationIntoDB.insert();
		insertData.InsertEventIntoDB.insert();
		
		insertData.InsertAgreementIntoDB.insert(nAgreement);
		insertData.InsertOrganizationIntoDB.insert(nOrganization);
		insertData.InsertPeopleIntoDB.insert(nPerson);
		
		insertData.InsertArticleIntoDB.insert(Article);
		insertData.InsertFactIntoDB.insert(m/10);
		
		long end = System.currentTimeMillis();
		return end - start;
	}
	public static long[] calBasicQueries() throws ClassNotFoundException, SQLException {
		long[] time = new long[12];
		long start, end;
		int i = 0;
		queries.basicQueries.queriesContent();
		
		start = System.currentTimeMillis();
		queries.basicQueries.truyvan1();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.basicQueries.truyvan2();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.basicQueries.truyvan3();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.basicQueries.truyvan4();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.basicQueries.truyvan5();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.basicQueries.truyvan6();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.basicQueries.truyvan7();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.basicQueries.truyvan8();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.basicQueries.truyvan9();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.basicQueries.truyvan10();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		return time;
	}
	
	public static long[] calAdvancedQueries() throws ClassNotFoundException, SQLException {
		long[] time = new long[12];
		long start, end;
		int i = 0;
		queries.advancedQueries.queriesContent();
		
		start = System.currentTimeMillis();
		queries.advancedQueries.truyvan1();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.advancedQueries.truyvan2();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.advancedQueries.truyvan3();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.advancedQueries.truyvan4();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.advancedQueries.truyvan5();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.advancedQueries.truyvan6();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.advancedQueries.truyvan7();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.advancedQueries.truyvan8();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.advancedQueries.truyvan9();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		start = System.currentTimeMillis();
		queries.advancedQueries.truyvan10();
		end = System.currentTimeMillis();
		time[i++] = end - start;
		
		return time;
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*System.out.println(cal(12000, 20000));
		long time[] = calBasicQueries();
		for(int i = 0; i < 10; i++)
			System.out.println(time[i]);
		long time2[] = calAdvancedQueries();
		for(int i = 0; i < 10; i++)
			System.out.println(time2[i]);*/
		
		/*System.out.println(cal(240000, 500000));
		long time[] = calBasicQueries();
		for(int i = 0; i < 10; i++)
			System.out.println(time[i]);
		long time2[] = calAdvancedQueries();
		for(int i = 0; i < 10; i++)
			System.out.println(time2[i]);*/
		
		/*System.out.println(cal(600000, 700000));
		long time[] = calBasicQueries();
		for(int i = 0; i < 10; i++)
			System.out.println(time[i]);
		long time2[] = calAdvancedQueries();
		for(int i = 0; i < 10; i++)
			System.out.println(time2[i]);*/
		
		/*System.out.println(cal(2400000, 5000000));
		long time[] = calBasicQueries();
		for(int i = 0; i < 10; i++)
			System.out.println(time[i]);
		long time2[] = calAdvancedQueries();
		for(int i = 0; i < 10; i++)
			System.out.println(time2[i]);*/
		
		/*System.out.println(cal(5000000, 10000000));
		long time[] = calBasicQueries();
		for(int i = 0; i < 10; i++)
			System.out.println(time[i]);
		long time2[] = calAdvancedQueries();
		for(int i = 0; i < 10; i++)
			System.out.println(time2[i]);*/
	}
}
