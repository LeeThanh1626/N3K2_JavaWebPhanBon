<%-- 
    Document   : index
    Created on : Jun 30, 2021, 5:04:21 PM
    Author     : Dell 7450
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="Allproduct/css/index.css">

    </head>
    <body style="background: gainsboro;overflow-y: scroll; overflow-x: hidden;">
        <header>
            <%@include file="WEB-INF/view/header.jsp" %> 
        </header>
        <section>
            <div class="slideshow-container">
                <div class="mySlides fade ">
                    <img src="Allproduct/sach3.jpg" >
                </div>
                <div class="mySlides fade">
                    <img src="Allproduct/sach2.jpg" >
                </div>
                <div class="mySlides ">
                    <img src="Allproduct/sach1.jpg" >
                </div>
                <div class="mySlides ">
                    <img src="Allproduct/sach5.jpg" >
                </div>   
                <div class="mySlides ">
                    <img src="Allproduct/sach1.jpg" >
                </div>   
            </div>

        </section>
        <footer>
            <%@include file="WEB-INF/view/footer.jsp" %>   
        </footer>
        <script type="text/javascript" src="Allproduct/css/main.js"></script>
    </body>

</html>
