package sakila.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import sakila.service.*;
import sakila.vo.*;

@WebServlet("/auth/MyInfoServlet")
public class MyInfoServlet extends HttpServlet {
	private StaffInfoService staffInfoService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Debug: MyInfoServlet doGet 실행");
		
		HttpSession session = request.getSession();
		
		staffInfoService = new StaffInfoService();
		StaffInfo staffInfo = new StaffInfo();
		staffInfo = new StaffInfo();
		
		System.out.println("Debug: StaffInfo 객체 생성");
		
		Staff staff = (Staff) session.getAttribute("loginStaff");	// 세션에 저장되어 있는 staff 객체 정보가 이 곳에 들어간다.
		System.out.println("Debug: StaffInfo 객체 생성");
		staffInfo.setStaffId(staff.getStaffId());	// staff 객체에 저장된 staffId를 staffInfo의 staffId에 저장한다.
		System.out.println("Debug: setStaffId 작업 수행");
		
		StaffInfo returnStaffInfo = staffInfoService.getStaffInfo(staffInfo);	// staff의 정보를 불러온다.
		System.out.println("Debug: returnStaffInfo(" + returnStaffInfo + ")");
		
		if (returnStaffInfo != null) {	// staff.email와 staff.password가 모두 일치하는 데이터가 존재할 경우
			request.setAttribute("staffInfo", returnStaffInfo);	// request에 staffInfo 데이터를 담음
		}
		
		request.getRequestDispatcher("/WEB-INF/views/auth/admin/myInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost
	}
}