package com.kh.admin.adminMember.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminMember.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.common.model.PageInfo;

/**
 * Servlet implementation class WithdrawalMemberListController
 */
@WebServlet("/adminWRlist.mem")
public class WithdrawalMemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawalMemberListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		int listCount = new MemberService().withdrawalListCountMember();
		int currentPage = Integer.parseInt(request.getParameter("cpage"));
		int pageLimit = 5;
		int boardLimit = 20;
		int maxPage = (int)Math.ceil((double)listCount / boardLimit);
		int startPage = (currentPage -1 ) /pageLimit * pageLimit +1;
		int endpage = startPage + pageLimit -1;
		if(endpage > maxPage) {
			endpage = maxPage;
		}
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endpage);
		
		ArrayList<Member> list = new MemberService().withdrawalSelectListMember(pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/views/admin/adminMember/adminMemberWithdrawalRestorationListView.jsp").forward(request, response);
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
