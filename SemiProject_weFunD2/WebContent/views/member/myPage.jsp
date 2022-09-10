<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int likesCount = (int)request.getAttribute("likesCount");
	int supportCount = (int)request.getAttribute("supportCount");
	int projectCount = (int)request.getAttribute("projectCount");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
    <style>
        /*
        div{
        border: 1px solid red;
        box-sizing: border-box;
        }
        */
        /* 메뉴스타일 */
        .outer{
        	width: 1200px;
        	margin-left: 8%;
        }
        .myPageNavigator{
            width: 280px;
            height: 600px;
            float: left;
            margin-left: 15%;
            margin-right: 2%;
            margin-top: 4%;
        }
        .myPageNavigator label:hover {
            font-size: 26px;
            color: rgb(63, 74, 224);
        }
        .myPageNavigator a:hover {
            font-size: 26px;
            color: rgb(63, 74, 224);
        }
        .myPageNavigator div {
            margin-bottom: 25px;
            margin-top: 25px;
        }
        .title {
            font-size: xx-large;
            width: 100%;
            font-weight: bold;
        }
        
        a {
            text-decoration: none !important;
        }
        /*
        @media ( max-width : 1810px ) {
            .myPageNavigator {
                display: none;
                
            }
        }
        */
        .myPageNavigator a {
	        color: black;
        }
        input[id*="answer"] {
	        display: none;
        }
        input[id*="answer"]+label {
	        display: block;
	        cursor: pointer;
	        position: relative;
	        color: black;
        }
        input[id*="answer"]+label+div {
	        max-height: 0;
	        transition: all 0.5s;
	        overflow: hidden;
        }
        input[id*="answer"]:checked+label+div {
	        max-height: 120px;
        }
        input[id*="answer"]+label img{
            position: absolute;
            top: 50%;
            right: 10px;
            width: 20px;
            height: 20px;
            margin-top: -10px;
            display: inline-block;
            background: 0 0 no-repeat;
        }
        input[id*="answer"]:checked+label img{
            background-position: 0 -30px;
        }

        /* 본문 스타일 */
        #myPageContent{
            width: 700px;
            height: 600px;
            margin-top: 4%;
            float: left;
        }
        #myPageContent1{
            height: 40%;
            width: 280px;
        }
        #myPageContent2{
            height: 40%;
            width: 410px;
        }
        #myPageContent3{
            height: 60%;
            width: 700px;
        }
        #myPageContent > div{
            float: left;
        }
        #myPage-form table{margin: auto;}
        #mypage-form input{margin: 5px;}
    </style>
