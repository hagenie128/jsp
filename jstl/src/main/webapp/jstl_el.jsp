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
	<h2>EL(Expression Language)</h2>
	<p>jsp에서 데이터를 쉽고 간결하게 접근하기 위해 사용하는 스크립트 언어</p>
	<p>request 영역에 저장된 내용은 requestScope를 사용해서 뽑음</p>
	<p>age : ${requestScope.age }</p>
	<p>msg : ${requestScope.msg }</p>
	<p>세션에 저장된 내용은 sessionScope 사용</p>
	<!-- user에 저장된 필드도 하나씩 뽑기 -->
	<ul>
		<li>${sessionScope.user.id }</li>
		<li>${sessionScope.user.name }</li>
		<li>${sessionScope.user.passwd }</li>
		<li>${sessionScope.user.nick }</li>
		<li>${sessionScope.user.toString() }</li>
	</ul>
	<!-- 영역(scope) 쓰지 않으면 자돈 검색
		page - request - session - application
	 -->
	<p>msg : ${msg }</p>
	<h2>jstl(JSP Standard Tag Library)</h2>
	<!-- set : 변수 선언해서 초기화 -->
	<c:set var="num" value="1000"></c:set>
	<c:set var="obj" value="${sessionScope.user }" scope="request" />
	<p>${num },${requestScope.obj }</p>
	<!-- out : 출력 -->
	<p>
		<c:out value="${num }" default="숫자 없음" />
	</p>
	<p>
		<c:out value="${num1 }" default="숫자 없음" />
	</p>
	<!-- if -->
	<!-- else if, else 안됨 -->
	<c:if test="${age > 20 }">
		<p>성인입니다</p>
	</c:if>
	<c:if test="${age < 20 }">
		<p>미성년자입니다</p>
	</c:if>
	<!-- choose, when otherwise -->
	<!-- 기존 if 처럼 분기문 역할 -->
	<c:choose>
		<c:when test="${age >= 20 && age <30 }">
			<p>20대입니다</p>
		</c:when>
		<c:when test="${age >= 30 && age <40 }">
			<p>30대입니다</p>
		</c:when>
		<c:when test="${age >20 }">
			<p>10대 미만입니다</p>
		</c:when>
		<c:otherwise>
			<p>40대 이상입니다</p>
		</c:otherwise>
	</c:choose>
	<!-- 반복문 -->
	<ul>
		<!-- 반복문 제어변수(변수명), 시작값, 마지막값, 증감값 -->
		<c:forEach var="i" begin="1" end="10" step="1">
			<li>${i }</li>
		</c:forEach>
	</ul>
	<ul>
		<!--
        상태변수
            current : 현재 아이템 값
            begin : 시작값
            end : 마지막값
            first : 해당 순서가 첫번째인지 확인
            last : 해당 순서가 마지막인지 확인
            step : 증가값
            count : 1부터 순서값 시작
            index : begin-end로 구성했을때는 var 값, items로 가져왔을때는 인덱스 번호
            
            first, last 를 if 로 활용할 수 있음
    	-->
		<c:forEach var="i" begin="1" end="10" step="2" varStatus="status">
			<li>${i },${status.current },${status.begin },${status.end },
				${status.first },${status.last },${status.step },${status.count }
				,${status.index }</li>
		</c:forEach>
	</ul>
	<!-- 리스트에 있는 데이터 꺼내기 -->
	<ul>
		<c:forEach var="member" items="${requestScope.list }"
			varStatus="status">
			<li>${member },${status.index },${status.count }</li>
		</c:forEach>
	</ul>
</body>
</html>