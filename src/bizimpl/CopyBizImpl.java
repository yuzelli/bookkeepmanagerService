package bizimpl;

import java.util.ArrayList;

import dao.CopyDao;
import daoimpl.CopyDaoImpl;
import bean.BookKeepBean;
import biz.CopyBiz;

public class CopyBizImpl implements CopyBiz {
    CopyDao dao = new CopyDaoImpl();
	@Override
	public int BeifengInfo(ArrayList<BookKeepBean> books) throws Exception {
		// TODO Auto-generated method stub
		return dao.BeifengInfo(books);
	}

}
