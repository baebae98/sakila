package sakila.dao;

import java.sql.*;

import sakila.query.*;
import sakila.service.*;
import sakila.vo.*;

public class StaffInfoDao {
	// Staff의 별명, 이름, 연락처, 주소, E-mail 정보를 불러오는 메소드
	public StaffInfo selectStaffInfo(Connection conn, StaffInfo staffInfo) throws Exception {
		System.out.println("Debug: selectStaffInfo 실행");
		
		StaffInfo returnStaffInfo = null;
		
		PreparedStatement stmt = conn.prepareStatement(StaffInfoQuery.SELECT_STAFF_INFO);
		stmt.setInt(1, staffInfo.getStaffId());
		
		ResultSet rs = stmt.executeQuery();		// conn 접속정보를 가진 SELECT_STAFF_BY_KEY 쿼리를 실행. 이후 결과를 rs에 저장.
		System.out.println("Debug: rs(" + rs + ")");
		
		if (rs.next()) {
			returnStaffInfo = new StaffInfo();
			returnStaffInfo.setUsername(rs.getString("staff.username"));
			System.out.println("Debug: username("+ rs.getString("staff.username") +")");
			returnStaffInfo.setFirstName(rs.getString("staff.first_name"));
			System.out.println("Debug: firstName("+ rs.getString("staff.first_name") +")");
			returnStaffInfo.setLastName(rs.getString("staff.last_name"));
			System.out.println("Debug: lastName("+ rs.getString("staff.last_name") +")");
			returnStaffInfo.setPhone(rs.getString("staff_list.phone"));
			System.out.println("Debug: phone("+ rs.getString("staff_list.phone") +")");
			returnStaffInfo.setCountry(rs.getString("staff_list.country"));
			System.out.println("Debug: country("+ rs.getString("staff_list.country") +")");
			returnStaffInfo.setCity(rs.getString("staff_list.city"));
			System.out.println("Debug: city("+ rs.getString("staff_list.city") +")");
			returnStaffInfo.setAddress(rs.getString("staff_list.address"));
			System.out.println("Debug: address("+ rs.getString("staff_list.address") +")");
			returnStaffInfo.setEmail(rs.getString("staff.email"));
			System.out.println("Debug: email("+ rs.getString("staff.email") +")");
		}
		
		return returnStaffInfo;
	}	
}