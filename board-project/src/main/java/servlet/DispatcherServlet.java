package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view.ModelAndView;

import java.io.IOException;

import controller.Controller;
import controller.HandlerMapping;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("*.do") // .do 로 끝나는 모든 요청을 처리하는 서블릿, 앞에 / 가 들어가면 안됨
@MultipartConfig(maxRequestSize = 1024 * 1024 * 50, maxFileSize = 1024 * 1024 * 5) // 50메가, 5메가
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI(); // 요청 URI 가져오기
		String contextPath = request.getContextPath(); // 컨텍스트 패스 가져오기
		String path = uri.substring(contextPath.length() + 1); // 컨텍스트 패스 제거하여 실제 요청 경로 얻기
//		System.out.println(uri);
//		System.out.println(contextPath);
//		System.out.println(path);

		// servlet 컨테이너가 요청 경로에 해당하는 컨트롤러 객체를 생성하도록
		// HandlerMapping 클래스의 createController 메서드 호출

		Controller controller = HandlerMapping.getInstance().createController(path); // 요청 경로에 해당하는 컨트롤러 생성
		// 페이지 이동할 곳 정보를 담고있는 객체 ModelAndView
		ModelAndView view = null;
		if (controller != null)
			view = controller.execute(request, response); // 컨트롤러 실행

		// 페이지 이동
		if (view != null) {
			if (view.isRedirect()) {
				// 리다이렉트 방식으로 페이지 이동
				response.sendRedirect(contextPath + "/" + view.getPath());
			} else {
				// 포워드 방식으로 페이지 이동
				request.getRequestDispatcher(view.getPath()).forward(request, response);
			}
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
