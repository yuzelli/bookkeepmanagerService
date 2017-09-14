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
import biz.CopyBiz;
import bizimpl.CopyBizImpl;

public class CopyServlet extends HttpServlet {
	CopyBiz copyBiz = new CopyBizImpl();

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

		JSONArray jsonArray = null;
		ArrayList<BookKeepBean> books = new ArrayList<BookKeepBean>();
		try {

			jsonArray = JSONArray.fromObject(dataString);
			for (int i = 0; i < jsonArray.size(); i++) {
				BookKeepBean b = new BookKeepBean();
				JSONObject json = (JSONObject) jsonArray.get(i);
				b.setYear(json.optString("year"));
				b.setMonth(json.optString("month"));

				b.setDay(json.optString("day"));
				b.setHour(json.optString("hour"));
				b.setMin(json.optString("min"));
				String week = new String(json.optString("week").getBytes("ISO8859-1"),"UTF-8");
				b.setWeek(week);
				b.setType_id(Integer.valueOf(json.optString("type_id")));
				b.setIsZhiCu(Integer.valueOf(json.optString("isZhiCu")));
				String comment = new String(json.optString("comment").getBytes("ISO8859-1"),"UTF-8");
				
				b.setComment(comment);

				b.setMoney(json.optString("money"));
				b.setTime(Long.valueOf(json.optString("time")));
				b.setPhone(json.optString("phone"));
				books.add(b);
			}
			int num = copyBiz.BeifengInfo(books);
			if (num != 0) {
				MyError error = new MyError();
				error.setError("ok");
				error.setObject(num + "");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			} else {
				MyError error = new MyError();
				error.setError("error");
				JSONObject jsonObject = JSONObject.fromObject(error);
				resp.getWriter().print(jsonObject);
			}
		} catch (Exception e) {

		}

		System.out.println(books);

	}

}
