package com.ncs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import service.QuestionService;
import service.SendMailService;
import service.UserService;
import vo.AllBusVO;
import vo.QuestionVO;
import vo.UserVO;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j
public class UserController {

	@Autowired
	UserService Service;

	@Autowired
	SendMailService mailService;

	@Autowired
	QuestionService qService;

	// user main page
	@RequestMapping(value = "/main")
	public ModelAndView main(ModelAndView mv) {
		mv.setViewName("user/main/main");
		return mv;
	}

	// user login page
	@RequestMapping(value = "/login")
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("user/login/login");
		return mv;
	}

	@RequestMapping(value = "/ulogin", method = RequestMethod.POST)
	public ModelAndView ulogin(HttpServletRequest req, ModelAndView mv, UserVO vo) {

		String password = vo.getPassword();
		vo = Service.selectOne(vo);
		if (vo != null) { // 성공
			if (vo.getPassword().equals(password)) {
				req.getSession().setAttribute("email", vo.getEmail());
				mv.setViewName("user/main/main");
				mv.addObject("vo", vo);
			} else { // password 오류
				mv.addObject("message", "비밀번호 오류 다시 입력하세요");
				mv.setViewName("user/login/login");
			}
		} else { // eamil 오류
			mv.addObject("message", "email 오류 다시 입력하세요");
			mv.setViewName("user/login/login");
		}
		return mv;

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, ModelAndView mv) {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("email") != null) {
			session.invalidate();
		}
		mv.setViewName("user/main/main");
		return mv;
	}

	// user find id page
	@RequestMapping(value = "/findID")
	public ModelAndView findID(ModelAndView mv) {
		mv.setViewName("user/login/findID");
		return mv;
	}

	// user findid
	@RequestMapping(value = "/ufindID", method = RequestMethod.POST)
	public ModelAndView ufindId(HttpServletRequest req, ModelAndView mv, UserVO vo) {
		String phone = vo.getPhone();
		vo = Service.ufindID(vo);
		if (vo != null) {
			mv.addObject("email", vo.getEmail());
		}
		mv.setViewName("jsonView");
		return mv;
	}

	// user find pw page
	@RequestMapping(value = "/findPW")
	public ModelAndView findPW(ModelAndView mv) {
		mv.setViewName("user/login/findPW");
		return mv;
	}

	// user findpassword
	@RequestMapping(value = "/ufindPW", method = RequestMethod.POST)
	public ModelAndView ufindPW(HttpServletRequest req, ModelAndView mv, UserVO vo) {
		vo = Service.selectOne(vo);
		if (vo != null) {
			mv.addObject("email", vo.getEmail());
			mv.setViewName("jsonView");
		}
		return mv;
	}

	@RequestMapping(value = "/sendEmail")
	public String sendEmail(UserVO vo) {
		if (mailService.sendEmail(vo)) {
			// 발송 성공구간
			return "user/login/login";
		}
		return "user/login/findPW";
	}

	@RequestMapping(value = "/join")
	public ModelAndView join(ModelAndView mv) {
		mv.setViewName("user/join/join");
		return mv;
	}

	// user join page
	@RequestMapping(value = "/ujoin")
	public ModelAndView join(ModelAndView mv, UserVO vo) {
		int join = Service.join(vo);
		String url = "user/join/join";
		if (join > 0) {
			mv.addObject("message", " 회원 가입 성공 로그인 후 이용하세요 ~~");
			mv.setViewName("user/login/login");
		} else {
			mv.addObject("message", " 회원 가입 실패 ");
			mv.setViewName("user/join/join");
		}
		return mv;

	}

	// user ticketing search page
	@RequestMapping(value = "/search")
	public ModelAndView search(ModelAndView mv) {
		mv.setViewName("user/ticketing/search");
		return mv;
	}

	@RequestMapping(value = "/seat")
	public ModelAndView seat(ModelAndView mv) {
		mv.setViewName("user/ticketing/seat");
		return mv;
	}

	@RequestMapping(value = "/myPage")
	public ModelAndView myPage(ModelAndView mv , UserVO vo, HttpSession session) {
		vo.setEmail((String)session.getAttribute("email"));
		vo= Service.selectOne(vo);
		mv.addObject("myinfo",vo);
		mv.setViewName("user/myPage/home");
		return mv;
	}

	@RequestMapping(value = "/changeNumber")
	public ModelAndView changeNumber(ModelAndView mv) {
		mv.setViewName("user/myPage/changeNumber");
		return mv;
	}
	@RequestMapping(value = "/changeNumber" ,method = RequestMethod.POST)
	public ModelAndView changeNumber (ModelAndView mv , UserVO vo) {
		Service.changeNumber(vo);
		mv.setViewName("redirect:/main");
		return mv;
	}
	

	@RequestMapping(value = "/changePW")
	public ModelAndView changePW(ModelAndView mv) {
		mv.setViewName("user/myPage/changePW");
		return mv;
	}
	@RequestMapping(value = "/changePW" ,method = RequestMethod.POST)
	public ModelAndView changePW(ModelAndView mv , UserVO vo, HttpSession session) {
		Service.changePW(vo);
		session.invalidate();
		mv.setViewName("redirect:/login");
		return mv;
	}
	

	@RequestMapping(value = "/ticketList")
	public ModelAndView ticketList(ModelAndView mv) {
		mv.setViewName("user/myPage/ticketList");
		return mv;
	}

	@RequestMapping(value = "/terminal")
	// terminal?area=서울
	public ModelAndView terminalList(ModelAndView mv,
			@RequestParam(defaultValue = "서울", required = false) String area) {
		List<AllBusVO> list = Service.terminalList(area);
		mv.addObject("areaList", list);
		mv.setViewName("user/terminal/terminal");
		return mv;
	}

	@RequestMapping(value = "/qnaList")
	public ModelAndView qnaList(ModelAndView mv) {
		List<QuestionVO> list = qService.qnaList();
		System.out.println(list);
		mv.addObject("li", list);
		mv.setViewName("user/qna/list");
		return mv;
	}

	@RequestMapping(value = "/qnaRegister")
	public ModelAndView qnaRegister(HttpSession session, ModelAndView mv, HttpServletRequest req) {
		mv.setViewName("user/qna/register");

		String email = (String) session.getAttribute("email");

		if (email == null) {
			mv.setViewName("user/login/login");
		} else {
			mv.setViewName("user/qna/register");
		}

		return mv;
	}

	@RequestMapping(value = "/qnaInsert", method = RequestMethod.POST)
	public ModelAndView insertQna(ModelAndView mv , QuestionVO vo) {
		
		if(qService.qnaInsert(vo)>0) {
			mv.setViewName("redirect:qnaList");
		}else {
			mv.setViewName("user/main/main");
		}
	
		return mv;
	}

}
