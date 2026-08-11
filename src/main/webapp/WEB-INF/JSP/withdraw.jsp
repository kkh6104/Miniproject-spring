<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<jsp:include page="/WEB-INF/JSP/header.jsp" />
	<div class="page">
		<br><br>
		<h1>회원탈퇴 페이지</h1><br><br>
		<form class="page-form" action="/user/delete" method="post">
			<label>탈퇴하시려면 비밀번호를 입력해주세요 : <input type="password" name="userPwd"></label><br>
			<button class="button">제출</button>
		</form>
		<a href="/"><button class="button">홈으로 돌아가기</button></a>
	</div>
	<jsp:include page="/WEB-INF/JSP/footer.jsp" />