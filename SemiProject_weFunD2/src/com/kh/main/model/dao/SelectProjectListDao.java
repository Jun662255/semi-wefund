package com.kh.main.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;

import com.kh.main.model.vo.SelectProjectList;
import com.kh.member.model.dao.MemberDao;

public class SelectProjectListDao {
	private Properties prop = new Properties();
	public SelectProjectListDao() {
		String file = MemberDao.class.getResource("/sql/main/main-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<SelectProjectList> selectByCount(Connection conn) {
		
		// SELECT문 -> ResultSet => 여러행
		
		ArrayList<SelectProjectList> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectByCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				SelectProjectList s = new SelectProjectList();
				
				s.setProjectNo(rset.getInt("PROJECT_NO"));
				s.setNickname(rset.getString("NICKNAME"));
				s.setProjectName(rset.getString("PROJECT_NAME"));
				s.setdDay(rset.getInt("DDAY"));
				s.setThumbnailImg(rset.getString("FILE_PATH||CHANGE_NAME"));
				s.setRate(rset.getDouble("RATE"));
				
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
