package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.CartEmptyException;
import exception.LoginRequiredException;
import model.Cart;
import model.Fruit;
import model.ItemSet;
import model.User;

@Controller
public class CheckoutController {
	@RequestMapping(value="/checkout/checkout.html")
	public ModelAndView checkout(HttpSession session) {
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser == null) {
			throw new LoginRequiredException("로그인 되어있지 않습니다");
		}
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null || cart.isEmpty()) {
			throw new CartEmptyException("카트가 비어있습니다");
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginUser",loginUser);
		List<ItemSet> itemList = cart.getItemList();//장바구니 안에있는 상품목록
		mav.addObject("itemList",itemList);
		//총액을 계산한다
		int total = 0;
		for(ItemSet is: itemList) {
			Fruit f = is.getItem();
			total = total + (f.getPrice()*is.getQuantity());
		}
		mav.addObject("totalAmount",total);
		return mav;
	}
}
