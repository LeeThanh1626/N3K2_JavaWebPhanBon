<%-- 
    Document   : edit
    Created on : Jul 9, 2021, 5:01:19 PM
    Author     : Dell 7450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>PHÂN BÓN</title>
        <link rel="icon" href="Allproduct/buffalo-_1_.ico">
        <link rel="stylesheet" href="./Allproduct/css/index.css">
    </head>

    <body>
        <header>
            <%@include file="../product/header.jsp" %> 
        </header>           
        <h1>Thông Tin User</h1>
        <form id="editproduct" action="./Save.html" method="POST">
            <div
                <label ><b>ID: ${u.id}</b></label>
            </div>
            <div>
                <label ><b>Tên: </b></label>
                <input type="text" name="name" value="${u.name}" required>
            </div>
            <div >
                <label ><b>Password:  </b></label>
                <input type="text" name="password" value="${u.password}" required>
            </div>
            <div>
                <label ><b>Số Điên Thoại: </b></label>
                <input type="text" name="phone" value="${u.phone}"></input>                    

            </div>
            <div>
                <label ><b>Số dư tài khoản: </b></label>  
                <input type="text" name="phone" value="${u.money}"></input>                    

            </div>
            <div>
                <button style="margin-left: 250px" type="submit">Cập nhật</button>
            </div>
        </form>
        <footer>
            <%@include file="../footer.jsp" %>
        </footer>
    </body>
</html>
