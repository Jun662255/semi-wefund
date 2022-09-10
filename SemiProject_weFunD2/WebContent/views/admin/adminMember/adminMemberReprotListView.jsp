<%@page import="com.kh.admin.adminMember.model.vo.Report"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.kh.common.model.PageInfo, com.kh.member.model.vo.Member, java.util.ArrayList"%>
<%
	ArrayList<Report> list = (ArrayList<Report>) request.getAttribute("list");
PageInfo pi = (PageInfo) request.getAttribute("pi");

int currentPage = pi.getCurrentPage();
int startPage = pi.getStartPage();
int endPage = pi.getEndPage();
int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>회원관리 - 신고내역</title>

<style>

</style>
</head>
<body>
	<%@ include file="/views/common/adminMenu.jsp"%>
	<% if(loginUser!=null && loginUser.getUserId().equals("admin")) {%>
	
	<div id="maincontent">
		<p class="title">회원관리 - 신고내역</p>
		<hr>
		<br> <br>
		<div>
			<table class="table">
				<tr>
					<th width="150px">댓글 번호</th>
					<th width="600px">글 제목</th>
					<th width="150px">댓글 작성자</th>
					<th width="200px">작성일</th>
				</tr>
				<tr>
					<th>회원 정지</th>
					<th>신고내역</th>
					<th>신고자</th>
					<th>신고일자</th>
				</tr>

				<% if (list.isEmpty()) { %>
					<tr>
						<td colspan="4">신고내역이 존재하지 않습니다</td>
					</tr>
				<% } else { %>
					<% for (Report r : list) { %>
						<tr>
							<td><%=r.getReplyNo()%></td>
							<td><a href="<%= contextPath %>/detail.rv?rno=<%=r.getReviewNo()%>"><%=r.getReviewTitle()%></a></td>
							<td><%=r.getReplyWriter()%></td>
							<td><%=r.getReplyDate().substring(0, 16)%></td>
						</tr>
						<tr>
							<td>
								<button class="btn-modal btn btn-dark" data-toggle="modal"
									data-target="#myModal" data-id="<%=r.getReplyWriter()%>,<%= r.getReplyNo()%>">회원정지</button>
							</td>
							<td><%=r.getReplyContent()%></td>
							<td><%=r.getReplyReporter()%></td>
							<td><%=r.getReportDate().substring(0, 16)%></td>
						</tr>
					<% } %>
				<% } %>
			</table>
		</div>
	</div>
	<!-- The Modal -->
	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title" style="text-align: center;">
						<br>해당 회원을 정지하겠습니까?<br>
					</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<form action="<%= contextPath %>/suspension.mem" method="post">
						<input type="hidden" class="body-contents" id="nickname" name="nickname">
						<input type="hidden" class="body-contents" id="replyNo" name="replyNo">
						<button type="submit" class="btn btn-danger">정지</button>
					</form>
					
					<form action="<%= contextPath %>/check.mem" method="post">
						<input type="hidden" class="body-contents" id="replyNo" name="replyNo">
					<button type="submit" class="btn btn-danger">확인</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>

	$(".btn-modal").click(function(){
		var data = $(this).data('id');
		var nickname = data.split(',');		
    	$("#nickname").val(nickname[0]);
    	$("#replyNo").val(nickname[1]);
	console.log(data);
	console.log(nickname[0]);
	
	});
	

  </script>
	
	<div class="selectPage">
		<div>
			<% if (currentPage != 1) { %>
				<button onclick="location.href='<%=contextPath%>/adminRepolist.mem?cpage=<%=currentPage - 1%>'" class="btn  btnYellow">&lt;</button>
			<% } %>

			<% for (int i = startPage; i <= endPage; i++) { %>
				<% if (i != currentPage) { %>
					<button onclick="location.href='<%=contextPath%>/adminRepolist.mem?cpage=<%=i%>'" class="btn  btnYellow"><%=i%></button>
				<% } else { %>
					<button style="background: rgb(255,240,110)" class="btn  btnYellow"><%=i%></button>
				<% } %>
			<% } %>

			<% if (currentPage != maxPage && 0 != maxPage) { %>
				<button onclick="location.href='<%=contextPath%>/adminRepolist.mem?cpage=<%=currentPage + 1%>'" class="btn  btnYellow">&gt;</button>
			<% } %>
		</div>
	<% } else  { %>	
		
	<% } %>
		
	</div>
	<br clear="both">
	<%@ include file="/views/common/footer.jsp"%>
	
</body>


</html>