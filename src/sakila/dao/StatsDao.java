package sakila.dao;

import java.sql.*;

import sakila.query.*;
import sakila.service.*;
import sakila.vo.*;

public class StatsDao {
	// 오늘 날짜가 있는지 없는지 확인하기 위한 메소드
	// boolean을 통해 true라면 updateStats로, false라면 insertStats로
	public Stats selectDay(Connection conn, Stats stats) throws Exception {
		System.out.println("Debug: selectDay 실행");
		
		Stats returnStats = null;
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_DAY);
		stmt.setString(1, stats.getDay());
		
		ResultSet rs = stmt.executeQuery();		// conn 접속정보를 가진 SELECT_DAY 쿼리를 실행. 이후 결과를 rs에 저장.
		System.out.println("Debug: rs(" + rs + ")");
		
		if (rs.next()) {
			returnStats = new Stats();
			returnStats.setDay(rs.getString("day"));
			System.out.println("Debug: day("+ rs.getString("day") +")");
			returnStats.setCount(rs.getLong("cnt"));
			System.out.println("Debug: cnt("+ rs.getLong("cnt") +")");
		}
		
		return returnStats;		// rs.next()가 true인 경우 updateStats 실행. 아니면 insertStats 실행.
	}
	
	// 방문수 입력을 위한 메소드 (동일 날짜가 없는 경우 새로운 날짜를 생성)
	public void insertStats(Connection conn, Stats stats) throws Exception {
		System.out.println("Debug: insertStats 실행");
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.INSERT_STATS);
		stmt.setString(1, stats.getDay());
		
		stmt.executeUpdate();	// conn 접속정보를 가진 INSERT_STATS 쿼리 실행.
	}
	
	// 방문수 수정을 위한 메소드 (동일 날짜가 있는 경우 해당 날짜의 카운트를 증가)
	public void updateStats(Connection conn, Stats stats) throws Exception {
		System.out.println("Debug: updateStats 실행");
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.UPDATE_STATS);
		stmt.setString(1, stats.getDay());
		
		stmt.executeUpdate();	// conn 접속정보를 가진 INSERT_STATS 쿼리 실행.
	}
	
	// 어제 날짜의 방문자 수를 확인하는 메소드
	public Stats selectYesterday(Connection conn, Stats stats) throws Exception {
		System.out.println("Debug: selectYesterday 실행");
		
		Stats returnStats = null;
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_YESTERDAY);
		stmt.setString(1, stats.getDay());
		
		ResultSet rs = stmt.executeQuery();		// conn 접속정보를 가진 SELECT_YESTERDAY 쿼리를 실행. 이후 결과를 rs에 저장.
		System.out.println("Debug: rs(" + rs + ")");
		
		if (rs.next()) {
			returnStats = new Stats();
			returnStats.setDay(rs.getString("day"));
			System.out.println("Debug: day("+ rs.getString("day") +")");
			returnStats.setCount(rs.getLong("cnt"));
			System.out.println("Debug: cnt("+ rs.getLong("cnt") +")");
		}
		
		return returnStats;
	}
	
	// 전체 기간의 방문자 수를 확인하는 메소드
	public Stats selectTotalCount(Connection conn) throws Exception {
		System.out.println("Debug: selectTotalCount 실행");
		
		Stats returnStats = null;
		
		PreparedStatement stmt = conn.prepareStatement(StatsQuery.SELECT_TOTAL);
		
		ResultSet rs = stmt.executeQuery();		// conn 접속정보를 가진 SELECT_TOTAL 쿼리를 실행. 이후 결과를 rs에 저장.
		System.out.println("Debug: rs(" + rs + ")");
		
		if (rs.next()) {
			returnStats = new Stats();
			returnStats.setCount(rs.getLong("sum(cnt)"));
			System.out.println("Debug: sum(cnt)");
		}
		
		return returnStats;
	}
}