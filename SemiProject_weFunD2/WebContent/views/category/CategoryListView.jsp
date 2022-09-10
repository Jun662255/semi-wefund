<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.kh.category.model.vo.Category, java.util.Date" %>
<%
	/* list라는 키값으로 전달 */
	ArrayList<Category> list = (ArrayList<Category>)request.getAttribute("list");
	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>카테고리 화면</title>
	<style>
        div{
            box-sizing : border-box;
            /*border : 1px solid red;*/
        }
        #outer{
            width : 1000px;
            height : 1000px;
            margin : auto;
            
        }
		/*product*/
        #product{
            width: 1000px;
            height: 1000px;
            margin: auto;
        }

        #cateP{
            font-size: 23px;
            font-weight: 500;
            margin-top: 30px;
            margin-left: 40px;
            margin-bottom: 0px;
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
	
    <div id="outer">
        
		<div id="product">

            <p id="cateP"></p>

            <div class="productList">
                
				<% if(list != null) { %>

                    <% for(Category c : list) { %>

                    	<%
                    		float ps = c.getPaymentSum();
                    		float ga = c.getGoalAmount();
                    		float ar = (ps / ga) * 100;
                    		
                    		String achievementRate = String.format("%.1f", ar);
                    		
                    	%>

                        <script>

                            $("#cateP").text("<%= c.getCategoryName()%>");

                        </script>

	                    <div class="products">
							<input type="hidden" value="<%= c.getProjectNo() %>">
	                        <img src="<%= c.getThumbnailImg() %>" style="width: 200px; height: 140px;" id="thumeImg">
	                        <div style="width: 200px; margin-left: 15px;"><p id="title"><%= c.getProjectName() %></p></div>
	                        <p id="seller"><%= c.getNickname() %></p>
	                        <p id="percent"><%= achievementRate %>%</p>
	                        <p id="deadline"><%=  c.getdDay() %>일 남음</p>
	                        <progress id="progress" value="<%= achievementRate %>" max="100"></progress>

	                    </div>
	                    
                	<% } %>
                <% } else {%>
                    해당 카테고리에 상품이 없습니다.
                <% } %>

            </div>

        </div>

	</div>
    <br><br><br><br><br><br><br><br><br><br>
    <%@ include file="../common/footer.jsp" %>
    
    <script>
        $(function(){

            $(".products").click(function(){

                var pno = $(this).children().eq(0).val();
                location.href = "<%= contextPath %>/detail.pj?pno=" + pno;

            });

        });
    </script>
</body>
</html>