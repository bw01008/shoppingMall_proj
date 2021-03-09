package shoppingMall_proj.dto;

public class Login {
	//Fields
	private String ID;
	private String Password;
	
	//Constructor
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(String iD) {
		ID = iD;
	}

	public Login(String iD, String password) {
		ID = iD;
		Password = password;
	}
	
	//getter & setter
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return String.format("Login [ID=%s, Password=%s]", ID, Password);
	}

}
