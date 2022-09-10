package com.kh.review.model.dao;

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
import com.kh.notice.model.dao.NoticeDao;
import com.kh.review.model.vo.Reply;
import com.kh.review.model.vo.Report;
import com.kh.review.model.vo.Review;
import com.kh.review.model.vo.ReviewAttachment;
import com.kh.review.model.vo.Support;

public class ReviewDao {

	private Properties prop = new Properties();
	
	public ReviewDao() {
		String fileName = NoticeDao.class.getResource("/sql/review/review-mapper.xml").getPath();
		
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
			pstmt= conn.prepareStatement(sql);
			
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

	public ArrayList<Review> selectReviewList(Connection conn, PageInfo pi) {
		
		ArrayList<Review> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;

			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();

			while(rset.next()) {
				Review r = new Review(rset.getInt("REVIEW_NO"),
									  rset.getString("NICKNAME"),
									  rset.getString("SUPPORT_NO"),
									  rset.getString("REVIEW_TITLE"),
									  rset.getInt("RATE"),
									  rset.getInt("COUNT"),
									  rset.getString("REVIEW_DATE"),
									  rset.getInt("PROJECT_NO"),
									  rset.getString("PROJECT_NAME"),
									  rset.getString("PROJECT_THUMBNAIL"),
									  rset.getString("REVIEW_IMG"));
				
				list.add(r);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Support> selectUserSupportList(Connection conn, int userNo) {
		
		ArrayList<Support> sList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectUserSupportList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, userNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Support s = new Support(rset.getInt("SUPPORT_NO"),
								rset.getInt("PROJECT_NO"),
								rset.getString("SUPPORT_DATE"),
								rset.getString("PROJECT_NAME"));
				
				sList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return sList;
	}

	public int insertReview(Connection conn, Review r) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, Integer.parseInt(r.getReviewWriter()));
			pstmt.setInt(2, Integer.parseInt(r.getSupportNo()));
			pstmt.setString(3, r.getReviewTitle());
			pstmt.setString(4, r.getReviewContent());
			pstmt.setInt(5, r.getRate());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertReviewAttachment(Connection conn, ReviewAttachment rat) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReviewAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rat.getOriginName());
			pstmt.setString(2, rat.getChangeName());
			pstmt.setString(3, rat.getFilePath());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

//	public int insertReviewAttachmentList(Connection conn, ArrayList<ReviewAttachment> fileList) {
//		
//		int result = 1;
//		PreparedStatement pstmt = null;
//		
//		String sql = prop.getProperty("insertReviewAttachmentList");
//		
//		try {
//			for(ReviewAttachment rat : fileList) {
//				pstmt = conn.prepareStatement(sql);
//
//				pstmt.setString(1, rat.getOriginName());
//				pstmt.setString(2, rat.getChangeName());
//				pstmt.setString(3, rat.getFilePath());
//				
//				result *= pstmt.executeUpdate();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}

	public int increaseCount(Connection conn, int reviewNo) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Review selectReview(Connection conn, int reviewNo) {
		
		Review r = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = new Review(rset.getInt("REVIEW_NO"),
							   rset.getString("NICKNAME"),
							   rset.getString("SUPPORT_NO"),
							   rset.getString("REVIEW_TITLE"),
							   rset.getString("REVIEW_CONTENT"),
							   rset.getInt("RATE"),
							   rset.getInt("COUNT"),
							   rset.getString("REVIEW_DATE"),
							   rset.getInt("PROJECT_NO"),
							   rset.getString("PROJECT_NAME"),
							   rset.getString("PROJECT_THUMBNAIL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return r;
	}

	public ReviewAttachment selectReviewAttachment(Connection conn, int reviewNo) {
		
		ReviewAttachment rat = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				rat = new ReviewAttachment();
				rat.setFileNo(rset.getInt("FILE_NO"));
				rat.setOriginName(rset.getString("ORIGIN_NAME"));
				rat.setChangeName(rset.getString("CHANGE_NAME"));
				rat.setFilePath(rset.getString("FILE_PATH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return rat;
	}

	public int updateReview(Connection conn, Review r) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getReviewTitle());
			pstmt.setString(2, r.getReviewContent());
			pstmt.setInt(3, r.getRate());
			pstmt.setInt(4, r.getReviewNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateReviewAttachment(Connection conn, ReviewAttachment rat) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateReviewAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rat.getOriginName());
			pstmt.setString(2, rat.getChangeName());
			pstmt.setString(3, rat.getFilePath());
			pstmt.setInt(4, rat.getFileNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int insertNewReviewAttachment(Connection conn, ReviewAttachment rat) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNewReviewAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rat.getReviewNo());
			pstmt.setString(2, rat.getOriginName());
			pstmt.setString(3, rat.getChangeName());
			pstmt.setString(4, rat.getFilePath());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteReviewAttachment(Connection conn, ReviewAttachment rat) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteReviewAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rat.getFileNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return  result;
	}

	
	public int deleteReview(Connection conn, int reviewNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<Reply> selectReplyList(Connection conn, int reviewNo) {
		
		ArrayList<Reply> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Reply r = new Reply();
				r.setReplyNo(rset.getInt("REPLY_NO"));
				r.setReplyWriter(rset.getString("NICKNAME"));
				r.setReplyContent(rset.getString("REPLY_CONTENT"));
				r.setReplyDate(rset.getString("REPLY_DATE"));
				
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertReply(Connection conn, Reply rp) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rp.getReviewNo());
			pstmt.setInt(2, Integer.parseInt(rp.getReplyWriter()));
			pstmt.setString(3, rp.getReplyContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateReply(Connection conn, Reply rp) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rp.getReplyContent());
			pstmt.setInt(2, rp.getReplyNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return  result;
	}

	public int deleteReply(Connection conn, int replyNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, replyNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertReport(Connection conn, Report report) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReport");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, report.getReplyNo());
			pstmt.setInt(2, Integer.parseInt(report.getReplyReporter()));
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateReplyStatusR(Connection conn, Report report) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateReplyStatusR");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, report.getReplyNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}



}
