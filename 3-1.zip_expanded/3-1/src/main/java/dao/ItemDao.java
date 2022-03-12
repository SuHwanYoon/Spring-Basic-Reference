package dao;

import java.util.List;

import model.Fruit;

public interface ItemDao {
	List<Fruit> findAll();
}
