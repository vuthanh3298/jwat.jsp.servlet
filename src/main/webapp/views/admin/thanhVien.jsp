<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="container-fluid">


	<div class="input-group md-form form-sm form-2 pl-0 ">
		<button type="button" class="btn btn-outline-danger"
			data-toggle="modal" data-target="#AddUserModalCenter">Thêm</button>
		<!-- start search -->
		<input class="form-control my-0 py-1 red-border" style="width: 70px;"
			type="text" placeholder="Tìm kiếm ..." aria-label="Search" />
		<div class="input-group-append " style="width: 100px">
			<span
				class="btn input-group-text red lighten-3 span-search-notifacation"
				style="width: 50px" id="basic-text1"></span>
		</div>
		<!-- end search -->
	</div>



	<!-- start list users -->
	<div class="h2-admin">
		<h2>THÀNH VIÊN</h2>

	</div>
	<div class="div-select-filter">
		<select name="loaiThongBao" class="select-filter">
			<option value="dangkylichtraining">Tất cả</option>
			<option value="thongbaonghi">Jwat 01</option>
			<option value="thongbaonghi">Jwat 02</option>
			<option value="thongbaonghi">Jwat 03</option>
			<option value="thongbaonghi">Jwat 04</option>
		</select>
	</div>

	<div class="list-group">
		<a href="#"
			class="list-group-item list-group-item-action flex-column align-items-start ">
			<div class="d-flex w-100 justify-content-between">
				<h5 class="mb-1 a-list-users">Hoàng Thùy Trang</h5>
				<small class="text-muted">Jwat 01</small>
			</div> <small class="text-muted">SĐT: 0352902224 - Email:
				Tranght636@gmail.com - SN: 16/2/1996 - Địa chỉ: Thôn 8, Nhân Cơ,
				ĐakRlap, ĐakNong. </small> <i class="edit" data-toggle="modal"
			data-target="#EditUserModalCenter"></i> <i class="delete"></i>
		</a> <a href="#"
			class="list-group-item list-group-item-action flex-column align-items-start ">
			<div class="d-flex w-100 justify-content-between">
				<h5 class="mb-1 a-list-users">Hoàng Thùy Trang</h5>
				<small class="text-muted">Jwat 01</small>
			</div> <small class="text-muted">SĐT: 0352902224 - Email:
				Tranght636@gmail.com - SN: 16/2/1996 - Địa chỉ: Thôn 8, Nhân Cơ,
				ĐakRlap, ĐakNong. </small> <i class="edit" data-toggle="modal"
			data-target="#EditUserModalCenter"></i> <i class="delete"></i>
		</a> <a href="#"
			class="list-group-item list-group-item-action flex-column align-items-start ">
			<div class="d-flex w-100 justify-content-between">
				<h5 class="mb-1 a-list-users">Hoàng Thùy Trang</h5>
				<small class="text-muted">Jwat 01</small>
			</div> <small class="text-muted">SĐT: 0352902224 - Email:
				Tranght636@gmail.com - SN: 16/2/1996 - Địa chỉ: Thôn 8, Nhân Cơ,
				ĐakRlap, ĐakNong. </small> <i class="edit" data-toggle="modal"
			data-target="#EditUserModalCenter"></i> <i class="delete"></i>
		</a>


	</div>
</div>

<!-- end list users -->

<!-- start Modal add user -->
<div class="modal fade" id="AddUserModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="AddUserModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title ModalTitle" id="exampleModalLongTitle">THÊM
					TÀI KHOẢN</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>


			<form action="/jwat/dangky2" method="post">
				<div class="modal-body">

					<!--modal body -->


					<div class="div-dangki">
						<table style="width: 100%" class="table-responsive">
							<tr>
								<td>Emai:</td>
								<td><input type="email" name="email" class="ModalSizeInput" /></td>
							</tr>
							<tr>
								<td>Tên:</td>
								<td><input type="text" name="username"
									class="ModalSizeInput" /></td>
							</tr>

							<tr>
								<td>Mật khẩu:</td>
								<td><input type="text" name="password" value="Qwer1234"
									class="ModalSizeInput" /></td>
							</tr>
							<tr>
								<td>Số điện thoại:</td>
								<td><input type="number" name="phonenumber"
									class="ModalSizeInput" /></td>
							</tr>
							<tr>
								<td>Địa chỉ:</td>
								<td><textarea name="address"
										class="form-control ModalSizeInput" rows="4"></textarea></td>
							</tr>
							<tr>
								<td>Ngày sinh:</td>
								<td><input type="date" name="dob" class="ModalSizeInput" /></td>
							</tr>
							<tr>
								<td>Trường:</td>
								<td><input type="text" name="university"
									class="ModalSizeInput" /></td>
							</tr>
						</table>
					</div>

					<!--end modal body -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Đóng</button>
					<button type="submit" class="btn btn-primary">OK</button>
				</div>
			</form>


		</div>
	</div>
</div>
<!-- end Modal add user -->
<!-- start Modal edit user -->
<div class="modal fade" id="EditUserModalCenter" tabindex="-1"
	role="dialog" aria-labelledby="EditUserModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">THÔNG TIN
					TÀI KHOẢN</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<form action="/jwat/updateUser" method="post">
				<div class="modal-body div-dangki">
					<table style="width: 100%" class="table-responsive">
						<tr>
							<td>Emai:</td>
							<td><input type="email" name="email" class="ModalSizeInput" /></td>
						</tr>
						<tr>
							<td>Tên:</td>
							<td><input type="text" name="username"
								class="ModalSizeInput" /></td>
						</tr>

						<tr>
							<td>Mật khẩu:</td>
							<td><input type="text" name="password" value="Qwer1234"
								class="ModalSizeInput" /></td>
						</tr>
						<tr>
							<td>Số điện thoại:</td>
							<td><input type="number" name="phonenumber"
								class="ModalSizeInput" /></td>
						</tr>
						<tr>
							<td>Địa chỉ:</td>
							<td><textarea name="address"
									class="form-control ModalSizeInput" rows="4"></textarea></td>
						</tr>
						<tr>
							<td>Ngày sinh:</td>
							<td><input type="date" name="dob" class="ModalSizeInput" /></td>
						</tr>
						<tr>
							<td>Trường:</td>
							<td><input type="text" name="university"
								class="ModalSizeInput" /></td>
						</tr>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Đóng</button>
					<button type="submit" class="btn btn-primary">Lưu</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- end Modal edit user -->
<!--  -->