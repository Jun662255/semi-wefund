<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.notice.model.vo.Notice" %>
<% Notice n = (Notice)request.getAttribute("n"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항상세페이지</title>
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
	.btnBlue{
		color: white;
		background-color: rgb(63, 74, 224);
	}
	.btnBlue:hover{
        color:white;
        background-color: rgb(35, 46, 194);
    }
    .modal{text-align: center;}
</style>
</head>
<body>

	<%@ include file="../common/header2.jsp" %>
	
    <div class="container">
		<br>
        <h3 class="page-title">공지사항</h3>

        <table class="table">
            <thead class="thead-light">
                <tr>
                    <th>[공지사항]&nbsp;<%= n.getNoticeTitle() %></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                  <td align="right">작성자:<%= n.getNoticeWriter() %>&nbsp;|&nbsp;작성일:<%= n.getNoticeDate().substring(0,16) %>&nbsp;(조회수:<%= n.getCount() %>)</td>
                </tr>
                <tr>
                  <td><p style="min-height:500px;"><%= n.getNoticeContent().replaceAll("\n", "<br/>") %></p></td>
                </tr>
            </tbody>
        </table>

        <br><br>
        <hr>

		<% if(loginUser!= null && loginUser.getUserId().equals("admin")) { %>
	        <div align="right">
	        	<a href="<%=contextPath%>/updateForm.no?nno=<%=n.getNoticeNo()%>" class="btn btnBlue">수정</a>  
		        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteNotice">삭제</button>
	        </div>
        <% } %>
        
		<div align="center">
			<a href="<%=contextPath%>/list.not?cpage=1"class="btn btn-secondary">돌아가기</a>
		</div>

    </div>

    <!-- 공지사항 삭제 모달 -->
	<div class="modal" id="deleteNotice">
		<div class="modal-dialog">
			<div class="modal-content">
                <div class="modal-body">
                    <div style="margin:30px;">
                		<h6>공지사항을 삭제하시겠습니까?</h6>
                	</div>
                    <div align="center"></div>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                        <a href="<%=contextPath%>/delete.no?nno=<%=n.getNoticeNo()%>" class="btn btn-danger">삭제하기</a>
                    </div>
                </div>
			</div>
		</div>
	</div>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>