<%--
  Created by IntelliJ IDEA.
  User: vladyslavhrieshnykh
  Date: 07/08/2023
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.LoFor1t.tennisScoreboard.DataModels.MatchStatus" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <form method="post">
    <table style="text-align: center">
      <tr> <th></th> <th>${match.player1.name}</th> <th>${match.player2.name}</th></tr>
      <tr> <th>Sets</th> <td>${match.player1Score.setWins}</td> <td>${match.player2Score.setWins}</td> </tr>
      <c:if test="${match.matchStatus != MatchStatus.TieBrake}">
        <tr> <th>Games</th> <td>${match.player1Score.gameWins}</td> <td>${match.player2Score.gameWins}</td> </tr>
      </c:if>
      <c:if test="${match.matchStatus == MatchStatus.TieBrake}">
        <tr> <th>Games</th> <td>Tie</td> <td>Brake</td> </tr>
      </c:if>
      <tr> <th>Score</th> <td>${match.player1Score.score}</td> <td>${match.player2Score.score}</td> </tr>
      <tr> <th></th> <td><button name="player" value="player-1-win">${match.player1.name} wins</button></td> <td><button name="player" value="player-2-win">${match.player2.name} wins</button></td> </tr>
    </table>
  </form>
</body>
</html>
