package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Fruit;

@Controller
public class ItemController {
	@Autowired
	private ItemDao itemDao;
	@RequestMapping(value="/item/index.html")
	public ModelAndView index() {
		List<Fruit> itemList = this.itemDao.findAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("itemList",itemList);
		return mav;
	}
}











