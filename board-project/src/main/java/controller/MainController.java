package controller;

import java.io.IOException;
import java.util.List;

import dto.BoardDTO;
import dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.BoardService;
import service.MemberService;
import view.ModelAndView;

public class MainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		1. 페이지 번호 읽어오기, 만약 없다면? 1
		String pageNo = request.getParameter("pageNo");
		int page = pageNo == null? 1 : Integer.parseInt(pageNo);
		
//		2. 페이지 번호에 해당하는 게시글 목록 읽어옴
		List<BoardDTO> list = BoardService.getInstance().selectBoardList(page);
//		3. 읽어온 list request 영역에 저장
		request.setAttribute("list", list);
		request.setAttribute("pageNo", pageNo);
//		3. main.jsp로 이동
		return new ModelAndView("main", false);
	}

}
