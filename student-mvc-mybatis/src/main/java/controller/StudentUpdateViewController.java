package controller;

import java.io.IOException;

import dto.StudentDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;
import view.ModelAndView;

public class StudentUpdateViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 전송할 학번 뽑음
		String student_id = request.getParameter("student_id");
		//Service 클래스에서 해당 학생 정보 가져옴
		StudentDTO dto = StudentService.getInstance().searchStudent(student_id);
		//update 로 학번 전송
		request.setAttribute("dto", dto);
		return new ModelAndView("student_update", false);
	}

}
