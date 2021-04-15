package service;

import java.util.List;

import vo.QuestionVO;

public interface QuestionService {
	
	public List<QuestionVO> qnaList();
	
	public int qnaInsert(QuestionVO vo);
	
	public QuestionVO selectOne(QuestionVO vo);
	
	public int update(QuestionVO vo);

}
