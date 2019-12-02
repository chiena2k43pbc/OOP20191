package insertData;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectionUtils;
import model.Organization;

public class InsertOrganizationIntoDB {
	public static void insert(int n) throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionUtils.getMyConnection();

		Statement statement = connection.createStatement();
		
		Organization[] c = generateData.generateOrganization.getListOrganizations(n);
		
		String sql = "INSERT INTO oop.organization VALUES";
		for(int i = 0; i < n; i++)
		{
			Organization t = c[i];
			sql += "('" + t.getIdentifier() + "', '" + t.getName() + "', '" + t.getDescription() + "', '" + t.getLocation().getIdentifier() + "')";
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
