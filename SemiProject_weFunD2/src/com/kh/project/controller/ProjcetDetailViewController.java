package com.kh.project.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.project.model.service.ProjectService;
import com.kh.project.model.vo.Product;
import com.kh.project.model.vo.Project;
import com.kh.project.model.vo.ProjectAttachment;

/**
 * Servlet implementation class ProjcetDetailViewController
 */
@WebServlet("/detail.pj")
public class ProjcetDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjcetDetailViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int projectNo = Integer.parseInt(request.getParameter("pno"));
		
		// 조회수 증가 먼저
		
		int result = new ProjectService().increaseCount(projectNo);
		
		
		
		
		if(result > 0) {
			
			Project p = new ProjectService().selectProject(projectNo);
			
			ArrayList<ProjectAttachment> palist = new ProjectService().selectProjectAttachment(projectNo);
	
			ArrayList<Product> plist = new ProjectService().selectProduct(projectNo);
			
			int totalPrice = new ProjectService().sumPayment(projectNo);

			
			request.setAttribute("p", p);
			request.setAttribute("palist", palist);
			request.setAttribute("plist", plist); 		
			request.setAttribute("totalPrice", totalPrice);
			request.getRequestDispatcher("views/project/ProjectDetailView.jsp").forward(request, response);

		}else {
			
			request.setAttribute("errorMsg", "조회된 프로젝트가 없습니다");
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
