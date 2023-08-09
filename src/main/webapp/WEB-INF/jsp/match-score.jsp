<%--
  Created by IntelliJ IDEA.
  User: vladyslavhrieshnykh
  Date: 07/08/2023
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <form method="post">
    <table style="text-align: center">
      <tr> <th></th> <th>${match.player1.name}</th> <th>${match.player2.name}</th></tr>
      <tr> <th>Sets</th> <td>${match.player1Score.setWins}</td> <td>${match.player2Score.setWins}</td> </tr>
      <tr> <th>Games</th> <td>${match.player1Score.gameWins}</td> <td>${match.player2Score.gameWins}</td> </tr>
      <tr> <th>Score</th> <td>${match.player1Score.score}</td> <td>${match.player2Score.score}</td> </tr>
      <tr> <th></th> <td><button name="player" value="player-1-win">${match.player1.name} wins</button></td> <td><button name="player" value="player-2-win">${match.player2.name} wins</button></td> </tr>
    </table>
  </form>
</body>
</html>
