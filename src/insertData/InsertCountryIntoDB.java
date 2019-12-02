package insertData;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import model.*;
import connectDB.ConnectionUtils;

public class InsertCountryIntoDB {
		public static void insert() throws ClassNotFoundException, SQLException {

			Connection connection = ConnectionUtils.getMyConnection();
	
			Statement statement = connection.createStatement();
	
			Country[] c = generateData.generateCountry.getListCountries();
			
			String sql = "INSERT INTO oop.country VALUES";
			for(int i = 0; i < 9; i++)
				sql += "('" + c[i].getIdentifier() + "', '" + c[i].getName() + "', '" + c[i].getDescription() + "'), ";
			sql += "('" + c[9].getIdentifier() + "', '" + c[9].getName() + "', '" + c[9].getDescription() + "'); ";
			System.out.println(sql);
			try {
				statement.executeUpdate(sql);
				connection.close();
			}
			catch (Exception e) {
				  System.out.println(e);
			}
		}

}
