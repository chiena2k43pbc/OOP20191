package queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectionUtils;

public class advancedQueries {
	public static String sql;
	public static String[] sqlStrings = new String[11];

	//
	public static void queriesContent() {
		// Ông Nguyễn Xuân Phúc đến thăm tổ chức nào vào tháng 8 năm 2018
		sqlStrings[1] = "select organization.Name from organization, fact, time, person "
				+ "where fact.Relationship = 'đến thăm' and fact.Object1Id = person.PersonId and  fact.TimeId = Time.TimeId "
				+ "and MONTH(Time.Name) = 8 and YEAR(Time.Name) = 2018 and person.Name = 'Nguyễn Xuân Phúc' "
				+ "and organization.OrganizationId = fact.Object2Id";
		
		//Tên sự kiện diễn ra vào ngày 2 tháng 9 tại Hà Nội năm 2019
		sqlStrings[2] = "select event.Name from event, fact, time, location "
				+ "where location.Name = 'Hà Nội' and DATE(Time.Name) = 2 and MONTH(Time.Name) = 9 and YEAR(Time.Name) = 2019 "
				+ "and fact.relationship = 'diễn ra' and fact.Object2Id = location.LocationId "
				+ "and event.EventId = fact.Object2Id";
		
		//Những sự kiện diễn ra có sự tham gia của Ông Barack Obama
		sqlStrings[3] = "select Count(EventId) AS numberOfEvent from event, fact, person "
				+ "where person.Name = 'Barack Obama' and fact.Relationship = 'đến thăm' and fact.Object1Id = person.PersonId and event.EventId = fact.Object2Id";

		//Số tổ chức mà người Adam làm việc thuộc quốc gia nào
		sqlStrings[4] = "select country.Name from organization, fact, person, country, location "
				+ "where fact.Relationship = 'làm việc' and fact.Object1Id = person.PersonId "
				+ "and person.Name LIKE '%Adam%' and organization.OrganizationId = fact.Object2Id "
				+ "and organization.LocationId = location.LocationId and location.CountryId = country.CountryId";

		// Link Bài báo nào ra mắt vào 2015 của tác giả có họ Nguyễn
		sqlStrings[5] = "select article.Link from article, time, person "
				+ "where article.Author LIKE 'Nguyễn %' and article.TimeId = time.TimeId "
				+ "and Year(time.Name) = 2015 ";
		
		//  Những event nào diễn ra tại Đà Nẵng vào năm 2017
		sqlStrings[6] = "SELECT oop.event.Name " + 
				"FROM   oop.event, fact, location, oop.time " + 
				"where  (fact.Type = 4) and (fact.Object1Id = location.LocationId) and (fact.Object2Id = event.EventId) and (location.Name = 'Đà Nẵng') " + 
				"and (fact.Relationship = 'là địa điểm tổ chức') and (event.TimeId = time.TimeId) and (YEAR(time.Name) = 2017) ";

		//	Các person phản đối hiệp ước, thông tin được trích xuất vào tháng 8 năm 2017
		sqlStrings[7] = "SELECT oop.person.Name " + 
				"FROM   oop.person, fact, time " + 
				"WHERE (fact.Type = 7) and (fact.Object1Id = person.PersonId) and (fact.Relationship = 'phản đối') " + 
				"and   (fact.TimeId = time.TimeId) and (YEAR(time.Name) = 2017) and (MONTH(time.Name) = 8)";

		//Tên người và sự kiện người đó tổ chức
		sqlStrings[8] = "SELECT person.Name as PersonName, event.Name as EventName " + 
				"FROM person, fact, event " + 
				"WHERE (fact.Type = 1) and (fact.Object1Id = person.PersonId) and (fact.Object2Id = event.EventId) and (fact.Relationship = 'tổ chức sự kiện') ";

		//Những người có quốc tịch hàn quốc ủng hộ hợp đồng thương mại
		sqlStrings[9] = "SELECT oop.person.Name " + 
				"FROM   oop.person, fact, agreement, country " + 
				"WHERE  (fact.Type = 7) and (fact.Object1Id = person.PersonId) and (fact.Object2Id = agreement.AgreementId) and (agreement.Name LIKE \"Hợp đồng thương mại%\") " + 
				"and    (fact.Relationship = 'ủng hộ') and (person.CountryId = country.CountryId) and (country.Name = 'Hàn Quốc')";
		// Những người không có quốc tịch Việt Nam ủng hộ các tổ chức ở VN
		sqlStrings[10] = "SELECT person.Name \r\n" + 
				"FROM   oop.person, fact, organization, location, country " + 
				"WHERE  (fact.Type = 8) and (fact.Object1Id = person.PersonId) and (fact.Object2Id = organization.OrganizationId) and (fact.Relationship = \"ủng hộ\") " + 
				"and    (organization.LocationId = location.LocationId) and (location.CountryId = country.CountryId) and (country.Name = \"Việt Nam\") " + 
				"and    (person.PersonId NOT IN (SELECT PersonId FROM person, country WHERE (person.CountryId = country.CountryId) and (country.Name = \"Việt Nam\")))";
	}

