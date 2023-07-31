<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url value="/new-api" var="urlAPI" />
<c:url value="/quan-tri/new/danh-sach" var="urlHome"/>
<c:url value="/quan-tri/new/them" var="urlAdd"/>
<c:url value="/quan-tri/new/chinh-sua" var="urlEdit"/>
<!DOCTYPE HTML5>
<html>
<head>
<style type="text/css">
body{color: #000;overflow-x: hidden;height: 100%;background-image: url("https://i.imgur.com/GMmCQHC.png");background-repeat: no-repeat;background-size: 100% 100%}.card{padding: 30px 40px;margin-top: 60px;margin-bottom: 60px;border: none !important;box-shadow: 0 6px 12px 0 rgba(0,0,0,0.2)}.blue-text{color: #00BCD4}.form-control-label{margin-bottom: 0}input, textarea, button{padding: 8px 15px;border-radius: 5px !important;margin: 5px 0px;box-sizing: border-box;border: 1px solid #ccc;font-size: 18px !important;font-weight: 300}input:focus, textarea:focus{-moz-box-shadow: none !important;-webkit-box-shadow: none !important;box-shadow: none !important;border: 1px solid #00BCD4;outline-width: 0;font-weight: 400}.btn-block{text-transform: uppercase;font-size: 15px !important;font-weight: 400;height: 43px;cursor: pointer}.btn-block:hover{color: #fff !important}button:focus{-moz-box-shadow: none !important;-webkit-box-shadow: none !important;box-shadow: none !important;outline-width: 0}
</style>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
		<div id="content-wrapper">

			<div class="container-fluid px-1 py-5 mx-auto">
			    <div class="row d-flex justify-content-start" style="margin-left: 200px;">
			            <div class="card" style="border: none;">
			                ${newDTO != null ? '<h5 class="text-center mb-4">Chỉnh sửa bài viết</h5>' : '<h5 class="text-center mb-4">Thêm bài viết</h5>'}
			               <c:if test="${report != null }">
								<div class="alert alert-${report}">${mess}</div>
							</c:if>
			                <form:form class="form-card" id="formData" modelAttribute="newDTO">
			                    <c:if test="${newDTO.id != null}">
			                    	<div class="row justify-content-begin text-left">
				                        <div class="form-group col-12 flex-column d-flex"> <label class="form-control-label px-0">Id<span class="text-danger"> *</span></label> 
				                        	<form:input style="width: 700px;" disabled="true" type="text" path="id" name="id"/>
				                        	<form:input style="width: 700px;" type="hidden" path="id" name="id"/>
				                        </div>
			                    	</div>
			                    </c:if>
			                    <div class="row justify-content-begin text-left">
			                        <div class="form-group col-12 flex-column d-flex"> <label class="form-control-label px-0">Tiêu đề<span class="text-danger"> *</span></label> 
			                        	<form:input style="width: 700px;" type="text" path="title"/> 
			                        </div>
			                    </div>
			                    <div class="row justify-content-begin text-left">
			                        <div class="form-group col-12 flex-column d-flex"> <label class="form-control-label px-0">Nội dung<span class="text-danger"> *</span></label> 
			                        	<form:textarea rows="5" type="text" name="content" path="content"/> 
			                        </div>
			                    </div>
			                    <div class="row justify-content-begin text-left">
			                        <div class="form-group col-12 flex-column d-flex"> <label class="form-control-label px-0">Mô tả ngắn<span class="text-danger"> *</span></label>
			                        	<form:input type="text" path="shortDes" name="shortDes"/>
			                        </div>
			                    </div>
			                    <div class="row justify-content-begin text-left">
			                        <div class="form-group col-12 flex-column d-flex"> <label class="form-control-label px-0">Hình ảnh<span class="text-danger"> *</span></label> 
			                        	<form:input type="text" path="thumbnail" name="thumbnail" placeholder=""/> 
			                        </div>
			                    </div>
			                    <div class="row justify-content-begin text-left">
			                        <div class="form-group col-12 flex-column d-flex"> <label class="form-control-label px-0">Thể loại<span class="text-danger"> *</span></label> 
			                        	<form:select style="height: 30px" path="categoryCode" name="categoryCode">
			                        		<form:option disabled="true" selected="true" value="--Chọn thể loại--"/>
			                        		<form:options items="${listCate}" itemValue="code" itemLabel="name"/>
			                        	</form:select>
			                        </div>
			                    </div>
			                    <div style="margin-top: 20px; margin-left: 40%; width: 100%;"  class="row">
			                        <div class="form-group col-sm-3"> 
			                        	<button type="button" class="btn-block btn-primary" id="btnSubmit">Đồng ý</button>
			                        </div>
			                    </div>
			                </form:form>
			        </div>
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
	<script>
		$('#btnSubmit').click(function (e) {
		    e.preventDefault();
		    var data = {};
		    var formdt = $('#formData').serializeArray();
		    $.each(formdt, function (i, v) {
	        	data[""+v.name+""] = v.value;
	        });
		    if(${newDTO.id != null}){
		    	edit(data);
		    }
		    else{
		    	add(data);
		    }
		    
		});
		function edit(data) {
			$.ajax({
				url:'${urlAPI}',
				type: 'PUT',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function(result){
					window.location.href = '${urlEdit}?id=${newDTO.id}&report=success';
				},
				error: function(error){
					window.location.href = '${urlEdit}?id=${newDTO.id}&report=danger';
				}
			});
		};
		function add(data) {
			$.ajax({
				url:'${urlAPI}',
				type: 'POST',
				contentType: 'application/json',
				data: JSON.stringify(data),
				dataType: 'json',
				success: function(result){
					window.location.href = '${urlAdd}?report=success';
				},
				error: function(er){
					window.location.href = '${urlAdd}?report=danger';
				}
			});
		};
		
	</script>
</body>
</html>