<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.common.model.PageInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.admin.adminProject.model.vo.Project" %>
<% ArrayList<Project> list = (ArrayList<Project>)request.getAttribute("list");
   PageInfo pi = (PageInfo)request.getAttribute("pi");
   String type = (String)request.getAttribute("type");
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();	
%>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>프로젝트 관리</title>


    <style>
		#Status{
			float: right;
			font-size: 20px;
			color: black;
			font-weight: bold;
			}
	#Status a{color: black;}
	#Status a:hover{color: gray;}
	
    </style>
</head>
<body>
	<%@ include file="/views/common/adminMenu.jsp" %>
	<% if(loginUser!=null && loginUser.getUserId().equals("admin")) {%>
    <div id="maincontent">
        <p class="title">프로젝트 - 상태</p>     
        <hr>
        <br>
        <div id="Status">
	        <a href="<%= contextPath %>/adminlist.pj?cpage=1&type=all">전체</a>
	        <a href="<%= contextPath %>/adminlist.pj?cpage=1&type=Y">승인</a>
	        <a href="<%= contextPath %>/adminlist.pj?cpage=1&type=N">대기</a>
	        <a href="<%= contextPath %>/adminlist.pj?cpage=1&type=X">반려</a>
	        <a href="<%= contextPath %>/adminlist.pj?cpage=1&type=E">마감</a>
        </div>
        <div>
            <table class="table">
                <tr>
                    <th width="150px">프로젝트 번호</th>
                    <th width="600px">프로젝트 명</th>               
                    <th width="150px">신청자</th>
                    <th width="200px">신청일</th>
                </tr>
                <%if(list.isEmpty()) { %>
	                <tr>
	                	<td colspan="4"> 신청프로젝트가 존재하지 않습니다.</td>
	                </tr>
                <% } else { %>
                	<% for(Project p :list) { %>
		                <tr>
		                    <td><%= p.getProjectNo() %></td>
		                    <td><a href="<%= contextPath %>/detail.pj?pno=<%=p.getProjectNo()%>"><%= p.getProjectName() %></a></td>
		                    <td><%= p.getProjectCreator() %></td>
		                    <td><%= p.getApplyDate().substring(0,10) %></td>
		                </tr>    
                	<% } %>
                <% } %>
            </table>
        </div>      
	</div>
    <div class="selectPage">

   		<div>
			<% if (currentPage != 1) { %>
        			<button  onclick="location.href='<%= contextPath %>/adminlist.pj?cpage=<%= currentPage -1 %>&type=<%= type %>'" class="btn  btnYellow">&lt;</button>
    			<% } %>        
    			<% for (int i = startPage; i <= endPage; i++) {%>
    	    		<%if (i != currentPage) { %>	        	    
        				<button onclick="location.href='<%= contextPath %>/adminlist.pj?cpage=<%= i %>&type=<%= type %>'"class="btn  btnYellow"><%= i %></button>	            		
        			<% } else { %>
        				<button style="background: rgb(255,240,110)" class="btn  btnYellow"><%= i %></button>	
       			<% } %> 	            	
			<% } %>			
   			<% if(currentPage != maxPage && 0 != maxPage) { %>  
				<button  onclick="location.href='<%= contextPath %>/adminlist.pj?cpage=<%= currentPage + 1 %>&type=<%= type %>'" class="btn  btnYellow">&gt;</button>
			<% } %>    
   		</div>
   	<% } else { %>
	<% } %>
    </div>
    <br clear="both">
	<%@ include file="/views/common/footer.jsp"%>

</body>
</html>