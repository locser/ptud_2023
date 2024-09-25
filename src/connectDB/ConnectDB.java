package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    

	private static Connection con = null;
	private static ConnectDB instance = new ConnectDB();

	// Singleton pattern to get an instance of ConnectDB
	public static ConnectDB getInstance() {
		return instance;
	}

	// Method to establish connection
	public void connect() throws Exception {
//                            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

		try {

			String url = "jdbc:sqlserver://139.162.61.24:1433;databaseName=banve;encrypt=true;trustServerCertificate=true;loginTimeout=30";
			String user = "sa";
			String password = "Password789";
			con = DriverManager.getConnection(url, user, password);

			System.out.println("Kết nối thành công!");
		} catch (SQLException e) {
			System.out.println("Không thể kết nối tới cơ sở dữ liệu");
//			e.printStackTrace();
		}
	}

	// Method to disconnect from the database
	public void disconnect() {
		if (con != null) {
			try {
				con.close();
				System.out.println("Đã ngắt kết nối thành công!");
			} catch (SQLException e) {
				System.out.println("Lỗi khi ngắt kết nối!");
				e.printStackTrace();
			}
		}
	}

	// Method to get current connection
	public static Connection getConnection() {
		return con;
	}

	public void closeConnection() {
		if (con != null) {
			try {
				con.close();
				System.out.println("Kết nối đã đóng.");
			} catch (SQLException e) {
				System.out.println("Lỗi khi đóng kết nối.");
				e.printStackTrace();
			}
		}
	}
}
