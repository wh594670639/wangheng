package wang.dalltree.shopmanage.common;

import wang.dalltree.shopmanage.bean.DBInfo;
import wang.dalltree.shopmanage.util.DBUtil;

public class CommonDao {
	protected DBInfo dbInfo = DBUtil.getConnection();
	protected DaoResultObject result = new DaoResultObject();
}
