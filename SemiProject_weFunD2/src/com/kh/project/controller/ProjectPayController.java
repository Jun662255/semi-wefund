package com.kh.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.project.model.service.ProjectService;
import com.kh.project.model.vo.Support;

/**
 * Servlet implementation class ProjectPayController
 */
@WebServlet("/pay.pj")
public class ProjectPayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectPayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		
		// 값 뽑기
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int projectNo = Integer.parseInt(request.getParameter("projectNo"));
		String productNames = request.getParameter("productNames");
		int payment = Integer.parseInt(request.getParameter("totalPayment"));
		
		String orderName = request.getParameter("orderName");
		String orderEmail = request.getParameter("orderEmail");
		
		if(orderEmail == null) {
			orderEmail = " ";
		}
	
		String orderPhone = request.getParameter("orderPhone");
		String receiverName = request.getParameter("receiverName");
		String receiverPhone = request.getParameter("receiverPhone");
		String requests = request.getParameter("requests");
		
		if(requests == null) {
			requests = " ";	
		}
	
		
		String addressNo = request.getParameter("addressNo");
		String addressDetail = request.getParameter("address");
		
		String address = "우편번호 : " + addressNo + " 상세주소 : " + addressDetail;
		
		
		// VO로 가공
		Support sup = new Support(userNo, projectNo, orderName,orderPhone,orderEmail,
								receiverName, receiverPhone, address,
								requests, productNames,payment);
		
		int result = new ProjectService().insertSupprot(sup);
		
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "펀딩성공!");
  
			response.sendRedirect(request.getContextPath());
		
		}else {
			request.setAttribute("errorMsg", "펀딩실패");
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
