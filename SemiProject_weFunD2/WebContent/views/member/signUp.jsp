<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
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

        ::placeholder{
            font-size: 13px;
        }
        #idP{
            margin-bottom: 0px;
            margin-top: 10px;
        }
        p{
            margin-bottom: 0px;
            margin-top: 20px;
        }
        

        /*회원가입*/
        
        #signUp{
            width: 300px;
            height: 650px;
            margin: auto;
            margin-top: 100px;
        }
        #signUpP{
            font-size: 32px;
            font-weight: 500;
        }
        #signUp>h1{
            text-align: center;
            margin-bottom: -20px;
        }
        #signUpForm{
            margin-top: 50px;
        }
        *#signUpForm{
            margin-left: 25px;
        }
        #signUpForm>p{
            font-size: 12px;
        }
        #userId, #nickname{
            width: 160px;
            height: 30px;
            border-top: 0;
            border-left: 0;
            border-right: 0;
        }
        #idCheck, #nicknameCheck{
            width: 70px;
            height: 30px;
            margin-left: 10px;
            background-color: rgb(247, 217, 58);
            border: none;
            cursor: pointer;
            font-size: 13px;
        }
        #userPwd, #userPwd2{
            width: 110px;
            height: 30px;
            margin-right: 10px;
            border-top: 0;
            border-left: 0;
            border-right: 0;
        }
        #userName{
            width: 240px;
            height: 30px;
            border-top: 0;
            border-left: 0;
            border-right: 0;
        }
        #phone{
            width: 240px;
            height: 30px;
            margin-right: 10px;
            border-top: 0;
            border-left: 0;
            border-right: 0;
        }
        #signUpBtn{
            width: 250px;
            height: 30px;
            background-color: rgb(247, 217, 58);
            border: none;
            cursor: pointer;
            font-size: 13px;
        }
        #idCheckP, #pwdCheckP2, #pwdCheckP, #nameCheckP, #nicknameCheckP, #phoneCheckP{
            color: red;
            margin-top: 10px;
        }


    </style>
