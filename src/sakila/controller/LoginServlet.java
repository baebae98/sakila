package sakila.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import sakila.service.*;
import sakila.vo.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private StatsService statsService;
	private StaffService staffService;
	
	// loginForm
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Debug: LoginServlet doGet 실행");
		
		// 테스트 로그인 시작 ==========>
		
		boolean test = Boolean.parseBoolean(request.getParameter("test"));
		
		if (test) {
			String staffEmail = "Mike.Hillyer@sakilastaff.com";
			String staffPassword = "1234";
			
			staffService = new StaffService();
			Staff staff = new Staff();	// 사용자가 로그인 폼에 입력한 email, pw 정보가 이 객체에 들어간다
			staff.setEmail(staffEmail);
			staff.setPassword(staffPassword);
			
			System.out.println("Debug: 로그인 Staff 객체 생성");
			System.out.println("Debug: staffEmail(" + staff.getEmail() + ")");
			System.out.println("Debug: staffPassword(" + staff.getPassword() + ")");
			
			Staff returnStaff = staffService.getStaffByKey(staff);	// 로그인에 성공한 staff.id, staff.store_id staff.email, staff.username의 데이터를 returnStaff에 저장
			
			if (returnStaff != null) {	// staff.email와 staff.password가 모두 일치하는 데이터가 존재할 경우
				System.out.println("Debug: 로그인 성공");
				
				HttpSession session = request.getSession();
				session.setAttribute("loginStaff", returnStaff);	// 세션에 로그인 성공한 정보가 담긴 returnStaff를 저장
				
				response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
				return;
			}
		}
		
		// 테스트 로그인 종료 ==========>
		
		HttpSession session = request.getSession();
		if (session.getAttribute("loginStaff") != null) {	// 로그인이 된 상태인지 확인
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
		
			return;
		}
		
		statsService = new StatsService();
		//Stats stats = statsService.getStats();
		Map<String, Object> map = statsService.getStats();
		
		//request.setAttribute("stats", stats);
		request.setAttribute("yesterdayStats", map.get("yesterdayStats"));
		request.setAttribute("todayStats", map.get("todayStats"));
		request.setAttribute("totalCount", map.get("totalCount"));
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	// loginAction
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Debug: LoginServlet doPost 실행");
		
		String staffEmail = request.getParameter("email");
		System.out.println("Debug: getParameter staffEmail("+ staffEmail +")");
		String staffPassword = request.getParameter("pw");
		System.out.println("Debug: getParameter staffPassword("+ staffPassword +")");
		
		staffService = new StaffService();
		Staff staff = new Staff();	// 사용자가 로그인 폼에 입력한 email, pw 정보가 이 객체에 들어간다
		staff.setEmail(staffEmail);
		staff.setPassword(staffPassword);
		
		System.out.println("Debug: 로그인 Staff 객체 생성");
		System.out.println("Debug: staffEmail(" + staff.getEmail() + ")");
		System.out.println("Debug: staffPassword(" + staff.getPassword() + ")");
		
		Staff returnStaff = staffService.getStaffByKey(staff);	// 로그인에 성공한 staff.id, staff.store_id staff.email, staff.username의 데이터를 returnStaff에 저장
		
		if (returnStaff != null) {	// staff.email와 staff.password가 모두 일치하는 데이터가 존재할 경우
			System.out.println("Debug: 로그인 성공");
			
			HttpSession session = request.getSession();
			session.setAttribute("loginStaff", returnStaff);	// 세션에 로그인 성공한 정보가 담긴 returnStaff를 저장
			
			response.sendRedirect(request.getContextPath() + "/auth/IndexServlet");
			return;
		}
		
		System.out.println("Debug: 로그인 실패");
		response.sendRedirect(request.getContextPath() + "/LoginServlet");
	}
}