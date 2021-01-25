package sakila.dao;

import java.sql.*;
import java.util.*;

import sakila.query.*;
import sakila.service.*;
import sakila.vo.*;

public class FilmStoreStatDao {
	// 매장별 매출액 출력
	public FilmStoreStat selectSalesByStore(Connection conn) throws Exception {
		System.out.println("Debug: selectSalesByStore 실행");
		
		FilmStoreStat filmStoreStat = null;
		
		PreparedStatement stmt = conn.prepareStatement(FilmStoreStatQuery.SELECT_SALES_BY_STORE);
		
		ResultSet rs = stmt.executeQuery();		// conn 접속정보를 가진 SELECT_SALES_BY_STORE 쿼리를 실행. 이후 결과를 rs에 저장.
		System.out.println("Debug: rs(" + rs + ")");
		
		while(rs.next()) {
			filmStoreStat = new FilmStoreStat();
			filmStoreStat.setTotalSales(rs.getFloat("sum(total_sales)"));
			System.out.println("Debug: store("+ rs.getFloat("sum(total_sales)") +")");
		}
		
		return filmStoreStat;
	}
	
	// 영화 카테고리별 매출액 출력
	public ArrayList<FilmStoreStat> selectSalesByFilmCategory(Connection conn) throws Exception {
		System.out.println("Debug: selectFilmStockList 실행");
		
		ArrayList<FilmStoreStat> list = new ArrayList<FilmStoreStat>();
		
		PreparedStatement stmt = conn.prepareStatement(FilmStoreStatQuery.SELECT_SALES_BY_FILM_CATEGORY);
		
		ResultSet rs = stmt.executeQuery();		// conn 접속정보를 가진 SELECT_SALES_BY_FILM_CATEGORY 쿼리를 실행. 이후 결과를 rs에 저장.
		System.out.println("Debug: rs(" + rs + ")");
		
		while(rs.next()) {
			FilmStoreStat filmStoreStat = new FilmStoreStat();
			filmStoreStat.setCategory(rs.getString("category"));
			System.out.println("Debug: category("+ rs.getString("category") +")");
			filmStoreStat.setTotalSales(rs.getFloat("total_sales"));
			System.out.println("Debug: totalSales("+ rs.getString("total_sales") +")");
			list.add(filmStoreStat);
		}
		
		return list;
	}
}