<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>

<style>
table {
	width: 500px;
	border-collapse: collapse;
	table-layout: fixed;
}

th, td {
	border: 1px solid #ccc;
	padding: 10px;
	text-align: center;
}

th {
	background-color: #f2f2f2;
}

.password-cell {
	max-width: 180px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

nav a {
	margin-right: 10px;
	text-decoration: none;
	color: #333;
}

.search-box {
	display: flex;
	justify-content: center;
	align-items: center;
	gap: 8px;
	padding: 15px 0;
}

.search-form {
	display: flex;
	align-items: center;
	gap: 8px;
}

.search-form input {
	width: 220px;
	padding: 10px 12px;
	border: 1px solid #ccc;
	border-radius: 8px;
	font-size: 14px;
}

.search-form input:focus {
	outline: none;
	border-color: #4a90e2;
}

#btnSearch {
	padding: 10px 18px;
	border: none;
	border-radius: 8px;
	background-color: #4a90e2;
	color: white;
	font-size: 14px;
	font-weight: bold;
	cursor: pointer;
}

#btnSearch:hover {
	background-color: #357abd;
}

#btnSearchCancel {
	padding: 10px 18px;
	border: none;
	border-radius: 8px;
	background-color: #ddd;
	color: #333;
	font-size: 14px;
	font-weight: bold;
	cursor: pointer;
}

#btnSearchCancel:hover {
	background-color: #c7c7c7;
}
</style>

</head>
<body>
	<nav>
		<a href="./loginView.do">로그인</a> <a href="./registerView.do">회원가입</a>
	</nav>

	<hr>

	<h2>전체 회원 정보</h2>

	<table>
		<thead>
			<tr>
				<td colspan="5">
					<div class="search-box">
						<form action="./search.do" method="get" class="search-form">
							<input type="text" name="text" placeholder="아이디 or 닉네임 일부 입력">
							<button type="submit" id="btnSearch">검색</button>
						</form>
						<button type="button" id="btnSearchCancel"
							onclick="location.href='./main.do'">취소</button>
					</div>
				</td>
			</tr>
			<tr>
				<th>NO</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>닉네임</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${list}" var="member">
				<tr>
					<td>${member.no}</td>
					<td>${member.id}</td>
					<td class="password-cell">${member.passwd}</td>
					<td>${member.username}</td>
					<td>${member.nickname}</td>
				</tr>
			</c:forEach>

			<c:if test="${empty list}">
				<tr>
					<td colspan="5">조회한 데이터가 없습니다</td>
				</tr>
			</c:if>
		</tbody>
	</table>
</body>
</html>