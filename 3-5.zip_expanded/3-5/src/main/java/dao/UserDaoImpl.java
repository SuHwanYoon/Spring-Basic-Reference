package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Loginuser;
import model.User;
@Repository//클래스를 자동생성,환경설정에 선언하지 않음
public class UserDaoImpl implements UserDao {
	@Autowired
	private SqlSession session;
	public User findByIdPwd(Loginuser user) {
		return session.selectOne("mapper.menu.getUser",user);
	}

	public void create(User user) {
		session.insert("mapper.menu.putUser",user);
	}

}
