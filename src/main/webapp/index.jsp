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
        
        <link rel="stylesheet" href="Allproduct/css/index.css">
        <link rel="stylesheet" href="./Allproduct/css/header.css">
        <title>PHÂN BÓN</title>
        <link rel="icon" href="Allproduct/buffalo-_1_.ico">

    </head>
    <body style="background: gainsboro;overflow-y: scroll; overflow-x: hidden;">
        <header>
            <%@include file="WEB-INF/view/header.jsp" %> 
        </header>
        <section>
            <div class="slideshow-container">
                <div class="mySlides fade ">
                    <img src="Allproduct/3.png" >
                </div>
                <div class="mySlides fade">
                    <img src="Allproduct/2.png" >
                </div>
                <div class="mySlides ">
                    <img src="Allproduct/3.png" >
                </div>
                <div class="mySlides ">
                    <img src="Allproduct/4.png" >
                </div>   
                <div class="mySlides ">
                    <img src="Allproduct/5.png" >
                </div>   
                  <div class="mySlides ">
                    <img src="Allproduct/6.png" >
                </div>   
                  <div class="mySlides ">
                    <img src="Allproduct/7.png" >
                </div>   
            </div>

        </section>
        <footer>
            <%@include file="WEB-INF/view/footer.jsp" %>   
        </footer>
        <script type="text/javascript" src="Allproduct/css/main.js"></script>
    </body>

</html>
