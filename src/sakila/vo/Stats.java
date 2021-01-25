package sakila.vo;

public class Stats {
	private String day;		// 해당하는 날짜
	private long count;		// 해당하는 날짜의 방문자 수
	
	public String getDay() {
		return day;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	public long getCount() {
		return count;
	}
	
	public void setCount(long count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Stats [day=" + day + ", count=" + count + "]";
	}
}