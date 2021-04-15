package service;

import vo.UserVO;

public interface SendMailService {
	public boolean sendEmail(UserVO vo);
}
