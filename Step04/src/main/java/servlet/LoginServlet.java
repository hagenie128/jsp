package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		HttpSession session = request.getSession();//세션 호출

		if (id.equals("admin") && pw.equals("123456")) {
			session.setAttribute("msg", id+"님 환영합니다");//세션에 정보 저장
			request.getRequestDispatcher("/WEB-INF/views/login_success.jsp").forward(request, response);
		} else if (id.equals("admin")) {
			request.setAttribute("result", "비밀번호를 다시 확인해주세요.");
			request.getRequestDispatcher("/WEB-INF/views/login_fail.jsp").forward(request, response);
		} else {
			request.setAttribute("result", "로그인 정보를 다시 확인해주세요");
			request.getRequestDispatcher("/WEB-INF/views/login_fail.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
