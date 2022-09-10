<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.kh.common.model.PageInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.admin.adminProject.model.vo.Support"%>
<% ArrayList<Support> list = (ArrayList<Support>)request.getAttribute("list");
   String type = (String)request.getAttribute("type");
%>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>프로젝트 관리</title>



</head>
<body>
	<%@ include file="/views/common/adminMenu.jsp" %>
	<% if(loginUser!=null && loginUser.getUserId().equals("admin")) {%>
    <div id="maincontent">

	<br><br>
        <div>
            <table class="table">
				<tr>
	        		<th width="100px" rowspan="4" style="vertical-align: middle;">주문 번호</th>
			        <th width="200px">구매자</th>
			        <th width="300px">구매자 휴대폰번호</th>
			        <th width="500px">구매자 이메일</th>
		       	</tr>
			    <tr>
			        <th>수령자</th>
			        <th>수령자 휴대폰번호</th>
			        <th>수령지</th>
			   	</tr>
			    <tr>
			        <th>가격</th>
			        <th>결제일</th>
			        <th>상품명</th>
		     	</tr>
		      	<tr>
			        <th colspan="3">요청사항</th>			        
		      	</tr>               
               	<% for(Support s :list) { %>
				<tr>
	        		<td rowspan="4" style="vertical-align: middle;"><%=s.getSupportNo() %> 번</td>
			        <td><%=s.getOrderName()%></td>
			        <td><%=s.getOrderPhone() %></td>
			        <td><%=s.getOrderEmail() %></td>
		       	</tr>
			    <tr>
			        <td><%=s.getReceiverName()%></td>
			        <td><%=s.getReceiverPhone()%></td>
			        <td><%=s.getReceiverAddress()%></td>
			   	</tr>
			    <tr>
			        <td><%=s.getPayment()%>원</td>
			        <td><%=s.getSupportDate().substring(0,16) %></td>
			        <td><%=s.getProduct() %></td>
		     	</tr>
		      	<tr>
			        <td colspan="3"><%=s.getOrderComment()%></td>
		      	</tr>  	
                <% } %>
            </table>
        </div>      
	</div>
    <% } %>
    <br><br><br><br>
    <br clear="both">
	<%@ include file="/views/common/footer.jsp"%>

</body>
</html>