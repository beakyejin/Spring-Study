package com.spring.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.btz.user.UserVO;
import com.spring.btz.user.impl.UserDAO;

@Controller
public class LoginController {

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("로그인 화면 이동");
		vo.setId("test");
		vo.setPassword("test123");
		
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO dao, HttpSession session) {
		System.out.println("로그인 처리");
		
		UserVO user = dao.getUser(vo);
		
		if(user != null){
			System.out.print("user[");
			System.out.print(user.getId()+", "+user.getPassword());
			System.out.println("]");
			session.setAttribute("userName", user.getName());
			
			return "getBoardList.do";
		}else {
			return "login.jsp";
		}
	}
	
}
