package sakila.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import sakila.service.*;
import sakila.vo.*;

@WebServlet("/auth/CustomerListServlet")
public class CustomerListServlet extends HttpServlet {
	private CustomerListService customerListService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Debug: CustomerListServlet doGet 실행");
		
		customerListService = new CustomerListService();
		System.out.println("Debug: CustomerList 객체 생성");
		
		// 현재 페이지
		int currentPage = 1;
		
		if (request.getParameter("currentPage") != null) { // null인지 아닌지 체크
			currentPage = Integer.parseInt(request.getParameter("currentPage"));	// currentPage를 파라미터 값으로 변경
		}
		
		// 페이지당 데이터를 표시할 개수
		int rowPerPage = 10;
		
		// 전체 데이터 수
		int totalCount = 0;
		totalCount = customerListService.countCustomerList();	// 전체 데이터 개수
		System.out.println("Debug: totalCount(" + totalCount + ")");
		
		// 마지막 페이지
		int lastPage = totalCount / rowPerPage;
		if (totalCount % rowPerPage != 0) {	// 10 미만의 개수의 데이터가 있는 페이지를 표시
			lastPage += 1;
		}
		
		if (lastPage == 0) { // 전체 페이지가 0개이면 현재 페이지도 0으로 표시
			currentPage = 0;
		}
		
		int navPerPage = 10;	// 네비게이션에 표시할 페이지 수
		int navFirstPage = currentPage - (currentPage % navPerPage) + 1;	// 네비게이션 첫번째 페이지
		int navLastPage = navFirstPage + navPerPage - 1;	// 네비게이션 마지막 페이지
		
		if (currentPage % navPerPage == 0 && currentPage != 0) {	// 10으로 나누어 떨어지는 경우 처리하는 코드
			navFirstPage = navFirstPage - navPerPage;
			navLastPage = navLastPage - navPerPage;
		}
		
		ArrayList<Customer> returnCustomerList = customerListService.getCustomerList((currentPage - 1) * rowPerPage, rowPerPage);	// 회원 목록을 불러온다.
		System.out.println("Debug: returnCustomerList(" + returnCustomerList + ")");
		
		request.setAttribute("customerList", returnCustomerList);	// request에 customerList 데이터를 담음
		
		request.setAttribute("currentPage", currentPage);			// request에 currentPage 데이터를 담음
		request.setAttribute("lastPage", lastPage);					// request에 lastPage 데이터를 담음
		
		request.setAttribute("navPerPage", navPerPage);				// request에 navPerPage 데이터를 담음
		request.setAttribute("navFirstPage", navFirstPage);			// request에 navFirstPage 데이터를 담음
		request.setAttribute("navLastPage", navLastPage);			// request에 navLastPage 데이터를 담음
		
		request.getRequestDispatcher("/WEB-INF/views/auth/customer/customerList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost
	}
}