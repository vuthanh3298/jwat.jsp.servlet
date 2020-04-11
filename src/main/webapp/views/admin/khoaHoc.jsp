<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Khoá học</title>
</head>
<body>
	<div style="margin-bottom: 10px;">
		<button type="button" class="btn btn-outline-danger"
			data-toggle="modal" data-target="#AddUserModalCenter">Thêm Khoá học</button>
	</div>
	<div class="list-group">
		<c:choose>
	         <c:when test = "${not empty courses}">
	         	<c:forEach var="course" items="${courses}" >
					<a href="#" class="list-group-item list-group-item-action flex-column align-items-start ">
						<i class="edit" data-toggle="modal" data-target="#EditUserModalCenter"></i> 
						<i class="delete"></i>
						<div class="d-flex w-100 justify-content-between">
							<h5 class="mb-1 a-list-users">${course.name}</h5>
						</div> 
						<small class="text-muted">
							${course.description}
						</small> 
					</a> 
				</c:forEach>
	         </c:when>
	         <c:otherwise>
	            Không có khoá học nào
	         </c:otherwise>
	      </c:choose>
	</div>
</body>
</html>