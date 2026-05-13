package service;

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
		if(instance == null)
			instance = new MemberService();
		return instance;
	}

	public List<MemberDTO> selectAllMember() {
		return mapper.selectAllMember();
	}

	public boolean insertMember(MemberDTO dto) {
		return mapper.insertMember(dto);
	}
	
	public boolean checkId(String id){
		return mapper.CheckId(id);
	}

	public List<MemberDTO> memberSearch(String text) {
		return mapper.memberSearch(text);
	}
}
