<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>mvp.jsp</title>
		
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
								<h2>MVP</h2>
							</td>
							<td width="15%">
								&nbsp;
							</td>
						</tr>
					</table>
					
					<hr style="margin-top: 8px;">
					
					<table class="table table-hover" style="text-align: center">
						<thead>
							<th>번호</th>
							<th>고객명</th>
							<th>총 구매액</th>
						</thead>
						<tbody>
							<c:forEach var="b" items="${mvp}">
								<tr>
									<td>${b.customerId}</td>
									<td>${b.name}</td>
									<td>${b.totalAmount}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<br>
					
					<!-- 페이지 네비게이션 -->
					<ul class="pagination justify-content-center">
						<!-- 처음으로 버튼 -->
						<c:choose>
							<c:when test="${currentPage > 1}">
								<li class="page-item">
									<a class="page-link" href="${pageContext.request.contextPath}/auth/MVPServlet?currentPage=1">처음</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="page-item disabled">
									<a class="page-link" href="#">처음</a>
								</li>
							</c:otherwise>
						</c:choose>
						
						<!-- 이전 버튼 -->
						<c:choose>
							<c:when test="${currentPage > 1}">
								<li class="page-item">
									<a class="page-link" href="${pageContext.request.contextPath}/auth/MVPServlet?currentPage=${currentPage - 1}">이전</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="page-item disabled">
									<a class="page-link" href="#">이전</a>
								</li>
							</c:otherwise>
						</c:choose>
						
						<!-- 현재 페이지 표시 -->
						<c:forEach var="i" begin="${navFirstPage}" end="${navLastPage}">
							<c:if test="${i <= lastPage}">
								<c:choose>
									<%-- 현재 페이지 --%>
									<c:when test="${i == currentPage}">
										<li class="page-item disabled">
											<a class="page-link" href="#">${i}</a>
										</li>
									</c:when>
									<%-- 현재 페이지가 아닌 선택 가능한 페이지 --%>
									<c:otherwise>
										<li class="page-item">
											<a class="page-link" href="${pageContext.request.contextPath}/auth/MVPServlet?currentPage=${i}">${i}</a>
										</li>
									</c:otherwise>
								</c:choose>
							</c:if>
						</c:forEach>
						
						<!-- 다음 버튼 -->
						<c:choose>
							<c:when test="${currentPage < lastPage}">
								<li class="page-item">
									<a class="page-link" href="${pageContext.request.contextPath}/auth/MVPServlet?currentPage=${currentPage + 1}">다음</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="page-item disabled">
									<a class="page-link" href="#">다음</a>
								</li>
							</c:otherwise>
						</c:choose>
						
						<!-- 마지막으로 버튼 -->
						<c:choose>
							<c:when test="${currentPage < lastPage}">
								<li class="page-item">
									<a class="page-link" href="${pageContext.request.contextPath}/auth/MVPServlet?currentPage=${lastPage}">마지막</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="page-item disabled">
									<a class="page-link" href="#">마지막</a>
								</li>
							</c:otherwise>
						</c:choose>
					</ul>
					
					<!-- 총 페이지 수 출력 -->
					<table style="margin: auto;">
						<tr>
							<td>
								<button type="button" class="btn btn-outline-dark btn-sm">
									${currentPage} / ${lastPage} 페이지
								</button>
							</td>
						</tr>
					</table>
				</main>
			</div>
		</section>
	</body>
</html>