<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>index.jsp</title>
		
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
		
					<h1>Index</h1>
		
					<hr>
					
					<div>
						Sakila 프로젝트 설명
						
						<br><br>
						
						<table class="table table-striped" width="100%" style="text-align: center;">
							<tr>
								<td width="30%">작업기간 :</td>
								<td width="70%">Sakila 데이터베이스 분석 수업 후 일주일간 미니프로젝트 진행</td>
							</tr>
							<tr>
								<td>제작자 :</td>
								<td>배형준(<a href="piskk74@naver.com">piskk74@naver.com</a>)</td>
							</tr>
							<tr>
								<td>사용기술 :</td>
								<td>
									FrontEnd: HTML5,CSS3,Bootstrap4<br/>
									BackEnd: JAVA<br/>
									Language: java8<br/>
									Tools: Eclipse, MySql<br/>
									OS:Windows<br/>
									Database: MariaDB
								</td>
							</tr>
						</table>
					</div>
				</main>
			</div>
		</section>
	</body>
</html>