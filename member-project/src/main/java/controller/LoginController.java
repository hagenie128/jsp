package controller;

import java.io.IOException;
import java.io.PrintWriter;
import dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.MemberService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");

		MemberDTO member = MemberService.getInstance().login(id, passwd);

		// 3. 로그인 결과에 따라 처리를 분기합니다.
		if (member == null) {
			// 3-1. 로그인 실패 시: 경고창을 띄우고 이전 페이지(로그인 폼)로 돌아갑니다.
			response.setContentType("text/html;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('로그인 실패 하셨습니다.\\n아이디와 비밀번호를 확인해 주세요');");
			pw.println("history.back();"); // 브라우저의 이전 기록으로 이동
			pw.println("</script>");
			
			return null; // 직접 스크립트로 응답했으므로 ModelAndView는 필요 없음
		} else {
			// 3-2. 로그인 성공 시: 세션(Session)에 회원 정보를 저장합니다.
			// 세션에 저장된 정보는 브라우저를 닫거나 로그아웃 전까지 유지됩니다.
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			System.out.println(member);
			// 메인 페이지(main.do)로 리다이렉트합니다.
			return new ModelAndView("./main.do", true);
		}
	}
}
