<%@ page import="domain.model.Trade" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Minecraft Trading</title>
    <link type="text/css" href="style/style.css" rel="stylesheet"/>
</head>
<body>
<div id="container">
    <%@ include file="header.jsp" %>
    <main>
        <h1>Minecraft Trading</h1>
        <p>
            Op deze website kan je verzoeken doen om items te traden op de minecraft server met ip:
            <em>mc.iswleuven.be</em>
        </p>
        <% ArrayList<Trade> trades = (ArrayList<Trade>) request.getAttribute("trades");
            if (trades == null || trades.size() == 0) { %>
        <p>Very empty, much silent. Be the first to <a href="add.jsp">add a new trade</a>.</p>
        <% } else { %>
        <p>
            The cheapest trade was made by <a href="Controller?command=overview"><%= ((Trade) request.getAttribute("cheapest")).getNickname() %></a>.
        </p>
        <% } %>

    </main>
    <%@ include file="footer.jsp" %>
</div>
</body>
</html>
