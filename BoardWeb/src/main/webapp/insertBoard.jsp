<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 등록</h1>
	<a href="logout_proc.jsp">로그아웃</a>
	
	<form action="insertBoard_proc.jsp" method="post">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="새글 등록">
				</td>
			</tr>
		</table>
		<a href="getBoardList.jsp">글 목록 가기 </a>
	</form>
</body>
</html>