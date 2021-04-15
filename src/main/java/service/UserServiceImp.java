package service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.UserDAO;
import vo.AllBusVO;
import vo.UserVO;



@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDAO dao;
	

	public int join(UserVO vo) {
		return dao.join(vo);
	}
	
	@Override	
	public UserVO selectOne(UserVO vo) {
		return dao.selectOne(vo);
	}
	
	public UserVO ufindID(UserVO vo) {
		return dao.ufindID(vo);
	}
	
	@Override
	public int updatePassword(UserVO vo) {
		return dao.updatePassword(vo);
	}
	
	@Override
	public List<AllBusVO> terminalList(String area){
		return dao.terminalList(area);
	}


	
	
	

	
	
	
	
}
