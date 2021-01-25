package sakila.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import sakila.service.*;
import sakila.vo.*;

@WebServlet("/auth/FilmStoreStatServlet")
public class FilmStoreStatServlet extends HttpServlet {
	private FilmStoreStatService filmStoreStatService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Debug: FilmStoreStatServlet doGet 실행");
		
		filmStoreStatService = new FilmStoreStatService();
		System.out.println("Debug: filmStoreStatService 객체 생성");
		
		FilmStoreStat filmStoreStat = filmStoreStatService.getStoreStat();	// 매장별 매출내역을 불러온다
		System.out.println("Debug: filmStoreStat(" + filmStoreStat + ")");
		
		ArrayList<FilmStoreStat> returnFilmStoreStat = filmStoreStatService.getFilmStoreStat();	// 카테고리별 매출내역을 불러온다
		System.out.println("Debug: returnFilmStoreStat(" + returnFilmStoreStat + ")");
		
		request.setAttribute("salesByStore", filmStoreStat);	// request에 SalesByStore 데이터를 담음
		request.setAttribute("filmStoreStat", returnFilmStoreStat);	// request에 filmStockList 데이터를 담음
		
		request.getRequestDispatcher("/WEB-INF/views/auth/statistics/statistics.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost
	}
}