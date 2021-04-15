package util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;

import vo.MemberVO;

@Repository
public class AdminDAO {

	@Autowired
	private SqlSession sqlsession;
	private static final String NS = "com.ncs.AdminMapper.";

	// memberList
	public List<MemberVO> memberList() {
		return sqlsession.selectList(NS + "memberList");
	}
	
	//update
	public int update(MemberVO vo) {
		return sqlsession.update(NS+"update",vo);
	}
	//selectOne
	public MemberVO selectOne(MemberVO vo) {
		return sqlsession.selectOne(NS+"selectOne",vo);
	}

}
