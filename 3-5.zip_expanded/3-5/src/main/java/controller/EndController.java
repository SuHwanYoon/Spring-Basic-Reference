package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.CartEmptyException;
import exception.LoginRequiredException;
import model.Cart;
import model.User;

@Controller
public class EndController {
	
	@RequestMapping(value="/end/end.html")
	public ModelAndView end(HttpSession session) {
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser == null)//로그인을 하지 않은 경우
			throw new LoginRequiredException("로그인 되어있지 않습니다");
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart ==  null || cart.isEmpty())//장바구니 비어있는 경우
			throw new CartEmptyException("카트가 비어있습니다");
		//매출처리 수행
		cart.clearAll();//구매가 되었으므로 장바구니를 비운다
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginUser",loginUser);
		return mav;
	}
}
