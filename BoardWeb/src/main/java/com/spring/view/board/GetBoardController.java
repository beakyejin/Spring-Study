package com.spring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.btz.board.BoardVO;
import com.spring.btz.board.impl.BoardDAO;

public class GetBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 상세 조회");
		
		String seq = request.getParameter("seq");
		System.out.println("seq:"+seq);
		
		int int_seq = Integer.parseInt(seq);
		BoardVO vo = new BoardVO();
		vo.setSeq(int_seq);
		
		BoardDAO dao = new BoardDAO();
		BoardVO boardvo = dao.getBoard(vo);
		
		System.out.println("boardvo: " + boardvo.toString());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardvo", boardvo);
		mv.setViewName("getBoard");
		return mv;
	}
	
}
