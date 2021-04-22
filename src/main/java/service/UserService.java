package service;


import java.util.List;

import vo.AllBusVO;
import vo.UserVO;

public interface UserService {
	
	
	public int join(UserVO vo);
	
	
	public UserVO selectOne(UserVO vo);
	
	public UserVO ufindID(UserVO vo);
	
	public int updatePassword(UserVO vo);
	
	public List<AllBusVO> terminalList(String area);
	
	public int changePW(UserVO vo);
	
	public int changeNumber(UserVO vo);
	
}
