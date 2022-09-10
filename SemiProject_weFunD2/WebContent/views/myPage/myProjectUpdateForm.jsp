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
<meta charset="UTF-8">
<title>나의 프로젝트 내용 수정하기</title>
<style>
	table th{
        text-align: right;
    }
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>

	<%@ include file="../common/header2.jsp" %>
    <% 
    	int userNo = loginUser.getUserNo();
    	String nickName = loginUser.getNickname(); 
    %>
	<br><br>
	<h2 align="center"><b>프로젝트 수정</b></h2>
	<br>

	<div class="container" style="border: 1px solid lightgray; padding:15px; margin-top:15px; margin-bottom: 15px;">
		<form id="update-form" method="post" enctype="multipart/form-data" action="<%= contextPath %>/myProjectUpdate.me">

			<!-- 프로젝트명, 프로젝트 내용, 첨부파일 이미지 입력받기 + projectNO-->

			<input type="hidden" value="<%= pj.getProjectNo() %>" name="pjno">

			<!-- 프로젝트명 -->
            <div style="margin-top: 15px;"><b>프로젝트명</b></div>
            <div>
                <input type="text" name="projectName" class="form-control" required value="<%= pj.getProjectName() %>">
            </div>

			<!-- 카테고리 -->
            <div style="margin-top: 15px;"><b>카테고리</b></div>
			<div>
				<select id="category" name="category" class="custom-select" style="width: 200px;" required>
                    <option selected><%= pj.getCategoryName() %></option>
                </select>
			</div>

			<!-- 펀딩마감일, 목표금액 -->
            <div class="row" style="margin-top: 15px;">
                <div class="col-sm-4"><b>펀딩마감일</b></div>
                <div class="col-sm-8"><b>목표금액</b></div>
            </div>

			<div class="row">
                <div class="col-sm-4">
                    <input type="date" class="form-control" readonly value="<%= pj.getEndDate() %>">
                </div>
				<div class="col-sm-3">
                    <input type="number" name="goalAmount" class="form-control" readonly value="<%= pj.getGoalAmount() %>">
                </div>
                <div class="col-sm-1">원</div>
			</div>

			<!-- 은행정보 -->
			<div style="margin-top: 15px;"><b>은행정보</b></div>
			<div class="row">
				<div class="col-sm-2">
					<select name="bank" class="custom-select">
						<option selected ><%= pj.getBank() %></option>
					</select>
				</div>
				<div class="col-sm-3">
					<input type="text" name="accountNo" class="form-control" readonly value="<%= pj.getAccountNo() %>">
				</div>
				<div class="col-sm-2">
					<input type="text" name="accountName" class="form-control" readonly value="<%= pj.getAccountName() %>">
				</div>
			</div>

			<!-- 이미지 -->
			<div style="margin-top: 15px;"><b>이미지</b></div>
			<div>
				<!-- 기존 파일이 있다면 원본명을 보여주자 aaa.jpg -->
				<% if(atList.size() > 4) { %>
					<% for(int i = 0; i <= 3; i++) { %>
						<div>
							<img id="Imgs<%= i %>" width="300px" height="200px" src="<%= contextPath %>/<%= atList.get(i).getFilePath()+atList.get(i).getChangeName() %>">
							<%= atList.get(i).getOriginName() %>
							<input type="hidden" name="originaFileNo<%= i %>" value="<%= atList.get(i).getFileNo() %>">
							<input type="hidden" name="originFileName<%= i %>" value="<%= atList.get(i).getChangeName() %>">
							<input type="hidden" name="originFileLevel<%= i %>" value="<%= atList.get(i).getFileLevel() %>">
						</div>
					<% } %>
				<% } else { %>
					<% for(int i = 0; i < atList.size(); i++) { %>
						<div>
							<img id="Imgs<%= i %>" width="300px" height="200px" src="<%= contextPath %>/<%= atList.get(i).getFilePath()+atList.get(i).getChangeName() %>">
							<%= atList.get(i).getOriginName() %>
							<input type="hidden" name="originFileNo<%= i %>" value="<%= atList.get(i).getFileNo() %>">
							<input type="hidden" name="originFileName<%= i %>" value="<%= atList.get(i).getChangeName() %>">
							<input type="hidden" name="originFileLevel<%= i %>" value="<%= atList.get(i).getFileLevel() %>">
						</div>
					<% } %>
				<% } %>
				<br>
				<div id="file-area">
					&nbsp;&nbsp;대표이미지 : &nbsp;<input type="file" name="reUpfile0" id="file0" onchange="loadImg(this,0)"> <br>
					상품이미지1 : &nbsp;<input type="file" name="reUpfile1" id="file1" onchange="loadImg(this,1)"><br>
					상품이미지2 : &nbsp;<input type="file" name="reUpfile2" id="file2" onchange="loadImg(this,2)"><br>
					상품이미지3 : &nbsp;<input type="file" name="reUpfile3" id="file3" onchange="loadImg(this,3)"><br>
				</div>
				
				
				<script>
					function loadImg(inputFile, num) {
						if(inputFile.files.length == 1){
							
							var reader = new FileReader();
							
							reader.readAsDataURL(inputFile.files[0]);
							reader.onload = function(e){
						
							$("#Imgs" + num).attr("src", e.target.result);
								
							}
						}
					}
				</script>
				
			</div>

			<!-- 프로젝트내용 -->
			<div style="margin-top: 15px;"><b>프로젝트내용</b></div>
			<div>
				<textarea name="projectContent" class="form-control" rows="10" style="resize: none;" required><%= pj.getProjectContent() %></textarea>
			</div>

			<!-- 상품정보 -->
			<div style="margin-top: 15px;"><b>상품정보</b></div>
			<div id="product-area">
				<div class="row"> 
					<div class="col-sm-3">상품명</div>
					<div class="col-sm-2">가격</div>
				</div>
				
				<% for(Product pd : list) { %>
					<div class="row">
						<div class="col-sm-3">
							<input type="text" class="form-control" name="productName" readonly value="<%= pd.getProductName() %>">
						</div>
						<div class="col-sm-2">
							<input type="number" class="form-control" name="productPrice" readonly value="<%= pd.getPrice() %>">
						</div>  
					</div>
				<% } %>
			</div>
			<br>
			<div align="center">
                <button type="submit" class="btn btn-warning"  style="color:white">수정하기</button>&nbsp;
                <button type="reset" class="btn btn-primary">취소하기</button>&nbsp;
				<a href="<%= contextPath %>/myProjectDetial.me?pjno=<%= pj.getProjectNo() %>" class="btn btn-sm btn-info" style="font-size: 18px;">목록가기</a>
            </div>
		</form>
	</div>
	
	<br><br><br><br><br><br><br><br><br><br>
    
    <%@ include file="../common/footer.jsp" %>

<br><br>
</body>
</html>