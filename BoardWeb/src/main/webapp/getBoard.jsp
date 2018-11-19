<%@page import="com.spring.btz.board.impl.BoardDAO"%>
<%@page import="com.spring.btz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String seq = request.getParameter("seq");
	
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO dao = new BoardDAO();
	BoardVO boardvo = dao.getBoard(vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
</head>
<body>
	<h1>글 상세</h1>
	<a href="logout_proc.jsp">로그아웃</a>
	
	<form action="updateBoard_proc.jsp" method="post">
	<input type="hidden" name="seq" value="<%=boardvo.getSeq()%>">
		<table>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="title" value="<%=boardvo.getTitle()%>">
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=boardvo.getWriter() %></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="content"><%=boardvo.getContent() %></textarea>
				</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><%=boardvo.getRegdate() %></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=boardvo.getCnt() %></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글 수정">
				</td>
			</tr>
		</table>
		<a href="insertBoard.jsp">글 등록</a>
		<a href="deleteBoard_proc.jsp?seq=<%=boardvo.getSeq()%>">글 삭제</a>
		<a href="getBoardList.jsp">글 목록</a>
	</form>
</body>
</html>