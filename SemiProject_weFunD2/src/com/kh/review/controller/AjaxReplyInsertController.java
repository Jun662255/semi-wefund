package com.kh.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.review.model.service.ReviewService;
import com.kh.review.model.vo.Reply;

/**
 * Servlet implementation class AjaxReplyInsertController
 */
@WebServlet("/rinsert.rv")
public class AjaxReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int reviewNo = Integer.parseInt(request.getParameter("rno"));
		String replyContent = request.getParameter("replyContent");
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		Reply rp = new Reply();
		rp.setReviewNo(reviewNo);
		rp.setReplyContent(replyContent);
		rp.setReplyWriter(String.valueOf(userNo));
		
		int result = new ReviewService().insertReply(rp);
		
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
