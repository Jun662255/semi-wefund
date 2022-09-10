package com.kh.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProjectPayFormController
 */
@WebServlet("/payform.pj")
public class ProjectPayFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectPayFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));

		String[]productInfoArr = request.getParameterValues("productInfo");
		
		String[][] product = new String[productInfoArr.length][2];
		
		int payment = 0;
		String productNames = "";
		
		for(int i = 0; i < product.length; i++) {
			
			String pdArr[]  = productInfoArr[i].split(",");
			product[i][0] = pdArr[0]; 
			product[i][1] = pdArr[1];

			if(i == product.length-1) {
				productNames += product[i][0];		
			}else {
				productNames += (product[i][0]+",");
			}
			 payment += Integer.parseInt(product[i][1]);
			 
		}
		
		//System.out.println(productNames);
		//System.out.println(payment);

	
		request.setAttribute("userNo", userNo);
		request.setAttribute("projectNo", projectNo);
		request.setAttribute("productNames", productNames);
		request.setAttribute("payment", payment);
		request.getRequestDispatcher("views/project/PaymentForm.jsp").forward(request, response);
								
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
