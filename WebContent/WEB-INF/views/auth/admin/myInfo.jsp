<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>myInfo.jsp</title>
		
		<!-- Bootstrap Framework 사용 -->
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		
		<!-- Popper JS -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		
		<!-- Bootstrap 4 Icons -->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
		
		<!-- Sakila CSS -->
		<link rel="stylesheet" type="text/css" href="/sakila/css/style.css" />
	</head>
	<body>
		<section>
			<div class="container">
				<aside class="sidebar">
					<!-- menu 항목을 include한다 -->
					<jsp:include page="/include/menu.jsp"></jsp:include>
				</aside>
				<main>
					<table width="100%" style="margin-top: 8px;">
						<tr>
							<td>
								<h2>관리자 정보</h2>
							</td>
							<td width="15%">
								<button type="button" class="btn btn-primary btn-sm btn-block" style="float: right;" onclick="location.href='${pageContext.request.contextPath}/auth/MyInfoUpdateServlet'">정보 수정</button>
							</td>
						</tr>
					</table>
					
					<hr style="margin-top: 8px;">
					
					<table class="adminInfo-table" width="100%" style="text-align: left;">
						<tr>
							<td width="15%">별명</td>
							<td width="45%">${staffInfo.username}</td>
							<td width="5%"rowspan="6">&nbsp;</td>
							<td width="45%" rowspan="6" bgcolor="#E2E2E2" style="text-align: center;">(사진)</td>
						</tr>
						<tr>
							<td>이름</td>
							<td>${staffInfo.firstName} ${staffInfo.lastName}</td>
						</tr>
						<tr>
							<td>연락처</td>
							<td>${staffInfo.phone}</td>
						</tr>
						<tr>
							<td>주소</td>
							<td>${staffInfo.city}, ${staffInfo.country}</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>${staffInfo.address}</td>
						</tr>
						<tr>
							<td>E-mail</td>
							<td>${staffInfo.email}</td>
						</tr>
					</table>
				</main>
			</div>
		</section>
	</body>
</html>