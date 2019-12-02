package insertData;

import java.sql.Statement;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import model.*;
import connectDB.ConnectionUtils;

public class InsertPeopleIntoDB {
		public static void insert(int n) throws ClassNotFoundException, SQLException {

			Connection connection = ConnectionUtils.getMyConnection();
	
			Statement statement = connection.createStatement();
			
			List<Person> c = generateData.generatePerson.generatePersons(n / 10);
			
			String sql = "INSERT INTO oop.person VALUES";
			for(int i = 0; i < c.size(); i++)
			{
				Person p = c.get(i);
				sql += "('" + p.getIdentifier() + "', '" + p.getName() + "', '" + p.getDescription() + "', '" + p.getCountry().getIdentifier() + "', '" + p.getPosition() + "', '" + p.getGender() + "', " + p.getAge() + ")";
				if (i != c.size() - 1)
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