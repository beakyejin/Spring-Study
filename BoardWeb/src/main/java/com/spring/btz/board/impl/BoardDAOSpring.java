package com.spring.btz.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.btz.board.BoardVO;

@Repository
public class BoardDAOSpring {
	@Autowired //dataSource객체 의존성 주입
	private JdbcTemplate jdbcTemplate;
	
	//(select nvl(max(seq),0)+1 from test_board)
	private final String BOARD_INSERT = 
			" insert into test_board(seq, title, writer, content) values( "
			+ "  ?, ? , ?, ?) ";
	private final String BOARD_UPDATE = " update test_board set "
		+ " title=?, content=? where seq=? ";
	private final String BOARD_DELETE = " delete test_board where seq=? ";
	private final String BOARD_GET = " select * from test_board where seq=? ";
	private final String BOARD_LIST = " select * from test_board order by seq desc ";
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
		jdbcTemplate.update(BOARD_INSERT, vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent());
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 updateBoard() 기능 처리");
		jdbcTemplate.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 deleteBoard() 기능 처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring JDBC로 getBoard() 기능 처리");
		Object[] args = {vo.getSeq()};
		
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper()); 
	}
	
	public List<BoardVO> getBoardList() {
		System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
		
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}

class BoardRowMapper implements RowMapper<BoardVO> {
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO vo = new BoardVO();
		vo.setSeq(rs.getInt("seq"));
		vo.setTitle(rs.getString("title"));
		vo.setWriter(rs.getString("writer"));
		vo.setContent(rs.getString("content"));
		vo.setRegdate(rs.getString("regdate"));
		vo.setCnt(rs.getInt("cnt")); 
		
		System.out.printf("%d %s %s %s %s %d", 
				vo.getSeq(), vo.getTitle(), vo.getWriter(),
				vo.getContent(), vo.getRegdate(), vo.getCnt());
		
		return vo;
	}
}