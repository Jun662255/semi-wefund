package com.kh.category.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.category.model.service.CategoryListService;
import com.kh.category.model.vo.Category;

/**
 * Servlet implementation class CategoryListController
 */
@WebServlet("/categoryList.ca")
public class CategoryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 카테고리 번호 가져오기
		String categoryNo = request.getParameter("categoryNo");
		

		// 테이블에서 조회
		// 조회 결과가 여러개 -> ArrayList
		ArrayList<Category> list = new CategoryListService().selectTechList(categoryNo);
		
		//request에 list 담기
		request.setAttribute("list", list);
		


		// 응답 뷰 지정
		request.getRequestDispatcher("views/category/CategoryListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
