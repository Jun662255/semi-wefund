<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.qna.model.vo.Qna, com.kh.common.model.PageInfo" %>
<% 
	ArrayList<Qna> list = (ArrayList<Qna>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA목록페이지</title>
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
	
	/* nav영역 */
	.nav-area{margin-bottom: 5px;}
	.nav-area>a{
		text-decoration: none;
		font-size: 18px;
		color: black;
	}
	.nav-area>.nav-selected{
		font-weight: bold;
		font-size: 25px;
		color: rgb(63, 74, 224);;
	}
	
	/* qna목록 */
	table>thead,tbody{text-align: center;}
	.title{text-align: left;}
	.title:hover{
		cursor: pointer;
		text-decoration:underline;
	}
	.title>a{color: black;}
	.answered{color: rgb(63, 74, 224);}
	
	/* 버튼 색상 */
	.btnBlue{
		color: white;
		background-color: rgb(63, 74, 224);
	}
	.btnBlue:hover{
        color:white;
        background-color: rgb(35, 46, 194);
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
	
	 <div class="container">
        <br>
        <h3 class="page-title">고객센터</h3>

        <div class="nav-area">
            <a href="<%=contextPath%>/list.not?cpage=1">공지사항</a>
            <a href="<%=contextPath%>/list.qna?cpage=1" class="nav-selected">QnA</a>
        </div>

        <table class="table">
            <thead class="thead-light">
                <tr>
                    <th width="70">글번호</th>
                    <th width="480">제목</th>
                    <th width="100">작성자</th>
                    <th width="120">작성일</th>
                    <th width="80">처리상태</th>
                </tr>
            </thead>
            <tbody>
            	<% if(list.isEmpty()) { %>
            		<tr>
            			<td colspan="5">등록된 문의 글이 없습니다</td>
            		</tr>
            	<% } else { %>
            		<% for(Qna q : list) { %>
	            		<tr>
		                    <td><%= q.getQnaNo() %></td>
		                    <td class="title"><%= q.getQnaTitle() %></td>
		                    <td><%= q.getQnaWriter() %></td>
		                    <td><%= q.getQnaDate().substring(0, 10) %></td>
		                    <% if(q.getAnswer() == null) { %>
		                    	<td>접수</td>
		                    <% } else { %>
		                    	<td><span class="answered">답변완료</span></td>
		                    <% } %>
	                	</tr>
            		<% } %>
            	<% } %>
            </tbody>
        </table>

		<script>
			$(document).on("click", ".title", function(){
				var qno = $(this).siblings().eq(0).text();
				var qnaWriter = $(this).siblings().eq(1).text();
				
				// 로그인 안 했을 경우
   				<% if(loginUser == null) { %>
   					alert("로그인 후 열람 가능합니다.");
   					location.href="<%=contextPath%>/loginForm.me";
   				// 로그인 했을 경우
   				<% } else { %>
   					if(qnaWriter == "<%=loginUser.getNickname()%>" || "<%=loginUser.getUserId()%>" == "admin") {
   						location.href = "<%=contextPath%>/detail.qna?qno=" + qno;
   					} else {
   						alert("본인 문의글만 열람 가능합니다.");
   					}
   				<% } %>
			});
		</script>

		<!-- 회원만 글작성 버튼이 보이게끔-->
        <% if(loginUser != null) { %>
            <div align="right">
            	<a href="<%=contextPath %>/enrollForm.qna" class="btn btnBlue">글작성</a>
        	</div>
        <% } %>
        
        
        <div align="center" class="paging-area">
		
			<% if(currentPage != 1) { %> <!-- 페이징바에서 <를 담당 -->
				<button class="btn btn-sm btnYellow" onclick="location.href='<%= contextPath %>/list.qna?cpage=<%= currentPage - 1 %>'">&lt;</button>
			<% } %>
			
			<% for(int i = startPage; i <= endPage; i++ ) { %>
			
				<% if(i != currentPage) { %>
					<button class="btn btn-sm btnYellow" onclick="location.href='<%= contextPath %>/list.qna?cpage=<%= i %>'"><%= i %></button>
				<% } else {%>
					<button class="btn btn-sm btnYellow" disabled><%= i %></button>
				<% } %>
			<% } %>
			
			<% if(currentPage != maxPage && maxPage != 0) { %> <!-- 페이징바에서 >를 담당 -->
				<button class="btn btn-sm btnYellow" onclick="location.href='<%= contextPath %>/list.qna?cpage=<%= currentPage + 1 %>'">&gt;</button>
			<% } %>
			
		</div>

    </div>
    
	<%@ include file="../common/footer.jsp" %>
</body>
</html>