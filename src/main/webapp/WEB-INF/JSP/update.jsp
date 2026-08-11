<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<jsp:include page="/WEB-INF/JSP/header.jsp" />
	<div class="page">
		<br><br>
		<h1>회원 정보 확인/수정</h1><br><br>
		<form class="page-form" action="/user/update" method="post">
			<input type="hidden" name="userId" value="${ currentUser.userId }">
			<input type="hidden" name="userPwd" value="${ currentUser.userPwd }">
			<label>이름 : <input type="text" name="userName" value="${ currentUser.userName }"></label><br>
			<label>나이 : <input type="number" name="userAge" value="${ currentUser.userAge }"></label><br>
			<input type="hidden" name="balance" value="${ currentUser.userBalance }">
			<button class="button">제출</button>
			
		</form>
		<a href="/"><button class="button">홈으로 돌아가기</button></a>
	</div>
	<jsp:include page="/WEB-INF/JSP/footer.jsp" />