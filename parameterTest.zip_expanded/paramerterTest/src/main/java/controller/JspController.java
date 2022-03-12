package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JspController {
	
	@RequestMapping(value="/jsp/index.html")
	public ModelAndView jsp() {
		ModelAndView mav = new ModelAndView();//뷰리절버를 썼을때
		return mav;
	}
}
