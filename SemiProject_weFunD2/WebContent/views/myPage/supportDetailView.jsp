<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.myPage.model.vo.Support, java.util.Date" %>

<%
	Support s = (Support)request.getAttribute("s");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문상세보기</title>
<style>
	div{
	    box-sizing : border-box;
	    /*border : 1px solid red;*/
	    
	}
	#outer{
	    width : 1000px;
	    height : 800px;
	    margin : auto;
        margin-top: 30px;
	}
	table{
	    margin-left: auto;
	    margin-right: auto;
	    width: 900px;
	    height: 200px;
	    text-align: center;
	    border: 1px solid black;
	    border-collapse:separate;
	    border-radius: 10px;
	}
	#infoTable th{
	    height: 30px;
	    text-align: center;
	    border-bottom: 1px solid black;
	    background-color: rgb(247, 217, 58);
	    border-radius: 5px;
	}
	#addressTable{
	    text-align: left;
	}
	#addressTable th{
	    text-align: center;
	    border-right: 1px solid black;
	    background: rgb(247, 217, 58);
	    border-radius: 5px;
	}
    #back{
        text-decoration: none;
        font-size: 13px;
        border: 1px solid rgb(247, 217, 58);
        border-radius: 15px;
        border-width: 8px;
        background-color: rgb(247, 217, 58);
        color: black;
        box-shadow: 1px 1px 1px 1px gray;
    }
</style>
</head>
<body>
<%@ include file="../common/header2.jsp" %>
<% int userNo = loginUser.getUserNo(); %>
    <div id="outer">
        <br>
        <p style="font-size:20px; margin-left: 50px;"><b>후원 상세 정보</b></p>
        <p style="font-size: 17px; margin-left: 50px;">주문일자 : <%= s.getSupportDate() %></p>
        
        <table id="infoTable">

            <thead>
                <tr>
                    <th style="border-right: 1px solid black; width: 250px;">후원 프로젝트</th>
                    <th style="border-right: 1px solid black; width: 300px;">주문 정보</th>
                    <th style="border-right: 1px solid black; width: 200px;">주문 금액</th>
                    <th>결제상태</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td rowspan="2" style="width: 250px; height:150px; text-align:center; border-right: 1px solid black;">
                        <img src="<%= s.getTitleImg() %>" style="width:200px; height: 140px; border-radius: 10px;">
                    </td>
                    <td style="border-right: 1px solid black; border-bottom: 1px solid black;"><%= s.getProjectName() %></td>
                    <td rowspan="2" style="border-right: 1px solid black;"><%= s.getPayment() %>원</td>
                    <td rowspan="2">
                    
                    <%= s.getStatus() %>
                    </td>
                </tr>
                <tr>
                    <td style="border-right: 1px solid black;"><%= s.getProduct() %></td>
                </tr>
            </tbody>
        </table>
        <p style="font-size : 12px; margin-left: 50px;">* 결제상태 - Y : 결제 완료 / N : 결제 예약 (프로젝트 진행중) / F : 펀딩 실패 </p>
        

        <br><br>
        <p style="font-size:20px; margin-left: 50px;"><b>배송지 정보</b></p>

        <table id="addressTable">
            <tr>
                <th style="height: 30px; width: 100px; border-bottom: 1px solid black;">수령인</th>
                <td style="border-bottom: 1px solid black; border-right: 1px solid black; width:400px;">&nbsp;<%= s.getReceiverName() %></td>
                <td style="border-bottom: 1px solid black; background-color: rgb(232, 232, 232); border-radius: 5px; text-align: center;">
                    <b>주문자 정보</b>
                </td>
            </tr>
            <tr>
                <th style="height: 30px; border-bottom: 1px solid black;">연락처</th>
                <td style="border-bottom: 1px solid black; border-right: 1px solid black;">&nbsp;<%= s.getReceiverPhone() %></td>
                <td rowspan="2">
                	<p>&nbsp;<%= s.getOrderName() %></p>
                    <p>&nbsp;<%= s.getOrderPhone() %></p>
                </td> 
            </tr>
            <tr>
                <th>배송지</th>
                <td style="border-right: 1px solid black;">&nbsp;<%= s.getReceiverAddress() %></td>
            </tr>
        </table>

        <br><br>
        <div style="text-align: center;">                                    
            <a id="back" href="<%= contextPath%>/mySupportListView.me?userNo=<%= userNo %>&spage=1&select=전체">&nbsp;돌아가기&nbsp;</a>
        </div>
        
    </div>

    <%@ include file="../common/footer.jsp" %>
</body>
</html>