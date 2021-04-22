package util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.AllBusVO;
import vo.UserVO;

@Repository
public class UserDAO {

	@Autowired
	private SqlSession sql;
	private static final String US = "com.ncs.UserMapper.";

	// join
	public int join(UserVO vo) {
		return sql.insert(US + "join", vo);
	}

	// selectOne
	public UserVO selectOne(UserVO vo) {
		return sql.selectOne(US + "selectOne", vo);
	}

	// findID
	public UserVO ufindID(UserVO vo) {
		return sql.selectOne(US + "ufindID", vo);
	}

	public int updatePassword(UserVO vo) {
		return sql.update(US + "updatePassword", vo);
	}

	public List<AllBusVO> terminalList(String area) {
		return sql.selectList(US + "terminalList", area);
	}
	
	public int changePW(UserVO vo) {
		return sql.update(US+"changePW",vo);
	}
	public int changeNumber(UserVO vo) {
		return sql.update(US+"changeNumber",vo);
	}

}
