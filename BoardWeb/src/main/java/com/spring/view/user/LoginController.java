package com.spring.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.btz.user.UserVO;
import com.spring.btz.user.impl.UserDAO;
import com.spring.view.controller.Controller;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		
		if(user != null){
			System.out.print("user[");
			System.out.print(user.getId()+", "+user.getPassword());
			System.out.println("]");
			
			System.out.println("-->getBoardList.do");
			return "getBoardList.do";
		}else {
			System.out.println("-->login.jsp");
			return "login";
		}
		
	}
	
}
