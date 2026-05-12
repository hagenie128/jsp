package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;
import view.ModelAndView;
import vo.StudentVO;

/**
 * 학번을 입력받아 해당 학생의 정보를 수정하는 기능을 담당하는 컨트롤러
 */
public class StudentUpdateController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 데이터 받는 부분
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String majorName = request.getParameter("majorName");
		double score = Double.parseDouble(request.getParameter("score"));
		//수정할 학생 정보 조회
		StudentVO vo = StudentService.getInstance().searchStudentVO2(no);
		//받은 값으로 학생정보 수정
		vo.setName(name);
		vo.setMajorName(majorName);
		vo.setScore(score);
		// 페이지 이동처리 및 전달할 데이터 세팅
		return new ModelAndView(request.getContextPath()+"main.do", true);
	}
}







