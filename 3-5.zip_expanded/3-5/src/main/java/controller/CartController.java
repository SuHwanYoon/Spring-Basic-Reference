package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.ItemCatalog;
import model.Cart;
import model.Fruit;
import model.ItemSet;
import model.User;

@Controller
@Scope("session")
public class CartController {
	@Autowired
	private ItemCatalog itemCatalog;
	@Autowired
	private Cart cart;
	
	
	
	@RequestMapping(value="/cart/cartConfirm.html")
	public ModelAndView confirm(HttpSession session) {
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null) cart = this.cart;
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("cart",cart);
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser !=  null) mav.addObject("loginUser",loginUser);
		return mav;
	}
	@RequestMapping(value="/cart/cartClear.html")
	public ModelAndView clear(HttpSession session) {
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if( cart == null) cart = this.cart;
		cart.clearAll();
		session.setAttribute("CART_KEY", cart);
		ModelAndView mav = new ModelAndView("cart/cart");//페이지 전환
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null)mav.addObject("loginUser",loginUser);
		mav.addObject("message","카트를 비웠습니다");
		return mav;
	}
	@RequestMapping(value="cart/cartAdd.html")
	public ModelAndView add(Integer itemId,Integer quantity,
			HttpSession session) {//장바구니를 담기위한 세션객체
		Fruit item = this.itemCatalog.getItem(itemId);
		//장바구니를 세션에서 찾는다. 없으면 생성한다
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null)cart = this.cart;//카트가 없으면 생성
		cart.push(new ItemSet(item, quantity));//ItemSet의 메서드 push사용
		session.setAttribute("CART_KEY", cart);
		session.setAttribute("ITEM_KEY", item);
		session.setAttribute("number", quantity);
		ModelAndView mav = new ModelAndView("redirect:/cart/result.html");//콘트롤러로 메핑
		return mav;
	}
	@RequestMapping(value="/cart/result.html")
	public ModelAndView reload(HttpSession session) {
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		Fruit selectedItem = (Fruit)session.getAttribute("ITEM_KEY");
		Integer quantity = (Integer)session.getAttribute("number");
		User loginUser = (User)session.getAttribute("USER_KEY");
		ModelAndView mav = new ModelAndView("cart/cart"); //장바구니 결과가 출력되는jsp
		if(loginUser != null) mav.addObject("loginUser",loginUser);
		mav.addObject("message",selectedItem.getItem_name()+"을(를)"+
		quantity + "개 카트에 담았습니다.");
		mav.addObject("cart",cart);
		return mav;
	}
}
