package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Fruit;

public class ItemDaoImpl implements ItemDao {
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	//crud의 역할
	public Fruit findById(Integer id) {
		Fruit f = session.selectOne("mapper.menu.getItem",id);
		return f;
	}

	public List<Fruit> findAll() {
		List<Fruit> list=
				session.selectList("mapper.menu.getItems");
		return list;
	}
	
}
