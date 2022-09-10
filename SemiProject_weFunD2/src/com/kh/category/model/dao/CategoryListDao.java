package com.kh.category.model.dao;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;
import com.kh.category.model.vo.Category;
import com.kh.member.model.dao.MemberDao;

public class CategoryListDao {
	
private Properties prop = new Properties();
	
	public CategoryListDao() {
		// mapper 파일 가져오기
		
		String file = MemberDao.class.getResource("/sql/category/category-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Category> selectTechList(Connection conn, String categoryNo) {
		
		// SELECT문 -> ResultSet => 여러행
		
		ArrayList<Category> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTechyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(categoryNo));
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Category c = new Category();
				
				c.setProjectNo(rset.getInt("PROJECT_NO"));
				c.setNickname(rset.getString("NICKNAME"));
				c.setProjectName(rset.getString("PROJECT_NAME"));
				c.setCategoryName(rset.getString("CATEGORY_NAME"));
				c.setdDay(rset.getInt("DDAY"));
				c.setGoalAmount(rset.getInt("GOAL_AMOUNT"));
				c.setPaymentSum(rset.getInt("PAYMENTSUM"));
				c.setThumbnailImg(rset.getString("FILE_PATH||CHANGE_NAME"));
				
				list.add(c);
			}
			
			System.out.println(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}


}
