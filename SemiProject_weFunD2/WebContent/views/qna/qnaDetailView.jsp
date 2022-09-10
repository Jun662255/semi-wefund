<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.qna.model.vo.Qna" %>
<% Qna q = (Qna)request.getAttribute("q"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA상세페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<style>
	.container{
		max-width: 1000px;
		min-height: 800px;
		margin-top: 15px;
        margin-bottom: 15px;
	}
	table>thead>tr>th{
		text-align: center;
		font-size: 18px;
	}
	.content{min-height: 200px;}
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
        
        <h2 style="text-align:center">QnA</h2>
		<br>
        <table class="table table-bordered">
            <thead class="thead-light">
                <tr>
                    <th><%=q.getQnaTitle() %></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                  <td align="right">작성자:&nbsp;<%= q.getQnaWriter() %>&nbsp;|&nbsp;작성일:&nbsp;<%= q.getQnaDate().substring(0,16) %></td>
                </tr>
                <tr>
                  <td><p class="content"><%= q.getQnaContent().replaceAll("\n", "<br/>") %></p></td>
                </tr>
            </tbody>
        </table>

        
        <!-- 관리자 답변 있을 경우 띄우기 -->
        <% if(q.getAnswer() != null) { %>
        	<table class="table table-bordered">
	            <thead class="thead-light">
	                <tr>
	                    <th>답변완료</th>
	                </tr>
	            </thead>
	            <tbody>
	                <tr>
	                    <td align="right">작성자:&nbsp;관리자&nbsp;|&nbsp;작성일:&nbsp;<%= q.getAnswerDate().substring(0,16) %></td>
	                </tr>
	                <tr id="showAnswer-area">
	                    <td><p style="min-height:200px;"><%= q.getAnswer().replaceAll("\n", "<br/>") %></p></td>
	                </tr>
	                <tr id="updateAnswer-area" style="display:none;">
	                	<td>
        					<textarea id="updateAnswer" name="answer" class="form-control" rows="10" placeholder="답변 입력" style="resize: none;"><%=q.getAnswer()%></textarea>
       				   	<div align="right" style="margin-top:5px;">
       				   		<button id="updateAnswerBtn" type="button" class="btn btn-info" onclick="updateAnswer();">수정</button>'
       				   		<button type="button" class="btn btn-secondary" onclick="closeUpdateAnswerArea();">취소</button>
       				   </div>
       				  	</td>
	                </tr>
	            </tbody>
        	</table>
        <% } %>

		<!-- 접수 상태일 때 보이는 버튼 (답변X) -->
		<% if(q.getAnswer() == null) { %>
		
			<!-- 관리자의 경우 답변입력창과 답변 작성 버튼이 보임 -->
			<% if(loginUser!= null && loginUser.getUserId().equals("admin")) { %>
		        <form action="<%=contextPath%>/insertAnswer.qna?qno=<%=q.getQnaNo()%>" method="post">
		            <textarea name="answer" class="form-control" rows="10" placeholder="답변 입력" style="resize: none;"></textarea>
		            <div align="right">
		            	<button type="submit" class="btn btn-info" style="margin-top: 5px;">작성</button>
		            </div>
		        </form>
        	<% } %>

			<!-- 해당 글을 쓴 회원일 경우 수정, 삭제 버튼이 보임 -->
			<% if(loginUser!= null && loginUser.getNickname().equals(q.getQnaWriter())) { %>
		        <div align="right">
		            <a href="<%=contextPath%>/updateForm.qna?qno=<%=q.getQnaNo()%>" class="btn btnBlue">수정</a> 
		            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteQnAModal">삭제</button>
		        </div>
	        <% } %>
	        
	        
	    <!-- 답변완료 상태일 때 보이는 버튼 (답변O) -->    
		<% } else {%>
			<!-- 관리자한테만 QNA삭제, 답변수정버튼 보임 -->
			<% if(loginUser!= null && loginUser.getUserId().equals("admin")) { %>
		        <div align="right">
		       		<button type="button" id="showUpdateAnswerAreaBtn" class="btn btn-info" onclick="showUpdateAnswerArea();">답변수정</button>
		            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteQnAModal">삭제</button>
		        </div>
			<% } %>
		<% } %>
       
        
        <div align="center">
			<a href="<%=contextPath%>/list.qna?cpage=1" class="btn btn-secondary">돌아가기</a>
		</div>

    </div>

	<script>
		// 관리자가 답변수정 버튼 클릭할 때 실행되는 함수
		function showUpdateAnswerArea(){
			$("#showAnswer-area").attr("style", "display:none;"); // 기존 답변 내용 숨기기
			$("#updateAnswer-area").attr("style", "display:'';"); // 답변 입력창 보이게 바꿈
			$("#showUpdateAnswerAreaBtn").attr("style", "display:none;"); // 답변수정 버튼 숨기기
		}
		
		function showNewAnswer(){
			$.ajax({
				url : "selectAnswer.qna",
				data : { qno : <%= q.getQnaNo() %>},
				success : function(answer){
					result = '<td><p class="content">' + answer.replaceAll("\n", "<br/>") + '</p></td>';
					$("#showAnswer-area").html(result);
				},
    			error : function(){
    				console.log("답변 가져오기 실패");
    			}
			});
		}
		
	    function updateAnswer(){
	    	$.ajax({
				url : "updateAnswer.qna",
				data : {
					qno : <%= q.getQnaNo() %>,
					answer : $("#updateAnswer").val()
				},
				type : "post",
				success : function(result){
					if(result > 0){
						showNewAnswer();
						closeUpdateAnswerArea();
					} else if(result == -50){
						alert("답변 내용을 입력해주세요.");
					}
				},
    			error : function(){
    				console.log("답변 수정 실패");
    			}
			});
	    }
		
		// 관리자가 취소 버튼 클릭할 때 실행되는 함수
		function closeUpdateAnswerArea(){
			$("#showAnswer-area").attr("style", "display:'';"); // 기존 답변 내용 다시 띄우기
			$("#updateAnswer-area").attr("style", "display:none;"); // 답변 입력창 숨기기
			$("#showUpdateAnswerAreaBtn").attr("style", "display:'';"); // 답변수정 버튼 다시 띄우기
		}
	</script>

    <!-- QnA 삭제 모달 -->
	<div class="modal" id="deleteQnAModal" style="text-align: center;">
		<div class="modal-dialog">
			<div class="modal-content">
                <div class="modal-body">
                    <div style="margin:30px;">
                        <h6>Q&A글을 삭제하시겠습니까?</h6>
                    </div>
                    <div align="center"></div>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                        <a href="<%=contextPath%>/delete.qna?qno=<%=q.getQnaNo()%>" class="btn btn-danger">삭제하기</a>
                    </div>
                </div>
		
			</div>
		</div>
	</div>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>