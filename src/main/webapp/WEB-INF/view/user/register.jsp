<%-- 
    Document   : register
    Created on : Jun 29, 2021, 3:25:16 PM
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
        <header>
            <%@include file="../header.jsp" %> 
        </header>
        <section background-image: url("paper.gif");>
                 <h1 >Đăng Ký</h1>
            <form id="regForm" modelattribute="User" action="./registerProcess.html" method="post">
                <div>
                    <label for="uname"><b>Username: </b></label>
                    <input type="text" name="name" value="admin" readonly="readonly"></input>
                </div>
                <br/>
                <div>
                    <label for="uname"><b>Phone:   </b></label>
                    <input style="margin-left: 33px" type="text" placeholder="Nhập số điện thoại" name="phone" required>
                </div>
                <div >
                    <label for="psw"><b>Password: </b></label>
                    <input type="password" placeholder="Nhập mật khẩu" name="password" required>
                </div>

                <button style="margin-left: 250px" type="submit">Register</button>

            </form>
        </section>
        <footer style="margin-top: 30px">
            <%@include file="../footer.jsp" %>  
        </footer:>
</body>
</html>
