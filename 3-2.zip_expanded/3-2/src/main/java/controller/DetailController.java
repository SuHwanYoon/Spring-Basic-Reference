package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Fruit;

@Controller
public class DetailController {
	private ItemDao itemDao;

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	// 상속을 하지 않은 경우 개발자가 메서드를 만들고 이메서드를 콜백메서드로 선언한다
	@RequestMapping(value="detail.html")//콜백 메서드 선어해주는 어노테이션,detail.html만 받게끔 설정
	public ModelAndView detail(Integer itemId) {
		Fruit f = itemDao.findById(itemId);
		ModelAndView mav = new ModelAndView();
		Map<String,Object> map = 
				new HashMap<String,Object>();
		map.put("item", f);//맵에 조회결과저장 item jsp에서 가져옴
		mav.addAllObjects(map);//맵을 모델앤뷰에 저장
		mav.setViewName("detail");//뷰리절버를 사용해서 폴더이름과 확장자이름이 없다
		//모델앤뷰에 jsp이름 저장
		return mav;
	}
}
