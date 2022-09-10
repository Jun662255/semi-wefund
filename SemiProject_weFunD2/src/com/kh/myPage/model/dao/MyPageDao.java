package com.kh.myPage.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.model.PageInfo;
import com.kh.myPage.model.vo.*;


import static com.kh.common.JDBCTemplate.*;


public class MyPageDao {
	
	private Properties prop = new Properties();
	
	public MyPageDao() {
		String fileName = MyPageDao.class.getResource("/sql/myPage/myPage-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Project> selectMyLikeList(Connection conn, PageInfo pi, int userNo) {
		
		// SELECT => ResultSet => 여러행
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMyLikeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
						
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Project p = new Project();
				p.setCategoryName(rset.getString("CATEGORY_NAME"));
				p.setProjectNo(rset.getInt("PROJECT_NO"));
				p.setStatus(rset.getString("STATUS"));
				p.setProjectName(rset.getString("PROJECT_NAME"));
				p.setEndDate(rset.getDate("END_DATE"));
				p.setTitleImg(rset.getString("TITLEIMG"));
				
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

	public int selectLikeListCount(Connection conn, int userNo) {
		
		// SELECT => ResultSet => int로 반환
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectLikeListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
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

	public int selectSupportListCount(Connection conn, int userNo) {
		
		//SELECT문 => ResultSet => int반환
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSupportListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
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

	public ArrayList<Support> selectMySupportList(Connection conn, PageInfo pi, int userNo) {
		
		ArrayList<Support> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMySupportList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1; 
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Support s = new Support(rset.getInt("SUPPORT_NO"),
										rset.getInt("PROJECT_NO"),
										rset.getDate("SUPPORT_DATE"),
										rset.getString("SS"),
										rset.getString("CATEGORY_NAME"),
										rset.getString("PROJECT_NAME"),
										rset.getString("PS"),
										rset.getString("TITLEIMG"));
				
				list.add(s);
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int selectProjectListCount(Connection conn, int userNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProjectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
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

	public ArrayList<Project> selectMyProjectList(Connection conn, PageInfo pi, int userNo) {
		
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyProjectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Project p = new Project(rset.getInt("PROJECT_NO"),
									 	rset.getString("PROJECT_NAME"),
									 	rset.getString("CATEGORY_NAME"),
									 	rset.getInt("GOAL_AMOUNT"),
									 	rset.getString("STATUS"),
									 	rset.getString("TITLEIMG"),
									 	rset.getDouble("PAYMENTSUM"));
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

	public Project selectMyProject(Connection conn, int projectNo) {
		
		// SELECT => ResultSet => 한행만 => Project
		Project pj = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyProject");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, projectNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				pj = new Project(rset.getInt("PROJECT_NO"),
								rset.getString("PROJECT_NAME"),
								rset.getString("CATEGORY_NAME"),
								rset.getDate("START_DATE"),
								rset.getDate("END_DATE"),
								rset.getInt("GOAL_AMOUNT"),
								rset.getString("BANK"),
								rset.getString("ACCOUNT_NO"),
								rset.getString("ACCOUNT_NAME"),
								rset.getString("PROJECT_CONTENT"),
								rset.getDate("APPLY_DATE"),
								rset.getString("STATUS"));
			}
   
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return pj;
	}

	public ArrayList<Product> selectMyProduct(Connection conn, int projectNo) {
		
		ArrayList<Product> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, projectNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product pd = new Product();
				pd.setProductNo(rset.getInt("PRODUCT_NO"));
				pd.setProductName(rset.getString("PRODUCT_NAME"));
				pd.setPrice(rset.getInt("PRICE"));
				
				list.add(pd);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int selectMyReviewListCount(Connection conn, int userNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyReviewListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
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

	public ArrayList<Review> selectMyReviewList(Connection conn, PageInfo pi, int userNo) {
		
		ArrayList<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyReviewList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Review rv = new Review(rset.getInt("REVIEW_NO"),
									   rset.getInt("REVIEW_WRITER"),
									   rset.getInt("SUPPORT_NO"),
									   rset.getString("REVIEW_TITLE"),
									   rset.getDate("REVIEW_DATE"),
									   rset.getString("USER_NAME"),
									   rset.getString("TITLEIMG"),
									   rset.getInt("PROJECT_NO"));
				
				list.add(rv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}



	public ArrayList<Project> selectMyFundingList(Connection conn, PageInfo pi, int userNo) {
		
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyFundingList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Project p = new Project();
				p.setCategoryName(rset.getString("CATEGORY_NAME"));
				p.setProjectNo(rset.getInt("PROJECT_NO"));
				p.setStatus(rset.getString("STATUS"));
				p.setProjectName(rset.getString("PROJECT_NAME"));
				p.setEndDate(rset.getDate("END_DATE"));
				p.setTitleImg(rset.getString("TITLEIMG"));
				
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

	public ArrayList<Project> selectCompleteList(Connection conn, PageInfo pi, int userNo) {
		
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCompleteList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Project p = new Project();
				p.setCategoryName(rset.getString("CATEGORY_NAME"));
				p.setProjectNo(rset.getInt("PROJECT_NO"));
				p.setStatus(rset.getString("STATUS"));
				p.setProjectName(rset.getString("PROJECT_NAME"));
				p.setEndDate(rset.getDate("END_DATE"));
				p.setTitleImg(rset.getString("TITLEIMG"));
				
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

	public ArrayList<ProjectAttachment> selectMyAttachmentList(Connection conn, int projectNo) {
		
		ArrayList<ProjectAttachment> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyAttachmentList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, projectNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ProjectAttachment at = new ProjectAttachment();
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFilePath(rset.getString("FILE_PATH"));
				at.setFileLevel(rset.getInt("FILE_LEVEL"));
				
				list.add(at);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Project> selectMyWaitingList(Connection conn, PageInfo pi, int userNo) {
		
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyWaitingList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Project p = new Project(rset.getInt("PROJECT_NO"),
									 	rset.getString("PROJECT_NAME"),
									 	rset.getString("CATEGORY_NAME"),
									 	rset.getInt("GOAL_AMOUNT"),
									 	rset.getString("STATUS"),
									 	rset.getString("TITLEIMG"),
									 	rset.getDouble("PAYMENTSUM"));
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

	public ArrayList<Project> selectMyEndingList(Connection conn, PageInfo pi, int userNo) {
		
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyEndingList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Project p = new Project(rset.getInt("PROJECT_NO"),
									 	rset.getString("PROJECT_NAME"),
									 	rset.getString("CATEGORY_NAME"),
									 	rset.getInt("GOAL_AMOUNT"),
									 	rset.getString("STATUS"),
									 	rset.getString("TITLEIMG"),
									 	rset.getDouble("PAYMENTSUM"));
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

	public ArrayList<Project> selectMyApprovedList(Connection conn, PageInfo pi, int userNo) {
		
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyApprovedList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Project p = new Project(rset.getInt("PROJECT_NO"),
									 	rset.getString("PROJECT_NAME"),
									 	rset.getString("CATEGORY_NAME"),
									 	rset.getInt("GOAL_AMOUNT"),
									 	rset.getString("STATUS"),
									 	rset.getString("TITLEIMG"),
									 	rset.getDouble("PAYMENTSUM"));
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

	public ArrayList<Project> selectMyCompanionList(Connection conn, PageInfo pi, int userNo) {
		
		ArrayList<Project> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyCompanionList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Project p = new Project(rset.getInt("PROJECT_NO"),
									 	rset.getString("PROJECT_NAME"),
									 	rset.getString("CATEGORY_NAME"),
									 	rset.getInt("GOAL_AMOUNT"),
									 	rset.getString("STATUS"),
									 	rset.getString("TITLEIMG"),
									 	rset.getDouble("PAYMENTSUM"));
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

	public ArrayList<Support> selectSuccessPayment(Connection conn, PageInfo pi, int userNo) {
		
		ArrayList<Support> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSuccessPayment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1; 
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Support s = new Support(rset.getInt("SUPPORT_NO"),
										rset.getInt("PROJECT_NO"),
										rset.getDate("SUPPORT_DATE"),
										rset.getString("SS"),
										rset.getString("CATEGORY_NAME"),
										rset.getString("PROJECT_NAME"),
										rset.getString("PS"),
										rset.getString("TITLEIMG"));
				
				list.add(s);
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	
		return list;
	}

	public ArrayList<Support> selectPaymentReservation(Connection conn, PageInfo pi, int userNo) {
		
		ArrayList<Support> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPaymentReservation");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1; 
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Support s = new Support(rset.getInt("SUPPORT_NO"),
										rset.getInt("PROJECT_NO"),
										rset.getDate("SUPPORT_DATE"),
										rset.getString("SS"),
										rset.getString("CATEGORY_NAME"),
										rset.getString("PROJECT_NAME"),
										rset.getString("PS"),
										rset.getString("TITLEIMG"));
				
				list.add(s);
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
	
		return list;
	}

	public ArrayList<Support> selectPaymentFailed(Connection conn, PageInfo pi, int userNo) {
		
		ArrayList<Support> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPaymentFailed");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1; 
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Support s = new Support(rset.getInt("SUPPORT_NO"),
										rset.getInt("PROJECT_NO"),
										rset.getDate("SUPPORT_DATE"),
										rset.getString("SS"),
										rset.getString("CATEGORY_NAME"),
										rset.getString("PROJECT_NAME"),
										rset.getString("PS"),
										rset.getString("TITLEIMG"));
				
				list.add(s);
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int updateMyProject(Connection conn, Project pj) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateMyProject");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pj.getProjectName());
			pstmt.setString(2, pj.getProjectContent());
			pstmt.setInt(3, pj.getProjectNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		//System.out.println(result);
		return result;
	}

	public int updateAttachment(Connection conn, ArrayList<ProjectAttachment> list) {
		
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateAttachment");
		
		//System.out.println("리스트 사이즈" + list.size());
		
		try {
			for(ProjectAttachment at : list) {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				pstmt.setInt(4, at.getFileNo());
				pstmt.setInt(5, at.getFileLevel());
				
				result *= pstmt.executeUpdate();
				
				System.out.println(at.getOriginName());
				System.out.println(at.getChangeName());
				System.out.println(at.getFilePath());
				System.out.println(at.getFileNo());
				System.out.println("디에이오 파일 레벨" + at.getFileLevel());
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		//System.out.println("업데이트 결과 " + result);
		return result;
	}

	public int insertNewAttachment(Connection conn, ArrayList<ProjectAttachment> list) {
		
		int result = 1;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNewAttachment");
		
		try {
			
			for(ProjectAttachment at : list) {
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, at.getProjectNo());
				pstmt.setString(2, at.getOriginName());
				pstmt.setString(3, at.getChangeName());
				pstmt.setString(4, at.getFilePath());
				pstmt.setInt(5, at.getFileLevel());
				
				result *= pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int selectProjectWaitingListCount(Connection conn, int userNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectProjectWaitingListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
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

	public int selectEndProjectListCount(Connection conn, int userNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectEndProjectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
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

	public int selectApprovedProjectListCount(Connection conn, int userNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectApprovedProjectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
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

	public int selectCompanionProjectListCount(Connection conn, int userNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCompanionProjectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
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

	public int selectMyFundingListCount(Connection conn, int userNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyFundingListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
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

	public int selectMyCompleteListCount(Connection conn, int userNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyCompleteListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
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

	public int selectSuccessPaymentListCount(Connection conn, int userNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSuccessPaymentListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
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

	public int selectPaymentReservationListCount(Connection conn, int userNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPaymentReservationListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
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

	public int selectPaymentFailedListCount(Connection conn, int userNo) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectPaymentFailedListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			
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
	 public Support selectSupportDetail(Connection conn, String userId, String pno) {

	        Support s = null;
	        PreparedStatement pstmt = null;
	        ResultSet rset = null;

	        String sql = prop.getProperty("selectSupportDetail");

	        try {
	            pstmt = conn.prepareStatement(sql);

	            pstmt.setString(1, userId);
	            pstmt.setInt(2, Integer.parseInt(pno));

	            rset = pstmt.executeQuery();

	            if(rset.next()) {
	                s = new Support(
	                        rset.getString("ORDER_NAME"),
	                        rset.getString("ORDER_PHONE"),
	                        rset.getString("RECEIVER_NAME"),
	                        rset.getString("RECEIVER_PHONE"),
	                        rset.getString("RECEIVER_ADDRESS"),
	                        rset.getString("PRODUCT"),
	                        rset.getInt("PAYMENT"),
	                        rset.getDate("SUPPORT_DATE"),
	                        rset.getString("STA"),
	                        rset.getString("PROJECT_NAME"),
	                        rset.getString("FILE_PATH||CHANGE_NAME"));

	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            close(rset);
	            close(pstmt);
	        }
	        return s;
	    }

}
