package com.kh.myPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.myPage.model.service.MyPageService;
import com.kh.myPage.model.vo.*;

/**
 * Servlet implementation class MyProjectUpdateFormController
 */
@WebServlet("/myProjectUpdateForm.me")
public class MyProjectUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyProjectUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 값 뽑기(project 번호)
		int projectNo = Integer.parseInt(request.getParameter("pjno"));
		
		// 해당 프로젝트 번호에 해당되는 PROJECT, PRODUCT, PROJECT_ATTACHEMT 행 조회
		Project pj = new MyPageService().selectMyProject(projectNo);
		ArrayList<Product> list = new MyPageService().selectMyProduct(projectNo);
		ArrayList<ProjectAttachment> atList = new MyPageService().selectMyAttachmentList(projectNo);
		
		// 값 담기
		request.setAttribute("pj", pj);
		request.setAttribute("list", list);
		request.setAttribute("atList", atList);
		
		// 응답 화면으로 보여주기
		request.getRequestDispatcher("views/myPage/myProjectUpdateForm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
