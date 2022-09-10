<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.kh.project.model.vo.* , java.util.ArrayList" %>
<%
	Project p = (Project)request.getAttribute("p");
	ArrayList<ProjectAttachment> palist = (ArrayList<ProjectAttachment>)request.getAttribute("palist");
	int totalPrice = (int)request.getAttribute("totalPrice");
	ArrayList<Product> plist = (ArrayList<Product>)request.getAttribute("plist");
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 상세페이지</title>
    <style>
        div{
            box-sizing : border-box;

        }
        /* 전체를 감싸는 div요소 */
        .wrap1{
            width : 1000px;
            height : auto;
            margin : auto;
        }

        /* 크게 세가지 영역 */
        .wrap1 > div{
            width:100%;
        }
        #header{
            height : 10%;
        }

        #footer{
            height : 10%;
        }

        #content {
            height : 90%;
        } 


        /* 더 세부영역 */
        #header > div, #content > div{
            height : 100%;
            float: left;
        }

        /* 각 세부영역의 가로 비율 정해주기*/
        #header_1{
            width: 75%;
        }
        #header_2{
            width : 25%;
        }

        
        #content_1{
            width: 75%;
        }
        #content_2{
            width: 25%;
        }
        #info{
            width: 250px;
            height: 190px;
        }

        #project{
            margin: 5%;
            width: auto;
            height: 100%;
        }

        #optchk{
            width: 250px;
            height: 525px;
        }

        #categori{
            height: 10%;
        }
        #pjTitle{
            height: 15%;
        }
        #pjThumbnail{
            height: 40%;
        }
        #pjContent{
            height: 25%;
            width: 100%;
        }

     

        #project img{
            height: auto;
            width: 100%;
        }
        #pjinfo td{
            width: 70%;
            height: 40px;
        }

        
        table,td,th{border:1px white solid; border-collapse: collapse;  }
        
        td{padding:10px 30px;}
        
        #optchk td{padding:20px 30px;}

        .option{
            height: auto;
            padding: 5px;
            margin:0 auto; /*중앙정렬*/
            transition: all 0.5s; /*0.5초동안 변함*/
        }
        .option:hover{
            height:300px; /*변경할 세로사이즈*/
            background: yellow; /*변경할 배경색*/
            -webkit-transform:scale(1.2);
            -moz-transform:scale(1.2);
            -ms-transform:scale(1.2);	
            -o-transform:scale(1.2);
            transform:scale(1.2);
                
        }
        .button{
            text-decoration: none;
            float: right;
            /*margin-right: 30px;*/
            font-size: 13px;
            border: 1px solid rgb(247, 217, 58);
            border-radius: 15px;
            border-width: 8px;
            background-color: rgb(247, 217, 58);
            color: black;
            box-shadow: 1px 1px 1px 1px gray;
            padding: 5px;
            width: 85px;
            transition: all 0.5s; /*0.5초동안 변함*/
            margin-right: 25px;
        }

        .button:hover{
            height:50px; /*변경할 세로사이즈*/
            background: yellow; /*변경할 배경색*/
            -webkit-transform:scale(1.2);
            -moz-transform:scale(1.2);
            -ms-transform:scale(1.2);
            -o-transform:scale(1.2);
            transform:scale(1.2);

        }
        #pay{
            width: 200px;
            margin-right: 25px;
        }

    </style>
