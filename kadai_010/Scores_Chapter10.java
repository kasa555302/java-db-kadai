package kadai_010;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Scores_Chapter10 {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement statement = null;
		
		try {
			// データベースに接続
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/challenge_java",
					"root",
					"Sfuji0576>.<"
			);
			
			System.out.println("データベース接続成功：" + con);
			
			statement = con.createStatement();
			
			// 武者小路勇気（id=5）の点数を更新
			System.out.println("レコード更新を実行します");
			String sqlUpdate = "UPDATE scores SET score_math = 95, score_english = 80 WHERE id = 5";
			int rowCnt = statement.executeUpdate(sqlUpdate);
			System.out.println(rowCnt + "件のレコードが更新されました");
			
			// 並べ替え（数学→英語の高得点順）
			System.out.println("数学・英語の点数が高い順に並べ替えました");
			String sqlSelect = "SELECT * FROM scores ORDER BY score_math DESC, score_english DESC";
			ResultSet result = statement.executeQuery(sqlSelect);
			
			int count = 1;
			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				int math = result.getInt("score_math");
				int english = result.getInt("score_english");
				
				System.out.println(count + "件目：生徒ID=" +
				id + "/氏名=" + name + "/数学=" + math + "/英語=" + english);
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {statement.close(); }
				if (con != null) { con.close(); }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
