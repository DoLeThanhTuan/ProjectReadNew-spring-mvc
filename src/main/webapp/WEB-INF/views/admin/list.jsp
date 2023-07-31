<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url value="/quan-tri/new/danh-sach" var="urlList"></c:url>
<c:url value="/new-api" var="urlAPI"></c:url>
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
					<li class="breadcrumb-item"><a href="/spring-mvc/quan-tri">Quản trị</a></li>
					<li class="breadcrumb-item">Danh sách bài viết</li>
				</ol>

				<!-- DataTables Example -->
				<div class="card mb-3">
					<div class="card-header">
						<a href="/spring-mvc/quan-tri/new/them" style="color:green; font-weight: 800;">Thêm bài viết</a>
					</div>
					<div class="card-header">
						<button id="btnDelete" type="button" style="background-color: red; color: white; font-weight: 800;" onclick="viewConfirm()">Xoá</button>
					</div>
					<div class="card-header">
						<i class="fas fa-table"></i> Danh sách bài viết
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table style="text-align: center;" class="table table-bordered">
								<thead>
									<tr>
										<th width="5%"><input type="checkbox" name="checkAll" id="checkAll"  onclick="selectAllOrDisAll()"></th>
										<th width="22%">Tiêu đề</th>
										<th width="40%">Mô tả ngắn</th>
										<th width="13%">Hình ảnh</th>
										<th width="10%">Danh mục</th>
										<th width="10%">Chức năng</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${page.list}" var="o">
										<tr>
											<td><input type="checkbox" value="${o.id}" name="checkbox" id="checkbox_${o.id}"></td>
											<td>${o.title}</td>
											<td>${o.shortDes}</td>
											<td>${o.thumbnail}</td>
											<td>${o.categoryCode}</td>
											<td><a style="color: red;font-weight:700; " onclick="deleteNew([${o.id}])">Xoá</a> | <a style="color: blue;font-weight:700;" href="/spring-mvc/quan-tri/new/chinh-sua?id=${o.id}">Sửa</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<ul class="pagination">
								<li class="paginate_button page-item previous ${page.index == 1 ? 'disabled' : ''}">
									<a href="/spring-mvc/quan-tri/new/danh-sach?index=${page.index-1}" class="page-link">Previous</a></li>
								<c:forEach begin="1" end="${page.totalPage}" var="o">
								<li class="paginate_button page-item ${page.index == o ? 'active' : ''}">
									<a href="/spring-mvc/quan-tri/new/danh-sach?index=${o}" class="page-link">${o}</a></li>
								</c:forEach>
								<li class="paginate_button page-item next ${page.index == page.totalPage ? 'disabled' : ''}" id="dataTable_next">
									<a href="/spring-mvc/quan-tri/new/danh-sach?index=${page.index+1}" class="page-link">Next</a></li>
							</ul>
						</div>
					</div>
					<div class="card-footer small text-muted">Updated yesterday
						at 11:59 PM</div>
				</div>

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
	
	<script type="text/javascript">
	
	function viewConfirm() {
			swal({
				  title: "Xoá",
				  text: "Bạn có chắc chắn muốn xoá ?",
				  type: "warning",
				  showCancelButton: true,
				  confirmButtonClass: "btn-danger",
				  cacelButtonClass: "btn-danger",
				  confirmButtonText: "Xác nhận",
				  cacelButtonText: "Huỷ bỏ",
				  closeOnConfirm: false
				}).then(function(isConfirm){
					if(isConfirm.value == true){
						var ids = $('tbody input[type=checkbox]:checked').map(function () {
							return $(this).val();
						}).get();
						deleteNew(ids);
					}
				});
		}
		function deleteNew(ids) {
			$.ajax({
				url:'${urlAPI}',
				type: 'DELETE',
				contentType:'application/json',
				data: JSON.stringify(ids),
				success: function(result) {
					swal("Đã xoá!", "Xoá thành công", "success").then(function(isConfirm){
						if(isConfirm.value == true){
						}
						window.location.href = '${urlList}';
					});;
				},
				error: function(error) {
					swal("Lỗi!", "Xoá thất bại", "error").then(function(isConfirm){
						if(isConfirm.value == true){
						}
						location.reload();
					});
				}
			});
		}
		function selectAllOrDisAll() {
			var checkAll = document.getElementsByName('checkAll');
			if(checkAll[0].checked == true){
				selects();
			}else{
				deSelect();
			}
		}
		function selects(){
            var selec=document.getElementsByName('checkbox');
            for(var i=0; i<selec.length; i++){
                if(selec[i].type=='checkbox')
                    selec[i].checked=true;
            }
        }
        function deSelect(){
            var selec=document.getElementsByName('checkbox');
            for(var i=0; i<selec.length; i++){
                if(selec[i].type=='checkbox')
                    selec[i].checked=false;

            }
        }
        function disabledDelete() {
		    var selec=document.getElementsByName('checkbox');
		    var btnDelete = document.getElementById('btnDelete');
		    if(selec.length == 0){
		        btnDelete.disable = true;
		    }
		    else{
		        btnDelete.disable = false;
		    }
		}
	</script>
	
</body>
</html>