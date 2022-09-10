package com.kh.admin.adminMember.model.service;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.adminMember.model.dao.adminMemberDao;
import com.kh.member.model.vo.Member;
import com.kh.admin.adminMember.model.vo.Report;
import com.kh.common.model.PageInfo;
public class MemberService {

	public int listCountMember() {
		
		Connection conn = getConnection();
					
		int listCount = new adminMemberDao().listCountMember(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Member> selectListMember(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Member> list = new adminMemberDao().selectListMember(conn,pi);
		
		close(conn);
		
		return list;
	}

	public int withdrawalListCountMember() {
		Connection conn = getConnection();
		
		int listCount = new adminMemberDao().withdrawalListCountMember(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Member> withdrawalSelectListMember(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Member> list = new adminMemberDao().withdrawalselectListMember(conn,pi);
		
		close(conn);
		
		return list;
	}

	public int restorationMember(String userNo) {
		
		Connection conn = getConnection();
		int result = new adminMemberDao().restorationMember(conn,userNo);
		
		if(result > 0)commit(conn);
		else rollback(conn);
		
		close(conn);
		return result;
	}

	public int listCountReportMember() {
		Connection conn = getConnection();
		
		int listCount = new adminMemberDao().listCountReportMember(conn);
		
		close(conn);
		
		return listCount;
	}



	public ArrayList<Report> selectListReportMember(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Report> list = new adminMemberDao().selectListReportMember(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int suspensionMember(String nickname,String replyNo) {
		Connection conn = getConnection();
		
		int result1 = new adminMemberDao().suspensionMember(conn, nickname);
				
		int result2 = new adminMemberDao().replystatusN(conn, replyNo);
		
		if(result1 *result2 > 0) commit(conn);
		else rollback(conn);
		
		
		close(conn);
		
		return result1 *result2;
	}

	
	public int checkMember(String replyNo) {
		Connection conn = getConnection();
		
		int result = new adminMemberDao().checkMember(conn, replyNo);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}
}
