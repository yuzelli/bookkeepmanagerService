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
			
			List<UserBean> userInfoList2 = findAllUserInfo();
			for (int i = 0; i < userInfoList2.size(); i++) {
				if (user.getPhone().equals(userInfoList2.get(i).getPhone())) {
					return null;
				}
			}
			
			
			String sqlStr = "insert into user (u_phone,u_password,u_name)"
					+ "values(?,?,?)";
			int num = DataBaseUtil.executeUpdate(
					sqlStr,new Object[] {user.getPhone(),user.getPassWord(),user.getName()});
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
		UserBean userInfo = null;
		try {
		
		String sqlStr = "update user set u_phone=?,u_password=?,u_name=? where u_phone=?";
		
		int num = DataBaseUtil.executeUpdate(
					sqlStr,
					new Object[] {user.getPhone(), user.getPassWord(),user.getName(),user.getPhone()});
		if(num>0){    
		  userInfo = findUserInfoByPhone(user.getPhone());
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConn();
		}
		return userInfo;	
	}
	public UserBean findUserInfoByPhone(String phone) throws Exception {
		// TODO Auto-generated method stub
		UserBean user = new UserBean();
		try {
			String sqlStr = "select * from user where u_phone = ?";
			ResultSet rs = DataBaseUtil.executeQuery(sqlStr, new Object[] { phone });

			while (rs.next()) {
				
				user.setUser_id(rs.getInt("u_id"));
				user.setPhone(rs.getString("u_phone"));
				user.setPassWord(rs.getString("u_password")); 	
				user.setName(rs.getString("u_name")); 	
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DataBaseUtil.closeConn();
		}
		return user;
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
