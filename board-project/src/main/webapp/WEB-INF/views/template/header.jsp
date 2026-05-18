<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
</style>
<!-- 메뉴 
			1. 로그인 하지 않은 상태에서
				홈, 로그인, 회원가입
			2. 로그인 한 상태에는
				홈, 글쓰기, ooo님이 로그인 하셨습니다, 로그아웃
	-->
<nav class="menu_bar">
	<c:choose>
		<c:when test="${sessionScope.user == null }">
		<!-- 로그인 안 했을 때 -->
			<ul>
				<li><a href="./main.do">홈</a></li>
				<li><a href="./loginView.do">로그인</a></li>
				<li><a href="./registerView.do">회원 가입</a></li>
			</ul>
		</c:when>

		<c:otherwise>
		<!-- 로그인 했을 때 -->
			<ul>
				<li><a href="./main.do">홈</a></li>
				<li><a href="./boardWriteView.do">글쓰기</a></li>
				<li>
					<strong>${sessionScope.user.nickName}</strong>님이 로그인하셨습니다.
				</li>
				<li><a href="./logOut.do">로그아웃</a></li>
			</ul>
		</c:otherwise>
	</c:choose>
</nav>