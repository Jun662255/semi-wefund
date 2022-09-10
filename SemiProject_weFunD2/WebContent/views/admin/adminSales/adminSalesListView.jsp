<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList , com.kh.admin.adminSales.model.vo.Sales, java.text.DecimalFormat"%>
<% 
ArrayList<Sales> list1 = (ArrayList<Sales>)request.getAttribute("list1");
ArrayList<Sales> list2 = (ArrayList<Sales>)request.getAttribute("list2");
String month = (String)request.getAttribute("month");
String year = (String)request.getAttribute("year");
int sum = 0;
for (Sales s : list1) { 
sum += s.getSamPayment(); 
} 

DecimalFormat df = new DecimalFormat("###,###");


%>  


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>매출 관리</title>


<style>


        #categorySales{
            text-align: center;

            width: 45%;

            display:inline-block;
        }
        #list{
            text-align: center;
            float: right;
            width: 45%;
            height: 100%;         


        }
        #table123{
            text-align: center;
            float: right;
            width: 100%;

        }
        
        .h60{
        height: 60px;
        font-size: 20px;
        }
        
        .h40{
        height: 40px;
        font-size: 17px;
        }




    </style>
</head>
<body>
	<%@ include file="/views/common/adminMenu.jsp" %>
	<% if(loginUser!=null && loginUser.getUserId().equals("admin")) {%>
	<div id="maincontent">
		<p class="title">매출 관리</p>
    	<hr>
    	<br><br>
    	<div id="categorySales">
    		<table class="table-bordered" >
      	 	 	<tr class="h60">
        			<th colspan="2">20<%= year%>년 <%=month %>월</th>
        		</tr>
        		<tr class="h40">
         		   	<th width="150px">카테고리</th>
         		   	<th width="300px">매출</th>
	        	</tr>
	        	<% for(Sales s : list1) {%>
		      	<tr class="h40">
		           	<td><%= s.getCategoryName() %></td>
		           	<td><%= df.format(s.getSamPayment()) %> 원</td>
		       	</tr>
		       	<% } %>
		       	<tr class="h60">
		       	    <th>계</th>
		       	    <th><%= df.format(sum) %>원</th>
		   	 	</tr>	   	 	
      		</table>
		</div>

	    <div id="list">
	
	        <table id="table123"  class="table-bordered">
	            <tr class="h60">
	                <th>날짜</th>
	                <th>매출액</th>
	            </tr>
	            <% if(!list2.isEmpty()) {%>
	            <% for(int i = 0; i<6; i++) { %> 
		           <tr class="h40">
		               <td>20<%= list2.get(i).getEndDate().replace("/", "년 ")	%>월</td>
		               <td><%= df.format(list2.get(i).getSamMonthPayment()) %>원</td>
		           </tr>
				<% } %>
                <% }else{ %>
                <p></p>
                <% } %>
            </table>
       	<% } else { %>
    	<% } %>
        </div>
    <br><br>
    <br clear="both">
    <%@ include file="/views/common/footer.jsp"%>
</div>
</body>
</html>
