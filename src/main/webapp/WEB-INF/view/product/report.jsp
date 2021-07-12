<%-- 
    Document   : listSach
    Created on : Jun 26, 2021, 10:16:03 PM
    Author     : Dell 7450
--%>



<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>

    <body>
        <style>
            input[name=number]{
                display: inline-block;
            }
        </style>
        <header>          
            <%@include file="./header.jsp" %> 
        </header>

        <table border="1" >
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Phone</td>
                    <td>nameuser</td>
                    <td>nameproduct</td>
                    <td>priceproduct</td>
                    <td>amount</td>
                    <td>total</td>
                    <td>day</td>

                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cart}" var="o" >
                    <tr>
                        <td>${o.id}</td>
                        <td>${o.phone}</td>
                        <td>${o.nameuser}</td>
                        <td>${o.nameproduct}</td>
                        <td>${o.priceproduct}</td>
                        <td>${o.amount}</td>
                        <td>${o.total}</td>
                        <td>${o.day}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="./export.html">Download Excel</a>




        <footer style="padding:20px ">
            <%@include file="../footer.jsp" %>
        </footer>
    </body>

</html>


