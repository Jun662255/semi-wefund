package com.kh.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.review.model.service.ReviewService;
import com.kh.review.model.vo.Report;

/**
 * Servlet implementation class AjaxReplyReportController
 */
@WebServlet("/rreport.rv")
public class AjaxReplyReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int replyNo = Integer.parseInt(request.getParameter("reportReplyNo"));
		int replyReporter = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		Report report = new Report();
		report.setReplyNo(replyNo);
		report.setReplyReporter(String.valueOf(replyReporter));
		
		int result = new ReviewService().insertReport(report);
		
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().print(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
