package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class AjaxNickCheckController
 */
@WebServlet("/nickCheck.me")
public class AjaxNickCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxNickCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) get => 인코딩 X
		// 2) 값 뽑기
		String checkNick = request.getParameter("checkNick");
		
		// 3) VO 가공 패스
		// 4) Service 단으로 토스
		// 중복 확인은 SELECT문이지만 정보 필요없어서 숫자로 받음
		int count = new MemberService().nickNameCheck(checkNick);
		
		// 5) 응답화면
		
		// 형식, 인코딩 지정
		response.setContentType("text/html; charset=UTF-8");
		
		//response.getWriter().print(count);
		
		//System.out.println(count);
		
		// 중복값이 있을때 "NNNNN" count == 1
		// 중복값이 없을때 "NNNNY" count == 0
		if(count > 0) {	// 존재하는 닉네임이 있을 경우 
			response.getWriter().print("NNNNN");
		} else {
			response.getWriter().print("NNNNY");
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
