package com.kh.review.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.review.model.service.ReviewService;
import com.kh.review.model.vo.Review;
import com.kh.review.model.vo.ReviewAttachment;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ReviewInsertController
 */
@WebServlet("/insert.rv")
public class ReviewInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertController() {
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
			
			HttpSession session = request.getSession();
			ServletContext application = session.getServletContext();
			
			// 1_2. 저장할 서버의 물리적 경로 제시
			String savePath = request.getServletContext().getRealPath("/resources/review_upfiles/");
			
			// 2. MultipartRequest 객체 생성(*** 파일명 수정해서 올리기)
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// 2) multiRequest로부터 값 뽑기 => getParameter 메소드 이용
			String reviewWriter = multiRequest.getParameter("userNo");
			String supportNo = multiRequest.getParameter("supportNo");
			String reviewTitle = multiRequest.getParameter("reviewTitle");
			String reviewContent = multiRequest.getParameter("reviewContent");
			int rate = Integer.parseInt(multiRequest.getParameter("rate"));
			
			// 3) VO로 가공
			Review r = new Review(reviewWriter, supportNo, reviewTitle, reviewContent, rate);
			
			ReviewAttachment rat = null;
			
			if(multiRequest.getOriginalFileName("file1") != null) {
				
				// 첨부파일이 있다 => VO 객체로 가공
				rat = new ReviewAttachment();
				
				rat.setOriginName(multiRequest.getOriginalFileName("file1")); // 원본명
				
				// 수정파일명
				// multiRequest.getFilesystemName("키값");
				rat.setChangeName(multiRequest.getFilesystemName("file1"));
				
				// 파일경로
				rat.setFilePath("resources/review_upfiles/");
			}
			
			// 4) Service단으로 토스
			int result = new ReviewService().insertReview(r, rat);
			
			// 5) 결과에 따른 응답뷰 지정
			if(result > 0) { //성공
				request.getSession().setAttribute("alertMsg", "리뷰글이 작성되었습니다.");
				response.sendRedirect(request.getContextPath() + "/list.rv?cpage=1");
				
			} else { // 실패
				
				// 첨부파일이 있었는데 실패했다면 이미 업로드된 첨부파일을 굳이 서버에 보관할 필요는 없다(용량만 차지)
				if(rat != null) {
					new File(savePath + rat.getChangeName()).delete();
				}
				
				request.setAttribute("errorMsg", "리뷰글 작성 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
			
			
//			// 여러 개의 첨부파일 존재 가능
//			ArrayList<ReviewAttachment> fileList = new ArrayList<>();
//			
//			if(multiRequest.getOriginalFileName("file1") != null) {
//				// 키값 : file1
//				for(int i = 1; i < 3; i++) {
//					
//					// 키값만 미리 변수로 세팅
//					String key = "file" + i;
//					
//					// 원본파일명이 존재하는지 메소드를 이용해서 파악 => 조건
//					if(multiRequest.getOriginalFileName(key) != null) { // 원본 파일이 조낻한다
//						
//						// 첨부파일이 존재한다면 ReviewAttachment객체 생성
//						// 필드 : 원본명, 수정명, 폴더경로
//						ReviewAttachment rat = new ReviewAttachment();
//						rat.setOriginName(multiRequest.getOriginalFileName(key)); // 원본명
//						rat.setChangeName(multiRequest.getFilesystemName(key)); // 수정명
//						rat.setFilePath("resources/review_upfiles/"); // 경로명
//						
//						fileList.add(rat);
//						
//					}
//				}
//				
//			}
			

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
