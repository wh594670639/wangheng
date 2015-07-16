package wang.dalltree.shopmanage.service;

import wang.dalltree.shopmanage.bean.User;
import wang.dalltree.shopmanage.common.CommonService;
import wang.dalltree.shopmanage.common.ServiceResultObject;
import wang.dalltree.shopmanage.dao.UserDao;

public class UserService extends CommonService {
	/**
	 * 校验用户名和密码
	 * @param username
	 * @param password
	 * @return 
	 * 00:成功
	 * 01:用户名为空
	 * 02:无此用户
	 * 03:密码输入错误
	 */
	public ServiceResultObject checkUser(String username, String password) {
		if (null == username || "".equals(username)) {
			result.setResult("01");
			result.setObject("请输入用户名");
			return result;
		}
		
		UserDao userDao = new UserDao();
		User user = userDao.getUser(username);
		if (null == user) {
			result.setResult("02");
			result.setObject("无此用户");
		} else if (!user.getPassword().equals(password)) {
			result.setResult("03");
			result.setObject("密码输入错误");
		} else {
			result.setResult("00");
			result.setObject("登录成功");
		}
		
		return result;
	}
}
