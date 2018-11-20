<%@page import="java.util.List"%>
<%@page import="com.spring.btz.board.impl.BoardDAO"%>
<%@page import="com.spring.btz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardVO> boardList = (List<BoardVO>)session.getAttribute("boardList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<h1>글 목록</h1>
	<a href="logout.do">로그아웃</a>
	
	<form action="getBoardList.do" method="post">
		<table border="1">
			<tr>
				<td>
					<select name="searchCondition">
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select>
					<input type="text" name="searchKeyword">
					<input type="submit" value="검색">
				</td>
			</tr>
		</table>
	</form>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<%for(BoardVO boardvo: boardList){ %>
		<tr>
			<td><%=boardvo.getSeq() %></td>
			<td>
				<a href="getBoard.do?seq=<%=boardvo.getSeq()%>">
					<%=boardvo.getTitle() %>
				</a>
			</td>
			<td><%=boardvo.getWriter() %></td>
			<td><%=boardvo.getRegdate() %></td>
			<td><%=boardvo.getCnt() %></td>
		</tr>
		<%} %>		
	</table>
	<a href="insertBoard.jsp">새글 등록</a>
</body>
</html>