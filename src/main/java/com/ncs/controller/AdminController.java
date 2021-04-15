package com.ncs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.AdminService;
import service.QuestionService;
import vo.MemberVO;
import vo.QuestionVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@Autowired
	QuestionService qService;

	// admin member update , delete

	// admin member list
	@RequestMapping(value = "/adminMemberList")
	public String adminMemberList(Model model) {
		List<MemberVO> list = service.adminMemberList();
		String url = "admin/member/list";
		if (list != null) {
			model.addAttribute("li", list);
		} else {
			url = "admin/member/list";
		}
		return url;
	}
	
	// admin member modify
	@RequestMapping(value = "/adminMemberModify")
	public ModelAndView adminMemberModify(ModelAndView mv , MemberVO vo) {
		vo= service.selectOne(vo);
		if(vo == null) {
			mv.setViewName("admin/member/list");
		}else {
			mv.setViewName("admin/member/modify");
			mv.addObject("info",vo);
		}
		return mv;
	}
	@RequestMapping(value = "/memberUpdate")
	public ModelAndView memberUpdate(ModelAndView mv , MemberVO vo) {
		
		if(service.update(vo)>0) {
			//성공
			mv.setViewName("redirect:adminMemberList");
		}else {
			//실패
			mv.setViewName("admin/member/modify");
			mv.addObject("message", "실패했습니다");
		}
		
		return mv;
	}
	
	

	// admin ticketing list
	@RequestMapping(value = "/adminTicketingList")
	public ModelAndView adminTicketingList(ModelAndView mv) {
		mv.setViewName("admin/ticketing/list");
		return mv;
	}

	// admin member detail
	@RequestMapping(value = "/adminQuestionsList")
	public ModelAndView adminQuestionsList(ModelAndView mv) {
		mv.setViewName("admin/questions/list");
		List<QuestionVO> list = qService.qnaList();
		System.out.println(list);
		mv.addObject("li", list);
		return mv;
	}

	// admin member detail
	@RequestMapping(value = "/adminQuestionsDetail")
	public ModelAndView adminQuestionsDetail(ModelAndView mv, QuestionVO vo) {
		mv.setViewName("admin/questions/detail");
		vo= qService.selectOne(vo);
		mv.addObject("info",vo);
		return mv;
	}
	
	
	@RequestMapping(value = "/questionUpdate")
	public String questionUpdate(Model model, QuestionVO vo) {
		if(qService.update(vo) > 0) {
			return "redirect:adminQuestionsList";
		}
		model.addAttribute("message", "답변등록 실패");
		return "admin/questions/detail";
	}
	
	
	

}
