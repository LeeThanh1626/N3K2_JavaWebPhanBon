<%-- 
    Document   : add
    Created on : Jul 9, 2021, 5:30:38 PM
    Author     : Dell 7450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./Allproduct/css/index.css">
    </head>
    <body>
        <header>
            <%@include file="../product/header.jsp" %> 
        </header>           
        <h1>Thêm Khách Hàng </h1>
        <form id="addproduct" action="./Save.html" method="POST">
            <div>
                <label ><b>Tên khách hàng: </b></label>
                <input type="text" name="name" required>
            </div>
            <div >
                <label ><b>Password:  </b></label>
                <input style="margin-left: 55px" type="text" name="password" required>
            </div>
            <%--
            <label ><b>Hình Ảnh:  </b></label><div>
                <img name="pic" src="./Allproduct/${u.pic}"/>
                <img name="pic2" src="./Allproduct/${u.pic2}"/>
                <img name="pic3" src="./Allproduct/${u.pic3}"/>
            </div>
            --%>
            <div>
                <label ><b>Số Điên Thoại: </b></label>
                <input style="margin-left: 18px" type="text" name="phone" ></input>                    
            </div>
            <div>
                <button style="margin-left: 250px" type="submit">Cập nhật</button>
            </div>
        </form>
        <footer style="position: absolute;bottom: 0; width: 100%;">
            <%@include file="../footer.jsp" %>
        </footer>
    </body>
</html>
