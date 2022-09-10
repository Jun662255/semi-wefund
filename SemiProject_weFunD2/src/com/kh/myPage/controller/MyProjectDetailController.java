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
 * Servlet implementation class MyProjectDetailController
 */
@WebServlet("/myProjectDetial.me")
public class MyProjectDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyProjectDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 프로젝트 넘버 가지고 오기
		int projectNo = Integer.parseInt(request.getParameter("pjno"));
		
		// Service 단으로 토스
		Project pj = new MyPageService().selectMyProject(projectNo);
		ArrayList<Product> list = new MyPageService().selectMyProduct(projectNo);
		ArrayList<ProjectAttachment> atList = new MyPageService().selectMyAttachmentList(projectNo);
		
		// request에 담기
		request.setAttribute("pj", pj);
		request.setAttribute("list", list);
		request.setAttribute("atList", atList);
		
		/*
		for(ProjectAttachment at : atList) {
			System.out.println(at.getFilePath());
			System.out.println(at.getChangeName());
		}
		*/
		
		// 응답 화면
		request.getRequestDispatcher("views/myPage/myProjectDetailView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
