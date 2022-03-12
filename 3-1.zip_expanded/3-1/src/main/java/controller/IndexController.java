package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import dao.ItemDao;
import model.Fruit;

public class IndexController implements Controller {
	private ItemDao itemDao;
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<Fruit> list = itemDao.findAll();//db에서 검색
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("itemList", list);//조회결과를 맵에 저장
		mav.addAllObjects(model);//맵을 ModelAndView에 저장 
		mav.setViewName("/WEB-INF/jsp/index.jsp");//jsp이름을 모델엔 뷰에 저장
		return mav;
	}

}
