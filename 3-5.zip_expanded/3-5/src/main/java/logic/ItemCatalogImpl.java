package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import model.Fruit;
@Service//dao객체를 제외한 객체들을 자동생성
public class ItemCatalogImpl implements ItemCatalog {
	@Autowired
	private ItemDao itemDao;
	public List<Fruit> getItemList() {
		return itemDao.findAll();
	}

	public Fruit getItem(Integer id) {
		return itemDao.findById(id);
	}

}
