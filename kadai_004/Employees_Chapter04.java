package kadai_004;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employees_Chapter04 {

	public static void main(String[] args) {
		
		// challenge_java データベースに接続するURL
		String url = "jdbc:mysql://localhost:3307/challenge_java?useSSL=false&allowPublicKeyRetrieval=true";
		String user = "root";
		String password = "Sfuji0576>.<"; // 自分のパスワード
		
		// 実行するSQL（employees テーブル作成）
		String sql = "CREATE TABLE IF NOT EXISTS employees ("
				+ "id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,"
				+ "name VARCHAR(60) NOT NULL,"
				+ "email VARCHAR(255) NOT NULL,"
				+ "age INT(11),"
				+ "address VARCHAR(255)"
				+ ");";
		
		try(
			Connection con = DriverManager.getConnection(url,user,password);
			Statement stmt = con.createStatement();
		) {
			System.out.println("データベース接続成功：" + con);
			
			int rowCnt = stmt.executeUpdate(sql);
			System.out.println("社員テーブルを作成しました：更新レコード数=" + rowCnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
