<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.kh.common.model.PageInfo"%>
<%@ page import="java.util.ArrayList , com.kh.admin.adminProject.model.vo.Project"%>
<% ArrayList<Project> list = (ArrayList<Project>)request.getAttribute("list");
   PageInfo pi = (PageInfo)request.getAttribute("pi");
   
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();	
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>프로젝트관리</title>

    <style>
	

    </style>
</head>
<body>

	<%@ include file="/views/common/adminMenu.jsp" %>
	<% if(loginUser!=null && loginUser.getUserId().equals("admin")) {%>
    <div id="maincontent"  >
        <p class="title">프로젝트 - 구매내역
        </p>
        <hr>
        <br><br>
        <div>
            <table class="table">
                <tr>
                    <th width="150px">프로젝트 번호</th>
                    <th width="600px">제목 </th>                    
                    <th width="150px">작성자</th>
                    <th width="200px">마감일</th>
                </tr>
                
                <% if(list.isEmpty()) { %>
                <tr>
                	<td colspan="4"> 구매내역이 존재하지 않습니다</td>
                </tr>
                <% } else { %>
	                <% for( Project p : list)  { %>
		                <tr>
		                    <td> <%= p.getProjectNo()%></td>
		                    <td>		                    
		                    	<a href="<%= contextPath%>/adminListDetail.sup?pno=<%= p.getProjectNo()%>">
		                    		<%= p.getProjectName() %>		                  
		                    	</a>	                    
		                    </td>                            
		                    <td> <%= p.getProjectCreator() %></td>
		                    <td> <%= p.getEndDate().substring(0,10) %></td>
		                </tr>                    
	            	<% } %>    
	            <% } %>    	                
            </table>
    	</div>        
	</div>
        <div class="selectPage">
            
            <div >
            <% if (currentPage != 1) { %>
	            <button  onclick="location.href='<%= contextPath %>/adminlist.sup?cpage=<%= currentPage -1 %>'" class="btn  btnYellow">&lt;</button>
	        <% } %>
	            
	        <% for (int i = startPage; i <= endPage; i++) {%>
	        	    <%if (i != currentPage) { %>	        	    
	            		<button onclick="location.href='<%= contextPath %>/adminlist.sup?cpage=<%= i %>'"class="btn  btnYellow"><%= i %></button>	            		
	            	<% } else { %>
	            		<button style="background: rgb(255,240,110)"class="btn  btnYellow"><%= i %></button>	
	            	<% } %> 	            	
			<% } %>
			 			
	      	<% if(currentPage != maxPage && 0 != maxPage) { %>  
				<button  onclick="location.href='<%= contextPath %>/adminlist.sup?cpage=<%= currentPage + 1 %>'"class="btn  btnYellow">&gt;</button>
			<% } %>    
            </div>
        </div>
   	<% } else { %>
	<% } %>
    </div>
    <br clear="both">
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>