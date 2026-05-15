package mapper;

import java.util.HashMap;
import java.util.List;

import dto.MemberDTO;

public interface MemberMapper {

	public List<MemberDTO> selectAllMember();

	public int insertMember(MemberDTO dto);

	public List<MemberDTO> memberSearch(String text);

	public MemberDTO selectMemberById(String id);

	public MemberDTO login(HashMap<String, String> map);

	public int delete(String no);

	public List<MemberDTO> searchMembers(HashMap<String, String> map);

	
}
