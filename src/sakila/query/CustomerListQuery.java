package sakila.query;

public class CustomerListQuery {
	// Customer의 정보를 목록화 하여 출력하는 쿼리
	public final static String SELECT_CUSTOMER_LIST = "SELECT cl.ID, cl.name, cl.phone, cl.notes, IF((SELECT COUNT(*) FROM rental WHERE return_date IS NULL AND customer_id = cl.ID) > 0,'Y','N') AS overdue FROM customer_list cl ORDER BY cl.ID ASC LIMIT ?, ?";
	
	// 회원 목록의 데이터가 몇 개나 있는지 출력
	public final static String COUNT_CUSTOMER_LIST = "SELECT COUNT(*) FROM customer_list";
}