package com.kh.qna.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.model.PageInfo;
import com.kh.qna.model.vo.Qna;

import static com.kh.common.JDBCTemplate.*;

public class QnaDao {

	private Properties prop = new Properties();
	
	public QnaDao() {
		String fileName = QnaDao.class.getResource("/sql/qna/qna-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectListCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	public ArrayList<Qna> selectQnaList(Connection conn, PageInfo pi) {
		
		ArrayList<Qna> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQnaList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Qna q = new Qna(rset.getInt("QNA_NO"),
								rset.getString("NICKNAME"),
								rset.getString("QNA_TITLE"),
								rset.getString("QNA_DATE"),
								rset.getString("ANSWER"));
				
				list.add(q);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertQna(Connection conn, Qna q) {
		
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(q.getQnaWriter()));
			pstmt.setString(2, q.getQnaTitle());
			pstmt.setString(3, q.getQnaContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Qna selectQna(Connection conn, int qnaNo) {
		
		Qna q = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qnaNo);
			
			rset= pstmt.executeQuery();
			
			if(rset.next()) {
				q = new Qna(rset.getInt("QNA_NO"),
							rset.getString("NICKNAME"),
							rset.getString("QNA_TITLE"),
							rset.getString("QNA_CONTENT"),
							rset.getString("QNA_DATE"),
							rset.getString("ANSWER"),
							rset.getString("ANSWER_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return q;
	}

	public int updateQna(Connection conn, Qna q) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, q.getQnaTitle());
			pstmt.setString(2, q.getQnaContent());
			pstmt.setInt(3, q.getQnaNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteQna(Connection conn, int qnaNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteQna");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, qnaNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertAnswer(Connection conn, Qna q) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAnswer");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, q.getAnswer());
			pstmt.setInt(2, q.getQnaNo());
			
			result= pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateAnswer(Connection conn, Qna q) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAnswer");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, q.getAnswer());
			pstmt.setInt(2, q.getQnaNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}


}
