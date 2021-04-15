package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.AdminDAO;
import vo.MemberVO;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO dao;

	public List<MemberVO> adminMemberList() {
		return dao.memberList();
	}
	public int update(MemberVO vo) {
		return dao.update(vo);
	}
	
	public MemberVO selectOne(MemberVO vo) {
		return dao.selectOne(vo);
	}

}
