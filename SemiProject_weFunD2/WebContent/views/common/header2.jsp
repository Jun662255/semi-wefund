<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.member.model.vo.Member" %>    
<%
	Member loginUser = (Member)session.getAttribute("loginUser");

	String alertMsg = (String)session.getAttribute("alertMsg");
	
	String contextPath = request.getContextPath();

    request.getParameter("categoryNo");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.4/dist/web/static/pretendard.css" />
    <title>Document</title>
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <style>
        div{
            box-sizing : border-box;
            /*border : 1px solid red;*/
            
        }
        .wrap{
            width : 1000px;
            height : 80px;
            margin : auto;
        }
        .warp > div{width : 100%;}

        /*헤더*/
        #header{height : 100%; margin-bottom: 10px;}
        #header > div{height : 100%; float : left;}
        #header_1{width : 15%; text-align: center;}
        #header_2{width : 30%; position : relative;}
        #header_3{width : 55%; text-align: right;}
        #header_3 a{text-decoration: none;color: black;}
        #etc{margin-top: 50px; width: 100%; height: 40px;}
        #userImg{width: auto; height: auto;}
		*{font-family: Pretendard;}
        
        /*로고*/
        #logo{width: 100px; margin-top: 30px;}

        /*검색창*/
        #search_form {
            width: 100%;
            height: 35%;
            position: absolute;
            right: 0;
            top : 40px;
            left: 0;
            bottom : 0;
        }
        #search_form>div{
            float:left;
        }
        #search_text{
            width:220px;
            height: 35px;
        }
        #search_btn{
            width: 23px;
            height: 23px;
            margin-top: 6px;
            margin-left: 5px;
            opacity: 0.8;
        }
        #search_form input{
            box-sizing: border-box;
            width:100%;
            height: 100%;
        }
        input:focus {outline:none;}
        #searchI{
            border-top: 0;
            border-left: 0;
            border-right: 0;
        }
        
        
        /*category*/
        #category{
            width:1000px; 
            height: 40px;
            margin: auto;
            margin-top: 20px;
        }
        #category > div{
            height : 100%;
            float : left;
        }
        #categoryHover{
            width: 10%; 
            text-align: right; 
            float: left;
        }
        #categoryHover a{
            display: inline-block; 
            font-size: 20px; 
            margin-top: 12px;
        }
        #categoryList{
            width: 85%; 
            text-align: left;
            display: none;
        }
        #categoryList li{
            list-style-type : none; 
            float: left; 
            width : auto; 
            height: 100%;
            margin-right: 20px;
        }
        #categoryList a{
            text-decoration: none; 
            color: black;
            width: auto;
        }
        #categoryHover>img{
            width: 15px; 
            height: 15px;
        }
        #categoryList>ul>li>a:hover{
            color: rgb(232, 215, 66);
        }

        /*자동완성시 배경색 없애기*/
        input:-webkit-autofill {
            -webkit-box-shadow: 0 0 0 1000px #ffffff inset;
        }
        
    </style>
</head>
<body>


    <div class="wrap">
        <div id="header">
            <div id="header_1">
            	<a href="<%= contextPath %>">
            		<img src="./resources/img/WeFunD.png" id="logo" >
            	</a>
                
            </div>
            <div id="header_2">
                
            </div>
            
            <% if (loginUser == null) { %>
	            <div id="header_3">
	                <div id="etc">
	                    <a href="<%= contextPath %>/list.rv?cpage=1">리뷰게시판</a>&nbsp;&nbsp;&nbsp;| &nbsp;
	                    <a href="<%= contextPath %>/loginForm.me">로그인</a>&nbsp;
	                    <a href="<%= contextPath %>/signUpForm.me">회원가입</a>&nbsp;
	                </div>
	            </div>
            <% } else if(loginUser.getUserId().equals("admin")) { %>
            	<!-- 관리자화면 마이페이지->QnA페이지 -->
                <div id="header_3">
                    <div id="etc">
                    <a href="<%= contextPath %>/list.rv?cpage=1">리뷰게시판</a>&nbsp;&nbsp;&nbsp;| &nbsp;
                        <a href="<%= contextPath %>/adminlist.qna?cpage=1">
                            <img src="./resources/img/user.png" id="userImg" style="width: 15px; height:15px;"> &nbsp;
                        </a>
                        <%= loginUser.getNickname() %> 님&nbsp;&nbsp;&nbsp;
                        <a href="<%= contextPath %>/logout.me">로그아웃</a>
                    </div>
                </div>
            
            <% } else { %>
	            <!-- 로그인 성공 시 화면 -->
	            <div id="header_3">
	                <div id="etc">
	                    <a href="<%= contextPath %>/list.rv?cpage=1">리뷰게시판</a>&nbsp;&nbsp;&nbsp;| &nbsp;
	                    <a href="<%= contextPath %>/EnrollForm.pj">프로젝트 업로드</a>&nbsp;&nbsp;&nbsp;
	                    
	                    <a href="<%= contextPath %>/myPage.me?userNo=<%= loginUser.getUserNo() %>">
	                    <img src="./resources/img/user.png" id="userImg" style="width: 15px; height:15px;">&nbsp
	                    <%= loginUser.getNickname() %> 님</a>&nbsp;&nbsp;&nbsp;
	                    <a href="<%= contextPath %>/logout.me">로그아웃</a>
	                </div>
	            </div>
            <% } %> 
		</div>
        
        </div>

    <script>
    
		var msg = "<%= alertMsg %>";
		
		var loginForm = document.getElementById("login-form");
     
		console.log(msg);
     
		if(msg != "null"){
			alert(msg);
          <% session.removeAttribute("alertMsg"); %>
		}
     	
	</script>
    
</body>
</html>