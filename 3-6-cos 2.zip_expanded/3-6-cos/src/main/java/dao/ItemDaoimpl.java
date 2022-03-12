package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Fruit;
@Repository
public class ItemDaoimpl implements ItemDao {
	@Autowired
	private SqlSession session;
	public List<Fruit> findByName(String name) {
		return session.selectList("mapper.menu.findItem", name);}
	public List<Fruit> findAll() {
		return session.selectList("mapper.menu.getItemList");}
	public Fruit findById(Integer id) {
		return session.selectOne("mapper.menu.getItem",id);}
	public void create(Fruit fruit) {
		session.insert("mapper.menu.putItem",fruit);}
	public void update(Fruit fruit) {
		session.update("mapper.menu.updateItem", fruit);}
	public void delete(Integer id) {
		session.delete("mapper.menu.deleteItem", id);}
}
