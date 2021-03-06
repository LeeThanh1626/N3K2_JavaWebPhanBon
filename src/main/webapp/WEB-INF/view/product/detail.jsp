<%-- 
    Document   : edit
    Created on : Jun 26, 2021, 11:20:33 PM
    Author     : Dell 7450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PHÂN BÓN</title>
        <link rel="icon" href="Allproduct/buffalo-_1_.ico">
        <link rel="stylesheet" href="./Allproduct/css/detail.css">
    </head>
    <body>
        <header>
            <%@include file="./header.jsp" %>
        </header>
        <section>
            <h1>Thông tin chi tiết</h1>
            <div class="grid-item">
                <div class="card">
                    <img class="card-img" src="./Allproduct/${b.pic}" alt="">
                </div>
                <div class="card-content">
                    <label ><b>Tên Phân Bón:  </b></label>   
                    <h1 class="card-header"> ${b.name}</h1> 
                     <label ><b>Quy Cách:  </b></label>  
                    <p class="card-text"> ${b.specifications}<span>kg</span></p>
                    <label ><b>Giá Tiền:  </b></label>  
                    <p class="card-text"> ${b.price}<span>VND</span></p>
                    
                    <c:if test="${b.discount != 0}">
                        <label ><b>Sản phẩm hiện đang được giảm:  </b></label>  
                        <p class="card-text"> ${b.discount * 100}<span>%</span></p>
                        <label ><b>Giá Tiền Sau Khi Giảm Giá:  </b></label>  
                        <p class="card-text"> ${b.price - b.price * b.discount}<span>VND</span></p>
                    </c:if>
                    
                    
                    
                    <a href="./addcart.html?id=${b.id}" onclick="return confirm('Sản phẩm đã được thêm vào giỏ hàng')" class="card-btn">Thêm vào giỏ hàng<span>&rarr;</span></a>
                </div>
            </div>
        </section>
        <footer>
            <%@include file="../footer.jsp" %>
        </footer>
    </body>

</html>
