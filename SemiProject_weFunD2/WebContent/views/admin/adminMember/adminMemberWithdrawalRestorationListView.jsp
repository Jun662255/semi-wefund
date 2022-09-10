<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.common.model.PageInfo, com.kh.member.model.vo.Member, java.util.ArrayList,java.text.SimpleDateFormat"%>
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
    <title>회원관리 - 탈퇴회원/복구</title>

 
    <style>

    </style>
</head>
<body>
   <%@ include file="/views/common/adminMenu.jsp" %>
   <% if(loginUser!=null && loginUser.getUserId().equals("admin")) {%>
    <div id="maincontent">
        <p class="title">회원관리 - 탈퇴회원/복구</p>
        <hr>
        <br><br>
        <div>
            <table class="table">
                <tr> 
                    
                    <th width="100px">회원번호</th>
                    <th width="130px">아이디</th>
                    <th width="130px">회원명</th>
                    <th width="140px">닉네임</th>
                    <th width="140px">휴대폰번호</th>
                    <th width="150px">회원가입일</th>
                    <th width="150px">회원탈퇴일</th>  	
                    <th width="160px">회원 복구</th>  	
                </tr>
                <tr>
                <% if(list.isEmpty()) { %>
                	<tr>
                		<td colspan="8">탈퇴회원이 존재하지 않습니다.</td>
                	</tr>
                	<% } else { %>
                		<% for (Member m : list) { %>
                		
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
			                    <td>
			                    	<button class="btn-modal btn btn-dark" data-toggle="modal" data-target="#myModal"  data-id="<%=m.getUserNo()%>" > 회원복구  </button> 
			                  	</td>
               				</tr>
					 <% } %>
 				<% } %>   				     
            </table>
        </div>    
    </div>  
    <!-- The Modal -->
    <div class="modal" id="myModal">
        <div class="modal-dialog">
        <div class="modal-content">                    
            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title" text-align="center"> <br>해당 회원을 복구 하겠습니까?<br></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>                
            <!-- Modal footer -->
            <div class="modal-footer">
            	<form action="<%= contextPath %>/restoration.mem" method="post">                   
            	<input type="hidden" class="body-contents" id="userNo" name="userNo">
                	<button type="submit" class="btn btn-danger">복구</button>            
                </form>   
                <button type="button" class="btn btn-danger"  data-dismiss="modal">확인</button>
            </div>                      
        </div>
        </div>
	</div>     

<script>

	$(".btn-modal").click(function(){
		var data = $(this).data('id');
    	$("#userNo").val(data);
	});
  </script>

    
    <div class="selectPage">

        <div>
           <% if(currentPage != 1) { %>
                    	<button  onclick="location.href='<%= contextPath %>/adminWRlist.mem?cpage=<%= currentPage -1 %>'"class="btn  btnYellow">&lt;</button>
                    <% } %>
                    
                	<% for(int i = startPage; i <= endPage; i++) { %>
	                	<% if(i != currentPage) { %>
	                    	<button onclick="location.href='<%= contextPath %>/adminWRlist.mem?cpage=<%= i %>'"class="btn  btnYellow"><%= i %></button>
						<% } else { %>
						  	<button style="background: rgb(255,240,110);"class="btn  btnYellow"><%= i %></button>
						<% } %>
					<% } %> 
					
					<% if(currentPage != maxPage && 0 != maxPage) { %>  
						<button  onclick="location.href='<%= contextPath %>/adminWRlist.mem?cpage=<%= currentPage + 1 %>'"class="btn  btnYellow">&gt;</button>
					<% } %>        
        </div>
    <% } else  { %>	
		
	<% } %>
    </div>
    <br clear="both">
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>