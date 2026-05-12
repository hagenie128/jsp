<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- - **한글 처리**: `request.setCharacterEncoding("UTF-8");`를 사용해 한글 깨짐을 방지합니다.
- **데이터 수신**: `request.getParameter()`로 이름과 점수를 받습니다.
- **로직 판별**: 
  - 점수가 **60점 이상**이면 `"합격"`, **60점 미만**이면 `"불합격"`을 변수에 저장합니다.
  - (참고: `Integer.parseInt()`를 사용해 문자열 점수를 숫자로 변환하세요.)
- **데이터 저장**: `request.setAttribute()`를 사용해 이름과 결과를 저장합니다.
- **페이지 이동**: **Forward 방식**을 사용하여 `quiz_result.jsp`로 이동합니다. -->

	<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	int score = Integer.parseInt(request.getParameter("score"));
	String result = (score >= 60 ? "합격" : "불합격");
	request.setAttribute("name", name);
	request.setAttribute("result", result);
	request.getRequestDispatcher("quiz_result.jsp").forward(request, response);
	%>

</body>
</html>