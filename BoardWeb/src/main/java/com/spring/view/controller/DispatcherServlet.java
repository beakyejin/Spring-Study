package com.spring.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.btz.board.BoardVO;
import com.spring.btz.board.impl.BoardDAO;
import com.spring.btz.user.UserVO;
import com.spring.btz.user.impl.UserDAO;

/*@WebServlet("*.do")*/
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1 클라이언트의 요청 path 정보 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		//2 클라이언트의 요청 path에 따라 적절히 분기 처리 
		if(path.equals("/login.do")) {
			System.out.println("로그인");
			
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
				response.sendRedirect("getBoardList.do");
			}else {
				System.out.println("-->login.jsp");
				response.sendRedirect("login.jsp");
			}
			
		}else if(path.equals("/logout.do")) {
			System.out.println("로그아웃");
			
			HttpSession session = request.getSession();
			session.invalidate();
			
			response.sendRedirect("login.jsp");
			
		}else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록");
			
			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO dao = new BoardDAO();
			dao.insertBoard(vo);
			
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정");
			
			request.setCharacterEncoding("UTF-8");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO dao = new BoardDAO();
			dao.updateBoard(vo);
			
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제");
			
			String seq = request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO dao = new BoardDAO();
			dao.deleteBoard(vo);
			
			response.sendRedirect("getBoardList.do");
			
		}else if(path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회");
			
			String seq = request.getParameter("seq");
			System.out.println("seq:"+seq);
			
			int int_seq = Integer.parseInt(seq);
			BoardVO vo = new BoardVO();
			vo.setSeq(int_seq);
			
			BoardDAO dao = new BoardDAO();
			BoardVO boardvo = dao.getBoard(vo);
			
			System.out.println("boardvo: " + boardvo.toString());
			
			HttpSession session = request.getSession();
			session.setAttribute("boardvo", boardvo);
			
			response.sendRedirect("getBoard.jsp");
		}else if(path.equals("/getBoardList.do")) {
			System.out.println("글 목록");
			
			//1.사용자 입력 정보 추출
			//2.DB 연동 처리
			BoardDAO dao = new BoardDAO();
			List<BoardVO> boardList = dao.getBoardList();
			
			//3. 검색 결과 세션 저장하고 목록 화면 이동
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			response.sendRedirect("getBoardList.jsp");
		}
	}

}