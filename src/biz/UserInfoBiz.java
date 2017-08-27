package biz;

import java.util.List;

import bean.UserBean;


public interface UserInfoBiz {
	//注册
		public UserBean registerUserInfo(UserBean user)throws Exception;
		//删
		public boolean deleteUserInfoByID(int userID) throws Exception;
		//改
		public UserBean updateUserInfoByID(int userID,UserBean user)throws Exception;
		
		public UserBean findUserInfoByID(int userID)throws Exception;

		public UserBean LoginUserInfo(String phone,String passWord)throws Exception;

}
