package com.spring.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.btz.user.UserVO;
import com.spring.btz.user.impl.UserDAO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리");
		
		//1.사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		System.out.println("id: " +id +"/passwoard: " + password);
		
		//2.DB연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser(vo);
		
		ModelAndView mv = new ModelAndView();
		if(user != null){
			System.out.print("user[");
			System.out.print(user.getId()+", "+user.getPassword());
			System.out.println("]");
			
			System.out.println("-->getBoardList.do");
			mv.setViewName("redirect:getBoardList.do");
		}else {
			System.out.println("-->login.jsp");
			mv.setViewName("redirect:login.jsp");
		}
		return mv;
	}
	
}
