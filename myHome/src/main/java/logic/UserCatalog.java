package logic;

import model.Loginuser;
import model.User;

public interface UserCatalog {
	Integer getIdCount(String id);//중복검사위해 특정계정의 갯수를 찾는 메서드
	User getUser(Loginuser lu);//계정과 암호를 찾는 메서드
	void putUser(User u);//가입자 등록 메서드
	
}
