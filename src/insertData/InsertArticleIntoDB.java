package insertData;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectionUtils;
import model.Article;
import model.Time;

public class InsertArticleIntoDB {
	public static void insert(int n) throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionUtils.getMyConnection();

		Statement statement = connection.createStatement();
		
		Article[] ar = generateData.GenerateArticle.getListArticles(n);
		
		String sql = "INSERT INTO oop.article VALUES";

		for(int i = 0; i < n; i++)
		{
			Article a = ar[i];
			sql += "('" + a.getIdentifier() + "', '" + a.getName() + "', '" + a.getLink() + "', '" + a.getWritingTime().getIdentifier() + "', '" + a.getAuthorName() + "', '" + a.getSubject() + "', '" + a.getDescription() + "')";
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
