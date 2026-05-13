package controller;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MemberService;
import view.ModelAndView;

public class RegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String hashedPw = BCrypt.hashpw(passwd, BCrypt.gensalt(10));
		boolean flag = MemberService.getInstance().insertMember(new MemberDTO(0,id, hashedPw, userName, nickName));
		request.setAttribute("flag", flag);
		request.setAttribute("msg", flag ? 
				"회원 가입이 완료되었습니다" : "회원 가입이 실패하였습니다.");
		ModelAndView view = new ModelAndView("register_result", false);
		return view;
	}

}
