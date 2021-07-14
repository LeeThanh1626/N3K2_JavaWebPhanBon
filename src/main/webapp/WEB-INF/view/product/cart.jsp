<%-- 
    Document   : listSach
    Created on : Jun 26, 2021, 10:16:03 PM
    Author     : Dell 7450
--%>



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
        <div class="row">
            <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
                <!-- Shopping cart table -->
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col" class="border-0 bg-light">
                                    <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                                </th>
                                <th scope="col" class="border-0 bg-light">
                                    <div class="py-2 text-uppercase">Quy Cách(kg)</div>
                                </th>
                                <th scope="col" class="border-0 bg-light">
                                    <div class="py-2 text-uppercase">Đơn Giá</div>
                                </th>
                                <th scope="col" class="border-0 bg-light">
                                    <div class="py-2 text-uppercase">Số Lượng Mua(kg)</div>
                                </th>
                                <th scope="col" class="border-0 bg-light">
                                    <div class="py-2 text-uppercase">Xóa</div>
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="o">
                                <tr>
                                    <th scope="row">
                                        <div class="p-2">
                                            <img src="./Allproduct/${o.pic}" alt="" width="70" class="img-fluid rounded shadow-sm">
                                            <div class="ml-3 d-inline-block align-middle">
                                                <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block">${o.name}</a></h5><span class="text-muted font-weight-normal font-italic"></span>
                                            </div>
                                        </div>
                                    </th>
                                     <td class="align-middle"><strong>${o.specifications}</strong></td>
                                    <td class="align-middle"><strong>${o.price - o.price * o.discount}</strong></td>
                                    <td class="align-middle">
                                        <a href="./subproductcart.html?id=${o.id}"><button class="btnSub">-</button></a>
                                        <strong>${o.amount}</strong>
                                        <a href="./addproductcart.html?id=${o.id}"><button class="btnAdd">+</button></a>
                                    </td>
                                    <td class="align-middle"><a href="./deleteproductcart.html?id=${o.id}" class="text-dark">
                                            <button type="button" class="btn btn-danger">Delete</button>
                                        </a>
                                    </td>
                                </tr> 
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- End -->
            </div>
        </div>

        <div class="row py-5 p-4 bg-white rounded shadow-sm">
            <div class="col-lg-6">
                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
                <div class="p-4">
                    <ul class="list-unstyled mb-4">
                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong>${total}đ</strong></li>
                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận chuyển</strong><strong>Free ship</strong></li>
                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong>10000đ</strong></li>
                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tài khoản của bạn được ưu đãi: </strong><strong>${heso * 100}%</strong></li>
                        <br>
                        <br>
                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>
                            <h5 class="font-weight-bold">${money+10000}đ</h5>
                        </li>
                    </ul><a href="./buy.html?totalmoney=${money}&&phone=${phone}" class="btn btn-dark rounded-pill py-2 btn-block">Mua hàng</a>
                </div>
            </div>
        </div>

    


    <footer>
        <%@include file="../footer.jsp" %>
    </footer>
</body>

</html>


