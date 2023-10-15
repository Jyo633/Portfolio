<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="controller.LoginCheck" %>
<%@ page import="model.UserInfoDto" %>

<%----------------------------------------------------------------------
 *■■■LoginJSP■■■
 *概要：ログイン画面
 *詳細：HTML文書（ログイン画面）を出力する。
 *----------------------------------------------------------------------%>

<%
		//セッションからユーザーデータを取得
		UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");

		//ログイン状態によって表示画面を振り分ける
		// ※ログイン状態はセッション上からユーザーデータを取得できたか否かで判断
		//    ユーザーデータを取得できた　　　→既にログインされている
		//    ユーザーデータを取得できなかった→まだログインされていない
		if (userInfoOnSession != null) {
			//ログイン済：ホーム画面へ転送
			response.sendRedirect("Home");
		}else{
			//未ログイン：HTML文書（ログイン画面）の出力
%>
			<html>                                                             
			<head>                                                            
			 <title>Tameshitar</title>                                      
			</head>                                                     
			<body>                                                          
			<h1>Tameshitarログイン</h1>   
			<form action="LoginCheck" method="post">            
					<p>ユーザーID：<br>                                         
					<input type="text" name="USER_ID" maxlength="20" id="ID_USER_ID">   
					</p>                                                       
					<p>パスワード：<br>                                         
					<input type="password" name="PASSWORD" maxlength="20" id="ID_PASSWORD">
					</p>                                                       
					<input type="submit" value="ログイン" id="ID_SUBMIT"  >           
				</form>                                                      
			
			 	<script type="text/javascript" src="js/brank-check.js"></script>                     
			                              
			
			</body>                                                       
			</html>
			
			<%                                                            
		}
%>
