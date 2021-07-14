<%-- 
    Document   : revenue
    Created on : Jul 13, 2021, 6:18:38 PM
    Author     : Dell 7450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../product/header.jsp" %>
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


            <table>
                <thead>
                    <tr>
                        <th>Tên User</th>
                            <c:forEach var="u" items="${list}">
                            <th>${u}</th>  
                            </c:forEach>
                    </tr>
                </thead>
                <c:forEach var="um" items="${listUM}">

                    <tr>
                        <td>${um.name} </td>
                        <td>${um.tien}</td>
                    </tr>

                </c:forEach>
                <td></td>
            </table>


        </form>
        <footer style="margin-top: 100px">
            <%@include file="../footer.jsp" %>
        </footer>
    </body>
</html>
