package controller;

import java.io.IOException;
import java.util.ArrayList;

import dto.StudentVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;
import view.ModelAndView;

/**
 * 전체 학생 정보를 조회하여 출력하는 기능을 담당하는 컨트롤러
 */
public class StudentAllPrintController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<StudentVO> list = StudentService.getInstance().selectAllStudent();
		
		//사용자에게 보여줄 데이터 셋팅
		request.setAttribute("list", list);
		
		//이동할 경로 셋팅
		ModelAndView view = new ModelAndView("main", false);
		System.out.println(view.getPath());
		return view;
	}
}





