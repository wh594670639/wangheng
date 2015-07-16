package wang.dalltree.shopmanage.bean;

import java.sql.Connection;

public class DBInfo {
	/**
	 * 返回DB结果：
	 * 00:正常
	 * 01:异常
	 */
	private String result;
	private Connection conn;
	private String errorInfo;
	
	public static final String NORMAL = "00";
	public static final String EXCEPTION = "01";
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
}
