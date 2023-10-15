<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%--
-------------------------------------------------------------------------------------------------
■■■ファイル名：search_survey_by_satisfaction_level.jsp■■■
概要：JSP
詳細：HTML文書（満足度別アンケート結果検索画面）を出力する。
-------------------------------------------------------------------------------------------------
--%>

<html>
<head>
  <title>満足度別アンケート結果検索</title>
</head>
<body>
  <h2>満足度別アンケート結果検索</h2>
  <form action="<%=request.getContextPath()%>/ShowSurveyBySatisfactionLevel" method="post">
    <p> 満足度：
      <select name="SATISFACTION_LEVEL">
        <option value="5">とても満足</option>
        <option value="4">満足      </option>
        <option value="3">普通      </option>
        <option value="2">不満      </option>
        <option value="1">とても不満</option>
      </select>
    </p>
    <input type="submit" value="検索">
  </form>
</body>
</html>
