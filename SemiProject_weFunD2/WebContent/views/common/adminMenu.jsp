<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<%@ include file="/views/common/header2.jsp"%>
<title>Insert title here</title>
<style>
.adminMenu a {
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

input[id*="answer"]+label img {
	position: absolute;
	top: 50%;
	right: 10px;
	width: 20px;
	height: 20px;
	margin-top: -10px;
	display: inline-block;
	background: 0 0 no-repeat;
}

input[id*="answer"]:checked+label img {
	background-position: 0 -30px;
}

.adminMenu {
	float: left;
	margin-left: 6%;

	margin-top: 3%;
	font-size: 25px;
}

.adminMenu label:hover {
	font-size: 26px;
	color: rgb(63, 74, 224);
}

.adminMenu a:hover {
	font-size: 26px;
	color: rgb(63, 74, 224);
}

.adminMenu div {
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

@media ( max-width : 1680px ) {
	.adminMenu {
		display: none;
	}
}

<!--위-->
.maincontent table {
	text-align: center;
}

table {
	text-align: center;
}

table a {
	color: black;
}

table th {
	color: #495057;
	background-color: #e9ecef;
}

#maincontent {
	width: 900px;
	float: right;
	margin-right: 25%;
	margin-top: 3%;
}

.selectPage {
	width: 64%;
	float: right;
	margin-right: 17%;
	text-align: center;
	display: block;
	height: 100px;
}

.btnYellow {
	font-weight: bold;
	color: white;
	background-color: rgb(255, 217, 72);
}

.btnYellow:hover {
	background-color: rgb(255, 190, 18);
	color: black;
}
</style>
</head>
<body>
	<% if(loginUser!=null && loginUser.getUserId().equals("admin")) {%>
	<div class="adminMenu">
		<p class="title">관리자 페이지</p>
		<hr>
		<div class="accordion">
			<input type="checkbox" id="answer01" /> <label for="answer01">
				<a href="<%=contextPath%>/adminlist.qna?cpage=1">Q&A</a>
			</label>
		</div>
			
		<div class="accordion">
			<input type="checkbox" id="answer02" /> <label for="answer02">프로젝트<img
				alt=""
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKKs6OP36GlHnJCLBRA3bwO1RYfLy9VLUesg&usqp=CAU"></label>
			<div>
				<a href="<%=contextPath%>/adminlist.pj?cpage=1&type=all"> - 프로젝트 상태</a>
				<br /> <a href="<%=contextPath%>//adminList.sup?cpage=1"> - 구매 내역</a>
			</div>
		</div>
		<div class="accordion">
			<input type="checkbox" id="answer03" /> <label for="answer03">회원<img
				alt=""
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKKs6OP36GlHnJCLBRA3bwO1RYfLy9VLUesg&usqp=CAU"></label>
			<div>
				<a href="<%=contextPath%>/adminRepolist.mem?cpage=1"> - 회원 신고 내역</a>
				<br /> <a href="<%=contextPath%>/adminlist.mem?cpage=1"> - 회원조회</a>
				<br /> <a href="<%=contextPath%>/adminWRlist.mem?cpage=1"> - 탈퇴회원 조회 / 복구</a>
			</div>
		</div>
		<div class="accordion">
			<input type="checkbox" id="answer04" /> <label for="answer04">게시판<img
				alt=""
				src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKKs6OP36GlHnJCLBRA3bwO1RYfLy9VLUesg&usqp=CAU"></label>
			<div>
				<a href="<%=contextPath%>/list.no?cpage=1"> - 공지글</a> <br /> <a
					href="<%=contextPath%>/adminlist.re?cpage=1"> - 리뷰</a>
			</div>
		</div>
		<div class="accordion">
			<input type="checkbox" id="answer04" /> <label for="answer04">
				<a href="<%=contextPath%>/adminlist.sa">매출</a>

			</label>
		</div>
	</div>

	<% } else  { %>	
		<br><br><br><br><p style="text-align: center; font-size: xx-large; color: red" > 관리자 페이지 입니다</p>
	<% } %>
	

</body>
</html>