package insertData;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import connectDB.ConnectionUtils;
import model.Location;

public class InsertLocationIntoDB {
	public static void insert() throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionUtils.getMyConnection();

		Statement statement = connection.createStatement();
		
		Location[] loc = generateData.generateLocation.getListLocations();
		
		String sql = "INSERT INTO oop.location VALUES";
		for(int i = 0; i < 236; i++)
		{
			Location l = loc[i];
			sql += "('" + l.getIdentifier() + "', '" + l.getName() + "', '" + l.getDescription() + "', '" + l.getCountry().getIdentifier() + "')";
			if (i != 235)
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
