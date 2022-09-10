package com.kh.myPage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.PageInfo;
import com.kh.myPage.model.dao.MyPageDao;
import com.kh.myPage.model.vo.*;


import static com.kh.common.JDBCTemplate.*;

public class MyPageService {

	public ArrayList<Project> selectMyLikeList(PageInfo pi, int userNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Project> list = new MyPageDao().selectMyLikeList(conn, pi, userNo);
		
		close(conn);
		
		return list;
	}

	public int selectLikeListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectLikeListCount(conn, userNo);
		
		close(conn);
		
		return listCount;
	}

	public int selectSupportListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectSupportListCount(conn, userNo);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Support> selectMySupportList(PageInfo pi, int userNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Support> list = new MyPageDao().selectMySupportList(conn, pi, userNo);
		
		close(conn);
		
		return list;
	}

	public int selectProjectListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectProjectListCount(conn, userNo);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Project> selectMyProjectList(PageInfo pi, int userNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Project> list = new MyPageDao().selectMyProjectList(conn, pi, userNo);
		
		close(conn);		
		
		return list;
	}

	public Project selectMyProject(int projectNo) {
		
		Connection conn = getConnection();
		
		Project pj = new MyPageDao().selectMyProject(conn, projectNo);
		
		close(conn);
		
		return pj;
	}

	public ArrayList<Product> selectMyProduct(int projectNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new MyPageDao().selectMyProduct(conn, projectNo);
		
		close(conn);
		
		return list;
	}

	public int selectMyReviewListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectMyReviewListCount(conn, userNo);
		
		close(conn);

		return listCount;
	}

	public ArrayList<Review> selectMyReviewList(PageInfo pi, int userNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Review> list = new MyPageDao().selectMyReviewList(conn, pi, userNo);
		
		close(conn);		
		
		return list;
	}



	public ArrayList<Project> selectMyFundingList(PageInfo pi, int userNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Project> list = new MyPageDao().selectMyFundingList(conn, pi, userNo);
		
		close(conn);		
		
		return list;
	}

	public ArrayList<Project> selectCompleteList(PageInfo pi, int userNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Project> list = new MyPageDao().selectCompleteList(conn, pi, userNo);
		
		close(conn);		
		
		return list;
	}

	public ArrayList<ProjectAttachment> selectMyAttachmentList(int projectNo) {
		
		Connection conn = getConnection();
		
		ArrayList<ProjectAttachment> list = new MyPageDao().selectMyAttachmentList(conn, projectNo);
		
		close(conn);		
		
		return list;
	}

	public ArrayList<Project> selectMyWaitingList(PageInfo pi, int userNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Project> list = new MyPageDao().selectMyWaitingList(conn, pi, userNo);
		
		close(conn);		
		
		return list;
	}

	public ArrayList<Project> selectMyEndingList(PageInfo pi, int userNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Project> list = new MyPageDao().selectMyEndingList(conn, pi, userNo);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Project> selectMyApprovedList(PageInfo pi, int userNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Project> list = new MyPageDao().selectMyApprovedList(conn, pi, userNo);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Project> selectMyCompanionList(PageInfo pi, int userNo) {
	
		Connection conn = getConnection();
		
		ArrayList<Project> list = new MyPageDao().selectMyCompanionList(conn, pi, userNo);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Support> selectSuccessPayment(PageInfo pi, int userNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Support> list = new MyPageDao().selectSuccessPayment(conn, pi, userNo);
		
		close(conn);	
		
		return list;
	}

	public ArrayList<Support> selectPaymentReservation(PageInfo pi, int userNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Support> list = new MyPageDao().selectPaymentReservation(conn, pi, userNo);
		
		close(conn);
		
		return list;
	}

	public ArrayList<Support> selectPaymentFailed(PageInfo pi, int userNo) {

		Connection conn = getConnection();
		
		ArrayList<Support> list = new MyPageDao().selectPaymentFailed(conn, pi, userNo);
		
		close(conn);
		
		return list;
	}

	public int updateMyProject(Project pj, ArrayList<ProjectAttachment> list) {
		
		Connection conn = getConnection();
		
		int result1 = new MyPageDao().updateMyProject(conn, pj);
		
		// project attachment
		int result2 = 1;
		
		// 새롭게 첨부된 파일이 있을경우
		if(!list.isEmpty()) {
			
			// 기존에 첨부파일이 있었을 경우
			for(int i = 0; i <list.size(); i++) {
				if(list.get(i).getFileNo() != 0) {
					result2 = new MyPageDao().updateAttachment(conn, list);
				} else {
					// 기존 첨부파일이 없었을 경우
					result2 = new MyPageDao().insertNewAttachment(conn, list);
				}
			}
		}
		
		if(result1 * result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return (result1 * result2);
	}

	public int selectProjectWaitingListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectProjectWaitingListCount(conn, userNo);
		
		close(conn);
		
		return listCount;
	}

	public int selectEndProjectListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectEndProjectListCount(conn, userNo);
		
		close(conn);
		
		return listCount;
	}

	public int selectApprovedProjectListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectApprovedProjectListCount(conn, userNo);
		
		close(conn);
		
		return listCount;
	}

	public int selectCompanionProjectListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectCompanionProjectListCount(conn, userNo);
		
		close(conn);
		
		return listCount;
		
	}

	public int selectMyFundingListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectMyFundingListCount(conn, userNo);
		
		close(conn);
		
		return listCount;
	}

	public int selectMyCompleteListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectMyCompleteListCount(conn, userNo);
		
		close(conn);
		
		return listCount;
	}

	public int selectSuccessPaymentListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectSuccessPaymentListCount(conn, userNo);
		
		close(conn);
		
		return listCount;
	}

	public int selectPaymentReservationListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectPaymentReservationListCount(conn, userNo);
		
		close(conn);
		
		return listCount;
	}

	public int selectPaymentFailedListCount(int userNo) {
		
		Connection conn = getConnection();
		
		int listCount = new MyPageDao().selectPaymentFailedListCount(conn, userNo);
		
		close(conn);
		
		return listCount;
	}
	public Support selectSupportDetail(String userId, String pno) {

        Connection conn = getConnection();

        Support s = new MyPageDao().selectSupportDetail(conn, userId, pno);

        close(conn);

        return s;
}
}
