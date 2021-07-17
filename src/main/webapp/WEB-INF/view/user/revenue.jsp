<%-- 
    Document   : revenue
    Created on : Jul 13, 2021, 6:18:38 PM
    Author     : Dell 7450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <%@include file="../product/header.jsp" %>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h3>Xem Doanh Thu</h3>
<form action="./statistical.html" method="POST">
    <div>
        <label>Chọn ngày bắt đầu:</label>
        <input type="date" name="startday">
        <label>Chọn ngày kết thúc:</label>
        <input type="date" name="endday">
    </div>
    <input type="submit" value="Xem thống kê">
</form>

<%--<table class="table table-bordered">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th scope="col">Tên User</th>--%>
<%--&lt;%&ndash;        <c:forEach var="u" items="${listDate}">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <th scope="col">${u}</th>&ndash;%&gt;--%>
<%--&lt;%&ndash;        </c:forEach>&ndash;%&gt;--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <c:forEach var="name" items="${listName}">--%>
<%--        <tr>--%>
<%--            <td> ${name} </td>--%>
<%--            <c:forEach var="doanhthu" items="${statistical}">--%>
<%--                <c:if test="${doanhthu.name == name}">--%>
<%--                    <c:forEach var="Ngay" items="${listDate}">--%>
<%--                        <c:if test="${doanhthu.ngay.equals(Ngay)}">--%>
<%--                            <tr>--%>
<%--                                <th scope="col">${Ngay}</th>--%>
<%--                                <td>${doanhthu.tien}</td>--%>
<%--                            </tr>--%>
<%--                        </c:if>--%>
<%--                    </c:forEach>--%>
<%--                </c:if>--%>
<%--            </c:forEach>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<table class="table table-bordered">
    <thead>
    <tr>
        <th>Tên User</th>
        <c:forEach var="u" items="${listDate}">
            <th>${u}</th>
        </c:forEach>
    </tr>
    </thead>
    <c:set var="temp1" value="0"/>
    <c:forEach var="name" items="${listName}">
        <tr>
            <td> ${name} </td>
            <c:forEach var="doanhthu" items="${statistical}">
                <c:if test="${doanhthu.name == name}">
                    <c:forEach var="Ngay" items="${listDate}">
                        <c:choose>
                            <c:when test="${doanhthu.ngay.equals(Ngay)}">
                                <td>${doanhthu.tien}</td>
                                <c:set var="temp1" value="1"/>
                            </c:when>
                        </c:choose>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${temp1 == 1}">
                            <c:set var="temp1" value="0"/>
                        </c:when>
                        <c:otherwise>
                            <td></td>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </c:forEach>
        </tr>
    </c:forEach>
    <td></td>
</table>

<footer style="position: absolute;bottom: 0; width: 100%;">
    <%@include file="../footer.jsp" %>
</footer>
</body>
</html>
