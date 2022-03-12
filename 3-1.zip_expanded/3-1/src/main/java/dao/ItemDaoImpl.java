package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Fruit;

public class ItemDaoImpl implements ItemDao {
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public List<Fruit> findAll() {
		List<Fruit> list=
				session.selectList("mapper.menu.getItems");
		return list;
	}

}
