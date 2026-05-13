package mybatis1.main;

import java.util.List;
import java.util.Map;

import config.DBManager;
import mybatis1.dto.StudentDTO1;
import mybatis1.mapper.StudentMapper;

public class TestMain {
	public static void main(String[] args) {
		//맵퍼 객체를 생성
		StudentMapper mapper = DBManager.getInstance()
				.getSession().getMapper(StudentMapper.class);
//		//전체 조회
//		List<StudentDTO1> list = mapper.selectAllStudent();
//		
//		for(StudentDTO1 dto :list) 
//			System.out.println(dto);
		
//		String name = "재원";
//		List<StudentDTO1> list = mapper.selectForName(name);
//		
//		for(StudentDTO1 dto :list) 
//		System.out.println(dto);
		
//		String no = "20229928";
//		//학번으로 조회
//		StudentDTO1 dto = mapper.selectForNo(no);
//		System.out.println(dto);
		
		//학생정보 한건 추가
//		StudentDTO1 dto = new StudentDTO1("22222222","김철수","물리학과",3.5);
//		int count = mapper.insertStudent(dto);
//		System.out.println("결과 : "+count);
		
		//학생정보 한건 삭제
//		String no = "22222222";
//		int count = mapper.deleteStudent(no);
//		System.out.println("결과 : "+count);
		
		//학생정보 수정
//		StudentDTO1 dto = new StudentDTO1("20229928","김철수","물리학과",3.2);
//		int count = mapper.updateStudent(dto);
//		System.out.println("결과 : "+count);
		
		//학과별 학생수 조회
		List<Map<String,Object>> list = mapper.selectStudentDeptCount();
		for(Map<String, Object> map :list) {
			System.out.println(map.get("major_name")+":"+map.get("major_count"));
		}
	}
}
