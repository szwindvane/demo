package cn.windvane.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlUtil {
	
	public static void connectMysql(){
		Connection c = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://bj-cynosdbmysql-grp-npydxpks.sql.tencentcdb.com:25504/sys","root", "qzh123456");
			String sql = "select * from metrics";
			PreparedStatement statement = c.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			c.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
