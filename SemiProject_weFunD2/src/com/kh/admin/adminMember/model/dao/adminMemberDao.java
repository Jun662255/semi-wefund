package com.kh.admin.adminMember.model.dao;

import static com.kh.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.member.model.vo.Member;
import com.kh.admin.adminMember.model.vo.Report;
import com.kh.common.model.PageInfo;
import com.kh.admin.adminNotice.model.dao.NoticeDao;

public class adminMemberDao {
	
	private Properties prop = new Properties();

	public adminMemberDao() {

		String fileName = NoticeDao.class.getResource("/sql/admin/adminMember/member-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int listCountMember(Connection conn) {
		
		int listcount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		
		String sql = prop.getProperty("listcount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listcount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);

		}

		return listcount;
	}

	public ArrayList<Member> selectListMember(Connection conn, PageInfo pi) {
		
		ArrayList<Member> list = new ArrayList<Member>();		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit();
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member(rset.getInt("USER_NO"),
									  rset.getString("USER_ID"),
									  rset.getString("USER_NAME"),
									  rset.getString("NICKNAME"),
									  rset.getString("PHONE"),
									  rset.getDate("ENROLL_DATE"),
									  rset.getDate("MODIFY_DATE"));
				list.add(m);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int withdrawalListCountMember(Connection conn) {
		int listcount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		
		String sql = prop.getProperty("withdrawalListCountMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listcount = rset.getInt("COUNT");
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);

		}

		return listcount;
	}

	public ArrayList<Member> withdrawalselectListMember(Connection conn, PageInfo pi) {
		
		ArrayList<Member> list = new ArrayList<Member>();		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("withdrawalselectListMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit();
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member(rset.getInt("USER_NO"),
									  rset.getString("USER_ID"),
									  rset.getString("USER_NAME"),
									  rset.getString("NICKNAME"),
									  rset.getString("PHONE"),
									  rset.getDate("ENROLL_DATE"),
									  rset.getDate("MODIFY_DATE"));
				list.add(m);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public int restorationMember(Connection conn,String userNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("restorationMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}


	
	public ArrayList<Report> selectListReportMember(Connection conn, PageInfo pi) {
				
		ArrayList<Report> list = new ArrayList<Report>();		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListReportMember");
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit();
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {

				Report r = new Report(rset.getString("R1"),
									  rset.getString("REVIEW_TITLE"),
									  rset.getString("N2"),
									  rset.getString("REPLY_DATE"),
									  rset.getString("REPLY_CONTENT"),
									  rset.getString("N1"),
									  rset.getString("REPORT_DATE"),
									  rset.getString("REVIEW_NO"));
				list.add(r);
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);

		}
		return list;
	}

	public int listCountReportMember(Connection conn) {
		int listcount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		
		String sql = prop.getProperty("listCountReportMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listcount = rset.getInt("COUNT");
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);

		}

		return listcount;
	}

	public int suspensionMember(Connection conn, String nickname) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("suspensionMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;	
	}
	
	public int checkMember(Connection conn, String replyNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("checkMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;	
		
		
	}

	public int replystatusN(Connection conn, String replyNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("replystatusN");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

}

