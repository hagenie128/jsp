<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>조건문</h2>
	<%
	int score = 82;
	String grade = "F";
	if (score >= 90)
		grade = "A";
	else if (score >= 80)
		grade = "B";
	else if (score >= 70)
		grade = "C";
	else if (score >= 60)
		grade = "D";
	%>
	<p>
		점수 :
		<%=score%>, 학점 :
		<%=grade%></p>
	<h2>반복문</h2>
	<ul>
		<%
		for (int i = 0; i <= 10; i++) {
		%>
		<li><%=i%></li>
		<%
		}
		%>
	</ul>
	<h2>반복문 - while</h2>
	<!-- 1~100까지 합 출력 -->
	<%
	int i = 1;
	int sum = 0;
	while (i < 101) {
		sum += i++;
	}
	%>
	<p>
		1~100까지의 합 :
		<%=sum%></p>

</body>
</html>