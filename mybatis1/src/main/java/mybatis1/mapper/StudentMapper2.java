package mybatis1.mapper;

import java.util.List;
import java.util.Map;

import mybatis1.config.DBManager;
import mybatis1.dto.StudentDTO1;

//mapper 객체를 만들지 않고 하는 방법(서비스와 통합 버전, 인터페이스 x)
public class StudentMapper2 {
	private DBManager manager;
	
	public StudentMapper2() {
		manager = DBManager.getInstance();
	}
	
	public List<StudentDTO1> selectAllStudent(){
		//가져올 값이 많은 경우 list, 하나일 경우는 selectOne, One 으로 했는데 여러건이 나오면 터짐
		return manager.getSession().selectList("selectAllStudent");
	}
	public StudentDTO1 selectForNo(String no) {
		return manager.getSession().selectOne("selectForNo",no);
	}
	public int insertStudent(StudentDTO1 dto) {
		return manager.getSession().insert("insertStudent", dto);
	}
	public int deleteStudent(String no) {
		return manager.getSession().insert("deleteStudent", no);
	}
	public int updateStudent(StudentDTO1 dto) {
		return manager.getSession().insert("updateStudent", dto);
	}
	public List<Map<String, Object>> selectStudentDeptCount(){
		return manager.getSession().selectList("selectStudentDeptCount");
	}
}
