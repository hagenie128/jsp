package mapper;

import java.util.List;
import java.util.Map;

import dto.StudentDTO;

public interface StudentMapper {
	public List<StudentDTO> selectAllStudent();

	public List<StudentDTO> selectForName(String name);

	public StudentDTO selectForNo(String no);

	public int insertStudent(StudentDTO dto);

	public int deleteStudent(String no);

	public int updateStudent(StudentDTO dto);
	
	public List<Map<String, Object>> selectStudentDeptCount();

	public List<StudentDTO> selectForNameStudent(String name);
}
