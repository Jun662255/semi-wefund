package com.kh.admin.adminProject.model.dao;

import static com.kh.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.admin.adminProject.model.vo.Project;
import com.kh.admin.adminProject.model.vo.Support;
import com.kh.admin.adminQna.model.vo.Qna;
import com.kh.common.model.PageInfo;

public class ProjectDao {

	private Properties prop = new Properties();

	public ProjectDao() {
		String fileName = ProjectDao.class.getResource("/sql/admin/adminProject/project-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int listCountAll(Connection conn) {
		int listCountAll = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("listCountAll");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCountAll = rset.getInt("COUNT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);

		}

		return listCountAll;
	}

	public int listCountY(Connection conn) {
		int listCountY = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("listCountY");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCountY = rset.getInt("COUNT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);

		}

		return listCountY;
	}

	public int listCountN(Connection conn) {
		int listCountN = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("listCountN");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCountN = rset.getInt("COUNT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);

		}

		return listCountN;
	}

	public int listCountE(Connection conn) {
		int listCountE = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("listCountE");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCountE = rset.getInt("COUNT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);

		}

		return listCountE;
	}

	public int listCountX(Connection conn) {
		int listCountX = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("listCountX");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				listCountX = rset.getInt("COUNT");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);

		}

		return listCountX;
	}

	public ArrayList<Project> selectAllListProject(Connection conn, PageInfo piAll) {
		ArrayList<Project> list = new ArrayList<Project>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAllListProject");

		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (piAll.getCurrentPage() - 1) * piAll.getBoardLimit() + 1;
			int endRow = startRow + piAll.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Project p = new Project(rset.getString("PROJECT_NO"),
						rset.getString("NICKNAME"),
						rset.getString("PROJECT_NAME"),		
						rset.getString("APPLY_DATE"));
				list.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Project> selectYListProject(Connection conn, PageInfo piY) {
		ArrayList<Project> list = new ArrayList<Project>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectYListProject");

		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (piY.getCurrentPage() - 1) * piY.getBoardLimit()+ 1;
			int endRow = startRow + piY.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Project p = new Project(rset.getString("PROJECT_NO"),
						rset.getString("NICKNAME"),
						rset.getString("PROJECT_NAME"),		
						rset.getString("APPLY_DATE"));
				list.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Project> selectNListProject(Connection conn, PageInfo piN) {
		ArrayList<Project> list = new ArrayList<Project>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectNListProject");

		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (piN.getCurrentPage() - 1) * piN.getBoardLimit()+ 1;
			int endRow = startRow + piN.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Project p = new Project(rset.getString("PROJECT_NO"),
						rset.getString("NICKNAME"),
						rset.getString("PROJECT_NAME"),		
						rset.getString("APPLY_DATE"));
				list.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Project> selectEListProject(Connection conn, PageInfo piE) {
		ArrayList<Project> list = new ArrayList<Project>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectEListProject");

		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (piE.getCurrentPage() - 1) * piE.getBoardLimit()+ 1;
			int endRow = startRow + piE.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Project p = new Project(rset.getString("PROJECT_NO"),
						rset.getString("NICKNAME"),
						rset.getString("PROJECT_NAME"),		
						rset.getString("APPLY_DATE"));
				list.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Project> selectXListProject(Connection conn, PageInfo piX) {
		ArrayList<Project> list = new ArrayList<Project>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectXListProject");

		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (piX.getCurrentPage() - 1) * piX.getBoardLimit()+ 1;
			int endRow = startRow + piX.getBoardLimit() - 1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				Project p = new Project(rset.getString("PROJECT_NO"),
						rset.getString("NICKNAME"),
						rset.getString("PROJECT_NAME"),		
						rset.getString("APPLY_DATE"));
				list.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int listCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("listCount");
		
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

	public ArrayList<Project> ProjectSupportList(Connection conn, PageInfo pi) {
		ArrayList<Project> list = new ArrayList<Project>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("ProjectSupportList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage()- 1) * pi.getBoardLimit() + 1 ;
			int endRow = startRow + pi.getBoardLimit() -1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Project p = new Project();
				p.setProjectNo(rset.getString("PROJECT_NO"));
				p.setProjectName(rset.getString("PROJECT_NAME"));
				p.setProjectCreator(rset.getString("NICKNAME"));
				p.setEndDate(rset.getString("END_DATE"));

				list.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}

		return list;
	}

	public ArrayList<Support> SupportDetail(Connection conn,String pno) {
		ArrayList<Support> list = new ArrayList<Support>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("SupportDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(pno));
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Support s = new Support(rset.getString("SUPPORT_NO"),
										rset.getString("ORDER_NAME"),
										rset.getString("ORDER_PHONE"),
										rset.getString("ORDER_EMAIL"),
										rset.getString("RECEIVER_NAME"),
										rset.getString("RECEIVER_PHONE"),
										rset.getString("RECEIVER_ADDRESS"),
										rset.getString("ORDER_COMMENT"),
										rset.getString("PRODUCT"),
										rset.getString("PAYMENT"),
										rset.getString("SUPPORT_DATE"));
				list.add(s);
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
