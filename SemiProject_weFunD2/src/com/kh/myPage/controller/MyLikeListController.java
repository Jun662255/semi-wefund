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
 * Servlet implementation class MyLikeListController
 */
@WebServlet("/myLikeListView.me")
public class MyLikeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyLikeListController() {
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
		// 필요한 변수들
		int listCount;		// 현재 나의관심프로젝트의 총 갯수 
		int currentPage;	// 현재 사용자가 요청한 페이지
		int pageLimit;		// 페이지 하단에 보여질 페이징 바의 최대갯수 => 5개로 고정
		int boardLimit;		// 한페이지에 보여질 리스트의 최대 갯수 => 4개로 고정
		
		int maxPage;		// 가장 마지막 페이지가 몇번째 페이지 인지
		int startPage;		// 페이지 하단에 보여질 페이징 바의 시작수
		int endPage;		// 페이지 하단에 보여질 페이징바의 끝수
		
		// * listCount: 총 게시글 갯수
		if(select.equals("전체")) { // 전체
			listCount = new MyPageService().selectLikeListCount(userNo);
			
		} else if(select.equals("펀딩진행중")) {
			listCount = new MyPageService().selectMyFundingListCount(userNo);
			
		} else { // 펀딩 완료
			listCount = new MyPageService().selectMyCompleteListCount(userNo);
		}
		
		
		// * currentPage: 현재 페이지
		currentPage = Integer.parseInt(request.getParameter("pjpage"));
		
		// * pageLimit: 페이징바의 페이지의 최대 갯수
		pageLimit = 5;
		
		// * boardLimit: 한페이지에 보여질 게시글의 최대 갯수
		boardLimit = 4;
		
		// * maxPage: 총 페이지 갯수
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		// * startPage: 페이지 하단에 보여질 시작수
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1; 
		
		// * endPage: 페이장 바의 끝수
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		
		// 4) VO 가공
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit,
									boardLimit, maxPage, startPage, endPage);
		
		//System.out.println(pi);
		
		// 5) Service 단으로 토스
		// 화면 띄우기전 => 테이블로 부터 조회해야함
		// select 조건에 따라서 조회결과가 다름
		// 조회 결과 하도 없거나 여러개 => ArrayList
		ArrayList<Project> list = new ArrayList<>();
		
		if(select.equals("전체")) { // 전체
			list = new MyPageService().selectMyLikeList(pi, userNo);
			
		} else if(select.equals("펀딩진행중")) {
			list = new MyPageService().selectMyFundingList(pi, userNo);
			
		} else { // 펀딩 완료
			list = new MyPageService().selectCompleteList(pi, userNo);
		} 
		
		// 6) 값 담기
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.setAttribute("select", select);
		
		// 7) 응답 화면
		request.getRequestDispatcher("views/myPage/myLikeListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
