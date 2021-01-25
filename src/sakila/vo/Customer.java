package sakila.vo;

public class Customer {
	private int customerId;		// customer 고유번호
	private int storeId;		// 고객이 속해 있는 매장번호
	private String firstName;	// 고객 성
	private String lastName;	// 고객 이름
	private String email;		// 고객 이메일
	private int active;			// 고객 계정 활성화 여부 (int)
	private String createDate;	// 고객 계정 생성일시
	private String lastUpdate;	// 고객 계정 변동일시
	
	private String name;		// customer 이름 (성+이름)
	private String phone;		// customer 연락처
	private String notes;		// 고객 계정 활성화 여부 (String)
	private String overdue;		// 연체 여부 (Y면 연체, N이면 연체 아님)
	
	private float totalAmount;	// 고객의 총 구매액
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getOverdue() {
		return overdue;
	}
	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [customerId=");
		builder.append(customerId);
		builder.append(", storeId=");
		builder.append(storeId);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", active=");
		builder.append(active);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", lastUpdate=");
		builder.append(lastUpdate);
		builder.append(", name=");
		builder.append(name);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", notes=");
		builder.append(notes);
		builder.append(", overdue=");
		builder.append(overdue);
		builder.append(", totalAmount=");
		builder.append(totalAmount);
		builder.append("]");
		return builder.toString();
	}
}