package sakila.query;

public class ActorListQuery {
	// Actor의 정보를 목록화 하여 출력하는 쿼리
	public final static String SELECT_ACTOR_LIST = "select actor_id, first_name, last_name from actor order by actor_id limit ?, ?";
	
	// 배우 목록의 데이터가 몇 개나 있는지 출력
	public final static String COUNT_ACTOR_LIST = "SELECT COUNT(*) FROM actor";
}