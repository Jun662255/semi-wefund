package com.kh.admin.adminNotice.model.service;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.PageInfo;

import com.kh.admin.adminNotice.model.dao.NoticeDao;
import com.kh.admin.adminNotice.model.vo.Notice;

public class NoticeService {

	public int insertNotice(Notice n) {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().insertNotice(conn, n);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
				
		return result;
	}

	public int selectCountNotice() {
		
		Connection conn = getConnection();
		
		int result = new NoticeDao().selectCountNotice(conn);
		
		close(conn);
		return result; 
	}

	public ArrayList<Notice> selectList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int increaseCount(int noticeNo) {
		
		Connection conn = getConnection();
		
		int result = new  NoticeDao().increaseCount(conn, noticeNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	
	
}
