package sakila.dao;

import java.sql.*;
import java.util.*;

import sakila.query.*;
import sakila.service.*;
import sakila.vo.*;

public class MVPDao {
	// MVP 회원 목록 출력
	public ArrayList<Customer> selectMVP(Connection conn, int limit1, int limit2) throws Exception {
		System.out.println("Debug: selectMVP 실행");
		
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		PreparedStatement stmt = conn.prepareStatement(MVPQuery.SELECT_MVP_LIST);
		stmt.setInt(1, limit1);	// 페이지에 표시할 데이터의 첫 번째 인자
		stmt.setInt(2, limit2);	// 페이지당 표시할 데이터 수
		
		ResultSet rs = stmt.executeQuery();		// conn 접속정보를 가진 SELECT_MVP_LIST 쿼리를 실행. 이후 결과를 rs에 저장.
		System.out.println("Debug: rs(" + rs + ")");
		
		while(rs.next()) {
			Customer MVP = new Customer();
			MVP.setCustomerId(rs.getInt("customer_id"));
			System.out.println("Debug: customerId("+ rs.getInt("customer_id") +")");
			MVP.setName(rs.getString("name"));
			System.out.println("Debug: name("+ rs.getString("name") +")");
			MVP.setTotalAmount(rs.getFloat("total_amount"));
			System.out.println("Debug: phone("+ rs.getString("total_amount") +")");
			list.add(MVP);
		}
		
		return list;
	}
	
	// MVP 목록의 데이터가 몇 개나 있는지 합계를 출력
	public int countMVP(Connection conn) throws Exception {
		System.out.println("Debug: countMVP 실행");
		int count = 0;
		
		PreparedStatement stmt = conn.prepareStatement(MVPQuery.COUNT_MVP_LIST);
		
		ResultSet rs = stmt.executeQuery();		// conn 접속정보를 가진 COUNT_MVP_LIST 쿼리를 실행. 이후 결과를 rs에 저장.
		System.out.println("Debug: rs(" + rs + ")");
		
		if(rs.next()) {
            count = rs.getInt("count(*)");
        }
		
		return count;
	}
}