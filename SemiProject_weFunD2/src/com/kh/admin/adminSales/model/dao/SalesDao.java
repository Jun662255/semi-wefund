package com.kh.admin.adminSales.model.dao;

import java.io.FileInputStream;
import static com.kh.common.JDBCTemplate.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.admin.adminReview.model.dao.ReviewDao;
import com.kh.admin.adminSales.model.vo.Sales;

public class SalesDao {
	private Properties prop = new Properties();
	
	public SalesDao() {

		String fileName = ReviewDao.class.getResource("/sql/admin/adminSales/sales-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public ArrayList<Sales> monthlyCategorySalesList(Connection conn, String month, String year){
		ArrayList<Sales> list = new ArrayList<Sales>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("monthlyCategorySalesList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%'+year+'/'+month);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Sales s  = new Sales(rset.getInt("SUMA"),
									 rset.getString("CATEGORY_NO"),
									 rset.getString("CATEGORY_NAME"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	
	public ArrayList<Sales> monthlySales(Connection conn, String month, String year){
		ArrayList<Sales> list = new ArrayList<Sales>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("monthlySales");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%'+year+'/'+month);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Sales s  = new Sales(rset.getInt("MSUM"),
								     rset.getString("DE"));
				list.add(s);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
}
