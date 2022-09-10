package com.kh.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.PageInfo;
import com.kh.review.model.dao.ReviewDao;
import com.kh.review.model.vo.Reply;
import com.kh.review.model.vo.Report;
import com.kh.review.model.vo.Review;
import com.kh.review.model.vo.ReviewAttachment;
import com.kh.review.model.vo.Support;

import static com.kh.common.JDBCTemplate.*;

public class ReviewService {

	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new ReviewDao().selectListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Review> selectReviewList(PageInfo pi) {

		Connection conn = getConnection();
		
		ArrayList<Review> list = new ReviewDao().selectReviewList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Support> selectUserSupportList(int userNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Support> sList = new ReviewDao().selectUserSupportList(conn, userNo);
		
		close(conn);
		
		return sList;
	}
	
	public int insertReview(Review r, ReviewAttachment rat) {
		
		Connection conn = getConnection();
		
		int result1 = new ReviewDao().insertReview(conn, r);
		
		int result2 = 1;
		if(rat != null) {
			result2 = new ReviewDao().insertReviewAttachment(conn, rat);
		}
		
		if(result1 * result2 > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return (result1 * result2);
	}

//	public int insertReview(Review r, ArrayList<ReviewAttachment> fileList) {
//		
//		Connection conn = getConnection();
//		
//		// REVIEW 테이블 INSERT
//		int result1 = new ReviewDao().insertReview(conn, r);
//		
//		// REVIEW_ATTACHMENT 테이블 INSERT
//		int result2 = 1;
//		if(!fileList.isEmpty()) { // 첨부파일 있을 경우
//			result2 = new ReviewDao().insertReviewAttachmentList(conn, fileList);
//		}
//		
//		if(result1 * result2 > 0) commit(conn);
//		else rollback(conn);
//		
//		close(conn);
//		
//		return (result1 * result2);
//	}

	public int increaseCount(int reviewNo) {
		
		Connection conn = getConnection();
		
		int result = new ReviewDao().increaseCount(conn, reviewNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public Review selectReview(int reviewNo) {
		
		Connection conn = getConnection();
		
		Review r = new ReviewDao().selectReview(conn, reviewNo);
		
		close(conn);
		
		return r;
	}

	public ReviewAttachment selectReviewAttachment(int reviewNo) {
		
		Connection conn = getConnection();
		
		ReviewAttachment rat = new ReviewDao().selectReviewAttachment(conn, reviewNo);
		
		close(conn);
		
		return rat;
	}

	public int updateReview(Review r, ReviewAttachment rat) {
		
		Connection conn = getConnection();
		
		int result1 = new ReviewDao().updateReview(conn, r);
		
		int result2 =1;
		if(rat != null) {
			// 원본파일 삭제 후 새로운 파일 첨부 안 했을 경우
			if(rat.getChangeName() == null) {
				if(rat.getFileNo() != 0) {
					result2 = new ReviewDao().deleteReviewAttachment(conn, rat);
				} else {
					result2 = new ReviewDao().insertNewReviewAttachment(conn, rat);
				}
			// 새로운 파일 첨부했을 경우
			} else {
				if(rat.getFileNo() != 0) { // 기존에 첨부파일 있었을 경우
					result2 = new ReviewDao().updateReviewAttachment(conn, rat);
				} else { // 없었을 경우
					result2 = new ReviewDao().insertNewReviewAttachment(conn, rat);
				}
			}
		}
		
		if(result1 * result2 > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return (result1 * result2);
	}

	public int deleteReview(int reviewNo) {
		
		Connection conn = getConnection();
		
		int result = new ReviewDao().deleteReview(conn, reviewNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	
	public ArrayList<Reply> selectReplyList(int reviewNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Reply> list = new ReviewDao().selectReplyList(conn, reviewNo);
		
		close(conn);
		
		return list;
	}

	
	public int insertReply(Reply rp) {
		
		Connection conn = getConnection();
		
		int result = new ReviewDao().insertReply(conn, rp);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
	

	public int updateReply(Reply rp) {

		Connection conn = getConnection();
		
		int result = new ReviewDao().updateReply(conn, rp);

		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int deleteReply(int replyNo) {
		
		Connection conn = getConnection();
		
		int result = new ReviewDao().deleteReply(conn, replyNo);

		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public int insertReport(Report report) {
		
		Connection conn = getConnection();
		
		int result1 = new ReviewDao().insertReport(conn, report);
		
		int result2 = new ReviewDao().updateReplyStatusR(conn, report);
		
		if(result1 * result2 > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return (result1 * result2);
	}


}
