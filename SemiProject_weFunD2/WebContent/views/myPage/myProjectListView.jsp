<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.myPage.model.vo.*, com.kh.common.model.*" %>
<%
	ArrayList<Project> list = (ArrayList<Project>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	String select = (String)request.getAttribute("select");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
	
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>마이페이지 나의프로젝트 화면</title>
<style>
    /*
    div{
            border: 1px solid red;
            box-sizing: border-box;
    }
    */
    .outer{
        	width: 1200px;
        	margin-left: 10%;
     }
    /* 메뉴 스타일 */
    .myPageNavigator{
        width: 250px;
        height: 600px;
        float: left;
        margin-left: 15%;
        margin-right: 3%;
    }
    .myPageNavigator label:hover {
        font-size: 26px;
        color: rgb(63, 74, 224);
    }
    .myPageNavigator a:hover {
        font-size: 26px;
        color: rgb(63, 74, 224);
    }
    .myPageNavigator div {
        margin-bottom: 25px;
        margin-top: 25px;
    }
    .title {
        font-size: xx-large;
        width: 100%;
        font-weight: bold;
    }
    
    a {
        text-decoration: none !important;
    }
    /*
    @media ( max-width : 1810px ) {
        .myPageNavigator {
            display: none;
            
        }
    }
    */
    .myPageNavigator a {
        color: black;
    }
    input[id*="answer"] {
        display: none;
    }
    input[id*="answer"]+label {
        display: block;
        cursor: pointer;
        position: relative;
        color: black;
    }
    input[id*="answer"]+label+div {
        max-height: 0;
        transition: all 0.5s;
        overflow: hidden;
    }
    input[id*="answer"]:checked+label+div {
        max-height: 120px;
    }
    input[id*="answer"]+label img{
        position: absolute;
        top: 50%;
        right: 10px;
        width: 20px;
        height: 20px;
        margin-top: -10px;
        display: inline-block;
        background: 0 0 no-repeat;
    }
    input[id*="answer"]:checked+label img{
        background-position: 0 -30px;
    }

    /* 본문 스타일*/
    #myProject{
        width: 780px;
        height: 600px;
        margin-left: 35%;
    }
    #myProjectContent1{
        width: 71%;
        height: 100%;
    }
    #myProjectContent2{
        width: 20%;
        height: 100%;
    }
    #myProject > div{
        float: left;
    }
    .list{
        width: 92%;
        height: 25%;
        border-radius: 10px;
        border: 1px solid black;
        margin-bottom: 8px;  
        cursor: pointer;
    }
	.btnYellow{
        font-weight : bold;
        color:white;
        background-color: rgb(255,217,72); 
    }
    .btnYellow:hover{
        background-color: rgb(255,190,18); 
        color: black;
    }

