package sakila.query;

public class FilmListQuery {
	// Film의 정보를 목록화 하여 출력하는 쿼리
	public final static String SELECT_FILM_LIST = "select fl.FID, fl.category, fl.title, l.name, fl.rating, fl.price from film_list as fl inner join film AS f on fl.FID = f.film_id inner join language AS l on f.language_id = l.language_id order by FID asc limit ?, ?";
	
	// 영화 목록의 데이터가 몇 개나 있는지 출력
	public final static String COUNT_FILM_LIST = "select COUNT(*) from film_list as fl inner join film AS f on fl.FID = f.film_id inner join language AS l on f.language_id = l.language_id";
}