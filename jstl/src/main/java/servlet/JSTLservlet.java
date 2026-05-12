package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

import dto.BoardMemderDTO;

/**
 * Servlet implementation class JSTLservlet
 */
@WebServlet("/jstl.do")
public class JSTLservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JSTLservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 보드멤버 생성
		BoardMemderDTO dto = new BoardMemderDTO("A0001", "홍길동", "123456", "HongKD");
		// session 생성
		// session에 dto 저장 - 키값 : user
		HttpSession session = request.getSession();
		session.setAttribute("user", dto);
		session.setAttribute("msg", "세션 메세지 내용");
		// ArrayList<BoardMemberDTO> 생성해서 데이터를 3건을 저장
		ArrayList<BoardMemderDTO> list = new ArrayList<>();
		list.add(new BoardMemderDTO("A0002", "박한수", "123456", "Park"));
		list.add(new BoardMemderDTO("A0003", "이영희", "123456", "Lee"));
		list.add(new BoardMemderDTO("A0004", "하상진", "123456", "Ha"));
		// request에 저장 - 키값 : list
		request.setAttribute("list", list);
		request.setAttribute("age", 35);
		/* request.setAttribute("msg", "request 메세지 내용"); */
		// 이동할 페이지는 jstl_el.jsp

		request.getRequestDispatcher("./jstl_el.jsp").forward(request, response);

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
