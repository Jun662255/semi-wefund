<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.common.model.PageInfo,
 				com.kh.member.model.vo.Member,
  				java.util.ArrayList,
  				java.text.SimpleDateFormat"%>    
<%
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
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
    <title>회원관리 - 조회</title>


    <style>
        #maincontent{
            width: 64%;
            float: right;
            margin-right: 5%;
        }
        #maincontent div{text-align: center;}
        .title{font-size: xx-large;}


    </style>
</head>
<body>
	<%@ include file="/views/common/adminMenu.jsp" %>
		<% if(loginUser!=null && loginUser.getUserId().equals("admin")) {%>
    <div id="maincontent">
        <p class="title">회원관리 - 조회
        </p>
        <hr>
        <br><br>
        <div>
            <table id="QnATable" width="100%" class="table">

	                <tr><!-- 1000px -->
	                    <th width="100px">회원번호</th>
	                    <th width="170px">아이디</th>
	                    <th width="150px">회원명</th>
	                    <th width="170px">닉네임</th>
	                    <th width="170px">휴대폰번호</th>
	                    <th width="170px">회원가입일</th>
	                    <th width="170px">회원정보변경일</th>  			
	                </tr>

                
                <% if(list.isEmpty()){ %>
	                <tr>
	                   <td colspan="7">회원정보가 존재하지 않습니다.</td>
	                </tr>
                <% } else { %>
                	<% for(Member m : list) { %>
	                	<tr>
		                    <td><%= m.getUserNo() %></td>
		                    <td><%= m.getUserId() %></td>
		                    <td><%= m.getUserName() %></td>
		                    <td><%= m.getNickname() %></td>
		                    <td><%= m.getPhone() %></td>
		                     
							<% 	
								String enrollDate = "";
								String modifyDate = "";
							
							   	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
							   	enrollDate = format.format(m.getEnrollDate()); 
							   	modifyDate = format.format(m.getModifyDate());  
							%>
							
		                    <td><%= enrollDate %></td>
		                    <td><%= modifyDate %></td>
		            	</tr>         
               		<% } %>	    
                <% } %>
            </table>
        </div>
    </div>
    <div class="selectPage">
   
        <div style=" height: 40px;">
            <% if(currentPage != 1) { %>
                    	<button  onclick="location.href='<%= contextPath %>/adminlist.mem?cpage=<%= currentPage -1 %>'" class="btn  btnYellow">&lt;</button>
                    <% } %>
                    
                	<% for(int i = startPage; i <= endPage; i++) { %>
	                	<% if(i != currentPage) { %>
	                    	<button onclick="location.href='<%= contextPath %>/adminlist.mem?cpage=<%= i %>'"class="btn  btnYellow"><%= i %></button>
						<% } else { %>
						  	<button style="background: rgb(255,240,110);"class="btn btnYellow"><%= i %></button>
						<% } %>
					<% } %> 
					
					<% if(currentPage != maxPage && 0 != maxPage) { %>  
						<button  onclick="location.href='<%= contextPath %>/adminlist.mem?cpage=<%= currentPage + 1 %>'"class="btn  btnYellow">&gt;</button>
					<% } %>        
        </div>
    	<% } else { %>
    	<% } %>
    </div>
        <br clear="both">
    	<%@ include file="/views/common/footer.jsp"%>
</body>
	
</html>