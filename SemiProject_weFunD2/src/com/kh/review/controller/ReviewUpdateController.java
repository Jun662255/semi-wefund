package com.kh.review.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.review.model.service.ReviewService;
import com.kh.review.model.vo.Review;
import com.kh.review.model.vo.ReviewAttachment;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ReviewUpdateController
 */
@WebServlet("/update.rv")
public class ReviewUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 단계 전체 "첨부파일" => multipart/form-data => 조건제시 => 곧바로 서버로 파일이 올라옴
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 1_1. 전송 용량 제한(10Mbyte)
			int maxSize = 1024 * 1024 * 10;
			
			// 1_2. 저장할 서버의 물리적 경로 제시
			String savePath = request.getServletContext().getRealPath("/resources/review_upfiles/");
			
			// 2. MultipartRequest 객체 생성(*** 파일명 수정해서 올리기)
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// 2) multiRequest로부터 값 뽑기 => getParameter 메소드 이용
			int reviewNo = Integer.parseInt(multiRequest.getParameter("rno"));
			String reviewTitle = multiRequest.getParameter("reviewTitle");
			String reviewContent = multiRequest.getParameter("reviewContent");
			int rate = Integer.parseInt(multiRequest.getParameter("rate"));
			String checkDeleteOrigin = multiRequest.getParameter("checkDeleteOrigin");
			
			// 3) VO로 가공
			Review r = new Review();
			r.setReviewNo(reviewNo);
			r.setReviewTitle(reviewTitle);
			r.setReviewContent(reviewContent);
			r.setRate(rate);
			
			ReviewAttachment rat = null;
			
			// 새로 첨부한 사진 있을 경우
			if(multiRequest.getOriginalFileName("reUpfile1") != null) {
				
				// 새로운 파일명이 존재한다면 객체 생성 후 원본이름, 수정된이름, 파일경로
				rat = new ReviewAttachment();
				rat.setOriginName(multiRequest.getOriginalFileName("reUpfile1"));
				rat.setChangeName(multiRequest.getFilesystemName("reUpfile1"));
				rat.setFilePath("resources/review_upfiles/");
				// => 여기까지는 새롭게 업로드한 새로운 첨부파일에 대한 내용
				
				// 첨부파일이 있을 경우 + 원본파일도 있을 경우
				if(multiRequest.getParameter("originFileNo") != null) {
					// 기존 파일이 존재했다
					// 기존파일에 대한 파일번호 rat에 담을 것(WHERE)
					rat.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
					
					// 기존에 서버에 존재하던 첨부파일 삭제
					new File(savePath+multiRequest.getParameter("originFileName")).delete();
				} else {
					// 새로운 첨부파일이 넘어왔지만 기존파일이 없을 경우 => INSERT
					// + 어느 게시글의 첨부파일인지 boardNo (REF_BNO)
					rat.setReviewNo(reviewNo);
				}
				
			// 새로 첨부한 사진 없을 경우
			} else {
				if(checkDeleteOrigin.equals("deleteOrigin")) { // 원본파일 삭제했을 경우 (파일 삭제 클릭했을 경우, 원본 있든 없든 클릭 가능함)
					rat = new ReviewAttachment();
					
					if(multiRequest.getParameter("originFileNo") != null) { // 기존에 원본파일이 있었을 경우
						rat.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
					} else { // 기존에 원본파일 없었을 경우
						rat.setReviewNo(reviewNo);
					}
				}
			}
		
			
			// 4) Service단으로 토스
			int result = new ReviewService().updateReview(r, rat);
			
			// 5) 결과에 따른 응답뷰 지정
			if(result > 0) { //성공
				request.getSession().setAttribute("alertMsg", "리뷰글이 수정되었습니다.");
				response.sendRedirect(request.getContextPath() + "/detail.rv?rno=" + reviewNo);
				
			} else { // 실패
				
				// 첨부파일이 있었는데 실패했다면 이미 업로드된 첨부파일을 굳이 서버에 보관할 필요는 없다(용량만 차지)
				// delete()호출 => 삭제시키고자 하는 파일 객체 생성
				if(rat != null) new File(savePath + rat.getChangeName()).delete();
				
				request.setAttribute("errorMsg", "리뷰글 작성 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
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
