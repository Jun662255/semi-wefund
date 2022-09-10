package com.kh.myPage.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.myPage.model.service.MyPageService;
import com.kh.myPage.model.vo.*;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MyProjectUpdateController
 */
@WebServlet("/myProjectUpdate.me")
public class MyProjectUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyProjectUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) POST => 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 파일 전송여부
		// multipart/form-data
		if(ServletFileUpload.isMultipartContent(request)) {
			
			//파일 업로드 => 2가지 설정
			// 1. 전송파일 용량제한
			int maxSize = 1024*1024*10;
			
			// 2. 전달된 파일을 저장시킬 물리적 경로
			String savePath = request.getSession().getServletContext().getRealPath("/resources/upfiles/");
			
			// 전달된 파일명 수정 후 서버에 업로드
			// multiRequest
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize,
																 "UTF-8", new MyFileRenamePolicy());
			// 값뽑기
			// update project
			int projectNo = Integer.parseInt(multiRequest.getParameter("pjno"));
			String projectName = multiRequest.getParameter("projectName");
			String projectContent = multiRequest.getParameter("projectContent");
			
			//System.out.println(projectNo);
			//System.out.println(projectName);
			//System.out.println(projectContent);
			
			// vo 가공 - project
			Project pj = new Project();
			pj.setProjectNo(projectNo);
			pj.setProjectName(projectName);
			pj.setProjectContent(projectContent);
			
			// project-attachment
			// 여러객체를 묶어서 다룸
			ArrayList<ProjectAttachment> list = new ArrayList<>();
			
			// 키값 : reUpfile1~4
			for(int i = 0; i <= 3; i++) {
				
				String key = "reUpfile" + i;
				String fileNo = "originFileNo" + i; 
				String fileName = "originFileName" + i;
				String filelevel = "originFileLevel"+ i;
				
				// 첨부된 파일이 있는지 확인 
				if(multiRequest.getOriginalFileName(key) != null) {
					
					// 첨부된 파일이 있으면 새로운 파일 객체생성후 리스트에 담기
					ProjectAttachment at = new ProjectAttachment();
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath("resources/upfiles/");
					
					//System.out.println("업파일: " + key);
					
					if(key.equals("reUpfile0") || filelevel.equals("originFileLevel0")) {
						at.setFileLevel(1);
					} else {
						at.setFileLevel(2);
					}
					//System.out.println("컨드롤러 파일레벨 : " + at.getFilelevel());
					list.add(at);
					
					// 첨부파일 + 원본파일 있을경우 
						if(multiRequest.getParameter(fileNo) != null) {
							// 기존파일이 존재한다
							// 기존파일에 대한 파일번호 담기
							at.setFileNo(Integer.parseInt(multiRequest.getParameter(fileNo)));
							
							//System.out.println(Integer.parseInt(multiRequest.getParameter(fileNo)));
							
							//System.out.println(list.get(0).getFileNo());
							
							//System.out.println(fileNo);
							
							// 기존에 서버에 존재하는 파일 삭제
							new File(savePath + multiRequest.getParameter(fileName)).delete();
						} else {
							// 새로운 첨부파일은 있지만 기존에 파일이 없는경우
							// 어느프로젝트에 첨부해야하는지 번호 지정
							at.setProjectNo(projectNo);
						}
				}
			}
			
			// Service 단으로 토스
			// 경우의수
			// 1) 새로운 첨부파일 X => pj, list.isEmpty() => project update
			// 2) 새로운 첨부파일 O, 기존파일 O => project, attachment update
			// 3) 새로운 청부파일 O, 기존파일 X => project update, attachment insert
			
			int result = new MyPageService().updateMyProject(pj, list);
			
			// 결과에 따른 응답 뷰 지정
			if(result > 0) {	// 성공
				request.setAttribute("alertMsg", "프로젝트 수정성공");
				response.sendRedirect(request.getContextPath()+"/myProjectDetial.me?pjno="+projectNo);
			
			} else {
				request.setAttribute("errorMsg", "프로젝트 수정실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
