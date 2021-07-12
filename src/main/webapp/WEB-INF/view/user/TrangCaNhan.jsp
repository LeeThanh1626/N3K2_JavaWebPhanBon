<%-- 
    Document   : TrangCaNhan
    Created on : Jul 4, 2021, 3:33:38 PM
    Author     : Dell 7450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./Allproduct/css/trangcanhan.css">
    </head>
    <%@include file="../product/header.jsp" %>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Tên User</th>
                    <th>Password</th>
                    <th>Số dư tài khoản</th>
                    <th>Status</th>
                </tr>
            </thead>

            <tr> <td>${u.name}</td>
                <td>${u.password}</td>
                <td>${u.money}</td>
                <td>
                    <p class="status status-paid">Good</p>
                </td>
            </tr>
        </tr>
    </table>
    <footer style="margin-top: 280px">
        <%@include file="../footer.jsp" %>
    </footer>
</body>

</html>
