<%--
  Created by IntelliJ IDEA.
  User: vladyslavhrieshnykh
  Date: 04/08/2023
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>
        Insert values
    </h1><br>
    <form action="new-match" method="post">
        <label for="player1">Player 1:</label>
        <input type="text" id="player1" name="player1">
        <br>
        <label for="player2">Player 2:</label>
        <input type="text" id="player2" name="player2">
        <br>
        <input type="submit" value="Create Match">
    </form>
</body>
</html>
