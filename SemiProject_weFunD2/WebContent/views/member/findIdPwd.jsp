<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
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
        #login{
            width: 350px;
            height: 400px;
            text-align: center;
            margin: auto;
            margin-top: 100px;
        }

        /*findId*/
        #findP{
            font-size: 32px;
            font-weight: 500;
        }
        #outer{
            width : 1000px;
            height : 800px;
            margin : auto;
            
        }
        #findIdD{
            width: 350px;
            height: 400px;
            text-align: center;
            margin: auto;
            margin-top: 100px;
        }
        #userName, #phone, #userId, #findIdBtn, #findPwBtn, #loginBtn, #userPwd1, #userPwd2, #setPwBtn{
            width: 230px;
            height: 30px;
        }
        #userName, #phone, #userId, #userPwd1, #userPwd2{
            border-top: 0;
            border-left: 0;
            border-right: 0;
        }
        #findIdBtn, #findPwBtn, #setPwBtn, #loginBtn{
            margin-top: 10px;
            background-color: rgb(247, 217, 58);
            border: none;
            cursor: pointer;
        }
        #findIdBtn:hover{
            opacity: 0.8;
        }
        #findPwBtn:hover{
            opacity: 0.8;
        }
        #setPwBtn{
            margin-top: 0;
        }
        #setPwBtn:hover{
            opacity: 0.8;
        }
        #rePwd{
            margin-bottom: 10px;
        }
        b{
            font-size: 20px;
        }

        /*tab*/
        input[type="radio"]{display:none;}
        input[type="radio"]:checked + label{
            border-bottom: 2px solid black;
            color: black;
        }
        label{
            display: inline-block;
            height: 40px;
            text-align: center;
            font-size: 20px;
            cursor: pointer;
            padding-top: 10px;
            border-bottom: 2px solid lightgray;
            color: lightgray;
        }
        #findIdLabel{
            width: 130px;
        }
        #findPwdLabel{
            width: 130px;
        }
        .findContent{
            margin: 0 auto; 
            display: none;
            margin-top: 30px;
        }
        input[id="findId"]:checked ~ .findIdContent{display: block;}
        input[id="findPwd"]:checked ~ .findPwdContent{display: block;}
		#pwdCheckP2, #pwdCheckP{
            font-size: 12px;
            color: red;
        }
    </style>
