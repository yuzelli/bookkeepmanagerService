package dao;



import java.util.List;

import bean.UserBean;


public interface UserInfoDao {
	//娉ㄥ唽
	public UserBean registerUserInfo(UserBean user)throws Exception;
	//鍒�
	public boolean deleteUserInfoByID(int userID) throws Exception;
	//鏀�
	public UserBean updateUserInfoByID(int userID,UserBean user)throws Exception;

	
	public UserBean findUserInfoByID(int userID)throws Exception;

	public UserBean LoginUserInfo(String phone,String passWord)throws Exception;
	

}
