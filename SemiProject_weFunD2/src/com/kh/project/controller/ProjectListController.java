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
 * Servlet implementation class ProjectListController
 */
@WebServlet("/list.pj")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		// 쿼리스트링으로 요청 /wefund/list.pj?cpage = 1 => GET방식 인코딩X

        // 1) request로부터 값 뽑기

        // ----------- 페이징 처리 -------------
        // 필요한 변수들
        int projectListCount; // 현재 일반게시판의 게시글 총 갯수 => project로 부터 조회 COUNT()활용(STATUS = 'Y')
        int currentPage; // 현제 페이지 (즉, 사용자가 요청한 페이지) => request.getParameter("cpage");
        int pageLimit; // 페이지 하단에 보여질 페이징바의 최대 갯수 =? 5개로 고정
        int projectLimit; // 한 페이지에 보여질 게시글의 최대 갯수 => 12개로 고정

        int maxPage; // 가장 마지막 페이지가 몇번 페이지 인지(총 페이지의 갯수)
        int startPage; // 페이지 하단에 보여질 페이징바의 시작 
        int endPage; // 페지이 하단에 보여질 페이징바의 끝 수

        // projectistCount : 총 게시글 갯수
        projectListCount = new ProjectService().selectProjectListCount();

        
        
        
        // * currentPage : 현재 페이지 (사용자가 요청한 페이지)
        currentPage = Integer.parseInt(request.getParameter("cpage"));

        // * pageLimit : 페이징바의 페이지 최대 갯수
        pageLimit = 5;

        // * boardLimit : 한 페이지에 보여질 게시글의 최대 갯수
        projectLimit = 12;

        // * maxPage : 가장 마지막 페이지가 몇 번 페이지인지
/*
         * listCount, boardLimit에 영향을 받음
         * 
         * - 공식 구하기
         *   단, boardLimit이 12이라는 가정하에 규칙을 찾아보자!
         *
         *   총 갯수(listCount)        projectLimit(10개)            maxPage(마지막페이지)
         *   100 개              	 /        12개                  		    =    8.33    9번페이지 
         *   101 개               	 /     	  12개                   			=    8.41    
         *   105 개                	 /        12개                   		    =    8.75     
         *   109 개             	 /        12개                    			=    9.08    10번페이지
         *   111 개              	 /        12개                     			=    9.25    
         *   119 개			 /		  12개					=    9.91
         *   120 개                      /	      12개    					=    12.00 	 12번페이지
         * => 나눗셈결과 (listCount / boardLimit)을 올림처리 할 경우 maxPage가 된다.
         * 
         * 
         * 
         * 
         * 스텝
         * 1) projectlistCount를 double로 형변환
         * 2) listCount / projectLimit
         * 3) Math.ceil() => 결과를 올림 처리
         * 4)
         * 
         * 
         * 
         */
        maxPage = (int)Math.ceil((double)projectListCount/ projectLimit);

   

        // startPage : 페이지 하단에 보여질 페이징바의 시작 수
        /*
         * pageLimit, currentPage에 영향을 받음
         * 
         * - 공식 구하기
         *      단, pageLimit 10이라는 가정하에 규칙을 구해보자
         * 
         * startPage : 1, 6, 11, 16, 21 .... => n * 5 + 1 => 5의 배수 + 1
         * 
         * 만약에 pageLimit이 5라면 : 1, 6, 11, 16 ... => n * 5 + 1 = 5의배수 + 1
         * 
         * 즉, startPage = n * pageLimit + 1
         * 
         * currentPage                startPagee
         *         1                        1
         *         5                        1
         *         6                        6
         *         10                       6
         *         11                       11
         *         21                       2
         * 
         * 
         * => 1 ~ 10 : n * 10 + 1 => n = 0
         * => 11 ~ 20 : n * 10 + 1 => n = 1
         * => 21 ~ 30 : n * 10 + 1 => n = 2
         * ....
         * 
         * 1 ~ 10 / 10 => n = 0 / 1
         * 11 ~ 20 / 10 => n = 1 / 2
         * 21 ~ 30 / 10 => n = 2 / 3    1씩 모자르네...
         * 
         * n을 구하는 공식을 도출해 보자
         * 
         * 0 ~ 4 / 5 = 0
         * 5 ~ 9 / 5 = 1
         * 10 ~ 14 /10 = 2
         * 
         * n = (currentPage - 1) / pageLimit
         *                                 n * pageLimiti + 1
         * startPage = (currentPate - 1) / pageLimit* pageLimit + 1 
         */
        startPage = (currentPage - 1) / pageLimit + 1;


        // * endPage : 페이지 하단의 보여질 페이징 바의 끝 수
        /*
         * startPage, pageLimit에 옇향을 받음(단,  maxPage도 마지막 페이징 바에 대해선 영향을 준다
         * 
         * 공식 구하기
         * 단, pageLimit이 5이라는 가정
         * 
         * startPage :  1 => endPage : 5
         * startPage : 11 => endPage : 15
         * startPage : 21 => endPage : 25
         * ....
         * 
         * => endPage = startPage + pageLimit - 1;
         * 
         */
         endPage = startPage + pageLimit - 1;

         // startPage가 11이어서 endPage에는 20이 들어갔는데
         // maxPage가 13이라면???
         // => endPage값을 maxPage값으로 변경
         if(endPage > maxPage) {
             endPage = maxPage;
         }

         // 여기까지 총 7개의 변수를 만들었음!
         // 7개의 변수를 가지고 해당되는 범위에 따른 게시글 10개씩만 SELECT
         // Service단으로토스 => 7개나 있다 => VO 클래스에 만들어서 가공해서 넘기자

         PageInfo pi = new PageInfo(projectListCount, currentPage, pageLimit, projectLimit,
                                         maxPage, startPage, endPage);
		
         ArrayList<Project> list = new ProjectService().selectProjectList(pi);
         
       
        request.setAttribute("list", list);
        request.setAttribute("pi", pi);
        
		request.getRequestDispatcher("views/project/ProjectListView.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
