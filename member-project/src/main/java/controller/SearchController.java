package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;
import view.ModelAndView;

public class SearchController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		
		List<MemberDTO> list = MemberService.getInstance().searchMembers(kind,search);
		int resultCount = list.size();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("msg", resultCount+"건 조회 완료");
		map.put("kind",kind);
		map.put("seaech",search);
		map.put("list",list);
		
		
		JSONObject json = new JSONObject(map);
		response.getWriter().println(json.toString());
		
		return null;
	}

}
