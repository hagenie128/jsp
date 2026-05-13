package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;
import view.ModelAndView;

/**
 * 학번을 입력받아 해당 학생의 정보를 수정하는 기능을 담당하는 컨트롤러
 */
public class StudentUpdateController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 데이터 받는 부분
		String student_id = request.getParameter("student_id");
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		double gpa = Double.parseDouble(request.getParameter("gpa"));
		StudentService.getInstance().updateStudent(new dto.StudentDTO(student_id, name, department, gpa));
		return new ModelAndView(request.getContextPath()+"main.do", true);
	}
}







