package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/deleteMember.me")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) POST => 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 현재 로그인한 회원정보를 얻기
		// 1. session 영역에 담겨있는 회원 객체로 부터 뽑기
		// 2. 요청시 아이디 숨겨서 보내낸거 가져오기
		
		HttpSession session = request.getSession();
		String userId = ((Member)session.getAttribute("loginUser")).getUserId();
		
		// 3) VO 패스
		// 4) Service 단으로 토스
		int result = new MemberService().deletMember(userId);
		
		// 
		if(result > 0) {	//탈퇴 성공
			// 로그아웃 시키고 메인페이지로 보내버리기
			session.removeAttribute("loginUser");
			session.setAttribute("alertMsg", "회원탈퇴가 완료되었습니다");
			
			response.sendRedirect(request.getContextPath());
		} else {	// 탈퇴 성공
			request.setAttribute("errorMsg", "회원탈퇴에 실패했습니다");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
