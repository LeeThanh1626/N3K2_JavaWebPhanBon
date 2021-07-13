<%-- 
    Document   : add
    Created on : Jun 28, 2021, 12:13:23 AM
    Author     : Dell 7450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./Allproduct/css/index.css">
    </head>
    <body>

        <header>
            <%@include file="./header.jsp" %> 
        </header>
        <section>
            
                <h1>Thông Tin Sản Phẩm Cần Thêm</h1>
                <form id="addproduct" action="./upload.html" method="POST" enctype="multipart/form-data">
                    <div>
                        <label ><b>Tên Sản Phẩm: </b></label>
                        <input type="text" placeholder="Nhập tên sách" name="name" required>
                    </div>
                    <div >
                        <label ><b>Quy cách:   </b></label>
                        <input style="margin-left: 45px" type="text" placeholder="Nhập quy cách" name="specifications" required>
                    </div>
                    <div >
                        <label ><b>Giá Tiền:   </b></label>
                        <input style="margin-left: 55px" type="text" placeholder="Nhập giá tiền" name="price" required>
                    </div>
                    <div>
                        <label ><b>Hình Ảnh: </b></label> 
                        <input style="margin-left: 45px" type="file" id="pic" name="pic">
                    </div>
                    <%--
                    <div>
                        <label ><b>Nội Dung: </b></label>
                        <textarea type="text" name="content" rows="10" cols ="80"></textarea>
                    </div>
                    --%>
                    <div>
                        <button style="margin-left: 250px" type="submit">Cập nhật</button>
                    </div>  

                </form>
            
        </section>
        <footer style="margin-top: 20px">
            <%@include file="../footer.jsp" %>
        </footer>
    </body>
</html>
