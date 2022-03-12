package dao;

import model.Loginuser;
import model.User;

public interface UserDao {
	User findByIdPwd(Loginuser user);
	void create(User user);//가입자 등록 메서드
}
