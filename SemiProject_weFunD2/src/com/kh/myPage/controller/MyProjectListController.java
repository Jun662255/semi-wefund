package com.kh.myPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.PageInfo;
import com.kh.myPage.model.service.MyPageService;
import com.kh.myPage.model.vo.*;

/**
 * Servlet implementation class MyProjectListController
 */
@WebServlet("/myProjectListView.me")
public class MyProjectListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyProjectListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 인코딩 X
		// 2) 값뽑기
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		String select = request.getParameter("select");
		
		//System.out.println(select);
		
		// 3) ---- 페이징 처리 ----
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;
		
		// listCount 관련해서 나눔
		if(select.equals("전체")) { // 전체
			listCount = new MyPageService().selectProjectListCount(userNo);
	
		} else if(select.equals("대기중")) {   //대기중
			listCount = new MyPageService().selectProjectWaitingListCount(userNo);
			
		} else if(select.equals("마감")) {   //마감
			listCount = new MyPageService().selectEndProjectListCount(userNo);
			
		} else if(select.equals("승인")) {	//승인
			listCount = new MyPageService().selectApprovedProjectListCount(userNo);
			
		} else {	// 반려
			listCount = new MyPageService().selectCompanionProjectListCount(userNo);
		}
		
		currentPage = Integer.parseInt(request.getParameter("mppage"));
		
		pageLimit = 5;
		boardLimit = 4;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage -1)/ pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// VO가공
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit,
									boardLimit, maxPage, startPage, endPage);
		
		// 5) Service 로 토스
		ArrayList<Project> list = new ArrayList<>();
		
		if(select.equals("전체")) { // 전체
			list = new MyPageService().selectMyProjectList(pi, userNo);
			
		} else if(select.equals("대기중")) {   //대기중
			list = new MyPageService().selectMyWaitingList(pi, userNo);
			
		} else if(select.equals("마감")) {   //마감
			list = new MyPageService().selectMyEndingList(pi, userNo);
			
		} else if(select.equals("승인")) {	//승인
			list = new MyPageService().selectMyApprovedList(pi, userNo);
			
		} else {	// 반려
			list = new MyPageService().selectMyCompanionList(pi, userNo);	
		}
		
		// 값 담기
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.setAttribute("select", select);
		
		// 7) 응답화면
		request.getRequestDispatcher("views/myPage/myProjectListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
