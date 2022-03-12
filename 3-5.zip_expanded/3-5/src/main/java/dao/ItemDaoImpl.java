package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Fruit;
@Repository//자동생성 어노테이션
public class ItemDaoImpl implements ItemDao {
	@Autowired//자동주입
	private SqlSession session;
	public List<Fruit> findAll() {
		return session.selectList("mapper.menu.getItems");
	}

	public Fruit findById(Integer id) {
		return session.selectOne("mapper.menu.getItem",id);
	}

}
