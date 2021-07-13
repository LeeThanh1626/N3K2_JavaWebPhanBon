<%-- 
    Document   : header
    Created on : Jun 30, 2021, 5:14:07 PM
    Author     : Dell 7450
--%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./Allproduct/css/header1.css">
    </head>
    <%--tạo biến admin, so sánh vs tên user => xác định admin--%>
    <c:set value="admin" var="admin" ></c:set>
    <c:set value="${name}" var="name" ></c:set>
        <body style="overflow-y: scroll;
              overflow-x: hidden;">
            <header>
                <div class="container-flux">

                    <a href="list.html"><img class="img" src="https://image.flaticon.com/icons/png/512/4082/4082010.png" alt="" ></a>
                    <c:if test="${name == admin}">
                    <form action="listSearch.html" method="GET">
                        <div class="group">
                            <input type="search" placeholder="Nhập tên sản phẩm" name="name"/>
                            <button  class="search-magnifier btn" type="submit">Tìm sản phẩm</button>
                        </div>
                    </form>
                    <form action="./SearchUser.html" method="GET">
                        <div class="group">
                            <input type="search" placeholder="Nhập số điện thoại" name="phone"/>
                            <button  class="search-magnifier btn" type="submit">Tìm Khách Hàng</button>
                        </div>
                    </form>
                </c:if>
                <c:if test="${name != admin}">
                    <form action="listSearch.html" method="GET">
                        <div class="group">
                            <input type="search" placeholder="Tìm kiếm sách" name="name"/>
                            <button title="Tìm sách" class="search-magnifier btn" type="submit">Tìm sách</button>
                        </div>
                    </form> 
                </c:if>

                <div class="login">
                    <a id="a" >Welcome ${phone}</a> 
                    <a id="a" href="./logout.html">Đăng Xuất</a>
                </div>
            </div>

            <div class="topnav">

                <c:if test="${name == admin}">
                    <a   href="list.html">Tất cả sản phẩm</a>

                    <a href="./TrangCaNhan.html">Trang Cá Nhân</a>

                    <a  href="add.html">Thêm Sản Phẩm</a>

                    <a href="./listUser.html">Quản Lý Người Dùng</a>

                    <a href="./addUser.html">Thêm Khách Hàng</a>
                </c:if>
                <c:if test="${name != admin}">
                    <a   href="list.html">Tất cả sản phẩm</a>

                    <a href="./TrangCaNhan.html">Trang Cá Nhân</a>

                    <div class="right">     
                        <a  href="listcart.html"><img style="width: 20px;height: 20px;" src="./Allproduct/shopping-cart.svg"> Giỏ hàng</a>
                    </div>
                </c:if>


            </div>
        </header>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="Allproduct/css/main.js"></script>

    </body>
</html>
