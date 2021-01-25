package sakila.commons;
import java.sql.*;

public class DBUtil {
	//DB연결
	public Connection getConnection() throws Exception { // 데이터베이스 접근
		
		final String DB_ADDR = "jdbc:mariadb://ahmo.kro.kr:3306/sakila";
		final String DB_ID = "root";
		final String DB_PW = "java1004";
		final Connection conn = DriverManager.getConnection(DB_ADDR,DB_ID,DB_PW);	
		
		conn.setAutoCommit(false);
		return conn;
	}
}