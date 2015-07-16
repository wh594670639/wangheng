package wang.dalltree.shopmanage.util;

import java.net.URLDecoder;
import java.sql.DriverManager;

import wang.dalltree.shopmanage.bean.DBInfo;

public class DBUtil {
	private static DBInfo dbInfo = new DBInfo();
	
	private DBUtil() {
		
	}
	
	// 取得数据库连接
	public static DBInfo getConnection() {
		dbInfo.setResult(DBInfo.NORMAL);
		try {
			Class.forName("org.sqlite.JDBC");
			String path = URLDecoder.decode(DBInfo.class.getResource("/").getPath().substring(1),"utf-8");
			String url = "jdbc:sqlite:" + 
					path + 
					"resource/db/db";
			dbInfo.setConn(DriverManager.getConnection(url));
		} catch (Exception e) {
			dbInfo.setResult(DBInfo.EXCEPTION);
			dbInfo.setErrorInfo("数据库连接失败");
		}
		
		if (null == dbInfo.getConn()) {
			dbInfo.setResult(DBInfo.EXCEPTION);
			dbInfo.setErrorInfo("打开数据库失败");
		}
		
		return dbInfo;
	}
}
