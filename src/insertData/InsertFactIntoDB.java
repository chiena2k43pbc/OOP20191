package insertData;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import connectDB.ConnectionUtils;
import model.Entity;
import model.Event;
import model.Fact;

public class InsertFactIntoDB {
	public static void insert(int n) throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionUtils.getMyConnection();
		
		Statement statement = connection.createStatement();
		
		List<Fact<?, ?>> facts = generateData.generateFact.getListFacts(n);
		
		
		String sql = "INSERT INTO oop.fact VALUES";
		for(int i = 0; i < n*10; i++)
		{
			Fact<?, ?> f = facts.get(i);
			sql += "('" + f.getIdentifier() + "', '" + f.getTime().getIdentifier() + "', " + f.getType() + ", '" + ((Entity)f.getObject1()).getIdentifier() + "', '" + ((Entity)f.getObject2()).getIdentifier() + "', '" + f.getSubject() + "', '" + f.getRelationship() + "')";
			if (i != n*10 - 1)
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
