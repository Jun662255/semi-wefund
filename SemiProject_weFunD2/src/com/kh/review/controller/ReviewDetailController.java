package com.kh.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.review.model.service.ReviewService;
import com.kh.review.model.vo.Review;
import com.kh.review.model.vo.ReviewAttachment;

/**
 * Servlet implementation class ReviewDetailController
 */
@WebServlet("/detail.rv")
public class ReviewDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int reviewNo = Integer.parseInt(request.getParameter("rno"));

		// 조회수 증가
		int result = new ReviewService().increaseCount(reviewNo);
		
		if(result > 0) {
			// 리뷰글 조회
			Review r = new ReviewService().selectReview(reviewNo);
			// 리뷰글 안의 첨부파일 조회
			ReviewAttachment rat = new ReviewService().selectReviewAttachment(reviewNo);

			request.setAttribute("r", r);
			request.setAttribute("rat", rat);
			request.getRequestDispatcher("views/review/reviewDetailView.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "없는 리뷰글입니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
