package daoimpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import bean.UserBean;
import dao.UserInfoDao;
import db.DataBaseUtil;

public class UserInfoDaoImpl implements UserInfoDao{

	@Override
	public UserBean registerUserInfo(UserBean user) throws Exception {
		// TODO Auto-generated method stub
		UserBean userInfo= null;
		 		 
		try {
			String sqlStr = "insert into user (u_phone,u_password)"
					+ "values(?,?)";
			int num = DataBaseUtil.executeUpdate(
					sqlStr,new Object[] {user.getPhone(),user.getPassWord()});
			if (num > 0) {
				List<UserBean> userInfoList = findAllUserInfo();
				for (UserBean userDB : userInfoList) {
					if (userDB.getPhone().equals(user.getPhone())
							&&userDB.getPassWord().equals(user.getPassWord())) {
						userInfo = userDB;
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}

		return userInfo;
	}

	@Override
	public boolean deleteUserInfoByID(int userID) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserBean updateUserInfoByID(int userID, UserBean user)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserBean findUserInfoByID(int userID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserBean LoginUserInfo(String phone, String passWord)
			throws Exception {
		// TODO Auto-generated method stub
		try {
			List<UserBean> uList = findAllUserInfo();
			for (UserBean u : uList) {
				if(u.getPhone().equals(phone)&&
						u.getPassWord().equals(passWord)){
					return u;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConn();
		}
		return null;
	}
	
	public List<UserBean> findAllUserInfo() throws Exception {
		// TODO Auto-generated method stub
		List<UserBean> usersList = new ArrayList<UserBean>();
		try {
			String sqlStr = "select * from user";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStr, null);

			while (rs.next()) {
				UserBean user = new UserBean();
				user.setUser_id(rs.getInt("u_id"));
				user.setPhone(rs.getString("u_phone"));
				user.setPassWord(rs.getString("u_password")); 	
				usersList.add(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBaseUtil.closeConn();
		}
		return usersList;
	}

	
}
