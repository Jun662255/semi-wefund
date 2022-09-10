package com.kh.project.model.dao;
import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.model.PageInfo;
import com.kh.project.model.vo.Likes;
import com.kh.project.model.vo.Product;
import com.kh.project.model.vo.Project;
import com.kh.project.model.vo.ProjectAttachment;
import com.kh.project.model.vo.Support;

public class ProjectDao {
	
	private Properties prop = new Properties();
	
	public ProjectDao() {
		String fileName = ProjectDao.class.getResource("/sql/project/project-mapper.xml").getPath();
	
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public int insertProject(Connection conn,Project p) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertProject");
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,p.getProjectCreator());
			pstmt.setString(2, p.getProjectName());
			pstmt.setInt(3, p.getCategoryNo());
			pstmt.setString(4, p.getCategoryName());
			pstmt.setString(5, p.getEndDate());
			pstmt.setString(6,p.getGoalAmount());
			pstmt.setString(7, p.getBank());
			pstmt.setString(8, p.getAccountNo());
			pstmt.setString(9, p.getAccountName());
			pstmt.setString(10, p.getProjectContent());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertProjectAttachmentList(Connection conn,ArrayList<ProjectAttachment> list) {
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertProjectAttachmentList");
		
		try {
			
			for(ProjectAttachment pat : list) {
				pstmt = conn.prepareStatement(sql);
				
				
				pstmt.setString(1, pat.getOriginName());
				pstmt.setString(2, pat.getChangeName());
				pstmt.setString(3, pat.getFilePath());
				pstmt.setInt(4, pat.getFileLevel());
				
				
				result *= pstmt.executeUpdate();
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
		
	public int insertProduct(Connection conn,ArrayList<Product> plist) {
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertProduct");
		
		try {
			
			for(Product pd : plist) {
				
				if(pd != null) {
					
					pstmt = conn.prepareStatement(sql);
					
					
					
					pstmt.setString(1, pd.getProductName());
					pstmt.setString(2, pd.getProductPrice());
					
					result *= pstmt.executeUpdate();
				}

			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}
	
	public int selectProjectListCount(Connection conn) {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectProjectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}
	
	public ArrayList<Project> selectProjectList(Connection conn,PageInfo pi){
		
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProjectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			/*
			 * currentpage = 1 / 1 ~ 5
			 * currentpage = 2 / 6 ~ 10
			 * currentpage = 3 / 11 ~15
			 * 
			 * 
			 */
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getProjectLimit() + 1;
			int endRow = startRow + pi.getProjectLimit() - 1 ;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
		
		
			rset = pstmt.executeQuery();
	
			while(rset.next()) {
				Project p = new Project(rset.getInt("PROJECT_NO"),
									 rset.getString("USER_ID"),
									 rset.getString("NICKNAME"),
									 rset.getString("PROJECT_NAME"),
									 rset.getString("CATEGORY_NAME"),
									 rset.getString("END_DATE"),
									 rset.getString("GOAL_AMOUNT"),
									 rset.getString("TITLEIMG"),
									 rset.getInt("PAYMENTSUM"),
									 rset.getString("START_DATE"),
									 rset.getInt("DDAY"),
									 rset.getInt("COUNT"),
									 rset.getDouble("RATE"));
									 
				
				list.add(p);
	
			}

			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
	
	
	public int increaseCount(Connection conn, int projectNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
	
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			
			pstmt.setInt(1, projectNo);
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return result;
	}
	
	
	public Project selectProject(Connection conn, int projectNo) {
		
		Project p = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectProject");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, projectNo);
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {

				p = new Project(rset.getInt("PROJECT_NO"),
								rset.getInt("PROJECT_CREATOR"),
								rset.getString("USER_ID"),
								rset.getString("NICKNAME"),
								rset.getString("PROJECT_NAME"),
								rset.getInt("CATEGORY_NO"),
								rset.getString("CATEGORY_NAME"),
								rset.getString("START_DATE"),
								rset.getString("END_DATE"),
								rset.getString("GOAL_AMOUNT"),
								rset.getString("PROJECT_CONTENT"),
								rset.getInt("COUNT"),
								rset.getString("APPLY_DATE"),						
								rset.getInt("PAYMENT"));
				  p.setStatus(rset.getString("STATUS"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return p;
	}
	
	public ArrayList<Product> selectProduct(Connection conn, int projectNo){
		
		
		ArrayList<Product> plist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, projectNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Product pd = new Product();
				
				pd.setProductNo(rset.getInt("PRODUCT_NO"));
				pd.setProductName(rset.getString("PRODUCT_NAME"));
				pd.setProductPrice(rset.getString("PRICE"));
				
				plist.add(pd);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return plist;
	}
	
	
	
	public ArrayList<ProjectAttachment> selectProjectAttachment(Connection conn, int projectNo){
		
			
		ArrayList<ProjectAttachment> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectProjectAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, projectNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				ProjectAttachment pat = new ProjectAttachment();
				
				pat.setFileNo(rset.getInt("FILE_NO"));
				pat.setOriginName(rset.getString("ORIGIN_NAME"));
				pat.setChangeName(rset.getString("CHANGE_NAME"));
				pat.setFilePath(rset.getString("FILE_PATH"));
				
				list.add(pat);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
		
	 
	public ArrayList<Project> projectSearchList(Connection conn, String keyword){
		
		ArrayList<Project> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("projectSearchList");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, '%' + keyword + '%');

			rset = pstmt.executeQuery();
			
				if(rset != null) {
					while(rset.next()) {
						Project p = new Project(rset.getInt("PROJECT_NO"),
											 rset.getString("USER_ID"),
											 rset.getString("NICKNAME"),
											 rset.getString("PROJECT_NAME"),
											 rset.getString("CATEGORY_NAME"),
											 rset.getString("END_DATE"),
											 rset.getString("GOAL_AMOUNT"),
											 rset.getString("TITLEIMG"),
											 rset.getInt("PAYMENTSUM"),
											 rset.getString("START_DATE"),
											 rset.getInt("DDAY"),
											 rset.getInt("COUNT"),
											 rset.getDouble("RATE"));

						list.add(p);
					}
					
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}	

	public int insertSupport(Connection conn, Support sup) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertSupport");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, sup.getUserNo());
			pstmt.setInt(2, sup.getProjectNo());
			pstmt.setString(3, sup.getOrderName());
			pstmt.setString(4, sup.getOrderPhone());
			pstmt.setString(5, sup.getOrderEmail());
			pstmt.setString(6, sup.getReceiverName());
			pstmt.setString(7, sup.getReceiverPhone());
			pstmt.setString(8, sup.getAddress());
			pstmt.setString(9, sup.getRequests());
			pstmt.setString(10, sup.getProductNames());
			pstmt.setInt(11, sup.getPayment());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return result;
	}	
		
	public int sumPayment(Connection conn , int projectNo) {
		int totalPrice = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("sumPayment");
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, projectNo);
			
			rset = pstmt.executeQuery();

			if(rset.next()) {
				totalPrice = rset.getInt("PAYMENT");
				
			}else {
				totalPrice = 0;
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		return totalPrice;
	}

	public int allowProject(Connection conn, int projectNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("allowProject");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, projectNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		

		return result;
	}

	
	
	public int returnProject(Connection conn , int projectNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("returnProject");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, projectNo);
			
			result = pstmt.executeUpdate();
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
		
		return result;
	}


	public int selectLike(Connection conn , Likes like) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectLike");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, like.getProjectNo());
			pstmt.setInt(2, like.getUserNo());

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("COUNT");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}

		return count;
	}
	
	
	public int deleteLike(Connection conn , Likes like) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteLike");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, like.getProjectNo());
			pstmt.setInt(2, like.getUserNo());

			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}

		
		
		return result;
	}
	
	public int insertLike(Connection conn, Likes like) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertLike");
		
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, like.getUserNo());
			pstmt.setInt(2, like.getProjectNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}

		return result;
	}
	
	
}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

