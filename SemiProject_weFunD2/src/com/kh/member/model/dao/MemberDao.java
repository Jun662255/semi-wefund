package com.kh.member.model.dao;

import static com.kh.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.member.model.vo.Member;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		// mapper 파일 가져오기
		
		String file = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member loginMember(Connection conn, String userId, String userPwd) {
		
		// SELECT문
		
		// 필요한 변수
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginMember");
		
		
		try {
			// pstmt 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// ? 채우기
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			// 실행 후 결과 받기
			rset = pstmt.executeQuery();
			
			// 컬럼값 뽑아서 Member 객체에 담기
			if(rset.next()) {
				m = new Member(
						rset.getInt("USER_NO"),
						rset.getString("USER_ID"),
						rset.getString("USER_PWD"),
						rset.getString("USER_NAME"),
						rset.getString("NICKNAME"),
						rset.getString("PHONE"),
						rset.getDate("ENROLL_DATE"),
						rset.getDate("MODIFY_DATE"),
						rset.getString("STATUS")
					);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}

	public int signUp(Connection conn, Member m) {
		
		// INSERT문
		
		// 필요한 변수
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("signUp");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getNickname());
			pstmt.setString(5, m.getPhone());
			
			//System.out.println(m);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public int idCheck(Connection conn, String userId) {
		
		// SELECT문
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			 
			//System.out.println(userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) { // 결과가 있다면
				result = 0; // 이미 존재하는 아이디
			}else if(userId.equals("")) {
				result = 2; // 값이 없는 경우
			}else {
				result = 1; // 사용가능한 아이디
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int nicknameCheck(Connection conn, String nickname) {
		
		// SELECT문
		
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("nicknameCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nickname);
			
			System.out.println(nickname);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = 0; // 이미 존재하는 닉네임
			}else if(nickname.equals("")) {
				result = 2; // 값이 없는 경우
			}else {
				result = 1; // 사용 가능한 닉네임
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public String findUserId(Connection conn, String userName, String phone) {
		
		// SELECT 문
		
		String userId = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findUserId");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userName);
			pstmt.setString(2, phone);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				userId = rset.getString("USER_ID");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return userId;
	}

	public String findUserPwd(Connection conn, String userId) {
		
		String result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("findUserPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				// 아이디가 존재하는 경우
				result = userId;
			}else {
				result = null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int setUserPwd(Connection conn, String userId, String userPwd1) {
		
		// UPDATE문 -> 처리된 행의 개수 반환
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("setUserPwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userPwd1);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
public int updateMember(Connection conn, String userId, String nickName, String phone) {
		
		// UPDATE문 => 처리된 행의 갯수
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		// UPDATE MEMBER SET NICKNAME =?, PHONE = ?, MODIFY_DATE = SYSDATE WHERE USER_ID = ? AND STATUS = 'Y'
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nickName);
			pstmt.setString(2, phone);
			pstmt.setString(3, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
public Member selectMember(Connection conn, String userId) {
	
	// SELECT문 => ResultSet => 결과 한행 => Member객체로 반환
	
	Member m = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	String sql = prop.getProperty("selectMember");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, userId);
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			m = new Member(rset.getInt("USER_NO"),
						   rset.getString("USER_ID"),
						   rset.getString("USER_PWD"),
						   rset.getString("USER_NAME"),
						   rset.getString("NICKNAME"),
						   rset.getString("PHONE"),
						   rset.getDate("ENROLL_DATE"),
						   rset.getDate("MODIFY_DATE"),
						   rset.getString("STATUS"));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	
	return m;
}
public int nickNameCheck(Connection conn, String checkNick) {
	
	// SELECT문 => ResetSet => count 함수 이용 (숫자 한개)
	int count = 0;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	String sql = prop.getProperty("nickNameCheck");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, checkNick);
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			count = rset.getInt("COUNT(*)");
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	
	return count;
}
public int deleteMember(Connection conn, String userId) {
	
	// UPDATE => int
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("deleteMember");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, userId);
		
		result = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	
	return result;
}
public int updatePwdMember(Connection conn, String userId, String userPwd, String updatePwd) {
	
	//UPDATE => int
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("updatePwdMember");
	
	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, updatePwd);
		pstmt.setString(2, userPwd);
		pstmt.setString(3, userId);
		
		result = pstmt.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(pstmt);
	}

	return result;
}

}
