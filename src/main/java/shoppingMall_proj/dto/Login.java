package shoppingMall_proj.dto;

public class Login {
	// Fields
	private String ID;
	private String Password;

	// Constructor
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(String ID) {
		this.ID = ID;
	}

	public Login(String ID, String password) {
		this.ID = ID;
		this.Password = password;
	}

	// getter & setter
	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((Password == null) ? 0 : Password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (Password == null) {
			if (other.Password != null)
				return false;
		} else if (!Password.equals(other.Password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Login [ID=%s, Password=%s]", ID, Password);
	}

}
