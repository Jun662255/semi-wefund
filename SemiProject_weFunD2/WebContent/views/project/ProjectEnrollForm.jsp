<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 입력폼</title>
<style>
table th {
	text-align: right;
}

</style>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
</head>
<body>

   <%@ include file="../common/header2.jsp" %>



	<div class="container"
		style="border: 1px solid lightgray; padding: 15px; margin-top: 15px; margin-bottom: 15px;max-width:1000px;">

		<form action="<%=contextPath%>/insertProject.do"
			enctype="multipart/form-data" method="post">
			<input type=hidden name="userNo" value="<%=loginUser.getUserNo()%>">
			<table class="table table-borderless">
				<thead class="thead-light">
					<tr>
						<th style="text-align: center;" colspan="5">프로젝트업로드</th>
					</tr>
				</thead>
			</table>

			<!-- 프로젝트명 -->
			<div style="margin-top: 15px;">
				<b>프로젝트명</b>
			</div>
			<div>
				<input type="text" name="projectName" class="form-control"
					placeholder="프로젝트명을 입력해주세요" required>
			</div>

			<!-- 카테고리 -->
			<div style="margin-top: 15px;">
				<b>카테고리</b>
			</div>
			<div>
				<select id="category" name="category" class="custom-select"
					style="width: 200px;" required>
					<option value="">카테고리 선택</option>
					<option value="10,테크">테크</option>
					<option value="20,패션">패션</option>
					<option value="30,뷰티">뷰티</option>
					<option value="40,푸드">푸드</option>
					<option value="50,홈리빙">홈리빙</option>
					<option value="60,스포츠">스포츠</option>
					<option value="70,굿즈">굿즈</option>
					<option value="80,키즈">키즈</option>
					<option value="90,반려동물">반려동물</option>
					<option value="99,기타">기타</option>
				</select>
			</div>

			<!-- 펀딩마감일, 목표금액 -->
			<div class="row" style="margin-top: 15px;">
				<div class="col-sm-4">
					<b>펀딩마감일</b>
				</div>
				<div class="col-sm-8">
					<b>목표금액</b>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<select name="year" class="custom-select" style="width: 100px;"
						required>
						<option value="2022" selected>2022년</option>
						<option value="2023">2023년</option>
					</select> <select name="month" class="custom-select" style="width: 80px;"
						required>
						<option value="1">1월</option>
						<option value="2">2월</option>
						<option value="3">3월</option>
						<option value="4">4월</option>
						<option value="5">5월</option>
						<option value="6">6월</option>
						<option value="7" selected>7월</option>
						<option value="8">8월</option>
						<option value="9">9월</option>
						<option value="10">10월</option>
						<option value="11">11월</option>
						<option value="12">12월</option>
					</select> <select name="day" class="custom-select" style="width: 80px;"
						required>
						<option value="1" selected>1일</option>
						<option value="2">2일</option>
						<option value="3">3일</option>
						<option value="4">4일</option>
						<option value="5">5일</option>
						<option value="6">6일</option>
						<option value="7">7일</option>
						<option value="8">8일</option>
						<option value="9">9일</option>
						<option value="10">10일</option>
						<option value="11">11일</option>
						<option value="12">12일</option>
						<option value="13">13일</option>
						<option value="14">14일</option>
						<option value="15">15일</option>
						<option value="16">16일</option>
						<option value="17">17일</option>
						<option value="18">18일</option>
						<option value="19">19일</option>
						<option value="20">20일</option>
						<option value="21">21일</option>
						<option value="22">22일</option>
						<option value="23">23일</option>
						<option value="24">24일</option>
						<option value="25">25일</option>
						<option value="26">26일</option>
						<option value="27">27일</option>
						<option value="28">28일</option>
						<option value="29">29일</option>
						<option value="30">30일</option>
						<option value="31">31일</option>
					</select>
				</div>
				<div class="col-sm-3">
					<input type="number" name="goalAmount" class="form-control"
						placeholder="숫자만 입력" min="0" required>
				</div>
				<div class="col-sm-1">원</div>
			</div>

			<!-- 은행정보 -->
			<div style="margin-top: 15px;">
				<b>은행정보</b>
			</div>
			<div class="row">
				<div class="col-sm-2">
					<select name="bank" class="custom-select">
						<option value="신한은행">신한은행</option>
						<option value="우리은행">우리은행</option>
						<option value="농협은행">농협은행</option>
						<option value="카카오뱅크">카카오뱅크</option>
					</select>
				</div>
				<div class="col-sm-3">
					<input type="text" name="accountNo" class="form-control"
						placeholder="계좌번호">
				</div>
				<div class="col-sm-2">
					<input type="text" name="accountName" class="form-control"
						placeholder="예금주">
				</div>
			</div>

			<!-- 썸네일이미지 -->
			<div style="margin-top: 15px;">
				<b>썸네일이미지</b>
			</div>
			<div>
				<img id="thumbnailImg" width="300px" height="200px"
					src="https://images.assetsdelivery.com/compings_v2/yehorlisnyi/yehorlisnyi2104/yehorlisnyi210400016.jpg">
				<input type="file" name="file1" id="file1" required>
			</div>

			<!-- 추가이미지 -->
			<div style="margin-top: 15px;">
				<b>추가이미지</b>
			</div>
			<div>
				<div>
					<input type="file" name="file2" id="file2">
				</div>
				<div>
					<input type="file" name="file3" id="file3">
				</div>
				<div>
					<input type="file" name="file4" id="file4">
				</div>
			</div>

			<!-- 프로젝트내용 -->
			<div style="margin-top: 15px;">
				<b>프로젝트내용</b>
			</div>
			<div>
				<textarea name="content" class="form-control" rows="10"
					placeholder="프로젝트 내용을 입력해주세요" style="resize: none;" required></textarea>
			</div>

			<!-- 상품정보 -->
			<div style="margin-top: 15px;">
				<b>상품정보</b>
			</div>
			<div id="product-area">
				<div class="row">
					<div class="col-sm-3">상품명</div>
					<div class="col-sm-2">가격</div>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<input type="text" class="form-control" name="productName"
							placeholder="상품명 입력" required style="margin: 5px;">
					</div>
					<div class="col-sm-2">
						<input type="number" class="form-control" name="productPrice"
							placeholder="가격 입력" min="0" required style="margin: 5px;">
					</div>
				</div>
				<div class="row" id="prodcuts-info">
					<div class="col-sm-3">
						<input type="text" class="form-control" name="productName"
							placeholder="상품명 입력" style="margin: 5px;">
					</div>
					<div class="col-sm-2">
						<input type="number" class="form-control" name="productPrice"
							placeholder="가격 입력" min="0" style="margin: 5px;">
					</div>
					<div>
						<button class="delete">삭제</button>
					</div>
				</div>



			</div>








			<!-- 상품정보 > 상품 추가 버튼 -->
			<div class="row" id="product-add-btn" style="margin-top: 15px;">
				<div class="col-sm-5">
					<button type="button" id="addButton"
						class="btn btn-primary btn-block">+상품추가</button>
				</div>
			</div>
			<script>
				$(function() {

					$('#addButton').click(
							function() {

								$('#product-area').append(
										$('#prodcuts-info').clone(true));

							})

				})

				$(function() {
					$('.delete').click(function() {

						$(this).parent().parent().remove();
					})
				})
			</script>

			<br>
			<br>
			<hr>

			<div align="center">
				<button type="button" class="btn btn-success"
					onclick="history.back();">돌아가기</button>
				<button type="submit" class="btn btn-primary">작성완료</button>
			</div>

		</form>

		<br>
		<br>
	</div>
           <%@ include file="../common/footer.jsp" %>
</body>
</html>