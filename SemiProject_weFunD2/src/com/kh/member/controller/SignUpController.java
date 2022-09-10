package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("/signUp.me")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 값 뽑기
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");
		
		// Member 객체에 담기
		Member m = new Member(userId, userPwd, userName, nickname, phone);
		
		// 서비스로 넘기기
		int result = new MemberService().signUp(m);
		
		// 응답페이지 지정
		if(result > 0) { // 성공
			request.getRequestDispatcher("views/member/signUpSuccess.jsp").forward(request, response);
		}else { // 실패
			request.getRequestDispatcher("views/member/signUp.jsp").forward(request, response);
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
