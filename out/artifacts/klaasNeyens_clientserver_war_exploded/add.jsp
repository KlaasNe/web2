<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add Trade</title>
    <link type="text/css" href="style/style.css" rel="stylesheet"/>
</head>
<body>
<div id="container">
    <%@ include file="header.jsp" %>
    <main>
        <h1>Add trade</h1>
        <form method="post" action="Servlet?command=add" novalidate>
            <fieldset>
                <legend><strong>Your in game name</strong></legend>
                <p>
                    <label for="nickname"></label>
                    <input type="text" id="nickname" name="nickname" required>
                </p>
            </fieldset>
            <fieldset>
                <legend><strong>You want</strong></legend>
                <p>
                    <label for="want"></label>
                    <input type="text" id="want" name="want1">
                </p>
                <p>
                    <label for="want-quantity">Quantity:</label>
                    <input type="number" id="want-quantity" name="want2" min="0" value="quantity">
                </p>
            </fieldset>
            <fieldset>
                <legend><strong>You have</strong></legend>
                <p>
                    <label for="have"></label>
                    <input type="text" id="have" name="have1" required>
                </p>
                <p>
                    <label for="have-quantity">Quantity:</label>
                    <input type="number" id="have-quantity" name="have2" min="0" value="quantity" required>
                </p>
            </fieldset>
            <p>
                <input type="submit" value="Submit" id="submit">
            </p>
        </form>
    </main>
    <%@ include file="footer.jsp" %>
</div>
</body>
</html>
