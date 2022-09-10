package com.kh.admin.adminMember.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminMember.model.service.MemberService;

/**
 * Servlet implementation class MemberSuspensionController
 */
@WebServlet("/suspension.mem")
public class MemberSuspensionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSuspensionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String nickname = request.getParameter("nickname");
		String replyNo = request.getParameter("replyNo");
		int result = new MemberService().suspensionMember(nickname,replyNo);
		

		
		request.getSession().setAttribute("alert", "회원 정지 완료");
		response.sendRedirect(request.getContextPath()+"/adminRepolist.mem?cpage=1");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
