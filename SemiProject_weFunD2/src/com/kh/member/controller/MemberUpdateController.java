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
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/update.me")
public class MemberUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**/
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) POST 방식 => 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		// 2) request로 부터 요청시 전달한 값 뽑기
		String userId = request.getParameter("userId");
		String nickName = request.getParameter("nickName");
		String phone = request.getParameter("phone");
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		// 3) VO 객체 담기 패스
		// 4) Service 단으로 토스
		Member updateMem = new MemberService().updateMember(userId, nickName, phone);
		
		//System.out.println(updateMem);
		// 5) 응답화면 지정
		// 성공하던 실패하던 myPage.me를 요청
		// localhost:8282/wefund/myPage.me
		
		HttpSession session = request.getSession();
		
		if(updateMem == null) {	// 정보 변경 실패
			session.setAttribute("alertMsg","회원정보 변경에 실패하였습니다.");
		} else {
			session.setAttribute("alertMsg", "회원정보 변경에 성공하였습니다.");
			session.setAttribute("loginUser", updateMem);
		}
		
		response.sendRedirect(request.getContextPath() + "/myPage.me?userNo="+userNo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
