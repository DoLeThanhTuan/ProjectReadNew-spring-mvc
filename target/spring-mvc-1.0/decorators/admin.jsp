<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<jsp:useBean id="securUtil" class="com.dolethanhtuan.util.SecurityUtils"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<!-- import thư viện để call API -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Custom fonts for this template-->
<link href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">

<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" type="text/css"/>
<link href="<c:url value='/template/admin/sweetalert/sweetalert2.min.css'/>"  rel="stylesheet" type="text/css"/>

<!-- Page level plugin CSS-->
<link href="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.css'/>" rel="stylesheet" type="text/css">

<!-- Custom styles for this template-->
<link href="<c:url value='/template/admin/css/sb-admin.css'/>" rel="stylesheet" type="text/css">

</head>
<body id="page-top">
		<jsp:include page="/common/admin/header.jsp"></jsp:include>
	<div id="wrapper">
		<jsp:include page="/common/admin/sideBar.jsp"></jsp:include>
		<dec:body/>
	</div>
		
		<!-- Paging  -->
	<script type="text/javascript" src="<c:url value='/template/admin/sweetalert/sweetalert2.min.js'/>"></script>
	<!-- Bootstrap core JavaScript-->
	<script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js'/>"></script>
	<script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

	<!-- Core plugin JavaScript-->
	<script src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

	<!-- Page level plugin JavaScript-->
	<script src="<c:url value='/template/admin/vendor/datatables/jquery.dataTables.js'/>"></script>
	<script src="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.js'/>"></script>

	<!-- Custom scripts for all pages-->
	<script src="<c:url value='/template/admin/js/sb-admin.min.js'/>"></script>

	<!-- Demo scripts for this page-->
	<script src="<c:url value='/template/admin/js/demo/datatables-demo.js'/>"></script>
</body>
</html>