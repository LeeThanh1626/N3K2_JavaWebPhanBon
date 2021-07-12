<%-- 
    Document   : login
    Created on : Jun 29, 2021, 11:57:29 PM
    Author     : Dell 7450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./Allproduct/css/index.css">
    </head>
    <body style="overflow-y: scroll;
          overflow-x: hidden;">
        <section>
            <%@include file="../header.jsp" %> 
        </section>
        <section>
            <h1>Đăng Nhập</h1>
            <form id="regForm" modelattribute="User" action="./loginProcess.html" method="post">
                
                <div>
                    <label for="uname"><b>Phone Number: </b></label>
                    <input type="text" placeholder="Nhập tên số điện thoại" name="phone" required>
                </div>
                <div >
                    <label for="psw"><b>Password: </b></label>
                    <input type="password" placeholder="Nhập mật khẩu" name="password" required>

                </div>
                <button style="margin-left: 250px" type="submit">Login</button>

            </form>
        </section>
        <footer style="margin-top: 30px">
            <%@include file="../footer.jsp" %>  
        </footer>
    </body>

</html>
