<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>statistics.jsp</title>
		
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
		
		<style>
			.statTable td {
				width: 50%;
			}
		</style>
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
								<h2>매장 통계</h2>
							</td>
							<td width="15%">
								&nbsp;
							</td>
						</tr>
					</table>
					
					<hr style="margin-top: 8px;">
					
					<!-- 매장 총 매출 -->
					<h5>매장 총 매출</h5>
					
					<table class="statTable">
						<tr>
							<td><input type="text" class="form-control" value="${salesByStore.totalSales}" readonly="readonly"></td>
							<td>&nbsp;원</td>
						</tr>
					</table>
					
					<br><br>
					
					<!-- 총 대여 수 -->
					<h5>총 대여 수</h5>
					
					<table class="statTable">
						<tr>
							<td><input type="text" class="form-control" value="00" readonly="readonly"></td>
							<td>&nbsp;건</td>
						</tr>
					</table>
					
					<br><br>
					
					<!-- 카테고리별 매출액 -->
					<h5>카테고리별 매출액</h5>
					
					<table class="table table-hover statTable" style="text-align: center">
						<thead>
							<th>카테고리</th>
							<th>매출액</th>
						</thead>
						<tbody>
							<c:forEach var="b" items="${filmStoreStat}">
								<tr>
									<td>${b.category}</td>
									<td>${b.totalSales}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</main>
			</div>
		</section>
	</body>
</html>