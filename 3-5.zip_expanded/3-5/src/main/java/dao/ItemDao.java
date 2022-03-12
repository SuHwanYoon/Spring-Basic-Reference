package dao;

import java.util.List;

import model.Fruit;

public interface ItemDao {
	List<Fruit> findAll();//전체상품 조회
	Fruit findById(Integer id);//상품번호 조회
}
