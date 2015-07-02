package wang.dalltree.shopmanage.service;

import wang.dalltree.shopmanage.bean.User;
import wang.dalltree.shopmanage.common.CommonService;
import wang.dalltree.shopmanage.common.ServiceResultObject;
import wang.dalltree.shopmanage.dao.UserDao;

public class UserService extends CommonService {
	/**
	 * У���û���������
	 * @param username
	 * @param password
	 * @return 
	 * 00:�ɹ�
	 * 01:�û���Ϊ��
	 * 02:�޴��û�
	 * 03:�����������
	 */
	public ServiceResultObject checkUser(String username, String password) {
		if (null == username || "".equals(username)) {
			result.setResult("01");
			result.setObject("�������û���");
			return result;
		}
		
		UserDao userDao = new UserDao();
		User user = userDao.getUser(username);
		if (null == user) {
			result.setResult("02");
			result.setObject("�޴��û�");
		} else if (!user.getPassword().equals(password)) {
			result.setResult("03");
			result.setObject("�����������");
		} else {
			result.setResult("00");
			result.setObject("��¼�ɹ�");
		}
		
		return result;
	}
}
