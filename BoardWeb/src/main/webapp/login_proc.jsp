<%@page import="com.spring.btz.user.impl.UserDAO"%>
<%@page import="com.spring.btz.user.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1.사용자 입력 정보 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//2.DB연동 처리
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO dao = new UserDAO();
	UserVO user = dao.getUser(vo);
	
	if(user != null){
		response.sendRedirect("getBoardList.jsp");
	}else {
		response.sendRedirect("login.jsp");
	}
%>