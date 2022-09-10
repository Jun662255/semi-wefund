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
 * Servlet implementation class MySupportListController
 */
@WebServlet("/mySupportListView.me")
public class MySupportListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySupportListController() {
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
		
		// 3) ---- 페이징 처리 ----
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;
		
		if(select.equals("전체")) {
			listCount = new MyPageService().selectSupportListCount(userNo);
			
		} else if(select.contentEquals("결제완료")) {
			listCount = new MyPageService().selectSuccessPaymentListCount(userNo);
			
		} else if(select.contentEquals("결제예약")) {
			listCount = new MyPageService().selectPaymentReservationListCount(userNo);
		} else { 	// 펀딩실패
			listCount = new MyPageService().selectPaymentFailedListCount(userNo);
		}
		
		currentPage = Integer.parseInt(request.getParameter("spage"));
		
		pageLimit = 5;
		boardLimit = 4;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		startPage = (currentPage - 1) / pageLimit * pageLimit +1;
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 4) VO가공
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit,
									boardLimit, maxPage, startPage, endPage);	
		
		// 5) Service 단으로 토스
		// 조회 결과 여러개
		ArrayList<Support> list = new ArrayList<>();
		
		if(select.equals("전체")) {
			list = new MyPageService().selectMySupportList(pi, userNo);
			
		} else if(select.contentEquals("결제완료")) {
			list = new MyPageService().selectSuccessPayment(pi, userNo);
			
		} else if(select.contentEquals("결제예약")) {
			list = new MyPageService().selectPaymentReservation(pi, userNo);
		} else { 	// 펀딩실패
			list = new MyPageService().selectPaymentFailed(pi, userNo);
		}
		
		// 6) request에 담기
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		request.setAttribute("select", select);
		
		// 7) 응답화면		
		request.getRequestDispatcher("views/myPage/mySupportListView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
