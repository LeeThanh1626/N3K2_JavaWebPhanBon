<%-- 
    Document   : TrangCaNhan
    Created on : Jul 4, 2021, 3:33:38 PM
    Author     : Dell 7450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PHÂN BÓN</title>
        <link rel="icon" href="Allproduct/buffalo-_1_.ico">
        <link rel="stylesheet" href="./Allproduct/css/trangcanhan.css">
    </head>
    <%@include file="../product/header.jsp" %>
    <body>
        <c:set value="0" var="zero"></c:set>
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
                <c:if test="${u.money > zero}">
                    <td>
                        <p class="status status-paid">Good</p>
                    </td>
                </c:if>
                <c:if test="${u.money <= zero && u.name != admin}">
                    <td>
                        <p class="status status-paid">Bad</p>
                    </td>
                </c:if>
                <c:if test="${u.name == admin}">
                    <td>
                        <p class="status status-paid">Admin</p>
                    </td>
                </c:if>
            </tr>
        </tr>
    </table>
    <footer style="position: absolute;bottom: 0; width: 100%;">
        <%@include file="../footer.jsp" %>
    </footer>
</body>

</html>
