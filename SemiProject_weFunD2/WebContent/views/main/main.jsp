<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.main.model.vo.SelectProjectList, java.util.Date" %>
<%
	ArrayList<SelectProjectList> list = (ArrayList<SelectProjectList>)request.getAttribute("list");
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WeFun:D</title>
<style>
    /*imageslide*/
    #imageslide{
        position: relative;
        width: 1000px;
        height: 400px;
        text-align: center;
        margin: auto;
        margin-top: 20px;
    }

    .imgSlide{
        width : 1000px; 
        height : 400px;     
    }
    
    /*product*/

    #product{
        width: 1000px;
        height: 1000px;
        margin: auto;
    }
    
    .productList{
            width: 100%;
            height: 30%;
            margin-top: 20px;
            margin-left: 24px;
        }
    .productList > div{float: left;}
    .products{
            width: 23%;
            height: 100%;
            text-align: center;
            margin-right: 10px;
            margin-top: 10px;
            cursor: pointer;
            border: 1px solid black;
            border-radius:10px;
    }
    #countT{
        font-size: 20px;
        margin-left: 40px;
        font-weight: 500;
    }
    #allP{
        text-decoration: none;
        float: right;
        margin-right: 30px;
        font-size: 13px;
        border: 1px solid rgb(247, 217, 58);
        border-radius: 15px;
        border-width: 8px;
        background-color: rgb(247, 217, 58);
        color: black;
        box-shadow: 1px 1px 1px 1px gray;
    }
    #thumeImg{margin-top: 10px; border-radius:10px;}
    #title{
        font-size: 18px; 
        font-weight: 500; 
        overflow:hidden;
        text-overflow:ellipsis;
        white-space:nowrap;
    }
    #seller{
        text-align: left; 
        margin-left: 30px; 
        font-size: 15px;
        margin-bottom: 10px;
        margin-top: 10px;
    }
    #percent{
        float: left;
        margin-left: 30px; 
        margin-top: 5px; 
        color: rgb(247, 217, 58); 
        font-weight: 700;
        margin-bottom: 8px;
    }
    #deadline{
        margin-top: 5px; 
        margin-right: 30px; 
        float:right;
        margin-bottom: 8px;
        font-size: 16px;
    }

    /*프로그래스바*/
    #progress {
        appearance: none;
    }
    #progress::-webkit-progress-bar {
        background:rgb(233, 233, 233);
        border-radius:10px;
        height: 5px;
    }
    #progress::-webkit-progress-value {
        border-radius:10px;
        background-color: rgb(247, 217, 58);
    }
    
    

        
</style>
</head>
<body>
	<%@ include file="../common/header1.jsp" %>
	<script>

        $(function(){

            $("#slide2").click(function(){

                $('#slide2A').attr("href","<%= contextPath %>/detail.pj?pno=11");

            });

            $("#slide3").click(function(){

                $('#slide3A').attr("href","<%= contextPath %>/detail.pj?pno=35");

            });

            $("#slide4").click(function(){

                $('#slide4A').attr("href","<%= contextPath %>/detail.pj?pno=2");

            });

        });

    </script>
	
	<div id="imageslide">
 
        <div><img class="imgSlide" src="./resources/img/mainSlide1.png"></div>
        <div><a id="slide2A" href=""><img class="imgSlide" id="slide2" src="./resources/img/mainSlide2.png"></a></div>
        <div><a id="slide3A"><img class="imgSlide" id="slide3" src="./resources/img/mainSlide3.png"></a></div>
        <div><a id="slide4A"><img class="imgSlide" id="slide4" src="./resources/img/mainSlide4.png"></a></div>

    </div>

    <script>

        // 자동 이미지 슬라이드
        var slideIndex = 0;
        var imgSlide = document.getElementsByClassName("imgSlide");
        slide();

        function slide() {
            
            var i;

            for(i = 0; i < imgSlide.length; i++) {
                imgSlide[i].style.display = "none";
            }

            slideIndex++;

            if(slideIndex > imgSlide.length) {slideIndex = 1}

            imgSlide[slideIndex-1].style.display = "block";
            
            setTimeout(slide, 3000); // Change image every 2 seconds
        }

    </script>

    <br><br>
    
	<div id="product">
        <br><br>
        
        <span id="countT">많이 조회했어요 :D</span>
        <a href="<%= contextPath %>/list.pj?cpage=1" id="allP">전체 프로젝트 보기</a>
        
        <div class="productList">
        	
        	<% if(list != null) { %>
        		
        		<% for(SelectProjectList s : list) { %>
        		
        			<%
        				String achievementRate = String.format("%.1f", s.getRate());
        				
        			%>
        
		            <div class="products">
						<input type="hidden" value="<%= s.getProjectNo() %>"> 
		                <img src="<%= s.getThumbnailImg() %>" style="width: 200px; height: 140px;" id="thumeImg">
	                    <div style="width: 200px; margin-left: 15px;"><p id="title"><%= s.getProjectName() %></p></div>
	                    <p id="seller"><%= s.getNickname() %></p>
	                    <p id="percent"><%= achievementRate %>%</p>
	                    <p id="deadline"><%=  s.getdDay() %>일 남음</p>
	                    <progress id="progress" value="<%= achievementRate %>" max="100"></progress>
		
		            </div>
		            
		            <% } %>
            
            <% } else { %>
            	프로젝트가 없습니다.
            <% } %>
            
        </div>

    </div>

    <script>
        $(function(){

            $(".products").click(function(){

                var pno = $(this).children().eq(0).val();
                location.href = "<%= contextPath %>/detail.pj?pno=" + pno;

            });

        });
    </script>
    
	<br><br><br><br><br><br><br><br><br><br>
    
    <%@ include file="../common/footer.jsp" %>
	
</body>
</html>