<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.kh.common.model.PageInfo"%>
<%@ page import="java.util.ArrayList , com.kh.admin.adminReview.model.vo.Review"%>
<% ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("list");
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
    <title>게시판관리 - 리뷰</title>


	<%@ include file="/views/common/adminMenu.jsp" %>

    
    <style>

    </style>
</head>
<body>
	<% if(loginUser!=null && loginUser.getUserId().equals("admin")) {%>
    <div id="maincontent" >
        <p class="title">게시판관리 - 리뷰
        </p>
        <hr>
        <br>
        <div>
            <table class= "table">
                <tr>
                    <th width="80px">글 번호</th>
                    <th width="510px">글 제목</th>                    
                    <th width="100px">후원번호</th>
                    <th width="100px">작성자</th>
                    <th width="80px">별점</th>
                    <th width="80px">조회수</th>
                    <th width="150px">작성일</th>
                </tr>
                
                <% if(list.isEmpty()) { %>
                <tr>
                	<td colspan="7"> 리뷰가 존재하지 않습니다.</td>
                </tr>
                <% } else { %>
	                <% for( Review r : list)  { %>
		                <tr>
		                    <td> <%= r.getReviewNo()%></td>
		                    <td>		                    
		                    	<a href="<%=contextPath%>/detail.rv?rno=<%=r.getReviewNo()%>">
		                    		<%= r.getReviewTitle() %>		                  
		                    	</a>	                    
		                    </td>
		                    <td> <%= r.getSupportNo() %></td>
                            <td> <%= r.getNickName() %></td>
                            <td> <%= r.getRate()%></td>
		                    <td> <%= r.getCount()%></td>
		                    <td> <%= r.getReviewDate().substring(0,10) %></td>
		                </tr>                    
	            	<% } %>    
	            <% } %>    
	                
            </table>
        </div>
        
        </div>
        <div class="selectPage">

            <div>
            <% if (currentPage != 1) { %>
	            <button  onclick="location.href='<%= contextPath %>/adminlist.re?cpage=<%= currentPage -1 %>'" class="btn  btnYellow">&lt;</button>
	        <% } %>
	            
	        <% for (int i = startPage; i <= endPage; i++) {%>
	        	    <%if (i != currentPage) { %>	        	    
	            		<button onclick="location.href='<%= contextPath %>/adminlist.re?cpage=<%= i %>'"class="btn  btnYellow"><%= i %></button>	            		
	            	<% } else { %>
	            		<button style="background: rgb(255,240,110)"class="btn  btnYellow"><%= i %></button>	
	            	<% } %> 	            	
			<% } %>
			 			
	      	<% if(currentPage != maxPage && 0 != maxPage) { %>  
				<button  onclick="location.href='<%= contextPath %>/adminlist.re?cpage=<%= currentPage + 1 %>'"class="btn  btnYellow">&gt;</button>
			<% } %>    
            </div>
   	<% } else { %>
	<% } %>
    </div>
    <br clear="both">
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>