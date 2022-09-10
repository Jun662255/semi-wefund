package com.kh.project.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.PageInfo;
import com.kh.project.model.service.ProjectService;
import com.kh.project.model.vo.Project;

/**
 * Servlet implementation class ProjectSearchListContoller
 */
@WebServlet("/search.pj")
public class ProjectSearchListContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectSearchListContoller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	
		String keyword = request.getParameter("keyword");
		
	

		ArrayList<Project> list = new ProjectService().projectSearchList(keyword);
		
		
		if(list.isEmpty()) {

			request.setAttribute("errorMsg", "조회된 검색결과가 없습니다.");		
		}
			request.setAttribute("keyword", keyword);
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/project/ProjectSearchListView.jsp").forward(request, response); 
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