	public static void truyvan1() throws ClassNotFoundException, SQLException {

		try {
			sql = sqlStrings[1];
			Connection connection = ConnectionUtils.getMyConnection();
			
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			//System.out.println("Truy vấn thống kê 1: ");
			while (result.next()) {
				//System.out.println(result.getString("Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static void truyvan2() throws ClassNotFoundException, SQLException {

		try {
			sql = sqlStrings[2];
			Connection connection = ConnectionUtils.getMyConnection();

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			//System.out.println("Truy vấn thống kê 2: ");
			while (result.next()) {
				//System.out.println(result.getString("Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static void truyvan3() throws ClassNotFoundException, SQLException {

		try {
			sql = sqlStrings[3];
			Connection connection = ConnectionUtils.getMyConnection();

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			//System.out.println("Truy vấn thống kê 3: ");
			while (result.next()) {
				//System.out.println(result.getString("numberOfEvent"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static void truyvan4() throws ClassNotFoundException, SQLException {

		try {
			sql = sqlStrings[4];
			Connection connection = ConnectionUtils.getMyConnection();

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			//System.out.println("Truy vấn thống kê 4: ");
			while (result.next()) {
				//System.out.println(result.getString("Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static void truyvan5() throws ClassNotFoundException, SQLException {
		try {
			sql = sqlStrings[5];
			Connection connection = ConnectionUtils.getMyConnection();

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			//System.out.println("Truy vấn thống kê 5: ");
			while (result.next()) {
				//System.out.println(result.getString("Link"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static void truyvan6() throws ClassNotFoundException, SQLException {

		try {
			sql = sqlStrings[6];
			Connection connection = ConnectionUtils.getMyConnection();

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			//System.out.println("Truy vấn thống kê 6: ");
			while (result.next()) {
				//System.out.println(result.getString("Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static void truyvan7() throws ClassNotFoundException, SQLException {

		try {
			sql = sqlStrings[7];
			Connection connection = ConnectionUtils.getMyConnection();

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			//System.out.println("Truy vấn thống kê 7: ");
			while (result.next()) {
				//System.out.println(result.getString("Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static void truyvan8() throws ClassNotFoundException, SQLException {

		try {
			sql = sqlStrings[8];
			Connection connection = ConnectionUtils.getMyConnection();

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			//System.out.println("Truy vấn thống kê 8: ");
			while (result.next()) {
				//System.out.println(result.getString("Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static void truyvan9() throws ClassNotFoundException, SQLException {

		try {
			sql = sqlStrings[9];
			Connection connection = ConnectionUtils.getMyConnection();

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			//System.out.println("Truy vấn thống kê 9: ");
			while (result.next()) {
				//System.out.println(result.getString("Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static void truyvan10() throws ClassNotFoundException, SQLException {
		try {
			sql = sqlStrings[10];
			Connection connection = ConnectionUtils.getMyConnection();

			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			//System.out.println("Truy vấn thống kê 10: ");
			while (result.next()) {
				//System.out.println(result.getString("Name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		queriesContent();
		sql = "select * from country";
		sql = sqlStrings[2];
		truyvan10();
	}
}
