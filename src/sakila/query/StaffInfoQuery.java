package sakila.query;

public class StaffInfoQuery {
	// Staff의 정보를 출력하는 쿼리
	// 세션에 저장된 staff_id와의 일치여부를 확인
	public final static String SELECT_STAFF_INFO = "select staff.username, staff.first_name, staff.last_name, staff_list.phone, staff_list.country, staff_list.city, staff_list.address, staff.email from staff inner join staff_list on staff.staff_id = staff_list.ID where staff.staff_id = ?";
}