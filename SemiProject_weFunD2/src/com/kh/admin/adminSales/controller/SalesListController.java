package com.kh.admin.adminSales.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.admin.adminSales.model.service.SalesService;
import com.kh.admin.adminSales.model.vo.Sales;

/**
 * Servlet implementation class SalesListController
 */
@WebServlet("/adminlist.sa")
public class SalesListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalesListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
		LocalDate now = LocalDate.now();      
		int intMonth = now.getMonthValue();
		int intYear = now.getYear();
		String month = String.valueOf(intMonth);
		String year = String.valueOf(intYear).substring(2,4);;

		
		if(month.length() != 2) {
			month ="0"+month; 
		}

		
		ArrayList<Sales> list1 = new SalesService().monthlyCategorySalesList(month,year); 
		ArrayList<Sales> list2 = new SalesService().monthlySales(month, year);

		request.setAttribute("year", year);
		request.setAttribute("month", month);
		request.setAttribute("list1", list1);
		request.setAttribute("list2", list2);

		request.getRequestDispatcher("views/admin/adminSales/adminSalesListView.jsp").forward(request,response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
