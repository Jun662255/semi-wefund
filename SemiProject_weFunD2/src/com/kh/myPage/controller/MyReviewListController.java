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
 * Servlet implementation class MyReviewListController
 */
@WebServlet("/myReviewListView.me")
public class MyReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReviewListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 값 뽑기
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		// 페이징 처리
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new MyPageService().selectMyReviewListCount(userNo);
		
		currentPage = Integer.parseInt(request.getParameter("rvpage"));
		
		pageLimit = 5;
		boardLimit = 5;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		endPage = startPage + pageLimit - 1;
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// vo 가공
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit,
									boardLimit, maxPage, startPage, endPage);
		
		// Service 단으로 토스
		ArrayList<Review> list = new MyPageService().selectMyReviewList(pi, userNo);
		
		// request 에 담기
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		/*
		for(Review rv : list) {
			System.out.println(rv);
		}
		*/
		
		// 응답 화면
		request.getRequestDispatcher("views/myPage/myReviewListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
