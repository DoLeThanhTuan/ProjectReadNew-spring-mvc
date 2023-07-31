<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="securUtil" class="com.dolethanhtuan.util.SecurityUtils"></jsp:useBean>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="./trang-chu">Trang chủ</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link" href="./trang-chu">Trang chủ</a></li>
				<security:authorize access="isAnonymous()">
					<li class="nav-item"><a class="nav-link" href="./dang-nhap">Đăng nhập</a></li>
					<li class="nav-item"><a class="nav-link" href="./dang-ky">Đăng ký</a></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li class="nav-item"><a class="nav-link">Xin chào ${securUtil.getCurrentUser().fullname}</a></li>
					<li class="nav-item"><a class="nav-link" href="./thoat">Thoát</a></li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>