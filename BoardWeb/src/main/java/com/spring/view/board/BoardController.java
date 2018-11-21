package com.spring.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.btz.board.BoardVO;
import com.spring.btz.board.impl.BoardDAO;

@Controller
public class BoardController {
	//검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "title");
		conditionMap.put("내용", "content");
		
		return conditionMap;
	}
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO dao) {
		System.out.println("글 등록");
		
		dao.insertBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO dao) {
		System.out.println("글 수정");
		System.out.println("작성자 이름: " + vo.getWriter());
		
		dao.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, BoardDAO dao, Model model) {
		System.out.println("글 목록");
		
		List<BoardVO> boardList = dao.getBoardList();
		model.addAttribute("boardList", boardList);
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO dao, Model model) {
		System.out.println("글 상세 조회");
		
		BoardVO boardvo = dao.getBoard(vo);
		
		System.out.println("boardvo: " + boardvo.toString());
		
		model.addAttribute("boardvo", boardvo);
		return "getBoard.jsp";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO dao) {
		System.out.println("글 삭제");

		dao.deleteBoard(vo);
		
		return "getBoardList.do";
	}
}
