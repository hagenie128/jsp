package controller;

import java.io.IOException;

import dto.StudentVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.StudentService;
import view.ModelAndView;

/**
 * 사용자로부터 학생 정보를 입력받아 시스템에 등록하는 기능을 담당하는 컨트롤러
 */
public class StudentInsertController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		// 데이터 받는 부분
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String majorName = request.getParameter("majorName");
		double score = Double.parseDouble(request.getParameter("score")); 
		// 값이 없거나 숫자가 아닌 경우 NumberFormatException 발생 가능
		System.out.println(no + "," + name + "," + majorName + "," + score);
		// 데이터 처리하는 부분
		boolean flag = StudentService.getInstance().appendStudentVO(
				new StudentVO(no, name, majorName, score));
		ModelAndView view = new ModelAndView("insert_result", false);
		// 페이지 이동처리 및 전달할 데이터 세팅
		request.setAttribute("flag", flag);
		request.setAttribute("msg", flag ? 
				"학생정보 추가가 완료되었습니다" : "학생정보 추가에 실패하였습니다.");

		return view;
	}
}