</style>
</head>
<body>

    <%@ include file="../common/header2.jsp" %>
    <% int userNo = loginUser.getUserNo(); %>

	<div class="outer">
    <br><br>
    <h2 align="center"><b>나의 프로젝트</b></h2>
    <br>

    <!-- 왼쪽 메뉴바 -->
    <div class="myPageNavigator">
        <p class="title">마이페이지</p>
        <hr>
        <div class="accordion">
            <input type="checkbox" id="answer01">
            <label for="answer01">회원정보<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKKs6OP36GlHnJCLBRA3bwO1RYfLy9VLUesg&usqp=CAU"></label>
            <div>
                <a href="<%= contextPath %>/myPage.me?userNo=<%= userNo %>"> - 개인정보 수정</a>
                <br />
                <a href="<%= contextPath %>/myPage.me?userNo=<%= userNo %>"> - 회원탈퇴</a>
            </div>
        </div>
        <div class="accordion">
            <input type="checkbox" id="answer02">
            <label for="answer02">활동내역(서포터)<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKKs6OP36GlHnJCLBRA3bwO1RYfLy9VLUesg&usqp=CAU"></label>
            <div>
                <a href="<%= contextPath %>/myLikeListView.me?userNo=<%= userNo %>&pjpage=1&select=전체"> - 관심프로젝트</a>
                <br />
                <a href="<%= contextPath %>/myReviewListView.me?userNo=<%= userNo %>&rvpage=1"> - 나의 리뷰조회</a>
                <br />
                <a href="<%= contextPath %>/mySupportListView.me?userNo=<%= userNo %>&spage=1&select=전체"> - 후원 현황조회</a>
            </div>
        </div>
        <div class="accordion">
            <input type="checkbox" id="answer03">
            <label for="answer03">활동내역(메이커)<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKKs6OP36GlHnJCLBRA3bwO1RYfLy9VLUesg&usqp=CAU"></label>
            <div>
                <a href="<%= contextPath %>/myProjectListView.me?userNo=<%= userNo %>&mppage=1&select=전체"> - 나의프로젝트</a>
            </div>
        </div>
        <div class="accordion">
            <input type="checkbox" id="answer04">
            <label for="answer04">고객센터<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKKs6OP36GlHnJCLBRA3bwO1RYfLy9VLUesg&usqp=CAU"></label>
            <div>
                <a href="<%=contextPath %>/enrollForm.qna"> - 문의하기</a>
            </div>
        </div>
    </div>

    <!-- 오른쪽 나의프로젝트 리스트 출력화면 -->
    <div id="myProject">
        <div id="myProjectContent1">
            
            <% if(list.isEmpty()) { %>
            	나의 프로젝트 목록이 없습니다
            <% } else { %>
            	<% for(Project p : list) { %>
	            	<%
	            	double ps = p.getPaymentSum();
	            	double ga = p.getGoalAmount();
	            	double ar = (ps / ga) * 100;
	
	            	String achievementRate = String.format("%.1f", ar);
	            	%>
		            <div class="list">
		            	<input type ="hidden" value="<%= p.getProjectNo() %>">
            			<table>
            				<tr>
            					<td style="width: 170px;">&nbsp;&nbsp;&nbsp;<%= p.getCategoryName() %>
            					<td style="width: 170px;">
            						<% if(p.getStatus().equals("Y")) { %>
            							프로젝트 승인
            						<% } else if(p.getStatus().equals("N")) { %>
            							프로젝트 대기
            						<% } else if(p.getStatus().equals("E")) { %>
            							프로젝트 마감
            						<% } else {%>
            							프로젝트 반려
            						<% } %>
            					</td>
            					<td rowspan="3"><img style="width: 190px; height: 140px; border-radius: 10px;"
            					src="<%= p.getTitleImg() %>"></td>
            				</tr>
            				<tr>
            					<td colspan="2">&nbsp;&nbsp;&nbsp;진행률&nbsp;&nbsp;:&nbsp; <%= achievementRate %>%</td>
            				</tr>
            				<tr>
            					<td colspan="2">&nbsp;&nbsp;&nbsp;<%= p.getProjectName() %></td>
            				</tr>
            			</table>
            		</div>
            	<% } %>
            <% } %>
            </div>
        
        <div id="myProjectContent2" class="container">
                <select id="projectSelect" class="form-control" name="select" size="1" onchange = "location.href = this.value">
                    <option value="<%= contextPath %>/myProjectListView.me?userNo=<%= userNo %>&mppage=1&select=전체">전체</option>
                    <option value="<%= contextPath %>/myProjectListView.me?userNo=<%= userNo %>&mppage=1&select=대기중">대기중</option>
                    <option value="<%= contextPath %>/myProjectListView.me?userNo=<%= userNo %>&mppage=1&select=마감">마감</option>
                    <option value="<%= contextPath %>/myProjectListView.me?userNo=<%= userNo %>&mppage=1&select=승인">승인</option>
                    <option value="<%= contextPath %>/myProjectListView.me?userNo=<%= userNo %>&mppage=1&select=반려">반려</option>
                </select>
        </div>
    </div>
    
    <script>
	    $(function(){
	        $("#projectSelect option").each(function(){
	            if($(this).text() == "<%=select%>"){
	                $(this).attr("selected", "true");
	            }
	        })
	     });
    
    </script>
    
    
    <script>
    	$(function(){
    		$(".list").click(function(){
    			var pjno = $(this).children().eq(0).val();
    			
    			location.href = "<%= contextPath %>/myProjectDetial.me?pjno=" + pjno;
    		})
    	})
    </script>
    
    

    <br><br>
    <div style="width: 500px; margin-left: 35%;" align="center">
   		<% if(currentPage != 1) { %>
   	 		<button class="btn btn-sm btn-info btnYellow" onclick="location.href='<%= contextPath %>/myProjectListView.me?userNo=<%= userNo %>&mppage=<%= currentPage -1 %>&select=<%= select %>'">&lt;</button>
	   	 <% } %>
	   	 <% for(int i = startPage; i <= endPage; i++) { %>
	 		<% if(i != currentPage) { %>
	 			<button class="btn btn-sm btn-info btnYellow" onclick="location.href='<%= contextPath %>/myProjectListView.me?userNo=<%= userNo %>&mppage=<%= i %>&select=<%= select %>'"><%= i %></button>
	 		<% } else { %>
	 			<button class="btn btn-sm btn-primary btnYellow"><%= i %></button>
	 		<% } %>
	   	 <% } %>
	   	 <% if(currentPage != maxPage && 0 != maxPage) { %>
	   	 	<button class="btn btn-sm btn-info btnYellow" onclick="location.href='<%= contextPath %>/myProjectListView.me?userNo=<%= userNo %>&mppage=<%= currentPage + 1 %>&select=<%= select %>'">&gt;</button>
	   	 <% } %>
    </div>

	</div>
	<br><br><br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br><br><br clear="both">
    
    <%@ include file="../common/footer.jsp" %>

<br><br>
</body>
</html>