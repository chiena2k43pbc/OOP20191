package generateData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectionUtils;
import model.Article;

public class getListId {
	/*public static String[] getListPersonId() {
		String sql = "SELECT PersonId FROM Person";
		
	}*/
	public static List<String> getListCountryId() throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionUtils.getMyConnection();

		Statement statement = connection.createStatement();
		String sql = "SELECT CountryId FROM oop.country";

	    ResultSet rs = statement.executeQuery(sql);
	 
	    List<String> lstId = new ArrayList<String>(); 
	    while (rs.next()) {
	    	String id = rs.getString("CountryId");
	    	lstId.add(id);
	    }
	    return lstId;
	}
	
	public static List<String> getListPersonId() throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionUtils.getMyConnection();

		Statement statement = connection.createStatement();
		String sql = "SELECT PersonId FROM oop.person";

	    ResultSet rs = statement.executeQuery(sql);
	 
	    List<String> lstId = new ArrayList<String>(); 
	    while (rs.next()) {
	    	String id = rs.getString("PersonId");
	    	lstId.add(id);
	    }
	    return lstId;
	}
	
	public static List<String> getListTimeId() throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionUtils.getMyConnection();

		Statement statement = connection.createStatement();
		String sql = "SELECT TimeId FROM oop.time";

	    ResultSet rs = statement.executeQuery(sql);
	 
	    List<String> lstId = new ArrayList<String>(); 
	    while (rs.next()) {
	    	String id = rs.getString("TimeId");
	    	lstId.add(id);
	    }
	    return lstId;
	}
	public static List<String> getListLocationId() throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionUtils.getMyConnection();

		Statement statement = connection.createStatement();
		String sql = "SELECT LocationId FROM oop.location";

	    ResultSet rs = statement.executeQuery(sql);
	 
	    List<String> lstId = new ArrayList<String>(); 
	    while (rs.next()) {
	    	String id = rs.getString("LocationId");
	    	lstId.add(id);
	    }
	    return lstId;
	}
	public static List<String> getListOrganizationId() throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionUtils.getMyConnection();

		Statement statement = connection.createStatement();
		String sql = "SELECT OrganizationId FROM oop.organization";

	    ResultSet rs = statement.executeQuery(sql);
	 
	    List<String> lstId = new ArrayList<String>(); 
	    while (rs.next()) {
	    	String id = rs.getString("OrganizationId");
	    	lstId.add(id);
	    }
	    return lstId;
	}
	public static List<String> getListArticleId() throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionUtils.getMyConnection();

		Statement statement = connection.createStatement();
		String sql = "SELECT ArticleId FROM oop.article";

	    ResultSet rs = statement.executeQuery(sql);
	 
	    List<String> lstId = new ArrayList<String>(); 
	    while (rs.next()) {
	    	String id = rs.getString("ArticleId");
	    	lstId.add(id);
	    }
	    return lstId;
	}
	public static List<String> getListAgreementId() throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionUtils.getMyConnection();

		Statement statement = connection.createStatement();
		String sql = "SELECT AgreementId FROM oop.agreement";

	    ResultSet rs = statement.executeQuery(sql);
	 
	    List<String> lstId = new ArrayList<String>(); 
	    while (rs.next()) {
	    	String id = rs.getString("AgreementId");
	    	lstId.add(id);
	    }
	    return lstId;
	}
	public static List<String> getListEventId() throws ClassNotFoundException, SQLException {

		Connection connection = ConnectionUtils.getMyConnection();

		Statement statement = connection.createStatement();
		String sql = "SELECT EventId FROM oop.event";

	    ResultSet rs = statement.executeQuery(sql);
	 
	    List<String> lstId = new ArrayList<String>(); 
	    while (rs.next()) {
	    	String id = rs.getString("EventId");
	    	lstId.add(id);
	    }
	    return lstId;
	}
}