</head>
<body>

	<%@ include file="../common/header2.jsp" %>

	<div id="outer">

        <div id="findIdD">

            <p id="findP">아이디/비밀번호 찾기</p>
            
            <div class="tabContent">
                <input type="radio" name="tabmenu" id="findId" onclick="window.location.reload()" checked>
                <label for="findId" id="findIdLabel">아이디 찾기</label><!--
                --><input type="radio" name="tabmenu" id="findPwd"><!--
                --><label for="findPwd" id="findPwdLabel">비밀번호 찾기</label>
            
                <div class="findContent findIdContent">
                    <input type="text" name="userName" id="userName" placeholder="이름" required>
                    <br><br>
                    <input type="text" name="phone" id="phone" placeholder="전화번호" required>
                    <br><br>
                    <button type="button" id="findIdBtn" onclick="findIdF();">찾기</button><br><br>
                </div>
                    
                <div class="findContent findPwdContent">
                    <input type="text" name="userId" id="userId" placeholder="아이디"><br><br>
                    <button id="findPwBtn" onclick="findPwdF();">다음</button><br><br>
                </div>
                
            </div>

            <div id="findFooter">
                
            </div>

    </div>

    <script>

		// tabmenu 클릭시
		    $("input:radio[id=findPwd]").click(function(){
		        $("#userId").val("");
		    });
			
		    $("input:radio[id=findPwd]").click(function(){
	            $("#findFooter").hide();
	        });
		    
        // 아이디 찾기
        function findIdF(){
            var userName = $("#userName").val();
            console.log(userName);
            var phone = $("#phone").val();
            console.log(phone);

            if(userName == "" || phone == ""){
                alert("회원정보를 입력하세요");
            }
            else{
                $.ajax({
                    url : "findUserId.me",
                    type : "post",
                    data : {
                            userName : userName,
                            phone : phone
                    },
                    success : function(result){
                        console.log(result);
                        if(result == "null"){

                            alert("해당하는 아이디가 없습니다");
                            $("#findForm")[0].reset();
                        }
                        else{
                            $(".findIdContent").html("<p>회원님의 아이디는<br><br><br>"+"<b>"+result+"</b>"+" 입니다.</p>");
                            $("#findFooter").html("<button id="+"loginBtn"+" onclick="+"location.href='<%= contextPath %>/loginForm.me'"+">로그인</button>"); 
                        }
                    },
                    error : function(){
                        console.log("실패");
                    }
                })
            } 
        }

        // 비밀번호 재설정
        function findPwdF(){
            // 1) 아이디로 회원검색

            var userId = $("#userId").val();
            console.log(userId);

            $.ajax({
                url : "findPwd.me",
                type : "post",
                data : {userId : userId},
                success : function(result){
                    if(result == $("#userId").val()){
                        $(".findPwdContent").html("<p id="+"rePwd"+">비밀번호 재설정</p><br><input type="
                                                    +"password"+" name="+"userPwd" +" " 
                                                    + "id="+ " "+"userPwd1"+" placeholder="+"새&nbsp;비밀번호"+" required><br><br>"
                                                    +"<input type="+"password"+" name="
                                                    +"userPwd" +" " + "id="+ " "+"userPwd2"+" placeholder="+"새&nbsp;비밀번호&nbsp;확인"+" required><br><br>"
                                                    +"<p id="+ " " +"pwdCheckP2"+"></p>"
                                                    +"<p id="+" "+"pwdCheckP"+"></p>"
                                                    +"<button id="+"setPwBtn"+">재설정</button><br><br>"
                                                    );
                    
                        // 비밀번호 체크
                        $("#userPwd2").keyup(function(){
                            var userPwd1 = $("#userPwd1").val();
                            var userPwd2 = $("#userPwd2").val();
                            var pwdCheckP = $("#pwdCheckP");

                            if(userPwd1 != "" && userPwd2 != ""){
                                if(userPwd1 == userPwd2){
                                    pwdCheckP.html("");
                                    $("#userPwd1").keyup(function(){ // userPwd 수정하면 userPwd2 값 없애기
                                        $("#userPwd2").val("");
                                    })
                                }
                                else{
                                    pwdCheckP.html("비밀번호가 일치하지 않습니다.");
                                }
                            }
                            else{
                                pwdCheckP.html("");
                            }
                        });

                        // 비밀번호 유효성 검사
                        $("#userPwd1").keyup(function(){
                            var userPwd1 = $("#userPwd1").val();
                            var pwdCheckP2 = $("#pwdCheckP2");
                            var pwdCheckRegExp = /^[a-zA-Z]+[a-zA-Z0-9]{5,12}$/;

                            if(!pwdCheckRegExp.test(userPwd1)){
                                pwdCheckP2.html("영문 대소문자, 숫자 6~12자");
                                if(userPwd1 == ""){
                                    pwdCheckP2.html("");
                                }
                            }
                            else
                            {
                                pwdCheckP2.html("");
                            }
                        });

                        $("#setPwBtn").click(function(){

                            var userPwd1 = $("#userPwd1").val();
                            var userId = result;
                            console.log(userId);

                            if($("#pwdCheckP").text() == "" && $("#pwdCheckP2").text() == ""){
                                
                                $.ajax({
                                    url : "setUserPwd.me",
                                    type : "post",
                                    data : {userPwd1 : userPwd1, userId : userId},
                                    success : function(result2){

                                        if(result2 > 0){
                                            alert("비밀번호가 변경되었습니다.");
                                            window.location = "<%= contextPath %>/loginForm.me";
                                        }
                                        else{
                                            console.log("비밀번호 변경 실패");
                                        }

                                    },
                                    error : function(){
                                        console.log("실패");
                                    }

                                });
                               
                            }
                            else{
                                alert("다시 입력해주세요.");
                            }

                        });
                    
                    }
                    else{
                        alert("아이디가 존재하지 않습니다.");
                        var userId = $("#userId").val("");
                    }
                },
                error : function(){
                    console.log("실패");
                }
            });
        }
       
    </script>

    <br><br><br><br><br><br><br><br><br><br>
        
    <%@ include file="../common/footer.jsp" %>

</body>
</html>