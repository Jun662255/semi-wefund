<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <style>
        div{
            box-sizing : border-box;
            /*border : 1px solid red;*/
        }
        #outer{
            width : 1000px;
            height : 800px;
            margin : auto;
        }

        /*완료*/
        #successP{
            font-size: 32px;
            font-weight: 500;
        }
        #signUpSuccess{
            width: 300px;
            height: 300px;
            margin: auto;
            margin-top: 100px;
            text-align: center;
        }
        #signUpSuccess>h1{
            text-align: center;
            margin-bottom: -20px;
        }
        #loginBtn{
            width: 250px;
            height: 30px;
            background-color: rgb(247, 217, 58);
            border: none;
            cursor: pointer;
        }
        #PPP{
            font-size: 20px;
        }
    </style>
</head>
<body>
	<%@ include file="../common/header2.jsp" %>
    <div id="outer">

        <div id="signUpSuccess">

            <p id="successP">회원가입 완료</p>
            <p id="PPP">회원가입이 완료되었습니다 :D</p>
            <br>
            <p>WeFun:D에서</p>
            <p>다양한 편딩상품을 만나보세요!</p>
            <br>
            <button id="loginBtn" onclick="login()">로그인하기</button>
            
            
        </div>
        
    </div>
    
    <script>
        function login(){
            location.href = "<%= contextPath %>/loginForm.me"
        }
    </script>
    <%@ include file="../common/footer.jsp" %>
</body>
</html>