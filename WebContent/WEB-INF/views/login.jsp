<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login.jsp</title>
		
		<!-- Bootstrap Framework 사용 -->
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		
		<!-- Popper JS -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		
		<!-- jQuery Google CDN -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		
		<!-- jQuery를 이용하여 로그인 E-mail/PW 검사 -->
		<script>
			$(document).ready(function() {	// 문서가 로드되면 이 스크립트를 제일 마지막에 실행해주세요
				$('#email').focus();	// 시작 시 폼 커서를 email쪽으로 이동
				
				$('#email').blur(function() {	// email에 커서가 있지 않은 경우 확인
					if($('#email').val() == '') {
						$("#emailMsg").html('');	// 메시지 초기화
						$('#emailMsg').append('<div style="margin-top: 10px;">이메일을 입력하세요<div>');
						$('#email').focus();
					} else {
						$("#emailMsg").html('');	// 메시지 초기화
					}
				});
				
				$('#pw').blur(function() {	// pw에 커서가 있지 않은 경우 확인
					if($('#pw').val() == '') {
						$("#pwMsg").html('');	// 메시지 초기화
						$('#pwMsg').append('<div style="margin-top: 10px;">비밀번호를 입력하세요<div>');
						$('#pw').focus();
					} else {
						$('#pwMsg').html('');		// 메시지 초기화
					}
				});
				
				$("#btn").click(function() {	// 버튼 클릭시 폼 내용의 유효성 검사를 수행
					if ($("#email").val() == "") {	// email이 공백인 경우 수행
						$("#emailMsg").html('');	// 메시지 초기화
						$('#emailMsg').append('<div style="margin-top: 10px;">이메일을 입력하세요<div>');
						$('#email').focus();
					
						return;
					}
					else if ($("#pw").val() == "") { // pw가 공백인 경우 수행
						$("#pwMsg").html('');	// 메시지 초기화
						$('#pwMsg').append('<div style="margin-top: 10px;">비밀번호를 입력하세요<div>');
						$('#pw').focus();
					
						return;
					}
					$("#loginForm").submit();
				});
			});
		</script>
		
		<style>
			.msgDiv {
				color: #FF0000;
			}
		</style>
	</head>
	<body>
		<br><br><br><br><br><br>
	
		<div class="container">
			<div class="align-self-center">
				<h1 class="text-center login-title">Sakila Log-in</h1>
				
				<br>
				
				<form method="post" action="${pageContext.request.contextPath}/LoginServlet" id="loginForm">
					<table class="table table-border" style="margin: auto; text-align: center; width: 50%;">
						<tr>
							<td>
								<div class="container">
									<input type="text" class="form-control" name="email" placeholder="Staff Email" id="email" value="Mike.Hillyer@sakilastaff.com">
									<div class="msgDiv" id="emailMsg"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="container">
									<input type="password" class="form-control" name="pw" placeholder="Password" id="pw" value="1234">
									<div class="msgDiv" id="pwMsg"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="container">
									<button type="button" class="btn btn-primary btn-block" id="btn">Log-in</button>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="container">
									<button type="button" class="btn btn-danger btn-block" id="testBtn" onclick="location.href='${pageContext.request.contextPath}/LoginServlet?test=true'">Test Log-in</button>
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
			
			<br>
			
			<table class="table table-striped" style="margin: auto; text-align: center; width: 50%">
				<tr>
					<td width="40%">
						<div class="container">
							Yesterday
						</div>
					</td>
					<td>
						<div class="container">
							${yesterdayStats.count}
						</div>
					</td>
				</tr>
				<tr>
					<td width="40%">
						<div class="container">
							Today
						</div>
					</td>
					<td>
						<div class="container">
							${todayStats.count}
						</div>
					</td>
				</tr>
				<tr>
					<td width="40%">
						<div class="container">
							Total
						</div>
					</td>
					<td>
						<div class="container">
							${totalCount}
						</div>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>