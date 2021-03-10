package shoppingMall_proj.dto;

public class Login {
	//Fields
	private String ID;
	private String Password;
	
	//Constructor
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(String ID) {
		ID = ID;
	}

	public Login(String ID, String password) {
		ID = ID;
		Password = password;
	}
	
	//getter & setter
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		ID = ID;
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
