<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.ArrayList, com.kh.project.model.vo.Project, com.kh.common.model.PageInfo" %>
<%@ page import = " java.text.DecimalFormat" %>
<%
	ArrayList<Project> list = (ArrayList<Project>)request.getAttribute("list");
	
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
<title>프로젝트 리스트</title>
<link rel="stylesheet" href="/lib/w3.css">
   <style>
        div{
            box-sizing : border-box;
            
     
        }

        .wrap{
            width : 1000px;
            height : 80px;
            margin : auto;
        }

        .warp > div{width : 100%;}
        #header{height : 100%;}
        

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



        /*footer*/

        #footer{
            height: 130px;
        }

        #footer > div{
            height : 100%;
            float : left;
        }

        #footer1{width: 60%;}
        #footer2{ width: 20%;}
        #footer2{ width: 20%;}
        
       
    

    </style>
</head>
<body>
	<%@ include file="/views/common/header1.jsp" %>

    <div class="wrap">
        <div id="header">
         
        </div>

    



        <div id="product">

      

            <div class="productList">
               <% if(! list.isEmpty()) { %>
               	
               		<% for(Project p : list) { %>
               	<div class="products">
                    <input type="hidden" value="<%= p.getProjectNo() %>"> 
               		<%
        				String achievementRate = String.format("%.1f", p.getRate());
               			
        			%>
                    <img src="<%= p.getTitleImg() %>" id="thumeImg"   style="width: 200px; height: 140px;">
                    <div style="width: 200px; margin-left: 15px;"><p id="title"><%= p.getProjectName() %></p></div>
                    <p id="seller"><%= p.getNickName() %></p>
                  	<p id="percent"><%= achievementRate %>%</p>
                  	<p id="deadline"><%=  p.getdDay() %>일 남음</p>
	                <progress id="progress" value="<%= achievementRate %>" max="100"></progress>
  
                </div>
               		<% } %>
               	<% } else { %>
               		<h1>등록된 프로젝트가 없습니다.</h1>
              	<% } %>
               

            </div>

            
        </div>
		<script>
            $(function(){

                $(".products").click(function(){

                    var pno = $(this).children().eq(0).val();

                    location.href = "<%= contextPath %>/detail.pj?pno=" + pno;


                })


            })
        </script>
		
        <div align="center" class="paging-area">
            <% if (currentPage != 1) { %>
            <button onclick="location.href='<%= contextPath%>/list.pj?cpage=<%= currentPage -1 %>'"> &lt; </button>
            <% } %>

            <% for(int i = startPage; i <= endPage; i++){ %>
                <% if(i != currentPage) { %>
                <button onclick="location.href='<%= contextPath %>/list.pj?cpage=<%= i %>'"><%= i %></button>
                <% }else { %>
                <button class="btn btn-sm btn-primary" disabled><%= i %></button>
                <% } %>
            <% } %>
            <% if(currentPage != maxPage) { %>
            <button onclick="location.href='<%= contextPath%>/list.pj?cpage=<%= currentPage +1 %>'"> &gt; </button>
            <% } %>
        </div>




        <div id="footer">

            <div id="footer1"> 
                <p id="p1">
                </p>
                
            </div>
            <div id="footer2"> 
                <p id="p1">
                    
                </p>
                
            </div>
            <div id="footer3"> 
                <p id="p1">
                   
                </p>
                
            </div>
            

        </div>


       
    </div>
    
</body>
</html>