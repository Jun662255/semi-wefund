package com.kh.admin.adminNotice.model.dao;

import static com.kh.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.model.PageInfo;
import com.kh.admin.adminNotice.model.vo.*;

public class NoticeDao {

	private Properties prop = new Properties();

	public NoticeDao() {

		String fileName = NoticeDao.class.getResource("/sql/admin/adminNotice/notice-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertNotice(Connection conn, Notice n) {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertNotice");

		try {
			pstmt = conn.prepareStatement(sql);


			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	/*public ArrayList<Notice> selectNoticeList(Connection conn) {
		
		ArrayList<Notice> list = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n = new Notice(rset.getInt("NOTICE_NO"),
									  rset.getString("NICKNAME"),
									  rset.getString("NOTICE_TITLE"),
									  rset.getString("NOTICE_CONTENT"),
									  rset.getInt("COUNT"),
									  rset.getDate("NOTICE_DATE"));
				list.add(n);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
			
		}

		return list;
	}*/

	public int selectCountNotice(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCountNotice");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
			
		}
		return listCount;
	}

	public ArrayList<Notice> selectList(Connection conn, PageInfo pi) {
		
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() +1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n = new Notice(rset.getInt("NOTICE_NO"),
									  rset.getString("NICKNAME"),
									  rset.getString("NOTICE_TITLE"),
									  rset.getString("NOTICE_CONTENT"),
									  rset.getInt("COUNT"),
									  rset.getDate("NOTICE_DATE"));
				list.add(n);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
			
		}
		
		return list;
	}

	public int increaseCount(Connection conn, int noticeNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return result;
	}



	
	
	
	
	
	
	
	
}
