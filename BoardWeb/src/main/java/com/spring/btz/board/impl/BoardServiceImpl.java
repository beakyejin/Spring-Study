package com.spring.btz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.btz.board.BoardService;
import com.spring.btz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	/*@Autowired
	private BoardDAO boardDAO;
	-->jdbcTemplate 메소드 사용*/
	@Autowired
	private BoardDAOSpring boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		/*Exception 확인*/
		/*if(vo.getSeq() == 0) {
			throw new IllegalArgumentException("0번 글은 등록 할 수 없습니다.");
		}*/
		boardDAO.insertBoard(vo);
		//boardDAO.insertBoard(vo); //롤백 확인
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}
	
}
