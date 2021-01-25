package sakila.vo;

public class Film {
	private int filmId;
	private String title;
	private String description;
	private String releaseYear;
	private String language;
	private String originalLanguage;
	private int rentalDuration;
	private float rentalRate;
	private int length;
	private float replacementCost;
	private String rating;
	private String lastUpdate;
	
	private String category;
	private String actors;
	
	private int filmTotalAmount;	// 영화 총 재고수
	private int filmStockAmount;	// 영화 현재 재고 수
	private int filmRentalAmount;	// 영화 대여 수
	
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getOriginalLanguage() {
		return originalLanguage;
	}
	public void setOriginalLanguage(String originalLanguage) {
		this.originalLanguage = originalLanguage;
	}
	public int getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	public float getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(float rentalRate) {
		this.rentalRate = rentalRate;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(float replacementCost) {
		this.replacementCost = replacementCost;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public int getFilmTotalAmount() {
		return filmTotalAmount;
	}
	public void setFilmTotalAmount(int filmTotalAmount) {
		this.filmTotalAmount = filmTotalAmount;
	}
	public int getFilmStockAmount() {
		return filmStockAmount;
	}
	public void setFilmStockAmount(int filmStockAmount) {
		this.filmStockAmount = filmStockAmount;
	}
	public int getFilmRentalAmount() {
		return filmRentalAmount;
	}
	public void setFilmRentalAmount(int filmRentalAmount) {
		this.filmRentalAmount = filmRentalAmount;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [filmId=");
		builder.append(filmId);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", releaseYear=");
		builder.append(releaseYear);
		builder.append(", language=");
		builder.append(language);
		builder.append(", originalLanguage=");
		builder.append(originalLanguage);
		builder.append(", rentalDuration=");
		builder.append(rentalDuration);
		builder.append(", rentalRate=");
		builder.append(rentalRate);
		builder.append(", length=");
		builder.append(length);
		builder.append(", replacementCost=");
		builder.append(replacementCost);
		builder.append(", rating=");
		builder.append(rating);
		builder.append(", lastUpdate=");
		builder.append(lastUpdate);
		builder.append(", category=");
		builder.append(category);
		builder.append(", actors=");
		builder.append(actors);
		builder.append(", filmTotalAmount=");
		builder.append(filmTotalAmount);
		builder.append(", filmStockAmount=");
		builder.append(filmStockAmount);
		builder.append(", filmRentalAmount=");
		builder.append(filmRentalAmount);
		builder.append("]");
		return builder.toString();
	}
}
