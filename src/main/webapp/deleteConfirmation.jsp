
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Mijn huisdieren</title>
    <link type="text/css" href="style/style.css" rel="stylesheet" />
</head>
<body>
<div id="container">
    <%@ include file="header.jsp" %>
    <main>
        <h2>Confirmation</h2>
        <p>Are you sure you want to remove this trade?</p>
        <form action="Controller?command=delete&id=<%= request.getParameter("id") %>" method="POST">
            <input type="submit" value="Yes"/>
            <input type="button" value="No" onclick="location.href='Controller?command=overview'">
        </form>
    </main>
    <%@ include file="footer.jsp" %>
</div>
</body>
</html>
