package service;

import java.util.HashMap;
import java.util.List;

import config.DBManager;
import dto.MemberDTO;
import mapper.MemberMapper;

public class MemberService {
	private static MemberService instance = new MemberService();
	MemberMapper mapper;

	private MemberService() {
		mapper = DBManager.getInstance().getSession().getMapper(MemberMapper.class);
	}

	public static MemberService getInstance() {
		if (instance == null)
			instance = new MemberService();
		return instance;
	}

	public List<MemberDTO> selectAllMember() {
		return mapper.selectAllMember();
	}

	public int insertMember(MemberDTO memberDTO) {
		int result = 0;

		try {
			// 매퍼를 통해 실제 DB에 INSERT 쿼리를 실행합니다.
			result = mapper.insertMember(memberDTO);
		} catch (Exception e) {
			// 오류 발생 시 콘솔에 출력합니다.
			e.printStackTrace();
		}

		return result;
	}

	public List<MemberDTO> memberSearch(String text) {
		return mapper.memberSearch(text);
	}

	public MemberDTO selectMemberById(String id) {
		return mapper.selectMemberById(id);
	}

	public MemberDTO login(String id, String passwd) {
		// MyBatis에 여러 데이터를 보낼 때 Map에 담아서 전달합니다.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("passwd", passwd);

		MemberDTO dto = mapper.login(map);

		return dto;
	}

	public int delete(String no) {
		return mapper.delete(no);
	}

	public List<MemberDTO> searchMembers(String kind, String search) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("kind", kind);
		map.put("search", search);
		return mapper.searchMembers(map);
	}

	public MemberDTO selectMemberByNo(String no) {
		return mapper.selectMemberByNo(no);
	}

	public int updateMember(MemberDTO memberDTO) {
		return mapper.updateMember(memberDTO);
	}
}
