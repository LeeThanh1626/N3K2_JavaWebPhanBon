<%-- 
    Document   : header
    Created on : Jun 30, 2021, 5:14:07 PM
    Author     : Dell 7450
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./AllBook/css/header.css">
    </head>
    <body>
        <header>
            <div class="container-flux">
               <a href="index.jsp"><img class="img" src="./AllBook/logo.svg" alt="" ></a>
                <form action="listSearch.html" method="GET">
                    <div class="group">
                        <input type="search" placeholder="Tìm kiếm sách" name="name"/>
                        <button title="Tìm sách" class="search-magnifier btn" type="submit">Tìm sách</button>
                    </div>
                </form>
                <div class="login">
                    <a id="a" href="./register.html">Đăng Ký</a>
                    <a id="a"  href="./login.html">Đăng Nhập</a>
                </div>
            </div>
        </header>

    </body>
</html>