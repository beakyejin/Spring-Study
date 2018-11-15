package com.spring.btz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	
	public static void main(String[] args) {
		//스프링 컨테이너 구동
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
	
		BoardService boardSerive = (BoardService) container.getBean("boardService");
		
		BoardVO vo = new BoardVO();
		vo.setSeq(100);
		vo.setTitle("title");
		vo.setWriter("writer");
		vo.setContent("test");
		boardSerive.insertBoard(vo);
		
		List<BoardVO> boardList = boardSerive.getBoardList();
		System.out.println("dddd");
		for(BoardVO board: boardList) {
			System.out.println("===>ddd" + board.toString());
		}
		
		container.close();
	}
}