</head>
<body>
	<%@ include file="../common/header2.jsp" %>
    
    <div id="outer">

        <div id="signUp">

            <p id="signUpP" style="text-align: center;">회원가입</p>

            <form action="<%= contextPath %>/signUp.me" id="signUpForm" method="post">

                <p id="idP">아이디</p>
                <input type="text" name="userId" id="userId" maxlength="12" required>
                <input type="button" id="idCheck" onclick="idCheckF();" value="중복확인"></input>
                <p id="idCheckP"></p>
                
                <p>비밀번호 &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;  &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;비밀번호 확인</p>
                <input type="password" name="userPwd" id="userPwd" maxlength="12" required>
                <input type="password" name="userPwd2" id="userPwd2" maxlength="12" required><br>
                <p id="pwdCheckP2"></p>
                <p id="pwdCheckP"></p>
                
                <p>이름</p>
                <input type="text" name="userName" id="userName" required>
                <p id="nameCheckP"></p>

                <p>닉네임</p>   
                <input type="text" name="nickname" id="nickname" required>
                <input type="button" id="nicknameCheck" onclick="nicknameCheckF();" value="중복확인"></input>
                <p id="nicknameCheckP"></p>

                <p>전화번호</p>
                <input type="text" name="phone" id="phone" required><br>
                <p id="phoneCheckP"></p>
                <br>
                &nbsp;<input type="checkbox" required>&nbsp;<span style="font-size: 15px;">WeFun:D 이용약관 동의</span> &nbsp;&nbsp;
                <a href="" data-toggle="modal" data-target="#myModal" style="font-size: 15px; color:rgb(63, 74, 224)">이용약관</a>
                <br><br>
                <input type="submit" id="signUpBtn" value="제출하기"></input>
            </form>
            
        </div>


        <!-- The Modal -->
        <div class="modal" id="myModal">
            <div class="modal-dialog">
                <div class="modal-content">
            
                    <!-- Modal Header -->
                    <div class="modal-header">
                    <h4 class="modal-title">WeFunD 이용약관</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
            
                    <!-- Modal body -->
                    <div class="modal-body">
                        <h4>제1조 목적</h4>
                        <br>
                        위펀드는 다양한 분야에 걸친 창작 프로젝트들을 통해 창작자와 후원자를 연결하고 있습니다. 회사의 주된 서비스는 창작 프로젝트의 후원을 위한 플랫폼 제공입니다. 이 약관은 회사가 운영하는 사이트 WeFunD에서 제공하는 모든 서비스를 이용함에 있어 회사와 회원의 권리와 의무, 책임 사항 및 회원의 서비스 이용 절차에 관한 사항을 규정함을 목적으로 합니다.게시글을 삭제합니다
                    </div>
            
                    <!-- Modal footer -->
                    <div class="modal-footer">
                    <button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal">확인</button>
                    </div>
            
                </div>
            </div>
        </div>


        <script>

            // 아이디 중복체크
            function idCheckF(){
                    var userId = $("#userId").val();
                    $.ajax({
                        url : "idCheck.me",
                        type : "post",
                        data : {userId : userId},
                        success : function(result){
                            if(result == 0){ // 이미 존재하는 아이디
                                alert("사용중인 아이디입니다.");
                                $("#userId").val("");
                            }
                            else if(result == 2){
                                alert("아이디를 입력하세요.");
                            }
                            else{ // 사용 가능한 아이디
                                alert("사용가능한 아이디입니다");
                                $("#idCheck").attr("disabled", true);
                                $("#userId").keyup(function(){
                                    $("#idCheck").attr("disabled", false);
                                });
                            }
                        },
                        error : function(){
                            console.log("실패");
                        }
                    })
                }

            // 닉네임 중복체크
            function nicknameCheckF(){
                var nickname = $("#nickname").val();
                $.ajax({
                    url : "nicknameCheck.me",
                    type : "post",
                    data : {nickname : nickname},
                    success : function(result){
                        if(result == 0){
                            alert("사용중인 닉네임입니다.");
                            $("#nickname").val("");
                        }
                        else if(result == 2){
                            alert("닉네임을 입력하세요.");
                        }
                        else{
                            alert("사용가능한 닉네임입니다.");
                            $("#nicknameCheck").attr("disabled", true);
                            $("#nickname").keyup(function(){
                                $("#nicknameCheck").attr("disabled", false);
                            });
                        }
                    },
                    error : function(){
                        console.log("실패");
                    }
                })
            }

            $(function(){
                
                // 비밀번호 체크
                $("#userPwd2").keyup(function(){
                    var userPwd = $("#userPwd").val();
                    var userPwd2 = $("#userPwd2").val();
                    var pwdCheckP = $("#pwdCheckP");

                    if(userPwd != "" && userPwd2 != ""){
                        console.log(userPwd);
                        console.log(userPwd2);
                        if(userPwd == userPwd2){
                            pwdCheckP.html("");
                            $("#userPwd").keyup(function(){ // userPwd 수정하면 userPwd2 값 없애기
                                $("#userPwd2").val("");
                            })
                        }
                        else{
                            console.log("일치하지않음");
                            pwdCheckP.html("비밀번호가 일치하지 않습니다.");
                        }
                    }
                    else{
                        pwdCheckP.html("");
                    }
                });
                
                // 아이디 유효성 체크
                $("#userId").keyup(function(){
                    var userId = $("#userId").val();
                    var idCheckP = $("#idCheckP");
                    var idCheckRegExp = /^[a-zA-Z]+[a-zA-Z0-9]{5,12}$/;

                    if(!idCheckRegExp.test(userId)){
                        idCheckP.html("영문 대소문자, 숫자 6~12자");
                        $("#idCheck").attr("disabled", true);

                        if(userId == ""){
                            idCheckP.html("");
                            $("#idCheck").attr("disabled", false);
                        }
                    } 
                    else{
                        idCheckP.html("");
                        $("#idCheck").attr("disabled", false);
                    }

                });

                // 비밀번호 유효성 체크
                $("#userPwd").keyup(function(){
                    var userPwd = $("#userPwd").val();
                    var pwdCheckP2 = $("#pwdCheckP2");
                    var pwdCheckRegExp = /^[a-zA-Z]+[a-zA-Z0-9]{5,12}$/;

                    if(!pwdCheckRegExp.test(userPwd)){
                        pwdCheckP2.html("영문 대소문자, 숫자 6~12자");
                        if(userPwd == ""){
                            pwdCheckP2.html("");
                        }
                    }
                    else
                    {
                        pwdCheckP2.html("");
                    }

                });

                // 이름 유효성 체크
                $("#userName").keyup(function(){
                    var userName = $("#userName").val();
                    var nameCheckP = $("#nameCheckP");
                    var nameCheckRegExp = /^[가-힣]+$/;

                    if(!nameCheckRegExp.test(userName)){
                        nameCheckP.html("한글만 입력할 수 있습니다.");
                        
                        if(userName == ""){
                            nameCheckP.html("");
                        }
                    }
                    else{
                        console.log("성공");
                        nameCheckP.html("");
                    }

                });

                // 닉네임 유효성 체크
                $("#nickname").keyup(function(){
                    var nickname = $("#nickname").val();
                    var nicknameCheckP = $("#nicknameCheckP");
                    var nicknameCheckRegExp = /^[가-힣]{2,5}$/;

                    if(!nicknameCheckRegExp.test(nickname)){
                        nicknameCheckP.html("2~5글자의 한글만 입력할 수 있습니다.");
                        $("#nicknameCheck").attr("disabled", true);
                        
                        if(nickname == ""){
                            nicknameCheckP.html("");
                            $("#nicknameCheck").attr("disabled", false);
                        }
                    }
                    else{
                        nicknameCheckP.html("");
                        $("#nicknameCheck").attr("disabled", false);
                    }
                });

                // 전화번호 유효성 체크
                $("#phone").keyup(function(){
                    var phone = $("#phone").val();
                    var phoneCheckP = $("#phoneCheckP");
                    var phoneCheckRegExp = /^010\d{4}\d{4}$/;
                    
                    if(!phoneCheckRegExp.test(phone)){
                        phoneCheckP.html("전화번호가 양식에 맞지 않습니다.");
                        if(phone == ""){
                            phoneCheckP.html("");
                        }

                    }
                    else{
                        phoneCheckP.html("");
                    }
                    
                });


                // 회원가입버튼클릭
                $("#signUpBtn").click(function(){
                    // 중복버튼이 disabled이고
                    // 비어있는칸이없고
                    // 조건 경고 멘트가 모두 없으면 회원가입가능 

                    var userId = $("#userId").val();
                    var userPwd = $("#userPwd").val();
                    var userPwd2 = $("#userPwd2").val();
                    var userName = $("#userName").val();
                    var nickname = $("#nickname").val();
                    var phone = $("#phone").val();

                    console.log($("#idCheck").attr("disabled"));

                    if($("#idCheck").attr("disabled") == "disabled" && $("#nicknameCheck").attr("disabled") == "disabled"){
                        if(!userId == "" && !userPwd == "" && !userPwd2 == "" && !userName == "" && !nickname == ""  && !phone == ""){
                            if($("#idCheckP").text()=="" && $("#nameCheckP").text()=="" && $("#pwdCheckP").text()=="" && $("#pwdCheckP2").text()=="" && $("#nicknameCheckP").text()=="" && $("#phoneCheckP").text()==""){
                                return true;
                            }else{
                                alert("조건을 확인해주세요.");
                                return false;
                            }
                        }
                        return false;
                    }
                    else{
                        alert("아이디 또는 닉네임 중복확인");
                        return false;
                    }

                })
                
            });

        </script>
        
    </div>
    <%@ include file="../common/footer.jsp" %>
</body>
</html>