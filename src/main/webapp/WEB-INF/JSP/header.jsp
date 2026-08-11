<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}../ASSETS/CSS/common.css">
</head>
<body>
	<header>
        <!-- 
        헤더 영역 : 로고 / 로고 클릭하면 메인페이지로 돌아오게
         -->
        <a href="/"><img src="/ASSETS/IMG/logo.png" alt="로고" width="300"></a>
    </header>
    <nav>
        <!-- 
        네비 영역 : 드랍박스 형식 - submenu에선 display: none; 이다가 hover시 display: inline-block;처럼 보이게
         -->
        <ul>
            <li><a href="#">예능</a>
                <ul class="submenu">
                    <li><a href="#">인기 예능</a></li>
                    <li><a href="#">최신 예능</a></li>
                    <li><a href="#">이번주 화제의 예능</a></li>
                </ul>
            </li>
            <li><a href="#">영화</a>
                <ul class="submenu">
                    <li><a href="#">인기 영화</a></li>
                    <li><a href="#">최신 영화</a></li>
                    <li><a href="#">이번주 화제의 영화</a></li>
                </ul>
            </li>
            <li><a href="#">다큐</a>
                <ul class="submenu">
                    <li><a href="#">인기 다큐</a></li>
                    <li><a href="#">최신 다큐</a></li>
                    <li><a href="#">이번주 화제의 다큐</a></li>
                </ul>
            </li>
            <li><a href="#">회원정보</a>
                <ul class="submenu">
                    <li><a href="/user/update">회원 정보 확인/수정</a></li>
                    <li><a href="#">재생 설정</a></li>
                    <li><a href="#">알림 설정</a></li>
                    <li><a href="/user/withdraw">회원 탈퇴</a></li>
                </ul>
            </li>
        </ul>
    </nav>