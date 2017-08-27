package bizimpl;

import java.util.List;






import dao.UserInfoDao;
import daoimpl.UserInfoDaoImpl;
import bean.UserBean;
import biz.UserInfoBiz;

public class UserInfoBizImpl implements UserInfoBiz {
	UserInfoDao userInfoDao = new UserInfoDaoImpl();

	@Override
	public UserBean registerUserInfo(UserBean user) throws Exception {
		// TODO Auto-generated method stub
		return userInfoDao.registerUserInfo(user);
	}

	@Override
	public boolean deleteUserInfoByID(int userID) throws Exception {
		// TODO Auto-generated method stub
		return userInfoDao.deleteUserInfoByID(userID);
	}

	@Override
	public UserBean updateUserInfoByID(int userID, UserBean user)
			throws Exception {
		// TODO Auto-generated method stub
		return userInfoDao.updateUserInfoByID(userID, user);
	}

	@Override
	public UserBean findUserInfoByID(int userID) throws Exception {
		// TODO Auto-generated method stub
		return userInfoDao.findUserInfoByID(userID);
	}

	@Override
	public UserBean LoginUserInfo(String phone, String passWord)
			throws Exception {
		// TODO Auto-generated method stub
		return userInfoDao.LoginUserInfo(phone, passWord);
	}
	

}
