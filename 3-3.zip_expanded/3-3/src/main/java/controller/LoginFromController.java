package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;
import model.User;

@Controller
public class LoginFromController {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@ModelAttribute
	public User setup() {
		return new User();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm() {
		return "login";
				
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView toLogin() {
		return null;
	}//에러 체크
}
