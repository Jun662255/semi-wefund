package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.myPage.model.service.MyPageService;

/**
 * Servlet implementation class MyPageController
 */
@WebServlet("/myPage.me")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 마이페이지 => 로그인한 사용자만 사용할수 있도록 해줌
		// 접속자의 정보는 session에 있음
		// 로그인 전 : loginUser키값에 해당 되는 벨류가 null => alert 경고
		// 로그인 후 : loginUser키값에 해당되는 벨류가 Member => 포워딩
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null) { // 로그인 하기 전 
			session.setAttribute("alertMsg", "로그인후 이용가능한 서비스 입니다");
			
			// 메인페이지로 보내기 => /wefund => sendRedirect
			response.sendRedirect(request.getContextPath());
		} else {
			
			int userNo = Integer.parseInt(request.getParameter("userNo"));
			//System.out.println(userNo);
			int likesCount = new MyPageService().selectLikeListCount(userNo);
			int supportCount = new MyPageService().selectSupportListCount(userNo);
			int projectCount = new MyPageService().selectProjectListCount(userNo);
			
			//System.out.println(likesCount);
			//System.out.println(supportCount);
			//System.out.println(projectCount);
			
			request.setAttribute("likesCount", likesCount);
			request.setAttribute("supportCount", supportCount);
			request.setAttribute("projectCount", projectCount);
			
			
			request.getRequestDispatcher("views/member/myPage.jsp").forward(request, response);
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
