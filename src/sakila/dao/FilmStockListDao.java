package sakila.dao;

import java.sql.*;
import java.util.*;

import sakila.query.*;
import sakila.service.*;
import sakila.vo.*;

public class FilmStockListDao {
	// 영화 재고 목록 출력
	public ArrayList<Film> selectFilmStockList(Connection conn, int limit1, int limit2) throws Exception {
		System.out.println("Debug: selectFilmStockList 실행");
		
		ArrayList<Film> list = new ArrayList<Film>();
		
		PreparedStatement stmt = conn.prepareStatement(FilmStockListQuery.SELECT_FILM_STOCK_LIST);
		stmt.setInt(1, limit1);	// 페이지에 표시할 데이터의 첫 번째 인자
		stmt.setInt(2, limit2);	// 페이지당 표시할 데이터 수
		
		ResultSet rs = stmt.executeQuery();		// conn 접속정보를 가진 SELECT_FILM_STOCK_LIST 쿼리를 실행. 이후 결과를 rs에 저장.
		System.out.println("Debug: rs(" + rs + ")");
		
		while(rs.next()) {
			Film film = new Film();
			film.setFilmId(rs.getInt("film_id"));
			System.out.println("Debug: filmId("+ rs.getInt("film_id") +")");
			film.setCategory(rs.getString("category"));
			System.out.println("Debug: category("+ rs.getString("category") +")");
			film.setTitle(rs.getString("title"));
			System.out.println("Debug: title("+ rs.getString("title") +")");
			film.setLanguage(rs.getString("language"));
			System.out.println("Debug: language("+ rs.getString("language") +")");
			film.setRating(rs.getString("rating"));
			System.out.println("Debug: rating("+ rs.getString("rating") +")");
			film.setFilmRentalAmount(rs.getInt("cnt"));
			System.out.println("Debug: filmRentalAmount("+ rs.getInt("cnt") +")");
			list.add(film);
		}
		
		return list;
	}
	
	// 영화 재고 목록의 데이터가 몇 개나 있는지 합계를 출력
	public int countFilmStockList(Connection conn) throws Exception {
		System.out.println("Debug: countFilmStockList 실행");
		int count = 0;
		
		PreparedStatement stmt = conn.prepareStatement(FilmStockListQuery.COUNT_FILM_STOCK_LIST);
		
		ResultSet rs = stmt.executeQuery();		// conn 접속정보를 가진 COUNT_FILM_STOCK_LIST 쿼리를 실행. 이후 결과를 rs에 저장.
		System.out.println("Debug: rs(" + rs + ")");
		
		if(rs.next()) {
            count = rs.getInt("count(*)");
        }
		
		return count;
	}
}