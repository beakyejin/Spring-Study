package com.spring.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.btz.board.BoardVO;
import com.spring.btz.board.impl.BoardDAO;

public class GetBoardListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록");
		
		//1.사용자 입력 정보 추출
		//2.DB 연동 처리
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = dao.getBoardList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardList", boardList);
		mv.setViewName("getBoardList");
		return mv;
	}

}
