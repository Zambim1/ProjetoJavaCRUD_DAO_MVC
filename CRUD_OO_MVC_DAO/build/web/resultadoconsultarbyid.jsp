<%-- 
    Document   : resultadoconsultarbyid
    Created on : 09/11/2023, 11:51:52
    Author     : PTOLEDO
--%>

<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado Consultar By ID</title>
    </head>
    <body>
        <h1>Resultado Consultar By ID</h1>

        <%
            Produto prod = (Produto) request.getAttribute("prod");
            out.println("<h2>");
            if (prod.getDescricao() != null) {
                out.println("ID.........: " + prod.getId());
                out.println("<BR>Descrição..: " + prod.getDescricao());
                out.println("<BR>Preço......: " + prod.getPreco());
            } else {
                out.println("ID não encontrado");
            }
            out.println("</h2>");
        %>
    </body>
</html>
