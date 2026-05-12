package service;

import java.util.ArrayList;

import dao.StudentDAO;
import vo.StudentVO;

/**
 * 학생 데이터를 관리(저장, 검색)하는 핵심 서비스 클래스 싱글톤 패턴을 적용하여 프로그램 전체에서 동일한 데이터 저장소(arr)를 공유함
 */
public class StudentService {
	// 자기 자신의 인스턴스를 하나만 생성하여 유지함 (싱글톤)
	private static StudentService instance = new StudentService();

	// 데이터 저장용 리스트 생성
	private ArrayList<StudentVO> list;
	private StudentDAO dao; 


	private StudentService() {
		dao = StudentDAO.getInstance();
	}

	/**
	 * 어디서든 동일한 서비스 객체에 접근할 수 있도록 인스턴스를 반환하는 메서드
	 */
	public static StudentService getInstance() {
		if (instance == null)
			instance = new StudentService();
		return instance;
	}

	/**
	 * 전체 학생 리스트를 반환하는 메서드
	 * 
	 * @return 학생 리스트
	 */
	public ArrayList<StudentVO> getList() {
		return list;
	}

	/**
	 * 학번을 기준으로 학생의 인덱스를 찾는 메서드
	 * 
	 * @param no 검색할 학번
	 * @return 찾으면 해당 인덱스, 못 찾으면 -1
	 */
	public int searchStudentVO(String no) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNo().equals(no))
				return i;
		}
		return -1;
	}

	public StudentVO searchStudentVO2(String no) {
		return dao.selectStudent(no);
	}

	public boolean appendStudentVO(StudentVO vo) {
		return dao.insertStudent(vo) != 0;
	}

	public boolean deleteStudentVO(String no) {
		return dao.deleteStudent(no) != 0;
	}

	public ArrayList<StudentVO> searchStudentVOForName(String name) {
		return dao.selectForNameStudent(name);
	}

	public ArrayList<StudentVO> selectAllStudent() {
		return dao.selectAllStudent();
	}

	public boolean updateStudent(StudentVO vo) {
		return dao.updateStudent(vo) != 0;
	}
}
