<%-- 
    Document   : welcome
    Created on : Jun 29, 2021, 9:26:23 PM
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
    <%@include file="../product/header.jsp" %>
    <body>
        <table>
            <tr>
                <td>Welcome ${u.phone}</td>
            </tr>    
        </table>
        <h1>
            Nạp tiền vào tài khoản 
        </h1>
        <form action="./XacNhan.html" method="GET">
            <input hidden="phone" type="text" name="phone" value="${u.phone}">            
            <table>
                <tr>
                    <td>
                        Số Tiền Nạp: <input type="text" name="money"/> 
                    </td> 
                </tr>            
                <tr>
                    <td></td>
                    <td>
                        <button type="submit">
                            Nạp
                        </button>
                    </td>
                </tr>
            </table>
        </form>
        <footer  style="margin-top: 250px">
            <%@include file="../footer.jsp" %>
        </footer>
    </body>

</html>
