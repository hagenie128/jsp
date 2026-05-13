<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	alert('${requestScope.msg }');
	location.href = `${pageContext.request.contextPath }/
	${requestScope.flag == "true" ? "main.do" : "registerView.do" }`;
	// pageContext.request.contextPath : 현재 프로젝트의 contextPath를 반환하는 내장 객체
</script>