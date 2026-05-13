package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;
import view.ModelAndView;
import vo.StudentVO;

public class StudentUpdateViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 전송할 학번 뽑음
		String no = request.getParameter("no");
		//Service 클래스에서 해당 학생 정보 가져옴
		StudentVO vo = StudentService.getInstance().searchStudentVO2(no);
		//update 로 학번 전송
		request.setAttribute("vo", vo);
		return new ModelAndView("student_update", false);
	}

}
