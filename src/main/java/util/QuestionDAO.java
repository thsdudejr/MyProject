package util;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.MemberVO;
import vo.QuestionVO;

@Repository
public class QuestionDAO {

	@Autowired
	private SqlSession sql;
	private static final String QS="com.ncs.QuestionMapper.";
	
	//qnaList
	public List<QuestionVO>qnaList(){
		return sql.selectList(QS+"qnaList");
	}
	//qnaInsert
	public int qnaInsert(QuestionVO vo) {
		return sql.insert(QS+"qnaInsert",vo);
	}
	
	public QuestionVO selectOne(QuestionVO vo) {
		return sql.selectOne(QS+"selectOne",vo);
	}
	
	public int update(QuestionVO vo) {
		return sql.update(QS+"update", vo);
	}
}
