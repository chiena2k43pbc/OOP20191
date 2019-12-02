package queries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectDB.ConnectionUtils;

public class basicQueries {
	public static String sql;
	public static String[] sqlStrings = new String[11];

	//
	public static void queriesContent() {
		// Thông tin về đất nước Hàn Quốc

		sqlStrings[1] = "select country.Description from country where country.Name = 'Hàn Quốc'";
		// Đưa ra những người có chức vụ Giảng viên

		sqlStrings[2] = "select person.Name from person where person.Position = 'Giảng viên'";
		// Liệt kê tên và thông tin những Giám đốc điều hành

		sqlStrings[3] = "select person.Name, person.Description from person where person.Position = 'Giám đốc điều hành'";
		// Liệt kê những tổ chức có vị trí làm việc tại An Giang

		sqlStrings[4] = "select organization.Name from organization, location where (organization.LocationId = location.LocationId) and (location.Name = 'An Giang');";
		// Link những bài báo của tác giả Dương Quốc Cường

		sqlStrings[5] = "select article.link from article where article.Author = 'Dương Quốc Cường'";
		// Thông tin những sự kiện bổ nhiệm giám đốc mới

		sqlStrings[6] = "select event.Description from event where event.Name = 'bổ nhiệm giám đốc mới'";
		// Thông tin của những hợp đồng liên quan đến bất động sản

		sqlStrings[7] = "select agreement.Description from agreement where agreement.Name LIKE 'Hợp đồng thuê khoán tài sản %'";
		// Tên và thông tin những người có quốc tịch Việt Nam

		sqlStrings[8] = "select person.Name, person.Description from person, country where (person.CountryId = country.CountryId) and (country.Name = 'Việt Nam');";
		// Tên những người có liên quan đến sự kiện công bố mục tiêu kế hoạch năm mới

		sqlStrings[9] = "select oop.person.Name \r\n" + 
				"from oop.person, oop.fact, oop.event \r\n" + 
				"where (fact.Type = 1) and (fact.Object1Id = person.PersonId) and (fact.Object2Id = event.EventId) and (event.Name = 'công bố mục tiêu kế hoạch năm mới')";

		// Thông tin của quốc gia có địa điểm Đà Nẵng
		sqlStrings[10] = "select country.Description from country, location where (location.CountryId = country.CountryId) and (location.Name = 'Đà Nẵng');";

	}

	public static void truyvan1() throws ClassNotFoundException, SQLException {

		try {
			sql = sqlStrings[1];
			Connection connection = ConnectionUtils.getMyConnection();
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			//System.out.println("Truy vấn cơ bản 1: Thông tin đất nước Hàn Quốc");
			while (result.next()) {
				//System.out.println(result.getString("Description"));
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
			//System.out.println("Truy vấn cơ bản 2: Những người có chức vụ là Giảng viên");
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
			//System.out.println("Truy vấn cơ bản 3: Liệt kê tên và thông tin những Giám đốc điều hành");
			while (result.next()) {
				//System.out.println(result.getString("Name") + " - " + result.getString("Description"));
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
			//System.out.println("Truy vấn cơ bản 4: Liệt kê những tổ chức có vị trí làm việc tại An Giang");
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
			//System.out.println("Truy vấn cơ bản 5: Link những bài báo của tác giả Dương Quốc Cường");
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
			//System.out.println("Truy vấn cơ bản 6: Thông tin những sự kiện bổ nhiệm giám đốc mới");
			while (result.next()) {
				//System.out.println(result.getString("Description"));
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
			//System.out.println("Truy vấn cơ bản 7: Thông tin của những hợp đồng liên quan đến bất động sản");
			while (result.next()) {
				//System.out.println(result.getString("Description"));
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
			//System.out.println("Truy vấn cơ bản 8: Tên và thông tin những người có quốc tịch Việt Nam");
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
			//System.out.println("Truy vấn cơ bản 9: Tên những người có liên quan đến sự kiện công bố mục tiêu kế hoạch năm mới");
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
			//System.out.println("Truy vấn cơ bản 10: Thông tin của quốc gia có địa điểm Đà Nẵng");
			while (result.next()) {
				//System.out.println(result.getString("Description"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		queriesContent();
		sql = sqlStrings[2];
		truyvan10();
	}
}
