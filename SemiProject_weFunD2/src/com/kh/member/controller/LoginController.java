package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.me")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		
		// MemberService()로 넘기기
		Member loginUser = new MemberService().loginMember(userId, userPwd);
		
		//System.out.println(loginUser);
		
		// 처리된 결과를 가지고 보게될 응답화면 지정
		
		if(loginUser == null) { // 로그인 실패
			
			request.setAttribute("errorMsg", "로그인 실패");
			
			// 다시 로그인창으로
			request.getRequestDispatcher("views/member/login.jsp").forward(request, response);
			
		}else { // 로그인 성공
			
			//System.out.println("성공");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", loginUser);
			
			// alert창 띄우기
			session.setAttribute("alertMsg", "로그인 성공");
			// session으로 보내는게 아니라 request로 보내야함
			
			response.sendRedirect(request.getContextPath());
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
