<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<jsp:include page="/WEB-INF/JSP/header.jsp" />
	<div class="page">
		<br><br> <h1>회원가입 페이지</h1> <br><br>
		<form class = "page-form" action="/user/insert" method="post">
			<label>아이디 : <input type="text" name="userId"></label><br>
			<label>비밀번호 : <input type="password" name="userPwd"></label><br>
			<label>이름 : <input type="text" name="userName"></label><br>
			<label>나이 : <input type="number" name="userAge"></label><br>
			<input type="hidden" name="userBalance" value="0">
			<button class="button">제출</button>
			
		</form>
		<a href="/"><button class="button">홈으로 돌아가기</button></a>
	</div>
	<jsp:include page="/WEB-INF/JSP/footer.jsp" />