package com.kh.admin.adminProject.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminProject.model.service.ProjectService;
import com.kh.admin.adminProject.model.vo.Project;
import com.kh.common.model.PageInfo;

/**
 * Servlet implementation class ProjectListController
 */
@WebServlet("/adminlist.pj")
public class ProjectListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjectListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int listCountAll = new ProjectService().listCountAll();
		int listCountY = new ProjectService().listCountY();
		int listCountN = new ProjectService().listCountN();
		int listCountE = new ProjectService().listCountE();
		int listCountX = new ProjectService().listCountX();

		int currentPage = Integer.parseInt(request.getParameter("cpage"));

		String type = request.getParameter("type");


		int pageLimit = 5;
		int boardLimit = 10;

		int maxPageAll = (int) Math.ceil((double) listCountAll / boardLimit);
		int maxPageY = (int) Math.ceil((double) listCountY / boardLimit);
		int maxPageN = (int) Math.ceil((double) listCountN / boardLimit);
		int maxPageE = (int) Math.ceil((double) listCountE / boardLimit);
		int maxPageX = (int) Math.ceil((double) listCountX / boardLimit);

		int startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		int endpage = startPage + pageLimit - 1;

		if (type.equals("all") &&endpage > maxPageAll)endpage = maxPageAll;
		if (type.equals("Y") &endpage > maxPageY)endpage = maxPageY;
		if (type.equals("N") &endpage > maxPageN)endpage = maxPageN;
		if (type.equals("E") &endpage > maxPageE)endpage = maxPageE;
		if (type.equals("X") &endpage > maxPageX)endpage = maxPageX;
		

		PageInfo piAll = new PageInfo(listCountAll, currentPage, pageLimit, boardLimit, maxPageAll, startPage, endpage);
		PageInfo piY = new PageInfo(listCountY, currentPage, pageLimit, boardLimit, maxPageY, startPage, endpage);
		PageInfo piN = new PageInfo(listCountN, currentPage, pageLimit, boardLimit, maxPageN, startPage, endpage);
		PageInfo piE = new PageInfo(listCountE, currentPage, pageLimit, boardLimit, maxPageE, startPage, endpage);
		PageInfo piX = new PageInfo(listCountX, currentPage, pageLimit, boardLimit, maxPageX, startPage, endpage);

		ArrayList<Project> listAll = new ProjectService().selectAllListProject(piAll);
		ArrayList<Project> listY = new ProjectService().selectYListProject(piY);
		ArrayList<Project> listN = new ProjectService().selectNListProject(piN);
		ArrayList<Project> listE = new ProjectService().selectEListProject(piE);
		ArrayList<Project> listX = new ProjectService().selectXListProject(piX);
		
		
		if (type.equals("all")) {
			request.setAttribute("pi", piAll);
			request.setAttribute("list", listAll);
		} else if (type.equals("Y")) {
			request.setAttribute("pi", piY);
			request.setAttribute("list", listY);

		} else if (type.equals("N")) {
			request.setAttribute("pi", piN);
			request.setAttribute("list", listN);

		} else if (type.equals("E")) {
			request.setAttribute("pi", piE);
			request.setAttribute("list", listE);

		} else {
			request.setAttribute("pi", piX);
			request.setAttribute("list", listX);
		}
		request.setAttribute("type" , type);
		request.getRequestDispatcher("/views/admin/adminProject/adminProjectListView.jsp").forward(request, response);

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
