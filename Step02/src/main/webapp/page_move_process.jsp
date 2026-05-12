<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String type = request.getParameter("type");
	String text = request.getParameter("txt");
	//request 영역에 text 저장
	request.setAttribute("txt", text);

	//type에 따라서 이동하는 방법을 다르게 처리
	if (type.equals("forward"))
		//사용자 요청 사항을 이어가는 특징, 조금 더 많이 쓰임
		//리퀘스트 이어말하기st
		//기존 경로 유지
		// ex) 상품 검색 기록, 유튜브 영상페이지 등
		//		새로고침할 때 기존 경로 가는 경우
		request.getRequestDispatcher("forward.jsp").forward(request, response);
	else
		//새로운 요청 - 기존 요청 완료
		//기존 리퀘스트 초기화
		//새로운 경로
		// ex) 로그아웃, 로그인, 회원가입 등
		//		새로고침할 때 기존 경로로 가지 않는 경우
		response.sendRedirect("redirect.jsp");
	%>
</body>
</html>