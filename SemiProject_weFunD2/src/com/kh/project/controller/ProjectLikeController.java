package com.kh.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.project.model.service.ProjectService;
import com.kh.project.model.vo.Likes;

/**
 * Servlet implementation class ProjectLike
 */
@WebServlet("/like.pj")
public class ProjectLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectLikeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		
		
		Likes like = new Likes();
		like.setUserNo(userNo);
		like.setProjectNo(projectNo);

		int count = new ProjectService().selectLike(like);
		int result = 0;

		if(count > 0){ // 이미 누른 상태면 좋아요 지우기
		    result = new ProjectService().deleteLike(like);
		} else { // 아닐 경우 좋아요에 insert
		    result = new ProjectService().insertLike(like);
		}
		
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공!");
			response.sendRedirect(request.getContextPath()+ "/detail.pj?pno=" + projectNo);
		}else {
			request.setAttribute("errorMsg", "실패");
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
