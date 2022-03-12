package logic;

import java.util.List;

import model.Fruit;

public interface ItemCatalog {
	//과일 목록을 호출하는 메서드
	List<Fruit> getItemList();
	//과일 상세정보를 보여주는 메서드
	Fruit getItem(Integer id);
}
