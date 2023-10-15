package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginCheckBL;
import model.UserInfoDto;


/**----------------------------------------------------------------------*
 *■■■LoginCheckクラス■■■
 *概要：サーブレット
 *詳細：IDとPASSを確認し、セッションを作成する
 *----------------------------------------------------------------------**/
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginCheck() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//レスポンス（出力データ）の文字コードを設定
		response.setContentType("text/html;charset=UTF-8");     //文字コードをUTF-8で設定
		//リクエスト（受信データ）の文字コードを設定
		request.setCharacterEncoding("UTF-8");                  //文字コードをUTF-8で設定
		
		String userId   = request.getParameter("USER_ID");
		String passWord = request.getParameter("PASSWORD");

			//「user_info」テーブルからユーザー入力値と合致するユーザーデータ（UserInfoDto型）を抽出
			// ※合致するデータがなかった場合、各フィールドがnullのDTOを得る
			LoginCheckBL logic = new LoginCheckBL();
			UserInfoDto   dto   = logic.certification(userId, passWord);

			//ユーザーデータの抽出成功/失敗に応じて表示させる画面を振り分ける
			if (dto.getUserId() != null) {
				//ユーザーデータの抽出に成功：ログインOKとしてセッションにユーザーデータをセット＆ホーム画面へ

				//DBから抽出したユーザデータをセッションにセット
				HttpSession session           = request.getSession();
				session.setAttribute("LOGIN_INFO", dto);

				//Homeサーブレットにフォワード
				RequestDispatcher dispatch = request.getRequestDispatcher("Home");
				dispatch.forward(request, response);

			} else {
				//ユーザーデータの抽出に失敗：ログインNGとしてログイン画面へ転送
				response.sendRedirect("Login");

			}
		
	}
}
