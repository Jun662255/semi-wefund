package com.kh.admin.adminReview.model.dao;
import static com.kh.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.admin.adminReview.model.vo.Review;
import com.kh.common.model.PageInfo;

public class ReviewDao {
	
	private Properties prop = new Properties();
	
	public ReviewDao() {

		String fileName = ReviewDao.class.getResource("/sql/admin/adminReview/review-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int listCountReview(Connection conn) {

		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("listCountReview");

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

	public ArrayList<Review> selectList(Connection conn, PageInfo pi) {

		ArrayList<Review> list = new ArrayList<Review>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectList");

		try {
			pstmt = conn.prepareStatement(sql);

			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Review r = new Review(rset.getInt("REVIEW_NO"),
									  rset.getString("NICKNAME"),
									  rset.getInt("SUPPORT_NO"),
									  rset.getString("REVIEW_TITLE"),
									  rset.getInt("RATE"),
									  rset.getInt("COUNT"),
									  rset.getString("REVIEW_DATE")
									  );
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
	
	
	
	
	

}
