package service;

import java.util.List;

import config.DBManager;
import dto.StudentDTO;
import mapper.StudentMapper;

/**
 * 학생 데이터를 관리(저장, 검색)하는 핵심 서비스 클래스 싱글톤 패턴을 적용하여 프로그램 전체에서 동일한 데이터 저장소(arr)를 공유함
 */
public class StudentService {
	// 자기 자신의 인스턴스를 하나만 생성하여 유지함 (싱글톤)
	private static StudentService instance = new StudentService();

	// 데이터 저장용 리스트 생성
	private StudentMapper mapper;


	private StudentService() {
		mapper = DBManager.getInstance().getSession().getMapper(StudentMapper.class);
	}


	public static StudentService getInstance() {
		if (instance == null)
			instance = new StudentService();
		return instance;
	}


	public StudentDTO searchStudent(String no) {
		return mapper.selectForNo(no);
	}

	public boolean appendStudentDTO(StudentDTO dto) {
		return mapper.insertStudent(dto) != 0;
	}

	public boolean deleteStudentDTO(String no) {
		return mapper.deleteStudent(no) != 0;
	}

	public List<StudentDTO> searchStudentForName(String name) {
		return mapper.selectForName(name);
	}

	public List<StudentDTO> selectAllStudent() {
		return mapper.selectAllStudent();
	}

	public boolean updateStudent(StudentDTO dto) {
		return mapper.updateStudent(dto) != 0;
	}
}
