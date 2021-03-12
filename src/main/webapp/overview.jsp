<%@ page import="domain.model.Trade" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Trading Overview</title>
    <link type="text/css" href="style/style.css" rel="stylesheet"/>
</head>
<body>
<div id="container">
    <%@ include file="header.jsp" %>
    <main>
        <h1>Trades overview</h1>
        <p>
            <%@ include file="searchForm.jsp" %>
        </p>
        <% ArrayList<Trade> trades = (ArrayList<Trade>) request.getAttribute("trades");
            if (trades.size() != 0) { %>
        <table>
            <tr>
                <th>Nickname</th>
                <th>Has</th>
                <th>Amount</th>
                <th>Wants</th>
                <th>Amount</th>
                <th></th>
                <th></th>
            </tr>
            <%
                try {
                    for (Trade trade : trades) {
            %>
            <tr>
                <td>
                    <%=trade.getNickname()%>
                </td>
                <td>
                    <%=trade.getMyOffer().getName()%>
                </td>
                <td>
                    <%=trade.getMyOffer().getAmount()%>
                </td>
                <td>
                    <%=trade.getMyNeed().getName()%>
                </td>
                <td>
                    <%=trade.getMyNeed().getAmount()%>
                </td>
                <td><a>edit</a></td>
                <td><a href="Controller?command=deleteConfirmation&id=<%= trade.getId() %>">Delete</a></td>
            </tr>
            <%
                    }
                } catch (NullPointerException ignored) {
                    ;
                }%>
        </table>
        <% } else { %>
        <h2>No trades available</h2>
        <p>Be the first to <a href="add.jsp">add a new trade</a>.</p>
        <%}%>
    </main>
    <%@ include file="footer.jsp" %>
</div>
</body>
</html>
