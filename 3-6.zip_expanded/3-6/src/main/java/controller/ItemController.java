package controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Fruit;

@Controller
public class ItemController {
	@Autowired
	private ItemDao itemDao;
	
	@RequestMapping(value="/item/search.html")
	public ModelAndView search(String itemName) {
		//입력된 상품명으로 상품검색
		if(itemName == null || itemName.equals("")) {
			return this.index();
		}//상품명이 없는경우는 다시 목록을 출력한다
		List<Fruit> itemList = this.itemDao.findByName(itemName);
		if(itemList == null || itemList.isEmpty()) {
			return this.index();
		}//검색된 상품이 없는 경우는 다시 목록을 출력한다
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("itemList",itemList);//검색된 상품의 목록
		return mav;//새로운 검색결과로 상품을 출력한다
	}
	
	@RequestMapping(value="/item/update.html")
	public ModelAndView update(@Valid Fruit fruit,
			BindingResult br,HttpServletRequest request) {
		if(br.hasErrors()) {
			System.out.println("폼에러");
			ModelAndView mav = new ModelAndView("update");
			mav.getModel().putAll(mav.getModel());
			return mav;
		}
		MultipartFile multiFile = fruit.getPicture();
		String fileName = null; String path = null;
		OutputStream out = null;
		if(multiFile !=  null) {
			fileName = multiFile.getOriginalFilename();
			ServletContext ctx = request.getSession().getServletContext();
			path = ctx.getRealPath("/upload/"+fileName);
			try {
				out = new FileOutputStream(path);
				BufferedInputStream bis = 
						new BufferedInputStream(multiFile.getInputStream());
				byte[] buffer = new byte[8106*2];//16바이트
				int read = 0;
				while((read = bis.read(buffer)) > 0 ) {
					out.write(buffer,0,read);
				}
				if(bis != null) bis.close();
				if(out != null) out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			fruit.setPicture_url(fileName);
		}
		this.itemDao.update(fruit);
		ModelAndView mav = new ModelAndView("redirect:/item/index.html");
		return mav;
	}
	
	@RequestMapping(value="/item/edit.html")
	public ModelAndView edit(Integer itemId) {
		ModelAndView mav = new ModelAndView("update");
		Fruit item = this.itemDao.findById(itemId);
		mav.addObject(item);
		return mav;
	}
	
	@RequestMapping(value="/item/delete.html")
	public ModelAndView delete(Integer item_id) {//delete.jsp에서 가져옴
		this.itemDao.delete(item_id);//상품정보 삭제
		return this.index();//다시 목록 화면을 출력
	}
	
	@RequestMapping(value="/item/confirm.html")
	public ModelAndView confirm(Integer itemId) {//index.jsp에서 가져옴
		ModelAndView mav = new ModelAndView("delete");
		Fruit item = this.itemDao.findById(itemId);
		mav.addObject(item);
		mav.addObject("imageName",item.getPicture_url());//delete에서 가져옴
		return mav;
	}
	
	@RequestMapping(value="/item/register.html")
	public ModelAndView register(@Valid Fruit fruit,//@Valid로 폼체크
			BindingResult br,HttpServletRequest request) {
		if(br.hasErrors()) {
			ModelAndView mav = new ModelAndView("add");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		MultipartFile multiFile = fruit.getPicture();//파일을 수신
		String fileName = null; String path = null;
		OutputStream out = null;//파일 입출력할때 사용하는 자바 객체
		if(multiFile != null) {//업로드 파일이 존재하는 경우
			fileName = multiFile.getOriginalFilename();//파일이름가져옴
			ServletContext ctx = request.getSession().getServletContext();//절대경로 찾기위한준비
			path = ctx.getRealPath("/upload/"+fileName);//절대경로
			System.out.println("업로드위치:"+path);
			try {
				out = new FileOutputStream(path);//파일을 뺄때 outputstream 다형성
				BufferedInputStream bis = //파일을 넣을때 쓰는 객체
						new BufferedInputStream(multiFile.getInputStream());
				byte[] buffer = new byte[8106];
				int read = 0;
				while((read = bis.read(buffer)) > 0 ) {
					out.write(buffer,0,read);//파일로 출력
				}
				if(out != null)out.close();
				if(bis != null)out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		fruit.setPicture_url(fileName);
		this.itemDao.create(fruit);//db에 삽입
		ModelAndView mav = new ModelAndView(
				"redirect:/item/index.html");
		return mav;
		//return this.index();//Forword로 페이지가 바껴서 새로고침하면 동일한 상품번호 삽입이 된다
				//->Redirect로 페이지를 바꿔야한다
	}
	
	@RequestMapping(value="/item/create.html")
	public ModelAndView create() {
		ModelAndView mav = new ModelAndView("add");
		mav.addObject(new Fruit());//jsp열때 객체직접주입?@ModelAttribute를 쓰지않는경우
		return mav;
	}
	
	@RequestMapping(value="/item/index.html")
	public ModelAndView index() {
		List<Fruit> itemList = this.itemDao.findAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("itemList",itemList);
		return mav;
	}
}











