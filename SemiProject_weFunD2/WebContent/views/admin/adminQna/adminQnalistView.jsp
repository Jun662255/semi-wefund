<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.kh.common.model.PageInfo"%>
<%@ page import="java.util.ArrayList , com.kh.admin.adminQna.model.vo.Qna"%>
<% ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
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
    <title>Q&A</title>




    
    <style>
	





    </style>
</head>
<body>

	<%@ include file="/views/common/adminMenu.jsp" %>
	<% if(loginUser!=null && loginUser.getUserId().equals("admin")) {%>
    <div id="maincontent"  >
        <p class="title">Q&A 관리
        </p>
        <hr>
        <br><br>
        <div>
            <table class="table">
                <tr>
                    <th width="150px">글 번호</th>
                    <th width="600px">글 제목</th>                    
                    <th width="150px">작성자</th>
                    <th width="200px">작성일</th>
                </tr>
                
                <% if(list.isEmpty()) { %>
                <tr>
                	<td colspan="4"> QnA가 존재하지 않습니다.</td>
                </tr>
                <% } else { %>
	                <% for( Qna q : list)  { %>
		                <tr>
		                    <td> <%= q.getQnaNo()%></td>
		                    <td>		                    
		                    	<a href="<%=contextPath%>/detail.qna?qno=<%=q.getQnaNo()%>">
		                    		<%= q.getQnaTitle() %>		                  
		                    	</a>	                    
		                    </td>                            
		                    <td> <%= q.getQnaWriter() %></td>
		                    <td> <%= q.getQnaDate().substring(0,10) %></td>
		                </tr>                    
	            	<% } %>    
	            <% } %>    	                
            </table>
    	</div>        
	</div>
        <div class="selectPage">
            
            <div >
            <% if (currentPage != 1) { %>
	            <button  onclick="location.href='<%= contextPath %>/adminlist.qna?cpage=<%= currentPage -1 %>'" class="btn  btnYellow">&lt;</button>
	        <% } %>
	            
	        <% for (int i = startPage; i <= endPage; i++) {%>
	        	    <%if (i != currentPage) { %>	        	    
	            		<button onclick="location.href='<%= contextPath %>/adminlist.qna?cpage=<%= i %>'"class="btn  btnYellow"><%= i %></button>	            		
	            	<% } else { %>
	            		<button style="background: rgb(255,240,110)"class="btn  btnYellow"><%= i %></button>	
	            	<% } %> 	            	
			<% } %>
			 			
	      	<% if(currentPage != maxPage && 0 != maxPage) { %>  
				<button  onclick="location.href='<%= contextPath %>/adminlist.qna?cpage=<%= currentPage + 1 %>'"class="btn  btnYellow">&gt;</button>
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