package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spring.btz.board.BoardVO;
import com.spring.btz.board.impl.BoardDAO;
import com.spring.view.controller.Controller;

public class GetBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		
		return "getBoard";
	}
	
}
