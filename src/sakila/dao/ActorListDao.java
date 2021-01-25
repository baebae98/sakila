package sakila.dao;

import java.sql.*;
import java.util.*;

import sakila.query.*;
import sakila.service.*;
import sakila.vo.*;

public class ActorListDao {
	// 배우 목록 출력
	public ArrayList<Actor> selectActorList(Connection conn, int limit1, int limit2) throws Exception {
		System.out.println("Debug: selectActorList 실행");
		
		ArrayList<Actor> list = new ArrayList<Actor>();
		
		PreparedStatement stmt = conn.prepareStatement(ActorListQuery.SELECT_ACTOR_LIST);
		stmt.setInt(1, limit1);	// 페이지에 표시할 데이터의 첫 번째 인자
		stmt.setInt(2, limit2);	// 페이지당 표시할 데이터 수
		
		ResultSet rs = stmt.executeQuery();		// conn 접속정보를 가진 SELECT_ACTOR_LIST 쿼리를 실행. 이후 결과를 rs에 저장.
		System.out.println("Debug: rs(" + rs + ")");
		
		while(rs.next()) {
			Actor actorList = new Actor();
			actorList.setActorId(rs.getInt("actor_id"));
			System.out.println("Debug: actorId("+ rs.getInt("actor_id") +")");
			actorList.setFirstName(rs.getString("first_name"));
			System.out.println("Debug: name("+ rs.getString("first_name") +")");
			actorList.setLastName(rs.getString("last_name"));
			System.out.println("Debug: phone("+ rs.getString("last_name") +")");
			list.add(actorList);
		}
		
		return list;
	}
	
	// 배우 목록의 데이터가 몇 개나 있는지 합계를 출력
	public int countActorList(Connection conn) throws Exception {
		System.out.println("Debug: countActorList 실행");
		int count = 0;
		
		PreparedStatement stmt = conn.prepareStatement(ActorListQuery.COUNT_ACTOR_LIST);
		
		ResultSet rs = stmt.executeQuery();		// conn 접속정보를 가진 COUNT_ACTOR_LIST 쿼리를 실행. 이후 결과를 rs에 저장.
		System.out.println("Debug: rs(" + rs + ")");
		
		if(rs.next()) {
            count = rs.getInt("count(*)");
        }
		
		return count;
	}
}
