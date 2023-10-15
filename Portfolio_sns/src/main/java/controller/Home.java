package controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HomeMakeBL;
import model.TimeLineDto;
import model.UserInfoDto;

public class Home  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Home() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//セッションからユーザーIDを取得
		HttpSession session           = request.getSession();
		UserInfoDto dto = (UserInfoDto)session.getAttribute("LOGIN_INFO");
		
		String id = dto.getUserId();
		
		//HomeMakeBLを起動し、タイムライン情報を取得
		List<TimeLineDto> timeLineDtoList = new ArrayList<TimeLineDto>();
		HomeMakeBL logic = new HomeMakeBL();
		timeLineDtoList = logic.makeTimeLine(id);
		
		//アンケートリストをリクエストスコープに保存し、viewのhome.jspにフォワード
				request.setAttribute( "TIMELINE_LIST" , timeLineDtoList );

				//Viewにフォワード（フォワード先：show_survey_by_satisfaction_level.jsp）
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/home.jsp");
				dispatch.forward(request, response);

		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}