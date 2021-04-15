package service;

import java.util.List;

import vo.MemberVO;

public interface AdminService {

	public List<MemberVO> adminMemberList();
	
	public int update(MemberVO vo);
	
	public MemberVO selectOne(MemberVO vo);

}
