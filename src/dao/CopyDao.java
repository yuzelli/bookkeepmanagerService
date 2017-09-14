package dao;

import java.util.ArrayList;

import bean.BookKeepBean;
import bean.UserBean;

public interface CopyDao {
	
	public int BeifengInfo(ArrayList<BookKeepBean> books)throws Exception;

}
