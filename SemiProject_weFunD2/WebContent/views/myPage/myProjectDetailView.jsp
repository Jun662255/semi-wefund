<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.myPage.model.vo.*" %>
<%
	Project pj = (Project)request.getAttribute("pj");
	ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
	ArrayList<ProjectAttachment> atList = (ArrayList<ProjectAttachment>)request.getAttribute("atList");
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
<title>마이페이지 프로젝트상세페이지</title>
<style>
   /* 
    div{
        border: 1px solid red;
        box-sizing: border-box;
    }
    */
    /* 메뉴 스타일 */
    .myPageNavigator{
        width: 15%;
        height: 600px;
        margin-left: 5%;
        float: left;
        position: relative;
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

    /* 본문 스타일 */
    #projectView{
        width: 1000px;
        min-height: 700px;
        margin: auto;
    }
    #projectContent1{
        width: 60%;
        height: 100%;
    }
    #projectContent2{
        width: 40%;
        height: 100%;
        margin-top: 15%;
    }
    #projectView > div{
        float: left;
    }
    #categori{
        height: 5%;
    }
    #pjTitle{
        height: 10%;
    }
    #pjThumbnail{
        height: 40%;
    }
    #pjContent{
        height: 45%;
    }
    .inlineblock{
        line-height: 65px;
        text-align: center;
        font-size: 20px;
        font-weight: 600;
    }
    .imgs{
        text-align:center; 
        line-height: 35px; 
        font-size: 15px;
    }
</style>
</head>
<body>

    <%@ include file="../common/header2.jsp" %>
    <% 
    	int userNo = loginUser.getUserNo();
    	String nickName = loginUser.getNickname(); 
    %>
    
    <br><br>
    <h2 align="center"><b>프로젝트 상세조회</b></h2>
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

    <!-- 오른쪽 프로젝트 상세페이지 출력화면 -->
    <form id="projectView">
        <div id="projectContent1">
            <table>
                <tr>
                    <div id="pjTitle" class="inlineblock" >
                        <%= pj.getProjectName() %>
                    </div>
                </tr>
                <tr>
                    <div id="categori" style="text-align: center; line-height: 35px; font-size: 15px;">
                        <%= pj.getCategoryName() %>
                    </div>
                </tr>
                <tr>
                    <div id="pjThumbnail" class="imgs">
                    	대표이미지
                        <br>
                        <img id="titleImg" width="350" height="230"
                        src="<%= contextPath %>/<%= atList.get(0).getFilePath()+atList.get(0).getChangeName() %>">
                    </div>
                </tr>
                <tr>
                	<% if(atList.size() > 4){ %>
	                    <% for (int i = 1; i <= 3; i++) { %>
		                    <div class="imgs"> 상품이미지 <%= i %>
                            <br>
		                    <img width="350" height="230"
                            src="<%= contextPath %>/<%= atList.get(i).getFilePath()+atList.get(i).getChangeName() %>">
		                    </div>
	               		<% } %>
	               	<% } else { %>
	               		<% for (int i = 1; i < atList.size(); i++) { %>
		                    <div class="imgs">상품이미지 <%= i %>
                            <br>
		                    <img  width="350" height="230"
                            src="<%= contextPath %>/<%= atList.get(i).getFilePath()+atList.get(i).getChangeName() %>">
		                    </div>
	               		<% } %>
	               	<% } %>
                </tr>
                <br>
                <tr>
                    <div id="pjContent" align="center" >
                        <textarea id="" cols="60" style="resize: none; line-height: 100px;">
                        <%= pj.getProjectContent() %>
                        </textarea>
                    </div>
                </tr>
                <tr>
                    <div align="center">
                        <a href="<%= contextPath %>/myProjectListView.me?userNo=<%= userNo %>&mppage=1&select=전체" 
                           class="btn btn-sm btn-info" style="font-size: 18px;" >
                           	목록가기
                        </a>
                    </div>
                </tr>
            </table>
        </div>

        <div id="projectContent2">
            <div id="projectInfo1" class="container">
                <table border="1" class="table table-bordered">
                    <tr>
                        <th>작성자</th>
                        <td><%= nickName %></td>
                    </tr>
                    <tr>
                        <th>목표금액</th>
                        <td><%= pj.getGoalAmount() %></td>
                    </tr>
                    <tr>
                        <th>펀딩시작일</th>
                        <% if(pj.getStartDate() == null) { %>
                        	<td>승인대기중</td>
                        <% } else {%>
                        	<td><%= pj.getStartDate() %></td>
                        <% } %>
                    </tr>
                    <tr>
                        <th>펀딩마감일</th>
                        <td><%= pj.getEndDate() %></td>
                    </tr>
                    <tr>
                        <th>은행정보</th>
                        <td><%= pj.getBank() %>/<%= pj.getAccountNo() %>(<%= pj.getAccountName() %>)</td>
                    </tr>
                    <tr>
                        <th>승인요청일</th>
                        <td><%= pj.getApplyDate() %></td>
                    </tr>
                    <tr>
                    	<th>프로젝트 승인여부</th>
                    	<td>
                    		<% if(pj.getStatus().equals("X")) { %>
                    			신청한 프로젝트가 반려되었습니다
                    		<% } else if (pj.getStatus().equals("E")) {%>
                    			신청한 프로젝트는 종료되었습니다
                    		<% } else if(pj.getStatus().equals("N")) { %>
                    			신청한 프로젝트가 승인 대기중입니다
                    		<% } else {%>
                    			신청한 프로젝트가 승인되었습니다
                    		<% } %>
                    	</td>
                    </tr>
                </table>
            </div>
            <br>

            <div id="projectInfo2">
            	<% if(list.isEmpty()) { %>
            		등록된 상품이 없습니다
            	<% } else {%>
            	
            		<table class="form-check">
            		<% for(Product pd : list) {%>
            			<tr>
	                        <td>
                                &nbsp; &nbsp;<input type="checkbox" class="form-check-input"><%= pd.getProductName() %> &nbsp; : &nbsp; <%= pd.getPrice() %>원
	                        </td>
                    	<tr>
            		<% } %>
            		</table>
            	<% } %>
            	
            </div>
            <br>
            <!-- 승인된 프로젝트만 수정버튼 보이게  -->
            <% if(pj.getStatus().equals("Y")) { %>
                &nbsp;<a href="<%= contextPath %>/myProjectUpdateForm.me?pjno=<%= pj.getProjectNo() %>" class="btn btn-sm btn-warning" style="color:white"> &nbsp;수정 &nbsp;</a>
            <% } %>
        </div>
    
    </form>
    
    <br><br><br><br><br><br><br><br><br><br clear="both">
    
    <%@ include file="../common/footer.jsp" %>

<br><br>
</body>
</html>