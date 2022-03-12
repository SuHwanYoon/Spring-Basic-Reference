package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping(value="/index/index.html")
	public ModelAndView index() {
//		ModelAndView mav = new ModelAndView(
//				"/WEB-INF/index/index.jsp?ABC=100");
		ModelAndView mav = new ModelAndView(
				"redirect:/jsp/index.html?ABC=100");
		return mav;
	}
	
}
