package com.kh.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.project.model.service.ProjectService;
import com.kh.project.model.vo.Product;
import com.kh.project.model.vo.Project;
import com.kh.project.model.vo.ProjectAttachment;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ProjectInsertController
 */
@WebServlet("/insertProject.do")
public class ProjectInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 전송용량제한
			int maxSize = 1024 * 1024 * 100;
			// 저장할 서버의 물리적 경로
			String savePath = request.getServletContext().getRealPath("/resources/thumbnail_upfiles/");
			
			// MultiRequest객체생성
			MultipartRequest MultiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// 갑 뽑기
			int userNo = Integer.parseInt(MultiRequest.getParameter("userNo"));
			
			
			String projectName = MultiRequest.getParameter("projectName");
			String categoryinfo = MultiRequest.getParameter("category");

			
			String[] categoryArr = categoryinfo.split(",");
			
			int categoryNo = Integer.parseInt(categoryArr[0]);
			String categoryName = categoryArr[1];
			
			// System.out.println(Arrays.toString(categoryArr));
			
			
			/*
			System.out.println(categoryNo);
			System.out.println(categoryName);
			*/
			
			
			String Year = MultiRequest.getParameter("year");
			String Month = MultiRequest.getParameter("month");
			String Day = MultiRequest.getParameter("day");
			
			String endDay = Year +"/"+Month + "/" + Day;
			
			String goalAmount = MultiRequest.getParameter("goalAmount");
			String bank = MultiRequest.getParameter("bank");
			String accountNo = MultiRequest.getParameter("accountNo");
			String accountName = MultiRequest.getParameter("accountName");
			
			String projectContent =  MultiRequest.getParameter("content");
			
			
			String[] productNames = MultiRequest.getParameterValues("productName");
			String[] productPrices  = MultiRequest.getParameterValues("productPrice");
			
			//System.out.println(Arrays.toString(productNames));
			
			
			// [1이름, 2이름, 3이름]
			// [1원, 2원, 3원]
			
			
		
			
			/*
			String productName1 = MultiRequest.getParameter("productname1");
			String productPrice1 = MultiRequest.getParameter("productprice1");
			String productName2 = MultiRequest.getParameter("productname2");
			String productPrice2 = MultiRequest.getParameter("productprice2");
			String productName3 = MultiRequest.getParameter("productname3");
			String productPrice3 = MultiRequest.getParameter("productprice3");
			*/
			
			// VO가공
			// 프로젝트
			Project p = new Project(userNo, projectName,categoryNo, categoryName,endDay, goalAmount, bank
									,accountNo, accountName, projectContent);

			ArrayList<Product> plist = new ArrayList();
			
			for(int i = 0; i < productNames.length; i++) {
				
				Product pd = new Product();
				pd.setProductName(productNames[i]);
				pd.setProductPrice(productPrices[i]);
				
				plist.add(pd);
			}
			
			
			
			/*
			String[] productNameArr = new String[3];
			String[] productPriceArr = new String[3];
			
			
			
			productNameArr[0] = productName1;			
			productNameArr[1] = productName2;
			productNameArr[2] = productName3;
			
			productPriceArr[0] = productPrice1;
			productPriceArr[1] = productPrice2;
			productPriceArr[2] = productPrice3;
			
			
			for(int i = 0; i <= 2; i++){
				
				if(! productNameArr[i].isEmpty() ||  ! productPriceArr[i].isEmpty()) {
					
					Product pd = new Product();
					pd.setProductName(productNameArr[i]);
					pd.setProductPrice(productPriceArr[i]);
					
					plist.add(pd);
				}
				
			}

			*/
			
			
			
			
			ArrayList<ProjectAttachment> list = new ArrayList();
			
			for(int i = 1; i <= 4; i ++) {
				
				String key = "file"+ i;
				
				if(MultiRequest.getOriginalFileName(key) != null) {
					ProjectAttachment pat = new ProjectAttachment();
					pat.setOriginName(MultiRequest.getOriginalFileName(key)); //원본명
					pat.setChangeName(MultiRequest.getFilesystemName(key)); // 수정명
					pat.setFilePath("resources/thumbnail_upfiles/"); // 경로명
					
					// 파일레밸
					if(i == 1) {
						pat.setFileLevel(1);
					}else {
						pat.setFileLevel(2);
					}
					list.add(pat);
				}
			
			}
			
			// Service단으로 토스
			System.out.println(list);
			int result = new ProjectService().insertProject(p, list, plist);
			
			

			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "프로젝트 생성 성공");
				response.sendRedirect(request.getContextPath()+ "/list.pj?cpage=1");
			}else {
				request.setAttribute("errorMsg", "프로젝트 생성 실패");
				request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
			}
			
			
			
			
			
			
			
			
			
			
			
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
