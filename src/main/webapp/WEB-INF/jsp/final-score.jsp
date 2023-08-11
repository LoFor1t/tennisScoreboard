<%--
  Created by IntelliJ IDEA.
  User: vladyslavhrieshnykh
  Date: 09/08/2023
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Final score</title>
</head>
<body>
  <table style="text-align: center">
    <tr> <th>Player 1</th> <th>Player 2</th> <th>Winner</th> </tr>
    <tr> <td>${match.player1.name}</td> <td>${match.player2.name}</td> <td>${match.winner.name}</td> </tr>
  </table>
</body>
</html>
