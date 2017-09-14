package daoimpl;

import java.util.ArrayList;
import java.util.List;

import bean.BookKeepBean;
import dao.CopyDao;
import db.DataBaseUtil;

public class CopyDaoImpl implements CopyDao {

	@Override
	public int BeifengInfo(ArrayList<BookKeepBean> books) throws Exception {
		// TODO Auto-generated method stub

		try {
			
			
			deleteCopy(books.get(0).getPhone());
			
			
			int num = 0;
			for (BookKeepBean b : books) {
				String sqlStr = "insert into bookkeep (year,month,day,"
						+ "min,week," + "type_id,isZhiCu,money,"
						+ "time,phone)" + "values(?,?,?,?,?,?,?,?,?,?)";
				num = num
						+ DataBaseUtil.executeUpdate(
								sqlStr,
								new Object[] { b.getYear(), b.getMonth(),
										b.getDay(), b.getMin(), b.getWeek(),
										b.getType_id() + "",
										b.getIsZhiCu() + "", b.getMoney(),
										b.getTime() + "", b.getPhone() });
			}

			if (num > 0) {
				return num;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeConn();
		}
		return 0;
	}
	public boolean deleteCopy(String phone) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = "delete from bookkeep where phone =?";
		boolean flag = false;
		try {
			int num  = DataBaseUtil.executeUpdate(sql, new Object[]{phone});
		    if(num>0){
		    	flag = true;
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeConn();
		}
		
		return flag;
	}
}
