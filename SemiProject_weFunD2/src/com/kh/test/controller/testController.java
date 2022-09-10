package com.kh.test.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testController
 */
@WebServlet("/join")
public class testController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); // 문자 인코딩 처리



		String memberId = request.getParameter("memberId");

		String memberPw = request.getParameter("memberPw");

		String memberName = request.getParameter("memberName");

		 

		Member member= new Member(memberId,memberPw,memberName);

		 

		 

		int result = new MemberService().insertMember(member);




		String msg = "";

		if(result > 0) {

		msg = "회원가입 성공";

		}else {

		msg = "회원가입 실패";

		}

		 

		request.setAttribute("msg", msg);



		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/joinResult.jsp");

		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
