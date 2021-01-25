package sakila.query;

public class StatsQuery {
	// 오늘 날짜가 있는지 없는지 확인하기 위한 쿼리
	public static final String SELECT_DAY="select * from stats where day = ?";
	
	// 방문자 수를 새로 입력하기 위한 쿼리 (동일 날짜가 없는 경우)
	public static final String INSERT_STATS="insert into stats(day, cnt) values(?, 1)";
	
	// 방문자 수를 수정하기 위한 쿼리 (동일 날짜에 +1을 하여 방문자수 수정)
	public static final String UPDATE_STATS="update stats set cnt = cnt+1 where day = ?";
	
	// 전체 방문자 수를 출력하기 위한 쿼리
	public static final String SELECT_TOTAL="select sum(cnt) from stats";
	
	// 어제의 방문자 수를 출력하기 위한 쿼리
	public static final String SELECT_YESTERDAY="select * from stats where day = ?";
}