package com.kh.qna.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.PageInfo;
import com.kh.qna.model.dao.QnaDao;
import com.kh.qna.model.vo.Qna;

public class QnaService {

	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new QnaDao().selectListCount(conn);
		
		close(conn);
				
		return listCount;
	}

	public ArrayList<Qna> selectQnaList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Qna> list = new QnaDao().selectQnaList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int insertQna(Qna q) {
		
		Connection conn = getConnection();
		
		int result = new QnaDao().insertQna(conn, q);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public Qna selectQna(int qnaNo) {

		Connection conn = getConnection();
		
		Qna q = new QnaDao().selectQna(conn, qnaNo);
		
		close(conn);
		
		return q;
	}
	
	public int updateQna(Qna q) {

		Connection conn = getConnection();
		
		int result = new QnaDao().updateQna(conn, q);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		return result;
	}
	
	public int deleteQna(int qnaNo) {
		
		Connection conn = getConnection();
		
		int result = new QnaDao().deleteQna(conn, qnaNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		return result;
	}
	
	public int insertAnswer(Qna q) {
		
		Connection conn = getConnection();
		
		int result = new QnaDao().insertAnswer(conn, q);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		return result;
	}
	
	public int updateAnswer(Qna q) {
		
		Connection conn = getConnection();
		
		int result = new QnaDao().updateAnswer(conn, q);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		return result;
	}

}
