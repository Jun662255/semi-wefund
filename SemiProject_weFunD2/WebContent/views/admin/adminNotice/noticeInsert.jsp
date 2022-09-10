<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>게시판 - 공지작성</title>


    <%@ include file="/views/common/adminMenu.jsp" %>

    <style>

      #content,#noticeTitle {
        resize: none;
        width: 100%;
        font-size: 20px
        
      }
      #submit {
        width: 100px;
        height: 50px;
        margin-left: 90%;
      }


    </style>
  </head>
  <body>
   <% if(loginUser!=null && loginUser.getUserId().equals("admin")) {%>
    <div id="maincontent">
      <p class="title">게시판 - 공지작성</p>
      <hr />
      <div>
        <form
          action="<%= contextPath %>/insert.no"
          id="createform"
          method="post"
        >
          <table width="100%">
            <tr>
              <td>
                <input
                  id="noticeTitle"
                  type="text"
                  placeholder="제목을 입력하세요"
                  required
                  name="title"
                />
              </td>
            </tr>

            <tr>
              <td width="100%">
                <textarea
                  name="content"
                  id="content"
                  rows="20"                 
                  placeholder="내용을 입력해주세요"
                  required
                ></textarea>
              </td>
            </tr>
          </table>
          <div id="insertNotice">
            <button type="submit" id="submit" class="btn  btnYellow">작성</button>
          </div>
        </form>
      </div>
    <% } else { %>
    <% } %>
    </div>
    <br clear="both">
	<%@ include file="/views/common/footer.jsp"%>
  </body>
</html>
