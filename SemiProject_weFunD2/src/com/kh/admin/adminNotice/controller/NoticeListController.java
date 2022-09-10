package com.kh.admin.adminNotice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.PageInfo;
import com.kh.admin.adminNotice.model.service.NoticeService;
import com.kh.admin.adminNotice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListController
 */
@WebServlet("/list.no")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 페이징 처리
		// 필요변수
		int listCount;
		int currentPage;
		int pageLimit;			
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new NoticeService().selectCountNotice();
		
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		

		pageLimit = 5;
		
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		

		
		startPage = (currentPage -1 ) / pageLimit * pageLimit +1;
		
		endPage = startPage + pageLimit -1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit,
									maxPage, startPage, endPage);
		
		ArrayList<Notice> list = new NoticeService().selectList(pi);

		request.setAttribute("list", list);
		request.setAttribute("pi", pi);
		
		request.getRequestDispatcher("/views/admin/adminNotice/noticelistView.jsp").forward(request, response);
		
		
		
		//ArrayList<Notice> list = new NoticeService().selectNoticeList();
		
		//request.setAttribute("list", list);
		
		//request.getRequestDispatcher("/views/notice/noticelistView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
