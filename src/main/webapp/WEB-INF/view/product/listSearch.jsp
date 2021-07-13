<%-- 
    Document   : listSearch
    Created on : Jun 27, 2021, 11:59:21 PM
    Author     : Dell 7450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <%@include file="./header.jsp" %>
    <body>

        <h1>Ket Qua Tim Kiem:</h1>
    <c:forEach var="b" items="${list}">
        <div class="row row-cols-1 row-cols-md-5">
            <div class="col mb-4 d-flex align-items-start flex-column bd-highlight mb-3">
                <div class="card h-100">
                    <div class="card-body">
                        <img src="./Allproduct/${b.pic}"/>
                        <div class="p-4 bd-highlight">
                            <h5 class="card-title"> ${b.name}</h5>
                            <p class="card-title"> ${b.price}</p>
                        </div>
                        <div>
                            <a href="./detail.html?name=${b.name}">Chi Tiết</a>
                            <a href="./edit.html?name=${b.name}">Sửa</a>
                            <a href="./delete.html?name=${b.name}" onclick="return confirm('Ban co chac chan muon xoa?')">Xóa</a>
                        </div>
                    </div>
                </div>  

            </div> 
        </div>               
    </c:forEach>
        
</body>
<%@include file="../footer.jsp" %>
</html>
