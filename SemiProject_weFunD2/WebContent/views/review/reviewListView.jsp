<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.review.model.vo.Review, com.kh.common.model.PageInfo" %>
<% 
	ArrayList<Review> list = (ArrayList<Review>)request.getAttribute("list");
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
<title>리뷰글목록</title>
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
	.reviewList-area{
		width: 100%;
		overflow:hidden;
		height:auto;
	}
	.reviewList{
		width: 100%;
        height: 370px;
        margin-top: 20px;
        margin-left: 24px;
	}
	.reviewList> div{float:left;}
	.review{
        width: 23%;
        height: 100%;
        display: inline-block;
        margin-right: 10px;
        margin-bottom:20px;
        cursor: pointer;
        border: 1px solid black;
        border-radius:10px;
        padding: 10px;
    }
    .review-top-area>p, table{
    	margin:0px;
    	margin-top: 8px;
    }
	.review-top-area:hover, .review-bottom-area:hover{
		cursor: pointer;
		opacity: 0.8;
	}

	#reviewImg{
		width: 100%;
		height: 160px;
		border-radius:10px;
	}
	#review-title{
		font-weight: bold;
		font-size: 15px;
		height: 45px;
		overflow: hidden;
		text-overflow: ellipsis;
		word-break: break-word;
		display: -webkit-box;
   		-webkit-line-clamp: 2;
   		-webkit-box-orient: vertical;
	}
	.review-writer-date{width: 100%;}
	#review-profileImg, #project-thumbnail{
		width: 40px;
		height:40px;
	}
	#review-writer, #review-date{
		color: rgb(85, 85, 85);
		font-size: 14px;
	}
	#review-writer{font-weight: bold;}
	.review-project{
		width: 100%;
		table-layout: fixed;
		border-collapse:collapse;
	}
	#project-title{
		font-weight: bold;
		font-size : 13px;
		text-overflow: ellipsis;
		overflow: hidden;
	}
	#review-rate{font-size : 14px;}
	
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
        <h3 class="page-title">리뷰게시판</h3>
        <hr>
        
        <div class="reviewList-area">
        	<div class="reviewList">
			<% if(!list.isEmpty()) {%>
				
				<% for(Review r : list) { %>
					<div class="review">
						<div class="review-top-area">
							<input type="hidden" value="<%= r.getReviewNo() %>">
							<% if(r.getReviewImg() != null) { %>
								<img src="<%=contextPath%>/<%=r.getReviewImg()%>" id="reviewImg">
							<% } else { %>
								<img src="./resources/img/reviewDefaultImg.png" id="reviewImg">
							<% } %>
							<p id="review-title"><%= r.getReviewTitle() %></p>
							<table class="review-writer-date">
								<tr><td rowspan="2" id="review-profileImg"><img src="./resources/img/user.png" width="100%" height="100%"></td><td id="review-writer"><%= r.getReviewWriter() %></td></tr>
								<tr><td id="review-date"><%=r.getReviewDate().substring(0,10) %></td></tr>
							</table>
							<p id="review-count" align="right">조회수: <%= r.getCount() %></p>
						</div>
						
						<div class="review-bottom-area">
							<table class="review-project">
								<input type="hidden" value="<%= r.getProjectNo() %>">
								<tr style="border-top:1px solid lightgray;">
									<td rowspan="2" id="project-thumbnail"><img src="<%=contextPath%>/<%=r.getProjectThumbnail() %>" width="100%" height="100%"></td>
									<td id="project-title"><nobr><%= r.getProjectName() %></nobr></td>
								</tr>
								<tr><td id="review-rate">별점 : <%=r.getRate() %>점</td></tr>
							</table>
						</div>
					</div>
				<% } %>
				
			<% } else { %>
				등록된 게시글이 없습니다.
			<% } %>
			</div>
		</div>

		<!-- 리뷰글작성버튼 회원한테만 보임 (관리자, 비회원X) -->
        <% if(loginUser != null && !loginUser.getUserId().equals("admin")) { %>
            <div align="right" style="margin-right:20px;">
                <form action="<%=contextPath %>/enrollForm.rv" method="post">
                    <input type="hidden" name="userNo" value=<%= loginUser.getUserNo() %>>
                    <button type="submit" class="btn btnBlue">글작성</button>
                </form>
            </div>
        <% } %>

		<!-- 페이지 이동 버튼 -->
        <div align="center" class="paging-area">
			<% if(currentPage != 1) { %> <!-- 페이징바에서 <를 담당 -->
				<button class="btn btn-sm btnYellow onclick="location.href='<%= contextPath %>/list.rv?cpage=<%= currentPage - 1 %>'">&lt;</button>
			<% } %>
			
			<% for(int i = startPage; i <= endPage; i++ ) { %>
			
				<% if(i != currentPage) { %>
					<button class="btn btn-sm btnYellow" onclick="location.href='<%= contextPath %>/list.rv?cpage=<%= i %>'"><%= i %></button>
				<% } else {%>
					<button class="btn btn-sm btnYellow" disabled><%= i %></button>
				<% } %>
			<% } %>
			
			<% if(currentPage != maxPage && maxPage != 0) { %> <!-- 페이징바에서 >를 담당 -->
				<button class="btn btn-sm btnYellow" onclick="location.href='<%= contextPath %>/list.rv?cpage=<%= currentPage + 1 %>'">&gt;</button>
			<% } %>
		</div>

    </div>

  	<script>
		$(function(){
			$(".review-top-area").click(function(){
				var rno = $(this).children().eq(0).val();
				location.href = "<%= contextPath %>/detail.rv?rno=" + rno;
			});
			
			$(".review-bottom-area").click(function(){
				var pno = $(this).find("input").eq(0).val();
				location.href = "<%= contextPath %>/detail.pj?pno=" + pno;
			});
		});
	</script>
	
	<%@ include file="../common/footer.jsp" %>
</body>
</html>