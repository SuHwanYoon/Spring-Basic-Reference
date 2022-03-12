package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.ItemCatalog;
import model.Fruit;
import model.User;

@Controller//구현 클래스를 자동 탐지할 수 있도록,자동생성도 됨
public class IndexController {
	@Autowired
	private ItemCatalog itemCatalog;
	@RequestMapping(value="index/index.html")//url을 지정해서 자동호출
	public ModelAndView index(HttpSession session) {//로그인여부 판단
		List<Fruit> fruitList = itemCatalog.getItemList();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("itemList", fruitList);
		ModelAndView mav = new ModelAndView();
		User loginUser = (User)session.getAttribute("USER_KEY");//loginformController에서 가져옴
		if(loginUser != null) {//로그인이 된경우
			mav.addObject("loginUser",loginUser);//객체를 모델앤뷰에 직접저장
		}
		mav.addAllObjects(map);//모델앤뷰에 맵을 저장
		return mav;
	}
}
