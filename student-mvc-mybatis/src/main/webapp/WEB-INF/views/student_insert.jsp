<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생 정보 등록 페이지</h2>
	<!-- 학생정보 입력받는 폼 -->
	<main>
		<form action="./insert.do" method="post">
			<input type="text" name="no" placeHolder="학번 8자리 입력" /><br> <input
				type="text" name="name" placeHolder="이름 입력" /><br> <input
				type="text" name="majorName" placeHolder="학과명 입력" /><br> <input
				type="text" name="score" placeHolder="평점 입력" /><br>
			<button>전송</button>
			<button type="button" onclick="location.href='./main.do'">취소</button>
		</form>
	</main>
</body>
</html>