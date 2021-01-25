<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="padding-left: 10px; padding-right: 10px;">
	<div style="margin: auto; text-align: center;">
		<h3>
			<a style="text-decoration: none; color: black;" href="${pageContext.request.contextPath}/auth/IndexServlet">Sakila Movie</a>
		</h3>
	</div>
	
	<br>
	
	<div style="margin: auto;">
		<a style="text-decoration: none; color: black;" href="${pageContext.request.contextPath}/auth/MyInfoServlet">
			<table style="width: 100%; margin: auto; text-align: right;">
				<tr>
					<td rowspan="2" style="text-align: left;">
						<i class="fas fa-user-circle fa-3x"></i>
					</td>
					<td>
						<span>${loginStaff.storeId}</span> 지점
					</td>
				</tr>
				<tr>
					<td>
						<span>${loginStaff.username}</span> 관리자님
					</td>
				</tr>
			</table>
		</a>
	</div>
	
	<div style="margin-top: 10px; margin-bottom: 100px;">
		<button type="button" class="btn btn-dark btn-sm btn-block" onclick="location.href='${pageContext.request.contextPath}/auth/LogoutServlet'">Log-out</button>
	</div>

	<div style="margin-bottom: 20px;">
		<h4>Menu</h4>
	</div>
	
	<table width="100%">
		<tr>
			<td>
				<a style="color: black;" href="${pageContext.request.contextPath}/auth/IndexServlet">홈</a>
			</td>
		</tr>
		<tr>
			<td><hr></td>
		</tr>
		<tr>
			<td>
				<a style="color: black;" href="${pageContext.request.contextPath}/auth/ReturnListServlet"><del>영화 반납</del></a>
			</td>
		</tr>
		<tr>
			<td><hr></td>
		</tr>
		<tr>
			<td>
				<a style="color: black;" href="${pageContext.request.contextPath}/auth/CustomerListServlet">회원목록 관리</a>
			</td>
		</tr>
		<tr>
			<td>
				<a style="color: black;" href="${pageContext.request.contextPath}/auth/FilmListServlet">영화목록 관리</a>
			</td>
		</tr>
		<tr>
			<td>
				<a style="color: black;" href="${pageContext.request.contextPath}/auth/FilmStockListServlet">영화재고 관리</a>
			</td>
		</tr>
		<tr>
			<td>
				<a style="color: black;" href="${pageContext.request.contextPath}/auth/ActorListServlet">영화배우 관리</a>
			</td>
		</tr>
		<tr>
			<td><del>영화 출연배우 등록</del></td>
		</tr>
		<tr>
			<td><hr></td>
		</tr>
		<tr>
			<td>
				<a style="color: black;" href="${pageContext.request.contextPath}/auth/FilmStoreStatServlet">매장 통계</a>
			</td>
		</tr>
		<tr>
			<td>
				<a style="color: black;" href="${pageContext.request.contextPath}/auth/MVPServlet">MVP</a>
			</td>
		</tr>
	</table>
</div>