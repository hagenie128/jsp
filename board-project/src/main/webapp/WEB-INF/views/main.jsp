<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 메인 페이지</title>

<link rel="stylesheet" as="style" crossorigin
	href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css">
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/css/board.css"> --%>
</head>
<body>
	<jsp:include page="./template/header.jsp"></jsp:include>
	<hr>
	<!-- 게시판 글 목록
			글 번호, 제목[댓글 갯수], 작성일, 닉네임, 조회수, 좋아요, 싫어요	
	  -->
	<!-- 페이지 처리 부분 -->
	<h2>게시판</h2>
	<table class="board_table">
		<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>닉네임</th>
				<th>조회수</th>
				<th>좋아요</th>
				<th>싫어요</th>
			</tr>
		</thead>
		<tbody id="board_content_list">
			<c:forEach  var="board" items="${requestScope.list}">
				<tr>
					<td>${board.bno}</td>
					<td class="title-cell">${board.title}
						<c:if test="${board.ccount > 0}">
							<span class="comment-count">[${board.ccount}]</span>
						</c:if>
					</td>
					<td>${fn:substring(board.writeDate, 2, 10)}</td>
					<td>${board.nickName}</td>
					<td>${board.bcount}</td>
					<td>${board.blike}</td>
					<td>${board.bhate}</td>
				</tr>
			</c:forEach>

			<c:if test="${list.isEmpty()}">
				<tr>
					<td colspan="7">조회한 데이터가 없습니다</td>
				</tr>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="7">
				<!-- 페이지 처리 부분 -->
				페이징 처리 영역
				</td>
			</tr>
		</tfoot>
	</table>
	<%-- <div class="page-area">
		<c:if test="${pageNo > 1}">
			<a href="./main.do?pageNo=${pageNo - 1}">이전</a>
		</c:if>

		<c:forEach var="i" begin="1" end="${totalPage}">
			<c:choose>
				<c:when test="${i == pageNo}">
					<strong>${i}</strong>
				</c:when>
				<c:otherwise>
					<a href="./main.do?pageNo=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<c:if test="${pageNo < totalPage}">
			<a href="./main.do?pageNo=${pageNo + 1}">다음</a>
		</c:if>
	</div> --%>
</body>
</html>