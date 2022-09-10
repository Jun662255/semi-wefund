package com.kh.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.project.model.service.ProjectService;

/**
 * Servlet implementation class ProjectAllowController
 */
@WebServlet("/allow.pj")
public class ProjectAllowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectAllowController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));

		int result = new ProjectService().allowProject(projectNo);
		

		if(result > 0){
			request.getSession().setAttribute("alertMsg", "프로젝트 승인 성공!");
			response.sendRedirect(request.getContextPath()+ "/list.pj?cpage=1");
		}else {
			request.setAttribute("errorMsg", "프로젝트 승인 실패");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
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
