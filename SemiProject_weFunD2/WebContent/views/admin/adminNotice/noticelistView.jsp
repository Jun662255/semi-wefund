<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.common.model.PageInfo"%>
<%@page import="com.kh.admin.adminNotice.model.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
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
    <title>게시판관리 - 공지</title>


    <style>

        #createNotice{float: right;}

    </style>
</head>
<body>

	<%@ include file="/views/common/adminMenu.jsp" %>
	
	<% if(loginUser!=null && loginUser.getUserId().equals("admin")) {%>
    <div id="maincontent">
        <p class="title">게시판관리 - 공지
        </p>
        <hr>
        <br><br>
        <div>
            <table class="table">
                <tr>
                    <th width="100px">글 번호</th>
                    <th width="500px">글 제목</th>                    
                    <th width="150px">작성자</th>
                    <th width="150px">조회수</th>
                    <th width="200px">작성일</th>
                </tr>
                <tr>
                <% if(list.isEmpty()){ %>
	                <tr>
	                   <td colspan="5">공지사항이 존재하지 않습니다.</td>
	                </tr>
                <% } else { %>
                	<% for(Notice n : list) { %>
	                	<tr>
	                    	<td><%= n.getNoticeNo() %></td>
		                    <td><a href="<%=contextPath%>/detail.no?nno=<%=n.getNoticeNo()%>"><%= n.getNoticeTitle() %></a></td>
		                    <td><%= n.getNoticeWriter() %></td>
		                    <td><%= n.getCount() %></td>
		                    <td><%= n.getNoticeDate() %></td>
	                	</tr>    
	                <% } %>
                <% } %>  
            </table>
            <a href="<%= contextPath %>/enrollForm.no" id="createNotice" class="btn  btnYellow">글작성</a>
        </div>    
 

        </div>
        <div class="selectPage">
			<div>
				<% if(currentPage != 1) { %>
			<button  onclick="location.href='<%= contextPath %>/list.no?cpage=<%= currentPage -1 %>'" class="btn  btnYellow">&lt;</button>
			<% } %>
			
			<% for(int i = startPage; i <= endPage; i++) { %>
			<% if(i != currentPage) { %>
				<button onclick="location.href='<%= contextPath %>/list.no?cpage=<%= i %>'"class="btn  btnYellow"><%= i %></button>
			<% } else { %>
				<button style="background: rgb(255,240,110)"class="btn  btnYellow"><%= i %></button>
			<% } %>
			<% } %> 
			
			<% if(currentPage != maxPage && 0 != maxPage) { %>  
				<button  onclick="location.href='<%= contextPath %>/list.no?cpage=<%= currentPage + 1 %>'"class="btn  btnYellow">&gt;</button>
			<% } %>                	                  
			</div>
   	<% } else { %>
	<% } %>
    </div>
    <br clear="both">
	<%@ include file="/views/common/footer.jsp"%>
                
                
                 
                <script>
                	$(function() {
                		$("#maincontent>table>tr").clik(function() {
                			
                			var nno = $(this).children().eq(0).text();
                			
                			 location.href="<%= contextPath%>/detail.no?nno=" + nno;							
						})						
					})
                </script>   
          
                
                
                
                
   </body>
</html>