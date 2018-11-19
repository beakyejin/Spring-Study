<%@page import="java.util.List"%>
<%@page import="com.spring.btz.board.impl.BoardDAO"%>
<%@page import="com.spring.btz.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1.사용자 입력 정보 추출
	//2.DB 연동 처리
	BoardVO vo = new BoardVO();
	BoardDAO dao = new BoardDAO();
	List<BoardVO> boardList = dao.getBoardList();
	
	//3.응답화면 구성
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<h1>글 목록</h1>
	<a href="logout_proc.jsp">로그아웃</a>
	
	<form action="getBoardList.jsp" method="post">
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
				<a href="getBoard.jsp?seq=<%=boardvo.getSeq()%>">
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