</head>
<body>
    <%@ include file="/views/common/header1.jsp" %>
    
    <script>
         function getURL() {

             var url = '';    // <a>태그에서 호출한 함수인 clip 생성
             var textarea = document.createElement("textarea");
             //url 변수 생성 후, textarea라는 변수에 textarea의 요소를 생성

             document.body.appendChild(textarea); //</body> 바로 위에 textarea를 추가(임시 공간이라 위치는 상관 없음)
             url = window.document.location.href;  //url에는 현재 주소값을 넣어줌
             textarea.value = url;  // textarea 값에 url를 넣어줌
             textarea.select();  //textarea를 설정
             document.execCommand("copy");   // 복사
             document.body.removeChild(textarea); //extarea 요소를 없애줌

             alert("URL이 복사되었습니다.")  // 알림창
         }
     </script>
    
    <div class="wrap1">
        <div id="header">
            <div id="header_1"></div>
            <div id="header_2"></div>
        </div>
        <div id="content">
  
            <div id="content_1">
                <div id="project" style="height: auto;">
                 
                            <h3 id="categori" style="text-align:center;"><%= p.getCategoryName() %></h3>
                            <br><br>
                        
                            <h1 id="pjTitle" style="text-align:center;"><%= p.getProjectName() %></h1>
                            <br><br>
                        
                            <div id="pjThumbnail" style="text-align:center;"><img src="<%= contextPath %>/<%= palist.get(0).getFilePath()+palist.get(0).getChangeName() %>"></div>
                            
                            <% for(int i = 1; i < palist.size(); i++) {  %>
                            	
                                <div id="pjContentImg<%= i %>" style="text-align:center;"><img src="<%= contextPath %>/<%= palist.get(i).getFilePath()+palist.get(i).getChangeName() %>"></div>
          
                            <% } %>
                            
                       
                            <div id="pjContent" style="text-align:center;"  >
                                <p style="font-size: 20px; word-break: keep-all; word-wrap: break-word;">
                                    <%= p.getProjectContent().replaceAll("\n", "<br/>") %>
                                </p>
                            </div>
                       
                          


                </div>
            </div>

            

            <div id="content_2">
                <div id="info">
                    <br><br><br><br><br><br><br><br><br><br>
                   <table id="pjinfo" border="1" width="100%" style="font-size: 16px;" >
                        <tr>
                            <th>작성자</th>
                            <td><%= p.getNickName() %></td>
                        </tr>
                        <tr>
                            <th>목표금액</th>
                            <td><%= p.getGoalAmount() %> 원</td>
                        </tr>
                        <tr>
                            <th>모인금액</th>
                            <td><%= totalPrice  %> 원</td>
                        </tr>
                        <tr>
                            <th>펀딩기간</th>
                            <td><%= p.getEndDate().substring(0,10) %></td>
                        </tr>
                   </table>
      
                </div>
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                
                <div id="optchk" align="">
                    <form action="payform.pj">
                            	<% for(int i = 0; i < plist.size(); i++) { %>
                            	
                                    	 <div class="option" style="height: auto; border: 1px solid rgb(185, 185, 182);" > 
                                             <input type="checkbox" class="pdOption" name="productInfo" value="<%= plist.get(i).getProductName() %>,<%= plist.get(i).getProductPrice() %>"><%= plist.get(i).getProductName() %> + <%= plist.get(i).getProductPrice() %>원
                                         </div>
                                         <br>
                               
                            	<% } %>
                              <br><br><br>
                              <div id="endText" style="display:none; color: red; font-size:15px; margin-bottom:5px;" align="center">종료된 프로젝트입니다</div>
                              <% if(loginUser != null){ %>
                              
                                  <input type="hidden" name="userNo" value="<%= loginUser.getUserNo() %>">
                                  <input type="hidden" name="projectNo" value="<%= p.getProjectNo() %>">
                                  <button  type="submit" id="pay" class="button" disabled>결제</button>
                                    <br><br><br>
                            	<% } %>
                     </form>   
                
                 


                        
                     <form action="like.pj">
                        <table>
                            <tr>
                                    <% if(loginUser != null){ %>
                               
                                        <button type="submit"  class="button">좋아요</button>
                                        
                                        <input type="hidden" name="projectNo" value="<%= p.getProjectNo() %>">
                                        <input type="hidden" name="userNo" value="<%= loginUser.getUserNo() %>">
                                 
                                    <% } %>
                                    <button type="button" class="button" onclick="getURL();">공유하기</button>
                            </tr>
                        </table>
                        <br><br><br>
                    </form>
                    <form action="allow.pj"> 
                        <table>
                            <tr>
                                <% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
                                	<button type="submit" class="button">승인</button>
                                    <input type="hidden" name="projectNo" value="<%= p.getProjectNo() %>">
                                <% } %>
                            </tr>
                    </form>
                	<form action="return.pj">
							<tr>
							  <% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
                                	<button type="submit" class="button">반려</button>
                                    <input type="hidden" name="projectNo" value="<%= p.getProjectNo() %>">
                                <% } %>
							</tr>                		
                	
                	</form>
                        </table>
                
                
                </div>
            </div>
        </div>
        <div id="footer"></div>
    </div>
    
    
    
    
    <script>
        $(function(){
        
        	<% if(p.getStatus().equals("E")) {%>
	            $('#endText').show(); //종료된 프로젝트 안내 텍스트 띄우기
	            $('#pay').hide(); // 결제버튼 숨기기
        	<% } %>
            
            $(".option").click(function(){
                                                     
                    var option = $(this).children().eq(0);
                    var paybtn = $('#pay');
                    console.log(paybtn);

                    if(!option.prop('checked')){
                        option.prop('checked', true)
                    }
                    else{
                        option.prop('checked', false)
                    }

                    if(!option.prop('checked')){
                        paybtn.attr("disabled", true);
                    }else{
                        paybtn.attr("disabled", false);
                    }


            })




        })
    </script>
    <br><br>
    <br clear="both">
               <%@ include file="../common/footer.jsp" %>
</body>
</html>