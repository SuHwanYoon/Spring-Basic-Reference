package dao;

import model.User;

public interface UserDao {
	User findByIdPwd(User user);
	void create(User user);//가입자 등록 메서드
}
