<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import=" java.util.ArrayList, com.kh.review.model.vo.Support" %>
<%
	ArrayList<Support> sList = (ArrayList<Support>)request.getAttribute("sList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰작성페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<style>
    .container{
		max-width: 1000px;
		min-height: 800px;
		margin-top: 15px;
        margin-bottom: 50px;
	}
	.page-title{
		text-align: center;
		margin-bottom: 15px;
		font-weight : bold;
	}
    table>thead>tr>th{
		text-align: center;
		font-size: 18px;
	}
	table th{
        text-align: right;
    }
    .btnBlue{
		color: white;
		background-color: rgb(63, 74, 224);
	}
	.btnBlue:hover{
        color:white;
        background-color: rgb(35, 45, 182);
    }
</style>
</head>
<body>

	<%@ include file="../common/header2.jsp" %>
	
	<div class="container">
        <br>
        <h3 class="page-title">리뷰게시판</h3>

        <form enctype="multipart/form-data" action="<%=contextPath%>/insert.rv" method="post">
			<input type="hidden" name="userNo" value="<%=loginUser.getUserNo()%>">
			
            <table class="table table-borderless">
                <thead class="thead-light">
                    <tr>
                        <th style="text-align: center;" colspan="2">리뷰작성</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th style="width: 125px;">제목:</th>
                        <td><input type="text" name="reviewTitle" class="form-control" maxlength="50" placeholder="글 제목" required></td>
                    </tr>
                    <tr>
                        <th>후원내역:</th>
                        <td>
                            <select name="supportNo" class="custom-select" style="width: 400px;" required>
	                            <option value="">프로젝트 선택</option>
	                            <% for(Support s : sList) { %>
	                            	<option value="<%= s.getSupportNo() %>"><%=s.getProjectName()%>(<%=s.getSupportDate().substring(0,16)%>)</option>
	                            <% } %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>별점:</th>
                        <td>
                            <select name="rate" class="custom-select" style="width: 100px;">
                                <option value="1">1점</option>
                                <option value="2">2점</option>
                                <option value="3">3점</option>
                                <option value="4">4점</option>
                                <option value="5" selected>5점</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>사진첨부:</th>
                        <td><img id="contentImg" width="200" height="150"><br></td>
                    </tr>
                    <tr>
                    	<th></th>
                    	<td><input type="file" name="file1" onchange="loadImg(this,1)"></td>
                    </tr>
                    
                    <tr>
                        <th>내용:</th>
                        <td><textarea class="form-control" name="reviewContent" rows="10" placeholder="내용을 입력해주세요" style="resize: none;" required></textarea></td>
                    </tr>
                </tbody>	
            </table>

	        <script>
	        	function loadImg(inputFile, num){
	        		if(inputFile.files.length == 1){ // 파일이 있는지 확인
						
						// 선택된 파일을 읽여들여서 그 영역에 맞는 미리보기

						// 파일을 읽어들일 FileReader 객체 생성
						var reader = new FileReader();

						// FileReader객체로부터 파일을 읽어들이는 메소드를 호출
						// 어느 파일을 읽을 것인지 인자 값으로 전달해줌
						reader.readAsDataURL(inputFile.files[0]);
						// 해달 파일을 읽어들이는 순간 그 파일만의 고유한 긴 url이 부여됨
						// => 해당 url을 src속성으로 부여할 것 (attr)

						// 파일 읽기가 완료되었을 때 실행할 함수를 정의
						reader.onload = function(e){
							// e의 target => e.target => 이벤트 적용된 것

							// e의 target.result에 각 파일의 url이 담김

							// 영역에 맞춰서 이미지 미리보기
							$("#contentImg").attr("src", e.target.result);
						}
					}
	        	}
            </script>

            <hr>

            <div align="center">
                <button type="button" class="btn btn-secondary" onclick="history.back();">돌아가기</button>
                <button type="submit" class="btn btnBlue">작성완료</button>
            </div>

        </form>

    </div>
    
    <%@ include file="../common/footer.jsp" %>
</body>
</html>