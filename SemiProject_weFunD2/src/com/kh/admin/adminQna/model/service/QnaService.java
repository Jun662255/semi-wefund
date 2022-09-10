package com.kh.admin.adminQna.model.service;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.adminQna.model.dao.QnaDao;
import com.kh.admin.adminQna.model.vo.Qna;
import com.kh.common.model.PageInfo;


public class QnaService {

	public int selectCountQna() {
		
		Connection conn = getConnection();
		
		int result = new QnaDao().selectCountQna(conn);
		
		close(conn);
		
		return result;
	}

	public ArrayList<Qna> selectlistQna(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Qna> list = new QnaDao().selectlistQna(conn, pi);
		
		close(conn);
				
		return list;
	}

}
