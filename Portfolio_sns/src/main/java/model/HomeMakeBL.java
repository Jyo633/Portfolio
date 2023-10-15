package model;

import java.util.ArrayList;
import java.util.List;

public class HomeMakeBL {

	public List<TimeLineDto> makeTimeLine(String id){
		
		//アンケートリスト（ArrayList<SurveyDto>型）
		List<TimeLineDto> surveyList = new ArrayList<TimeLineDto>();

		//DAOクラスをインスタンス化＆アンケートリストを抽出するよう依頼
		PostDao dao = new PostDao();
		surveyList = dao.selectPost( id );

		return surveyList;
		
	}
	
}
