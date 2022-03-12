package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.UserCatalog;
import model.Loginuser;
import model.User;

@Controller
@Scope("session")
public class LoginformController {
	@Autowired
	private UserCatalog userCatalog;
	
	@ModelAttribute//login.jsp modelattribute에 객체주입
	public Loginuser setup() {
		return new Loginuser();
	}
	
	@RequestMapping(value="loginform/login.html", method=RequestMethod.GET)
	public String loginForm() {
		return "loginform/login";
	}
	@RequestMapping(value="loginform/login.html",method=RequestMethod.POST)
	public ModelAndView toLogin(@Valid Loginuser loginuser,//User객체의 어노테이션을 동작시킴
			BindingResult br,HttpSession session) {//BindingResult에러메세지 처리해서 jsp로 보냄,HttpSession로그인 성공했을때 쓸것
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		User loginUser = this.userCatalog.getUser(loginuser);
		if(loginUser != null) {//로그인 성공
			mav.setViewName("loginform/loginSuccess");
			mav.addObject("loginUser",loginUser);//loginSuccess로 넘겨줌
			session.setAttribute("USER_KEY", loginUser);//indexController로 전해줌
			return mav;
		}else {//로그인실패
			br.reject("error.input.user");//에러 메세지 프로퍼티즈 파일에서 가져와서 출력
			mav.getModel().putAll(br.getModel());
			return mav;
		}
	}
}
