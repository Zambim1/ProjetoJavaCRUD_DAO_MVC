<%-- 
    Document   : resultado
    Created on : 09/11/2023, 11:19:49
    Author     : PTOLEDO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REsultado</title>
    </head>
    <body>
        <h1>
            <%
               String msg = (String) request.getAttribute("msg");
               out.println(msg);
            %>
            
        </h1>
    </body>
</html>
