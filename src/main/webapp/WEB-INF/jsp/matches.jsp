<%--
  Created by IntelliJ IDEA.
  User: vladyslavhrieshnykh
  Date: 09/08/2023
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Matches</title>
</head>
<body>
    <form method="get" action="matches">
        <input type="text" name="filter_by_player_name">
        <button type="submit">Search by name</button>
    </form>

    <table>
        <tr><th>Player 1</th> <th>Player 2</th> <th>Winner</th></tr>
        <c:forEach var="game" items="${matches}">
            <tr> <td>${game.player1.name}</td> <td>${game.player2.name}</td> <td>${game.winner.name}</td></tr>
        </c:forEach>
    </table>
</body>
</html>
