package dao;

import java.util.List;

import model.Fruit;

public interface ItemDao {
	List<Fruit> findByName(String name);//이름으로 상품 검색
	List<Fruit> findAll();//모든 상품 검색
	Fruit findById(Integer id);//상품 번호로 검색
	void create(Fruit fruit);//상품 등록
	void update(Fruit fruit);//상품 변경
	void delete(Integer id);//상품 삭제
}









