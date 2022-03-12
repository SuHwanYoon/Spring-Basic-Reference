package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.UserCatalog;
import model.User;

@Controller
public class UserentryController {
	@Autowired
	private UserCatalog userCatalog;
	@RequestMapping(value="/userentry/entry.html")
	public ModelAndView entry(User user,HttpSession session) {
		this.userCatalog.putUser(user);//DB에 삽입
		session.setAttribute("LOGINUSER", user);//가입과 동시에 로그인
		//바뀌어야할 jsp는 로그인 성공메세지가 출력된는 jsp(loginResult.jsp)
		return new ModelAndView("redirect:/userentry/toHome.html");
		
	}
	
	@RequestMapping(value="/userentry/toHome.html")
	public ModelAndView toHome() {
		ModelAndView mav = new ModelAndView("home/home");
		mav.addObject("BODY","loginResult.jsp");
		return mav;
	}
	
	@RequestMapping(value="/userentry/idCheck.html")
	public ModelAndView idCheck(String USER_ID) {
		ModelAndView mav = new ModelAndView("home/idCheckResult");
		//db에서 중복검사를 한다
		Integer cnt = this.userCatalog.getIdCount(USER_ID);//DB에서 검색
		if(cnt == 0) mav.addObject("DUP","NO");//사용가능의미count이니깐 0과 비교
		else mav.addObject("DUP","YES");//계정중복을 의미
		mav.addObject("ID",USER_ID);//계정을 저장
		//결과를 mav에 저장한다
		return mav;
	}
	
	@RequestMapping(value="/userentry/userentry.html")
	public ModelAndView entry() {
		ModelAndView mav = new ModelAndView("home/home");
		mav.addObject(new User());
		mav.addObject("BODY","userEntry.jsp");
		return mav;
	}
}
