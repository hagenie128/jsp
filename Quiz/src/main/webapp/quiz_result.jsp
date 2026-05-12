<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- - **데이터 추출**: `request.getAttribute()`를 사용하여 이름과 판별 결과를 가져옵니다.
- **화면 출력**: `OOO님은 이번 시험에서 [합격/불합격] 하셨습니다!` 문구를 출력합니다. -->
	<h2>합격 결과</h2>
	<p><%=request.getAttribute("name")%>님은 이번 시험에서 [<%=request.getAttribute("result")%>]
		하셨습니다!
	</p>
</body>
</html>