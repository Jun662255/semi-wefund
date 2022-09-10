package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.*;
import java.sql.Connection;
import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {

	public Member loginMember(String userId, String userPwd) {
		
		// Connection 객체 생성
		Connection conn = getConnection();
		
		// MemberDao()로 넘기기
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
	
		// Connection 객체 닫기
		close(conn);
		
		// Controller로 결과 넘기기
		return m;
	}

	public int signUp(Member m) {
		// Connection 객체 생성
		Connection conn = getConnection();
		
		// MemberDao()로 넘기기
		int result = new MemberDao().signUp(conn, m);
		// 성공1 실패0
		
		// 트랜잭션 처리
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		// Connection 객체 닫기
		close(conn);
				
		// Controller로 결과 넘기기
		return result;
		
	}
	
	public int idCheck(String userId) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().idCheck(conn, userId);
		
		close(conn);
		
		return result;
		
	}

	public int nicknameCheck(String nickname) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().nicknameCheck(conn, nickname);
		
		close(conn);
		
		return result;
	}

	public String findUserId(String userName, String phone) {
		
		Connection conn = getConnection();
		
		String userId = new MemberDao().findUserId(conn, userName, phone);
		
		close(conn);
		
		return userId;
	}

	public String findUserPwd(String userId) {
		
		Connection conn = getConnection();
		
		String result = new MemberDao().findUserPwd(conn, userId);
		
		close(conn);
		
		return result;
	}

	public int setUserPwd(String userId, String userPwd1) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().setUserPwd(conn, userId, userPwd1);
		
		close(conn);
		
		return result;
	}
public Member updateMember(String userId, String nickName, String phone) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMember(conn, userId, nickName, phone);
		
		// 호출 결과에 따라서 성공이면 commit후 새로바뀐 회원정보 다시 받아오기
		Member updateMem = null;
		
		if(result > 0) {
			commit(conn);
			// 갱신된 회원 객체 다시 조회
			updateMem = new MemberDao().selectMember(conn, userId);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return updateMem;
	}
public int nickNameCheck(String checkNick) {
	
	Connection conn = getConnection();
	
	int count = new MemberDao().nickNameCheck(conn, checkNick);
	
	close(conn);
	
	return count;
}
public int deletMember(String userId) {
	
	Connection conn = getConnection();
	
	int result = new MemberDao().deleteMember(conn, userId);
	
	if(result > 0) {
		commit(conn);
	} else {
		rollback(conn);
	}
	close(conn);
	
	return result;
}
public Member updatePwdMember(String userId, String userPwd, String updatePwd) {
	
	Connection conn= getConnection();
	
	int result = new MemberDao().updatePwdMember(conn, userId, userPwd, updatePwd);
	
	// 호출 결과에 따라서 성공이면 commit 후  새로바뀐 회원정보를 다시 받아오기
	Member updateMem = null;
	
	if(result > 0) {	// 비밀번호 변경 성공
		commit(conn);
		// 갱신된 회원 객체 다시 조회
		updateMem = new MemberDao().selectMember(conn, userId);
	} else {	// 비밀번호 변경 실패
		rollback(conn);
	}
	
	return updateMem;
}


	

	
}
