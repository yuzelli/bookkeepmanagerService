package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.MyStringUtlis;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import bean.MyError;
import bean.Success;
import bean.UserBean;
import biz.UserInfoBiz;
import bizimpl.UserInfoBizImpl;

public class UserInfoServlet extends HttpServlet {
	UserInfoBiz userInfoBiz = new UserInfoBizImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf8");
		resp.setCharacterEncoding("utf8");
		String type = req.getParameter("type");
		if ("register".equals(type)) {
			registerUserInfo(req, resp);
			return;
		} else if ("login".equals(type)) {
			Login(req, resp);
			return;
		} else if ("updata".equals(type)) {
			Updata(req, resp);
			return;
		} 
	}

	/**
	 * 登陆用户
	 * 
	 * @param req
	 * @param resp
	 */
	private void Login(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			String phone = req.getParameter("phone");
			String passWord = req.getParameter("passWord");

			UserBean userInfo = userInfoBiz.LoginUserInfo(phone, passWord);
			if (userInfo != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(userInfo);
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			} else {
				MyError error = new MyError();
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 注册用户
	 * 
	 * @param req
	 * @param resp
	 */
	private void registerUserInfo(HttpServletRequest req,
			HttpServletResponse resp) {
		// TODO Auto-generated method stub
		try {
			String phone = req.getParameter("phone");
			String passWord = req.getParameter("passWord");
			
			UserBean userInfo = new UserBean();
			userInfo.setPhone(phone);
			userInfo.setPassWord(passWord);
			

			UserBean userInfo2 = userInfoBiz.registerUserInfo(userInfo);
			if (userInfo2 != null) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(userInfo2);
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			} else {
				MyError error = new MyError();
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
