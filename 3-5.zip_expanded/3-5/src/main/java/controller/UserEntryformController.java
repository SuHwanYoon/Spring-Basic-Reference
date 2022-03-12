package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.UserCatalog;
import model.User;

@Controller
public class UserEntryformController {
	@Autowired
	private UserCatalog userCatalog;
	@Autowired
	private MessageSource messageSource;
	
	@ModelAttribute
	public User setUp() {
		User user = new User();
		MessageSourceAccessor msa = //프로퍼티즈 파일에 접근하는 객체,환경설정에 메세지소스가 필요
				new MessageSourceAccessor(messageSource);
		user.setId(msa.getMessage("user.id.default"));//기본메시지
		user.setName(msa.getMessage("user.name.default"));//기본메시지
		return user;
	}
	
	@RequestMapping(value="userentryform/userEntry.html",method=RequestMethod.GET)
	public String userentryForm() {
		return "userentryform/userEntry";
				
	}
	@RequestMapping(value="userentryform/userEntry.html",method=RequestMethod.POST)
	public ModelAndView userEntry(@Valid User user,
			BindingResult br, HttpSession session) {
		ModelAndView mav =  new ModelAndView();
		if(br.hasErrors()) {
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		try {
			this.userCatalog.putUser(user);//디비에 삽입
			session.setAttribute("USER_KEY", user);//세션에 저장
			mav.setViewName("userentryform/userEntrySuccess");
			return mav;
		} catch (DataIntegrityViolationException e) {//동일한 계정이미있는 경우
			br.reject("error.duplicate.user");//에러 메세지 출력
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		
	}
	
	
	
	
	
	
	
}
