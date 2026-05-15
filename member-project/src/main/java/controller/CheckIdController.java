package controller;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;

import dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;
import view.ModelAndView;

public class CheckIdController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 사용자가 보낸 데이터를 받음
		String id = request.getParameter("id");

		// id로 해당 사용자가 있는지 검색 결과 받음
		MemberDTO member = MemberService.getInstance().selectMemberById(id);

		// 검색 결과를 토대로 사용자에게 보낼 데이터 셋팅
		HashMap<String, Object> map = new HashMap<>();
		if (member == null) {
			map.put("result", 1);
			map.put("msg", "사용할 수 있는 아이디입니다.");
		} else {
			map.put("result", 0);
			map.put("msg", "중복된 아이디입니다.");
		}
		
		// json 오브젝트로 바꿔주기
		JSONObject json = new JSONObject(map);
		System.out.println(json.toString());
		
		// 클라이언트에게 데이터를 보내는 부분
		response.getWriter().println(json.toString());
		
		// view는 리턴하지 않음, 페이지 이동을 쓰면 해당 페이지 내용이 전달
		return null;
	}

}
