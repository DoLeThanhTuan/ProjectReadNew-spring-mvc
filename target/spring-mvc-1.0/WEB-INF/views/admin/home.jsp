<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="securUtil" class="com.dolethanhtuan.util.SecurityUtils"></jsp:useBean>
<!DOCTYPE HTML5>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	
		

		<div id="content-wrapper">

			<div class="container-fluid">

				<!-- Breadcrumbs-->
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="/spring-mvc/quan-tri/trang-chu">Quản trị</a></li>
					<li class="breadcrumb-item active">Trang chủ</li>
				</ol>

				<!-- Area Chart Example-->
				<div class="card mb-3">
					<div class="card-header">
						<i class="fas fa-chart-area"></i> Area Chart Example
					</div>
					<div class="card-body">
						<h3>Xin chào admin ${securUtil.getCurrentUser().fullname}</h3>
					</div>
				</div>

				<!-- DataTables Example -->
				

			</div>
			<!-- /.container-fluid -->

			<!-- Sticky Footer -->
			<footer class="sticky-footer">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright © Your Website 2019</span>
					</div>
				</div>
			</footer>

		</div>
		<!-- /.content-wrapper -->
	<!-- /#wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>
</body>
</html>