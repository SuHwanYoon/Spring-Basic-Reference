package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.ItemCatalog;
import model.Fruit;
import model.User;

@Controller//컨트롤러를 자동생성해줌
public class DetailController {
	@Autowired
	private ItemCatalog itemCatalog;
	@RequestMapping(value="detail/detail.html")//url을 지정해서 자동호출
	public ModelAndView detail(Integer itemId,HttpSession session) {
		Fruit item = itemCatalog.getItem(itemId);//detail.jsp에서 가져옴
		ModelAndView mav = new ModelAndView();
		User user = (User)session.getAttribute("USER_KEY");
		if(user != null) {
			mav.addObject("loginUser",user);
		}
		mav.addObject("item",item);//<!-- index.jsp var에서 가져옴 -->
		return mav;
	}
}
