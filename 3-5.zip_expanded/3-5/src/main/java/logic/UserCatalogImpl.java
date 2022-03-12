package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import model.Loginuser;
import model.User;
@Service
public class UserCatalogImpl implements UserCatalog {
	@Autowired
	private UserDao userDao;
	public User getUser(Loginuser user) {
		return userDao.findByIdPwd(user);
	}

	public void putUser(User user) {
		userDao.create(user);
	}

}
