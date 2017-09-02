package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.processors.JsonValueProcessor;
import utils.MyStringUtlis;
import bean.BookKeepBean;
import bean.MyError;
import bean.Success;
import bean.UserBean;
import biz.UserInfoBiz;
import bizimpl.UserInfoBizImpl;

public class CopyServlet extends HttpServlet {
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
		if ("beifeng".equals(type)) {
			BeifengInfo(req, resp);
			return;
		} 
	}

	private void BeifengInfo(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		Object dataString = req.getParameter("data");

		JSONArray jsonArray  = null;
		ArrayList<BookKeepBean> books = new ArrayList<BookKeepBean>();
		try{
		
		jsonArray= 		JSONArray.fromObject(dataString);
		for (int i = 0; i < jsonArray.size(); i++) {
			BookKeepBean b = new BookKeepBean();
			JSONObject json = (JSONObject)jsonArray.get(i);
			b.setYear(json.optString("year"));
		    b.setMonth(json.optString("month"));
   
             json.put("comment",b.getComment());
             json.put("money",b.getMoney());
             json.put("time",b.getTime());
             b.setDay(json.optString("day"));
             b.setHour(json.optString("hour"));
             b.setMin(json.optString("min"));
             b.setWeek(json.optString("week"));
             b.setType_id(Integer.valueOf(json.optString("type_id")));
             b.setIsZhiCu(Integer.valueOf(json.optString("isZhiCu")));
             b.setComment(json.optString("comment"));
             
             b.setMoney(json.optString("money"));
             b.setTime(Long.valueOf(json.optString("time")));
             books.add(b);
		}
		}catch(Exception e)
		{
			
		}
		
		System.out.println(books);
		
	}
	
	

	

}
