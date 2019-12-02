package insertData;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import model.*;
import connectDB.ConnectionUtils;

public class InsertTimeIntoDB {
		public static void insert(int n) throws ClassNotFoundException, SQLException {

			Connection connection = ConnectionUtils.getMyConnection();
	
			Statement statement = connection.createStatement();
			
			Time[] c = generateData.generateTime.getListTimes(n);
			
			String sql = "INSERT INTO oop.time VALUES";
			for(int i = 0; i < n; i++)
			{
				Time t = c[i];
				sql += "('" + t.getIdentifier() + "', '" + t.getName() + "', '" + t.getDescription() + "')";
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