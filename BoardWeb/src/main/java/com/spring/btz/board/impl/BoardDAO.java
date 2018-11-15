package com.spring.btz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.btz.board.BoardService;
import com.spring.btz.board.BoardVO;
import com.spring.btz.common.JDBCUtil;

//@Repository("boardDAO")
public class BoardDAO {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	private final String BOARD_INSERT = 
				" insert into test_board(seq, title, writer, content) values( "
				+ " (select nvl(max(seq),0)+1 from test_board) , ? , ?, ?) ";
	private final String BOARD_UPDATE = " update test_board set "
			+ " title=?, content=? where seq=? ";
	private final String BOARD_DELETE = " delete test_board where seq=? ";
	private final String BOARD_GET = " select * from test_board where seq=? ";
	private final String BOARD_LIST = " select * from test_board order by seq desc ";
	
	
	public void insertBoard(BoardVO vo) {
		System.out.println("JDBC boardInsert()");
		
		try {
			con = JDBCUtil.getConnection();
			
			ps = con.prepareStatement(BOARD_INSERT);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getContent());
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, con);
			
		}
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("JDBC updateBoard()");
		
		try {
			con = JDBCUtil.getConnection();
			
			ps = con.prepareStatement(BOARD_UPDATE);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getSeq());
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, con);
		}
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("JDBC deleteBoard()");
		
		try {
			con = JDBCUtil.getConnection();
			
			ps = con.prepareStatement(BOARD_DELETE);
			ps.setInt(1, vo.getSeq());
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(ps, con);
		}
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("JDBC getBoard()");
		
		BoardVO board = null;
		
		try {
			con = JDBCUtil.getConnection();
			
			ps = con.prepareStatement(BOARD_GET);
			ps.setInt(1, vo.getSeq());
			
			rs = ps.executeQuery();
			
			if(rs.next()){
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegdate(rs.getString("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return board;
	}
	
	public List<BoardVO> getBoardList() {
		System.out.println("JDBC getBoardList()");
		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			con = JDBCUtil.getConnection();
			
			ps = con.prepareStatement(BOARD_LIST);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setContent(rs.getString("content"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setCnt(rs.getInt("cnt"));
				
				boardList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, ps, con);
		}
		
		return boardList;
	}
}
