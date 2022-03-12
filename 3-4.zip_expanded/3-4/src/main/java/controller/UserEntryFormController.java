package controller;

import javax.validation.Valid;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.UserDao;
import model.User;

@Controller//구현한 클래스를 자동으로 상속하게 해줌
public class UserEntryFormController {
	private UserDao userDao;
	private MessageSource messageSource;// 프로퍼티즈 파일에 대한 종속객체
	
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@ModelAttribute
	public User setup() {
		User user = new User();
		MessageSourceAccessor msa = //프로퍼티즈 키를 불러오는 객체
				new MessageSourceAccessor(this.messageSource);
		user.setId(msa.getMessage("user.id.default"));
		user.setName(msa.getMessage("user.name.default"));
		return user;
	}
	@RequestMapping(method=RequestMethod.GET)
	public String userEntryForm() {
		return "userEntry";
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView toEntry(@Valid User user,
			BindingResult br) {
		if(br.hasErrors()) {
			ModelAndView mav = new ModelAndView("userEntry");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		ModelAndView mav = new ModelAndView();
		try {
			this.userDao.create(user);//디비에 가입자 삽입
			mav.setViewName("userEntrySuccess");//jsp이름 설정
			mav.addObject("user",user);//"user"userEntrySuccess에서 가져옴
			return mav;
		} catch (DataIntegrityViolationException e) {//기본키 중복오류를 처리하는객체
			br.reject("error.duplicate.user");//가입자 중복 에러 메세지 처리
			mav.getModel().putAll(br.getModel());
			return mav;
			// TODO: handle exception
		}
	}
}
