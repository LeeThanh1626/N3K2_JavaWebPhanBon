<%-- 
    Document   : purchseHistory
    Created on : Jul 13, 2021, 12:19:33 AM
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
    <body>
        <header>
            <%@include file="../product/header.jsp" %>
        </header>
        <c:forEach var="o" items="${list}"> 
            <table>
                <thead>
                    <tr>
                        <th>Tên User</th>
                        <th>Số điện thoại</th>
                        <th>Tên sản phẩm</th>
                        <th>Giá sả phẩm</th>
                        <th>Số lượng mua</th>
                        <th>Tổng tiền</th>
                        <th>Ngày mua</th>
                    </tr>
                </thead>
                <tr> 
                    <td>${o.nameuser}</td>
                    <td>${o.phone}</td>
                    <td>${o.nameproduct}</td>
                    <td>${o.priceproduct}</td>
                    <td>${o.amount}</td>
                    <td>${o.total}</td>
                    <td>${o.day}</td>
                </tr>
            </table>
        </c:forEach>

        <footer><%@include file="../footer.jsp" %></footer>
    </body>
</html>
