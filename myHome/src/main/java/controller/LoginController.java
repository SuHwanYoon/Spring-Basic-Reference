package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.UserCatalog;
import model.Loginuser;
import model.User;

@Controller
public class LoginController {
	@Autowired
	private UserCatalog userCatalog;
	
	@RequestMapping(value="login/home.html",
			method=RequestMethod.POST)
	public ModelAndView doLogin(@Valid Loginuser loginuser,
			BindingResult br, HttpSession session) {
		ModelAndView mav = new ModelAndView("home/home");
			if(br.hasErrors()) {
				mav.getModel().putAll(br.getModel());
				mav.addObject("RELOGIN","login.jsp");
				return mav;
			}
			User user = this.userCatalog.getUser(loginuser);
			if(user == null) {//로그인 실패
				mav.addObject("NOLOGIN","YES");
			}else {//로그인 성공
				session.setAttribute("LOGINUSER", user);
				mav.addObject("LOGIN","YES");
			}
			mav.addObject("BODY","loginResult.jsp");
			return mav;//return null이면 안된다
	}
	
	@RequestMapping(value="login/login.html")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("home/login");
		mav.addObject(new Loginuser());//Loginuser객체를 주입
		return mav;
	}
}
