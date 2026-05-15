package controller;

import java.io.IOException;

import dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;
import view.ModelAndView;

public class UpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String no = request.getParameter("no");
		String passwd = request.getParameter("passwd");
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		// 2. 입력받은 데이터를 MemberDTO 객체에 담아서 서비스 클래스로 전달합니다.
		MemberService.getInstance().updateMember(new MemberDTO(Integer.parseInt(no), null, passwd, userName, nickName));

		return new ModelAndView("./main.do", true);
	}
}
