package controller;

import java.io.IOException;
import java.util.List;

import dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;
import view.ModelAndView;

public class MemberSearchController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String text = request.getParameter("text");
		List<MemberDTO> list = MemberService.getInstance().memberSearch(text);
		request.setAttribute("list", list);
		ModelAndView view = new ModelAndView("main", false);
		return view;
	}

}
