<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import ="model.TimeLineDto" %>
<%@ page import ="java.util.List" %>



<%
java.util.List<model.TimeLineDto> timeLineDtoList = (java.util.List<model.TimeLineDto>)request.getAttribute("TIMELINE_LIST");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Tameshitar</title>
</head>
<body>
	<h2>タイムライン</h2> 
	<a href="MyPage">マイページ</a>
	<a href="NewPost">投稿する</a>
	<a href="Logout">ログアウト</a>
	<table class="list" border=1 id="TABLE">
	 <tr bgcolor="#c0c0c0"> 
	   <th>名前</th> 
	   <th>ID</th> 
	   <th>投稿</th> 
	   <th>日付</th> 
	 </tr>  
	 
	 <%
	 String escapeNameText ;
	 String escapeIdText ;
	 String escapeSentenceText ;
		for (int i = 0; i < timeLineDtoList.size(); i++) {
			escapeNameText = replaceEscapeChar( timeLineDtoList.get(i).getName());
			escapeIdText = replaceEscapeChar( timeLineDtoList.get(i).getUserId());
			escapeSentenceText = replaceEscapeChar( timeLineDtoList.get(i).getSentence());
	 %>
	 <tr>
	  	<td><%= escapeNameText  %> </td>    
	  	<td><%= escapeIdText %></td> 
	    <td><%=  escapeSentenceText %> </td> 
	    <td><%= timeLineDtoList.get(i).getPostTime()  %> </td>
	 </tr>
	 
	 <%
		}
	 %>
	 
	 </table> 
	  
	  
</body>
</html>

<%!
private String replaceEscapeChar(String inputText) {

	// 「&」を変換して無害化
	inputText = inputText.replace("&", "&amp;");
	// 「<」を変換して無害化
	inputText = inputText.replace("<", "&lt;");
	// 「>」を変換して無害化
	inputText = inputText.replace(">", "&gt;");
	// 「"」を変換して無害化
	inputText = inputText.replace("\"", "&quot;");
	// 「'」を変換して無害化
	inputText = inputText.replace("'", "&#039;");

	return inputText;
}
%>
