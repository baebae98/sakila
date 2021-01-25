package sakila.vo;

public class FilmStoreStat {
	private String category;
	private float totalSales;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getTotalSales() {
		return totalSales;
	}
	public void setTotalSales(float totalSales) {
		this.totalSales = totalSales;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FilmStoreStat [category=");
		builder.append(category);
		builder.append(", totalSales=");
		builder.append(totalSales);
		builder.append("]");
		return builder.toString();
	}
}