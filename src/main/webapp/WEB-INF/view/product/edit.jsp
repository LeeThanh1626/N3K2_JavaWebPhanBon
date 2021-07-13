<%-- 
    Document   : editi
    Created on : Jun 27, 2021, 9:23:52 PM
    Author     : Dell 7450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PHÂN BÓN</title>
        <link rel="icon" href="Allproduct/buffalo-_1_.ico">
        <link rel="stylesheet" href="./Allproduct/css/edit.css">
        <link rel="stylesheet" href="./Allproduct/css/index.css">
    </head>

    <body>
        <header>
            <%@include file="./header.jsp" %> 
        </header>
        <section>
            <div  >
                <h1>Thông Tin Sách</h1>
                <form id="editproduct" action="./upload.html" method="POST" enctype="multipart/form-data">
                    <input hidden="id" type="text" name="id" value="${b.id}">
                    <label ><b>Hình Ảnh:  </b></label><div>
                        <img name="pic" src="./Allproduct/${b.pic}"/>

                    </div>
                    <div>
                        <label ><b>Tên Phân Bón </b></label>
                        <input type="text" name="name" value="${b.name}" required>
                    </div>
                    <div >
                        <label ><b>Giá Tiền:  </b></label>
                        <input type="text" name="price" value="${b.price}" required>
                    </div>
                    <div>
                        <label ><b>Quy Cách: </b></label>
                        <input type="text" name="specifications" rows="10" cols ="90" value="${b.specifications}"></input>                    
                    </div>
                    <button style="margin-left: 50px" type="submit">Cập nhật</button>

                </form>
            </div>
        </section>

        <footer>
            <%@include file="../footer.jsp" %>
        </footer>
    </body>
</html>
