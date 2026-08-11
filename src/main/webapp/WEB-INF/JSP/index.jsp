<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>

			<jsp:include page="/WEB-INF/JSP/header.jsp" />
				<main>
					<c:if test="${ not empty msg }">
						<script>
							alert('${msg}');
							<c:remove var="msg" />
						</script>
					</c:if>
					<!-- 
            메인 영역 : section 부분과 aside 부분으로 나눔.
         -->
					<section>
						<!-- 
                section 영역: 각 컨텐츠별 구역을 나누고 그 구역은 타이틀과 섬네일 구역으로. 섬네일은 누르면 각 영상페이지로
             -->
						<h2>예능</h2>
						<div class="subject">
							<c:forEach var="l" items="${list}">
								<c:if test="${l.contentId < 20000}">
									<div>
										<div>
											<div class="poster"><a href="#"><img src="/ASSETS/IMG/${l.contentId}.jpg"
														alt="${l.contentTitle}" width="250" height="300"></a></div>
											<div class="title">${l.contentTitle}</div>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
						<h2>영화</h2>
						<div class="subject">
							<c:forEach var="l" items="${list}">
								<c:if test="${l.contentId >= 20000 and l.contentId < 30000}">
									<div>
										<div>
											<div class="poster"><a href="#"><img src="/ASSETS/IMG/${l.contentId}.jpg"
														alt="${l.contentTitle}" width="250" height="300"></a></div>
											<div class="title">${l.contentTitle}</div>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
						<h2>다큐</h2>
						<div class="subject">
							<c:forEach var="l" items="${list}">
								<c:if test="${l.contentId >= 30000}">
									<div>
										<div>
											<div class="poster"><a href="#"><img src="/ASSETS/IMG/${l.contentId}.jpg"
														alt="${l.contentTitle}" width="250" height="300"></a></div>
											<div class="title">${l.contentTitle}</div>
										</div>
									</div>
								</c:if>
							</c:forEach>
						</div>
					</section>
					<aside>
						<!-- 
                aside 부분 로그인 영역과 배너 영역으로 나눔. 배너 영역은 뭔가 허전해 보여서 자리 채우기용
            -->

						<div class="login-box">
							<c:choose>
								<c:when test="${ empty sessionScope.currSession }">
									<c:if test="${ not empty errorMsg }">
										<script>
											alert('${errorMsg}');
											<c:remove var="errorMsg" />
										</script>
									</c:if>
									<form action="/user/login" method="post">
										<table class="login">
											<tr>
												<td><input class="id" type="text" name="userId" placeholder="  아이디">
												</td>
												<td rowspan="2"><button class="btn">로그인</button></td>
											</tr>
											<tr>
												<td><input class="password" type="password" name="userPwd"
														placeholder="  비밀번호"></td>
												<td></td>
											</tr>
										</table>
									</form>
									<div class="login-links">
										<a href="#">아이디 찾기</a>
										<a href="#">비밀번호 찾기</a>
										<a href="/user/join">회원가입</a>
									</div>
								</c:when>
								<c:otherwise>
									<div class="login">
										<h3> ${ sessionScope.currSession.userName } 님, 어서오세요! </h3><br>

										<form action="/user/logout" method="get">
											<button>로그 아웃</button>
										</form>
									</div>
								</c:otherwise>
							</c:choose>
						</div>


						<div class="banner"><a href="#"><img src="/ASSETS/IMG/banner.jpg" width="75%"></a></div>
					</aside>
				</main>
				<jsp:include page="/WEB-INF/JSP/footer.jsp" />