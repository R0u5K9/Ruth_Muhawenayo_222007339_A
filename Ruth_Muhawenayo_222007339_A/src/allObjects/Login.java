package allObjects;

public class Login {
	private String email;
	private String password;
	
	public Login(String email, String password) {
		this.email=email;
		this.password=password;
	}
	public Login() {
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getpassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
		
public void logmein(String email1, String password1)	{
	this.email=email1;
	this.password=password1;
}
			
}

