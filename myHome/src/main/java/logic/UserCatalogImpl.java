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
	
	public Integer getIdCount(String id) {
		return userDao.getIdCount(id);
	}

	public User getUser(Loginuser lu) {
		return userDao.findByIdPwd(lu);
	}

	public void putUser(User u) {
		this.userDao.create(u);
	}

}
