package allObjects;

public class Admin {
	private int admin_id;
	private String name;
	private String phone;
	private String email;
	
	public Admin(int admin_id, String name, String phone, String email) {
		this.admin_id=admin_id;
		this.name=name;
		this.phone=phone;
		this.email=email;
		
	}
		
		public Admin() {
	}
	public int getId() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id=admin_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone=phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	
}
