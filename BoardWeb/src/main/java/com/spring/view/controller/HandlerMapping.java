package com.spring.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.spring.view.board.DeleteBoardController;
import com.spring.view.board.GetBoardController;
import com.spring.view.board.GetBoardListController;
import com.spring.view.board.InsertBoardController;
import com.spring.view.board.UpdateBoardController;
import com.spring.view.user.LoginController;
import com.spring.view.user.LogoutController;

//클라이언트의 요청을 처리할 controller 검색 기능
public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
