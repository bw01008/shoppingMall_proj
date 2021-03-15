package shoppingMall_proj.service;

import shoppingMall_proj.dao.LoginDao;
import shoppingMall_proj.dao.Impl.LoginDaoImpl;
import shoppingMall_proj.dto.Login;

public class LoginService {
	private LoginDao dao = LoginDaoImpl.getInstance();
	
	public Login LoginInfo(Login logTry) {
		return dao.selectLoginByID(logTry);
		
	}
}
 