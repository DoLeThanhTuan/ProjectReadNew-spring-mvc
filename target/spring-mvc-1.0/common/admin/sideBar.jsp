<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Sidebar -->
		<ul class="sidebar navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="/spring-mvc/quan-tri"> <i class="fas fa-fw fa-home"></i> <span>Trang chủ</span>
			</a></li>
			<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="pagesDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-fw fa-user"></i> <span>Tài khoản</span>
			</a>
				<div class="dropdown-menu" aria-labelledby="pagesDropdown">
					<h6 class="dropdown-header">Thông tin cá nhân</h6>
					<a class="dropdown-item" href="/spring-mvc/thoat">Đăng xuất</a> <a
						class="dropdown-item" href="register.html">Thay đổi thông tin</a>					
						<div class="dropdown-divider"></div>
					<h6 class="dropdown-header">Trang khác</h6>
					<a class="dropdown-item" href="/spring-mvc/trang-chu">Trang bài viết</a>
				</div>
			<li class="nav-item"><a class="nav-link" href="/spring-mvc/quan-tri/new/them">
					<i class="fas fa-fw fa-plus"></i> <span>Thêm bài viết</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="/spring-mvc/quan-tri/new/danh-sach">
					<i class="fas fa-fw fa-table"></i> <span>Danh sách bài viết</span>
			</a></li>
		</ul>