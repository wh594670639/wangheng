package wang.dalltree.shopmanage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import wang.dalltree.shopmanage.bean.DBInfo;
import wang.dalltree.shopmanage.bean.User;
import wang.dalltree.shopmanage.common.CommonDao;

public class UserDao extends CommonDao{
	/**
	 * 根据用户名，查找用户信息
	 * @param username
	 * @return
	 */
	public User getUser(String username) {
		List<User> list = new ArrayList<User>();
		try {
			if (DBInfo.NORMAL.equals(dbInfo.getResult())) {
				Statement stmt = dbInfo.getConn().createStatement();
				String sql = "SELECT * FROM USER WHERE USER_NAME='" + username + "';";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					User user = new User();
					user.setUserId(rs.getString("user_id"));
					user.setUserName(rs.getString("user_name"));
					user.setPassword(rs.getString("password"));
					user.setUserStatus(rs.getString("user_status"));
					user.setUserLevel(rs.getString("user_level"));
					list.add(user);
				}
			}
		} catch (SQLException e) {
		}
		
		if (null == list || list.isEmpty()) {
			return null;
		}
		
		return list.get(0);
	}
}
