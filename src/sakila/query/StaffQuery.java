package sakila.query;

public class StaffQuery {
	// Staff가 존재하는지 확인하는 쿼리
	// staff_id와 password가 모두 일치하는지 여부 확인 후 staff_id, store_id, email, username을 반환
	public final static String SELECT_STAFF_BY_KEY = "select staff_id, store_id, email, username from staff where email = ? and password = password(?)";
}