<title>마이페이지 메인화면</title>
</head>
<body>

	<%@ include file = "../common/header2.jsp" %>
	<%
		String userId = loginUser.getUserId();
		String userName = loginUser.getUserName();
		String nickName = loginUser.getNickname();
		String phone = loginUser.getPhone();
		int userNo = loginUser.getUserNo();
	%>
	<div class="outer">
    <!-- 왼쪽 메뉴바 -->
    <div class="myPageNavigator">
        <p class="title">마이페이지</p>
        <hr>
        <div class="accordion">
            <input type="checkbox" id="answer01">
            <label for="answer01">회원정보<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKKs6OP36GlHnJCLBRA3bwO1RYfLy9VLUesg&usqp=CAU"></label>
            <div>
                <a href="<%= contextPath %>/myPage.me?userNo=<%= userNo %>"> - 개인정보 수정</a>
                <br />
                <a href="<%= contextPath %>/myPage.me?userNo=<%= userNo %>"> - 회원탈퇴</a>
            </div>
        </div>
        <div class="accordion">
            <input type="checkbox" id="answer02">
            <label for="answer02">활동내역(서포터)<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKKs6OP36GlHnJCLBRA3bwO1RYfLy9VLUesg&usqp=CAU"></label>
            <div>
                <a href="<%= contextPath %>/myLikeListView.me?userNo=<%= userNo %>&pjpage=1&select=전체"> - 관심프로젝트</a>
                <br />
                <a href="<%= contextPath %>/myReviewListView.me?userNo=<%= userNo %>&rvpage=1"> - 나의 리뷰조회</a>
                <br />
                <a href="<%= contextPath %>/mySupportListView.me?userNo=<%= userNo %>&spage=1&select=전체"> - 후원 현황조회</a>
            </div>
        </div>
        <div class="accordion">
            <input type="checkbox" id="answer03">
            <label for="answer03">활동내역(메이커)<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKKs6OP36GlHnJCLBRA3bwO1RYfLy9VLUesg&usqp=CAU"></label>
            <div>
                <a href="<%= contextPath %>/myProjectListView.me?userNo=<%= userNo %>&mppage=1&select=전체"> - 나의프로젝트</a>
            </div>
        </div>
        <div class="accordion">
            <input type="checkbox" id="answer04">
            <label for="answer04">고객센터<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKKs6OP36GlHnJCLBRA3bwO1RYfLy9VLUesg&usqp=CAU"></label>
            <div>
                <a href="<%= contextPath %>/enrollForm.qna"> - 문의하기</a>
            </div>
        </div>
        
    </div>

    <!-- 오른쪽 마이페이지 메인화면 -->
    <div id="myPageContent">
        <div id="myPageContent1" class="container">
            <table align="center" style="margin-top: 21%">
                <tr>
                    <td><img src="https://cdn.discordapp.com/attachments/980671798452580373/989080402079678484/user.png" width="80px" height="80px"><br></td>
                </tr>
                <tr>
                    <td><b><%= userName %></b>님 환영합니다</td>
                </tr>
                
            </table>
        </div>
        <div id="myPageContent2" class="container">
            <table class="table table-bordered" align="center" style="margin-top: 15%;">
                <tr align="center">
                    <th onclick="location.href='<%= contextPath %>/mySupportListView.me?userNo=<%= userNo %>&spage=1&select=전체'">후현 현황</th>
                    <th onclick="location.href='<%= contextPath %>/myProjectListView.me?userNo=<%= userNo %>&mppage=1&select=전체'">나의 프로젝트</th>
                    <th onclick="location.href='<%= contextPath %>/myLikeListView.me?userNo=<%= userNo %>&pjpage=1&select=전체'">찜</th>
                </tr>
                <tr align="center">
                    <td onclick="location.href='<%= contextPath %>/mySupportListView.me?userNo=<%= userNo %>&spage=1&select=전체'">
                    <%= supportCount %>
                    </td>
                    <td onclick="location.href='<%= contextPath %>/myProjectListView.me?userNo=<%= userNo %>&mppage=1&select=전체'">
                    <%= projectCount %>
                    </td>
                    <td onclick="location.href='<%= contextPath %>/myLikeListView.me?userNo=<%= userNo %>&pjpage=1&select=전체'">
       				<%= likesCount %>
                    </td>
                </tr>
            </table>
        </div>      
 
        <div id="myPageContent3">
            <br>
            <form action="<%= contextPath %>/update.me" method="post" id="myPage-form">
            	<input type="hidden" name="userNo" value="<%= userNo %>">
                <table  style="margin-top: 1%">
                    <tr>
                        <td>아이디 &nbsp;</td>
                        <td><input type="text" name="userId" value="<%= userId %>" readonly required></td>
                    </tr>
                    <tr>
                        <td>이름 &nbsp;</td>
                        <td><input type="text" name="userName" value="<%= userName %>" readonly required></td>
                    </tr>
                    <tr>
                        <td>닉네임 &nbsp;</td>
                        <td><input type="text" name="nickName" value="<%= nickName %>" required>&nbsp;</td>
                        <td><button type="button" onclick="nickCheck();" class="btn btn-sm btn-secondary">중복확인</button></td>
                    </tr>
                    <tr>
                        <td>전화번호 &nbsp;</td>
                        <td><input type="text" name="phone" value="<%= phone %>"></td>
                    </tr>
                </table>
                <br>

                <div align="center">
	                <button type="submit" class="btn btn-sm btn-secondary">변경</button>
	                <button type="button" class="btn btn-sm btn-warning" style="color:white" data-toggle="modal" data-target="#updatePwdForm">비밀번호 변경</button>
	                <button type="button" class="btn btn-sm btn-danger" data-toggle="modal" data-target="#deleteMemberForm">회원탈퇴</button>
                </div>
            </form>
        </div>
    </div>
    
    <!-- 회원탈퇴 Modal -->
	<div class="modal" id="deleteMemberForm">
		<div class="modal-dialog">
		<div class="modal-content">
	
			<!-- Modal Header -->
			<div class="modal-header">
			<h4 class="modal-title">회원탈퇴</h4>
			<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
	
			<!-- Modal body -->
			<div class="modal-body">
				<form action="<%= contextPath %>/deleteMember.me" method="post">

					<input type="hidden" name="userId" value="<%= userId %>">
					<h6>탈퇴하시면 모든 정보가 사라집니다</h6><br>
					<h6>탈퇴하시겠습니까?</h6>
					<br>

					<button type="submit" class="btn btn-sm btn-danger">회원탈퇴</button>
					<button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal">취소</button>
				</form>
			</div>

		</div>
		</div>
    </div>
    
    <!-- 비밀 번호 변경 Modal -->
	<div class="modal" id="updatePwdForm">
		<div class="modal-dialog">
		<div class="modal-content">
	
			<!-- Modal Header -->
			<div class="modal-header">
			<h4 class="modal-title">비밀번호 변경</h4>
			<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
	
			<!-- Modal body -->
			<div class="modal-body">
				<form action="<%= contextPath %>/updatePwd.me" method="post" id="form1">

					<!-- 현재 비밀번호, 변경할 비밀번호 , 변경할 비밀번호 확인(재입력) -->
					
					<!-- 확실하게 주인을 판별할 수 있는 id 값도 같이 넘겨줌 -->
					<input type="hidden" name="userId" value="<%= userId %>">
					<input type="hidden" name="userNo" value="<%= userNo %>">
					
					<table>
						<tr>
							<td>현재 비밀번호</td>
							<td ><input type="password" name="userPwd" required></td>
						</tr>
						<tr>
							<td>변경할 비밀번호</td>
							<td><input type="password" id="userPwd2" name="updatePwd" maxlength="12" required></td>
                            <label>영문 대소문자, 숫자 6~12자로 입력해주세요</label>
                        </tr>
						<tr>
							<td>변경할 비밀번호 재입력</td>
							<td><input type="password" id="userPwd3" name="checkPwd" required></td>
						</tr>
					</table>
					
					<br>

					<button type="button" class="btn btn-sm btn-secondary" id ="changePWD" onclick ="return validatePwd();">비밀번호 변경</button>
				</form>

				<script>
					function validatePwd(){
						
                        // 비밀번호 유효성 체크
                        var userPwd2 = $("#userPwd2").val();
                        var userPwd3 = $("#userPwd3").val();
                        var pwdCheckRegExp = /^[a-zA-Z]+[a-zA-Z0-9]{5,12}$/;
                        console.log(userPwd2);
                        console.log(userPwd3);
                        
                        if(!pwdCheckRegExp.test(userPwd2)){
                            alert('유효한 비밀번호가 아닙니다. 다시 입력해주세요');
                            //userPwd.select();
                            console.log(userPwd2);
                            return false;
                        }
                        	// 비밀번호 일치 체크
                        else if(userPwd2 != userPwd3){
                            alert("비밀번호가 일치하지 않습니다");
                            console.log(userPwd3);
                            return false;
                        } 
                        else {
                        	$("form#form1").submit();
                
                        }
				    }
				</script>

			</div>

		</div>
		</div>
    </div>
    
      
    <script>
    	function nickCheck(){
    		
    		// 닉네임을 인풋태그에서 값을 뽑아옴
    		var $nickName = $("#myPage-form input[name=nickName]");
    		
    		console.log("클릭");
    		
    		// ajax로 컨트롤러 요청 
    		$.ajax({
    			url: "nickCheck.me",
    			data : {checkNick : $nickName.val()},
    			success : function(result){
    				if(result == "NNNNN"){	// 중복닉네임 == 사용불가
	    				alert("이미 존재하거나 탈퇴한 회원의 닉네임 입니다.")
    					console.log(result);
    					// 재입력
    					$nickName.focus();
    				}
    				else {	// 중복 X == 사용가능
    					   console.log(result);
    					// 알림창 => window.confirm()
    					if(confirm("사용가능한 닉네임 입니다. 사용하시겠습니까?")){ // 사용 하겠다는 대답 받은 경우

    						// 닉네임 값이 이후에 변경이 불가능하도록 readonly
    						$nickName.attr("readonly", true);
    					}
    					else {	// 닉네임 사용 안함 => 다시 선택
    						$nickName.focus();
    					}
    				}
    			},
    			error : function(){
    				console.log("닉네임 중복체크 비동기요청 실패")
    			}
    		});
    	}
    
    </script>
	</div>
	

<br><br><br><br>
<br><br><br><br><br><br><br><br><br><br clear="both">
   
    <%@ include file="../common/footer.jsp" %>
</body>
</html>