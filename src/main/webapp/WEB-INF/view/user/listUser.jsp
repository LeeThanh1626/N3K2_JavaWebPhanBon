<%-- 
    Document   : listSach
    Created on : Jun 26, 2021, 10:16:03 PM
    Author     : Dell 7450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./Allproduct/css/trangcanhan.css">
    </head>
    <body class="bodyy">
        <c:set value="admin" var="admin" ></c:set>

            <header>
            <%@include file="../product/header.jsp" %>
        </header>
        <c:forEach var="u" items="${list}"> 
            <c:set value="${u.name}" var="name" ></c:set>
                <table>
                    <thead>
                        <tr>
                            <th>Tên User</th>
                            <th>Password</th>
                            <th>Số điện thoại</th>
                            <th>Số dư tài khoản</th>
                            <th>id</th>

                        </tr>
                    </thead>

                    <tr> 
                        <td>${u.name}</td>
                    <td>${u.password}</td>
                    <td>${u.phone}</td>
                    <td>${u.money}</td>
                    <td>
                        ${u.id}  
                    </td>
                </tr>
            </table>

            <c:if test="${name != admin}">
                <a href="./editUser.html?id=${u.id}" class="card-btn">Sửa<span>&rarr;</span></a>
                <a href="./addMoneyUser.html?id=${u.id}" class="card-btn">Nạp Tiền<span>&rarr;</span></a>
                <a href="./deleteUser.html?id=${u.id}" onclick="return confirm('Bạn có chắc muốn xóa sản phẩm?')" class="card-btn">Xóa<span>&rarr;</span></a>
            </c:if>

        </c:forEach>

        <footer ><%@include file="../footer.jsp" %></footer>
    </body>

</html>
