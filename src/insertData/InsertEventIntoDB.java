package insertData;

import java.sql.Statement;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import model.*;
import connectDB.ConnectionUtils;

public class InsertEventIntoDB {
		public static void insert() throws ClassNotFoundException, SQLException {

			Connection connection = ConnectionUtils.getMyConnection();
			
			Statement statement = connection.createStatement();
			
			int n = generateData.GenerateEvent.nEvent;
			Event[] events = generateData.GenerateEvent.getListEvents();
			
			
			String sql = "INSERT INTO oop.event VALUES";
			for(int i = 0; i < n; i++)
			{
				Event e = events[i];
				sql += "('" + e.getIdentifier() + "', '" + e.getName() + "', '" + e.getDescription() + "', '" + e.getTime().getIdentifier() + "')";
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