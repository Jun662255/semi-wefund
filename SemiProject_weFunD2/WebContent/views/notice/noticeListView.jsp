<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.notice.model.vo.Notice, com.kh.common.model.PageInfo" %>
<% 
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	
	// 페이징바 만들 때 필요한 변수 미리 세팅
	int currentPage = pi.getCurrentPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	int maxPage = pi.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항목록페이지</title>
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
	
	/* 공지사항 목록 */
	table>thead,tbody{text-align: center;}
	.title{text-align: left;}
	.title>a{color: black;}
	
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
		color: white;
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
            <a href="<%=contextPath%>/list.not?cpage=1" class="nav-selected">공지사항</b></a>
            <a href="<%=contextPath%>/list.qna?cpage=1">QnA</a>
        </div>

        <table class="table">
            <thead class="thead-light">
                <tr>
                    <th width="70">글번호</th>
                    <th width="480">제목</th>
                    <th width="100">작성자</th>
                    <th width="120">작성일</th>
                    <th width="80">조회수</th>
                </tr>
            </thead>
            <tbody>
            	<% if(list.isEmpty()) { %>
            		<tr>
            			<td colspan="5">공지사항 글이 없습니다.</td>
            		</tr>
            	<% } else { %>
         		    <% for(Notice n : list) { %>
	            		<tr>
		                    <td><%= n.getNoticeNo() %></td>
		                    <td class="title"><a href="<%=contextPath%>/detail.no?nno=<%=n.getNoticeNo()%>">[공지사항]&nbsp;<%= n.getNoticeTitle() %></a></td>
		                    <td><%= n.getNoticeWriter() %></td>
		                    <td><%= n.getNoticeDate().substring(0,10) %></td>
		                    <td><%= n.getCount() %></td>
	                	</tr>
            		<% } %>
            	<% } %>
            </tbody>
        </table>


		<!-- 관리자만 글작성 버튼이 보임-->
		<!-- 관리자페이지의 공지사항 작성 페이지로 이동-->
        <% if(loginUser!= null && loginUser.getUserId().equals("admin")) { %>
            <div align="right">
            	<a href="<%=contextPath%>/enrollForm.no" class="btn btnBlue">글작성</a>
        	</div>
        <% } %>


        <div align="center" class="paging-area">
		
			<% if(currentPage != 1) { %> <!-- 페이징바에서 <를 담당 -->
				<button class="btn btn-sm btnYellow" onclick="location.href='<%= contextPath %>/list.not?cpage=<%= currentPage - 1 %>'">&lt;</button>
			<% } %>
			
			<% for(int i = startPage; i <= endPage; i++ ) { %>
				<% if(i != currentPage) { %>
					<button class="btn btn-sm btnYellow" onclick="location.href='<%= contextPath %>/list.not?cpage=<%= i %>'"><%= i %></button>
				<% } else {%>
					<button class="btn btn-sm btnYellow" disabled><%= i %></button>
				<% } %>
			<% } %>
			
			<% if(currentPage != maxPage && maxPage != 0) { %> <!-- 페이징바에서 >를 담당 -->
				<button class="btn btn-sm btnYellow" onclick="location.href='<%= contextPath %>/list.not?cpage=<%= currentPage + 1 %>'">&gt;</button>
			<% } %>
			
		</div>

    </div>
    
    <%@ include file="../common/footer.jsp" %>
</body>
</html>