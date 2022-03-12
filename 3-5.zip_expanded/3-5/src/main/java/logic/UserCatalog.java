package logic;

import model.Loginuser;
import model.User;

public interface UserCatalog {
	User getUser(Loginuser user);
	void putUser(User user);
}
