package sakila.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/auth/IndexServlet")
public class IndexServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Debug: IndexServlet doGet 실행");
		
		HttpSession session = request.getSession();
		
		System.out.println("Debug: loginStaff(" + session.getAttribute("loginStaff") + ")");
		
		request.getRequestDispatcher("/WEB-INF/views/auth/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost
	}
}