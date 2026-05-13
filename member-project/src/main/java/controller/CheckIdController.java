package controller;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;
import view.ModelAndView;

public class CheckIdController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		//사용자에게 보낼 데이터 셋팅
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("result",1 );
//		map.put("msg", "결과메세지");
//		map.put("list",MemberService.getInstance().selectAllMember());
		
		boolean result = MemberService.getInstance().checkId(id);
		
		//json 오브젝트로 바꿔주기
//		JSONObject json = new JSONObject(map);
//		System.out.println(json.toString());
		//클라이언트에게 데이터를 보내는 부분
		response.getWriter().println(json.toString());
		//view는 리턴하지 않음, 페이지 이동을 쓰면 해당 페이지 내용이 전달
		return null;
	}

}
