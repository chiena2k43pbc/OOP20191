package insertData;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectionUtils;
import model.Agreement;
import model.Time;

public class InsertAgreementIntoDB {
	public static void insert(int n) throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionUtils.getMyConnection();

		Statement statement = connection.createStatement();
		
		Agreement[] c = generateData.GenerateAgreement.getListAgreements(n);
		
		String sql = "INSERT INTO oop.agreement VALUES";
		for(int i = 0; i < n; i++)
		{
			Agreement a = c[i];
			sql += "('" + a.getIdentifier() + "', '" + a.getName() + "', '" + a.getDescription() + "')";
			if (i != n - 1)
				sql += ",";
		}
		sql += ";";
		//System.out.println(sql);
		try {
			statement.executeUpdate(sql);
			System.out.println("Insert success!!");
			connection.close();
		}
		catch (Exception e) {
			  System.out.println(e);
		}
	}
}
