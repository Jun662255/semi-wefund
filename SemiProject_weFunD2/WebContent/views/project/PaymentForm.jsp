<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int userNo = (int)request.getAttribute("userNo");
	int projectNo = (int)request.getAttribute("projectNo");
	String productNames = (String)request.getAttribute("productNames");
	int payment = (int)request.getAttribute("payment");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <style>
  
        div{
			    
            box-sizing: border-box;
        }
        /* 전체를 감싸는 div */
        .wrap1{
            width : 1000px;
            min-height : 800px;
            margin: auto;
        }
        /*#header, #content, #footer*/
        .wrap1>div{
            width : 100%;            
        }
        #content {
            height : 60%;
        }
        /* content 내부의 세분화된 영역들 */
        #content_1{
            width:100%;
        }
    
        /*#content_1, #content_2*/
        #content > div{
            height: 100%;
            display: inline-block;
            /*float: left;*/
        }
        #Requests{
            border: 1px solid black;
            resize: none;
        }
        #submit{
            height:100px;
            width: 220px;
            margin-left: 40%;
        }
        #title{
            font-size: larger;
            font-weight: bolder;
            text-align: center;
        }
        #content{
            display: block;
            
        }
        table,td,th{border:1px #000 solid; border-collapse: collapse;  }
        td{padding:10px 30px;}

        

        input[type=text]{
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        textarea {
            width: 100%;
            height: 150px;
            padding: 12px 20px;
            box-sizing: border-box;
            border: 2px solid #ccc;
            border-radius: 4px;
            background-color: #f8f8f8;
            resize: none;
        }
        
        

    </style>

<title>결제 폼</title>
</head>
<body>
    <%@ include file="../common/header2.jsp" %>
    <div class="wrap1">
<br><br>
        <div id="content">
            <div id="content_1">
                <form action="pay.pj" method="post">
                        <div id="title">
                            <p>결제페이지</p>
                        </div>
                        <div id="content">

                            <table border="1" width="100%" id="payinfo">
                            	<tr>
                            		<td hidden>
                            			<input type="hidden" name="userNo" value="<%= userNo %>">
                            			<input type="hidden" name="projectNo" value="<%= projectNo %>">
                            			<input type="hidden" name="productNames" value="<%= productNames %>">
                            			<input type="hidden" name="totalPayment" value="<%= payment %>">
                            		</td>
                            	</tr>
                                <tr>
                                    <th colspan="2">
                                        <p>주문결제</p>
                                    </th>
                                </tr>
                                <tr>
                                    <th colspan="2">주문자 정보</th>
                                </tr>
                                <tr>
                                    <td colspan="2"><input type="text" name="orderName" id="" placeholder="주문자명"></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><input type="text" name="orderEmail" id="" placeholder="주문자이메일"></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><input type="text" name="orderPhone" id="" placeholder="주문자 핸드폰번호"></td>
                                </tr>
                                <tr>
                                    <th colspan="2">받는사람 정보</th>
                                </tr>
                                <tr>
                                    <td colspan="2"><input type="text" name="receiverName" id="" placeholder="수령자명"></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><input type="text" name="receiverPhone" id="" placeholder="연락처"></td>
                                </tr>
                            <tr>
                                <td><input type="text" name="addressNo" placeholder="우편번호"></td>
                                <td><button>우편번호찾기</button></td>
                            </tr>
                            <tr>
                             	<td colspan="2"><input type="text" name="address"  placeholder="상세주소" ></td>
                            </tr>
                            <tr>
                                <td colspan="2"><textarea name="requests" id="Requests"  placeholder="배송요청사항(선택)"></textarea></td>
                            </tr>
                            <tr>
                                <th colspan="2">개인정보 수집 및 동의</th>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <p>상품 주문 및 배송을 위해 위에 입력된 개인정보를 수집합니다. 수집한 개인정보는<br>
                                        주문과 배송이외의 목적으로는 사용하지 않습니다. <br>
                                        개인정보의 수집 및 이용에 대한 동의를 거부할수 있으며, 이 경우 상품 주문이 어려울 수 있습니다.</p>
                                    </td>
                                </tr>
                                <tr>
                                    <td align="center" colspan="2"><input type="checkbox" name="" id="" required>동의합니다.</td>
                                </tr>
                            </table>

                            <br><br><br>
                            <table border="1" width="100%">
                                <tr><th colspan="5">결제정보</th></tr>
                                <tr>
                                	<th>선택 상품</th>
                                	<td colspan="5"><%= productNames %></td>
                                </tr>
                                <tr>
                                    <th >총상품가격</th>
                                    <td colspan="4"><%= payment %>원</td>
                                </tr>
                                <tr>
                                    <th>배송비</th>
                                    <td colspan="4">3000원</td>
                                </tr>
                                <tr>
                                    <th>총결제금액</th>
                                    <td colspan="4"><%= payment + 3000 %>원</td>
                                </tr>
                                <tr>
                                    <th>결제방법</th>
                                    <td><input type="radio" name="pay">계좌이체</td>
                                    <td><input type="radio" name="pay">신용/체크카드</td>
                                    <td><input type="radio" name="pay">무통장입금</td>
                                    <td><input type="radio" name="pay">휴대폰</td>
                                </tr>
                            </table>
                            <br><br><br>
                            <button type="submit" id="submit">결제하기</button>
                        </div>
                        </form>
                    </div>
        </div>
        <div id="footer"></div>
    </div>
		
           <%@ include file="../common/footer.jsp" %>
           

</body>
</html>