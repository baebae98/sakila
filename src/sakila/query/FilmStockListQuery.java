package sakila.query;

public class FilmStockListQuery {
	// Film 재고의 정보를 목록화 하여 출력하는 쿼리
	public final static String SELECT_FILM_STOCK_LIST = "SELECT f.film_id, c.name AS category, f.title, l.name AS language, f.rating, COUNT(rental_id) AS cnt from rental r INNER join inventory i on r.inventory_id = i.inventory_id inner join film f on i.film_id = f.film_id INNER JOIN sakila.`language` l ON f.language_id = l.language_id INNER JOIN film_category fc ON f.film_id = fc.film_id INNER JOIN category c ON fc.category_id = c.category_id WHERE r.return_date IS NULL GROUP BY f.film_id ORDER BY f.film_id LIMIT ?, ?";
	
	// 영화 재고 목록의 데이터가 몇 개나 있는지 출력
	public final static String COUNT_FILM_STOCK_LIST = "SELECT COUNT(*) from rental r INNER join inventory i on r.inventory_id = i.inventory_id inner join film f on i.film_id = f.film_id INNER JOIN sakila.`language` l ON f.language_id = l.language_id INNER JOIN film_category fc ON f.film_id = fc.film_id INNER JOIN category c ON fc.category_id = c.category_id WHERE r.return_date IS NULL";
}