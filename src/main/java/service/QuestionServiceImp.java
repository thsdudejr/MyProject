package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.QuestionDAO;
import vo.QuestionVO;

@Service
public class QuestionServiceImp implements QuestionService{

	@Autowired
	QuestionDAO dao;
	
	@Override
	public List<QuestionVO>qnaList(){
		return dao.qnaList();
	}
	
	@Override
	public int qnaInsert(QuestionVO vo) {
		return  dao.qnaInsert(vo);
	}
	
	@Override
	public QuestionVO selectOne(QuestionVO vo) {
		return dao.selectOne(vo);
	}
	
	@Override
	public int update(QuestionVO vo) {
		return dao.update(vo);
	}
}
