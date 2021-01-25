package sakila.query;

public class MVPQuery {
	// MVP의 정보를 목록화 하여 출력하는 쿼리
	public final static String SELECT_MVP_LIST = "select p.customer_id, cl.name, sum(amount) as total_amount from payment p inner join customer_list cl on p.customer_id = cl.ID group by p.customer_id order by sum(amount) desc limit ?, ?";
	
	// MVP 목록의 데이터가 몇 개나 있는지 출력
	public final static String COUNT_MVP_LIST = "select COUNT(*) from customer";
}