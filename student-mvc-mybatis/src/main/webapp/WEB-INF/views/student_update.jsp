<%@ page import="dto.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생 정보 수정 페이지</h2>
	<!-- 학생정보 입력받는 폼 -->
	<main>
		<form action="./update.do" method="post">
			<span>학번 : ${requestScope.dto.student_id }</span> <input type="hidden"
				name="student_id" value="${requestScope.dto.student_id }" /><br>
			<!-- 
			read only : 입력 불가능하게 만드는 속성, 
			hidden : 화면에 보이지 않게 만드는 속성 + 폼 전송 시 해당 요소의 값이 전송됨,
			disabled : 입력 불가능하게 만드는 속성 + 폼 전송 시 해당 요소의 값이 전송되지 않음 -->
			<input type="text" name="name" value="${dto.name }" /><br> <input
				type="text" name="department" value="${dto.department }" /><br> <input
				type="text" name="gpa" value="${dto.gpa }" /><br>
			<button>수정</button>
			<button type="button" onclick="location.href='./main.do'">취소</button>
		</form>
	</main>
</body>
</html>