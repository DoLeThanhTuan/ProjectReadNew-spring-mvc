<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Đăng ký</title>
</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
				<c:if test="${param.registerSuccess != null }">
					<div class="alert alert-success">Đăng ký thành công</div>
				</c:if>
				<c:if test="${param.wrongPassword != null }">
					<div class="alert alert-danger">Sai mật khẩu</div>
				</c:if>
				<c:if test="${param.existedUser != null }">
					<div class="alert alert-danger">Tài khoản đã tồn tại</div>
				</c:if>
				<form action="dang-ky" method="post" id="formRegister">
					<div class="form-group">
						<input type="text" class="form-control" id="fullname" name="fullname" placeholder="Họ và tên" required="required">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="username" name="username" placeholder="Tên đăng nhập" required="required">
					</div>
			
					<div class="form-group">
						<input type="password" class="form-control" id="password" name="password" placeholder="Mật khẩu" required="required">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="repeat_password" name="repeat_password" placeholder="Xác thực mật khẩu" required="required">
					</div>
					<button id="btn_submit" type="submit" class="btn btn-primary" >Đăng ký</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>