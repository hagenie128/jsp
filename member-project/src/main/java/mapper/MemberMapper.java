package mapper;

import java.util.List;

import dto.MemberDTO;

public interface MemberMapper {

	public List<MemberDTO> selectAllMember();

	public boolean insertMember(MemberDTO dto);
	
}
