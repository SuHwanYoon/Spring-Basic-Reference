package dao;

import model.Loginuser;
import model.User;

public interface UserDao {
	Integer getIdCount(String id);//계정으로 갯수를 찾는 중복검사를 위한 메서드
	
	User findByIdPwd(Loginuser user);
	void create(User user);//가입자 등록 메서드
}
