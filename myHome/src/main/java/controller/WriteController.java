package controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import logic.WriteCatalog;
import model.Bbs;
import model.Condition;
import model.ImageBBS;
import model.Loginuser;
import model.User;

@Controller
public class WriteController {
	@Autowired
	private WriteCatalog writeCatalog;
	
	@RequestMapping(value="/write/replyForm.html")
	public ModelAndView replyForm(Integer id,Integer parentid,
			Integer groupid) {
		ModelAndView mav = new ModelAndView("home/home");
		ImageBBS imageBBS = this.writeCatalog.getImage(id);//글번호로 원글정보검색
		imageBBS.setContent(null);//답글 작성을 위해 내용을 지운다
		imageBBS.setWriter_name(null);//답글작성을 위해 작성자를 지운다
		imageBBS.setEmail(null);//답글 작성을 위해 이메일을 지운다
		imageBBS.setGroup_id(groupid);
		imageBBS.setParent_id(parentid);
		mav.addObject(imageBBS);
		mav.addObject("title","RE]"+imageBBS.getTitle());
		mav.addObject("BODY","imageWriteForm.jsp");
		return mav;
	}
	
	@RequestMapping(value="/write/upload.html",method=RequestMethod.POST)
	public ModelAndView upload(ImageBBS imageBBS,
			HttpServletRequest request,HttpSession session,
			Integer order_no,Integer group_id,Integer parent_id) throws Exception{//이미지 예외처리
		ServletContext ctx = request.getSession().getServletContext();
		//HttpSession session = request.getSession();
		//ServletContext ctx = session.getServletContext();
		//ServletContext는 절대경로(upload폴더)를 획득하기위해서 생성한다
		//ServletContext객체의 getRealPath라는 메서드를 호출해서 절대경로 획득
		String filePath = ctx.getRealPath("/upload");//upload폴더의 절대경로
		System.out.println("업로드 경로:"+filePath);
		String encType = "euc-kr";
		MultipartRequest multipart = new MultipartRequest(request,filePath,
				5*1024*1024,encType,new DefaultFileRenamePolicy());//업로드객체생성
		String fileName = multipart.getFilesystemName("IMAGENAME");//파일가지고있는 파라미터 업로드실행
		imageBBS.setImage_name(fileName);//파일이름설정
		Integer maxId = this.writeCatalog.getMaxId();//최대글번호검색
		int max_id = 0;
		if(maxId == null)max_id++;//기존의 글이 없는경우
		else max_id = maxId+1;//기존에 글이 있는 경우 (기본번호 +1)
		imageBBS.setWriting_id(max_id);//글번호설정
		//원글인지 답글인지를 찾는다
		if(Integer.parseInt(multipart.getParameter("parent_id")) == 0) {//원글인 경우
			imageBBS.setGroup_id(max_id);//그룹번호 설정
			imageBBS.setOrder_no(0);//원글인 경우 순서번호는 0
			imageBBS.setParent_id(0);//원글인 경우 부모글번호는 0
		}else {//답글인경우
			int groupId = Integer.parseInt(multipart.getParameter("group_id"));
			imageBBS.setGroup_id(groupId);//그룹번호 설정
			int orderNo = Integer.parseInt(multipart.getParameter("order_no"));
			imageBBS.setOrder_no(orderNo);;//
			int parentId = Integer.parseInt(multipart.getParameter("parent_id"));
			imageBBS.setParent_id(parentId);;//
			//순서번호를 update한다
			this.writeCatalog.updateOrderNo(imageBBS);
		}
		User user = (User)session.getAttribute("LOGINUSER");
		imageBBS.setWriter_name(user.getId());//작성자 계정설정
		imageBBS.setTitle(multipart.getParameter("title"));
		imageBBS.setEmail(multipart.getParameter("email"));
		imageBBS.setContent(multipart.getParameter("content"));
		imageBBS.setPassword(multipart.getParameter("password"));
		//작성일설정
		Calendar c = Calendar.getInstance();//달력객체 생성
		long times = c.getTimeInMillis();//오늘까지의 초를 획득
		Timestamp ts = new Timestamp(times);//초를 이용해서 객체생성
		String ymdhms = String.valueOf(ts);//위의 객체를 문자열로 전환
		imageBBS.setRegister_date(ymdhms);
		//작성일 설정끝
		this.writeCatalog.putImage(imageBBS);//디비에 삽입
		return new ModelAndView("redirect:/write/imageList.html");//이미지 게시판 출력 매핑
	}
	
	@RequestMapping(value="/write/imageList.html")
	public ModelAndView uploadList(Integer PAGE_NUM) {
		if(PAGE_NUM == null) PAGE_NUM = 1;
		//DB에서 이미지 게시글 검색(한페이지당 5개)
		int currentPage = PAGE_NUM;
		int totalPageCount = 0;
		int startRow = 0; int endRow = 0;
		int count = this.writeCatalog.getImageCount();//전체글 갯수검색
		if(count > 0) {
			totalPageCount = count/ 5;
			if(count % 5>0)totalPageCount++;
			startRow = (currentPage -1)*5+1;
			endRow = currentPage*5;
			if(endRow > count) endRow = count;
		}
		Condition c = new Condition();
		c.setStartRow(startRow);c.setEndRow(endRow);
		List<ImageBBS> imageList = this.writeCatalog.getImages(c);//게시글검색
		ModelAndView mav = new ModelAndView("home/home");
		mav.addObject("imageList",imageList);
		mav.addObject("count",count);
		mav.addObject("startRow",startRow);
		mav.addObject("endRow",endRow);
		mav.addObject("pageCount",totalPageCount);
		mav.addObject("BODY","imageList.jsp");
		mav.addObject("currentPage",currentPage);
		return mav;
	}
	
	@RequestMapping(value="/write/imageForm.html")
	public ModelAndView imageForm(HttpSession session) {
		ModelAndView mav= new ModelAndView("home/home");
		User user = (User)session.getAttribute("LOGINUSER");
		if(user == null) {//로그인을 안한경우
			mav.addObject("MSG","게시글을 올리려면 로그인을 해야합니다");//메세지 전달
			mav.addObject("BODY","login.jsp");
			mav.addObject(new Loginuser());
		}else {//로그인 한경우
			mav.addObject("BODY","imageWriteForm.jsp");
			mav.addObject(new ImageBBS());
		}
		return mav;
	}
	
	//에러메세지를 출력하는 컨트롤러
	@RequestMapping(value="/write/write.html",method=RequestMethod.POST)
	public ModelAndView write(@Valid Bbs bbs,BindingResult br,
			HttpSession session) {
		ModelAndView mav = new ModelAndView("home/home");
		if(br.hasErrors()) {
			mav.addObject("BODY","bbsInput.jsp");
			mav.getModel().putAll(br.getModel());
			return mav;
		}
		//글번호 ,제목,작성자,글내용,작성일
		Integer seqno = writeCatalog.getMaxSeqno() + 1;//글번호
		bbs.setSeqno(seqno);//글번호 설정
		User user = (User)session.getAttribute("LOGINUSER");
		bbs.setId(user.getId());// 작성자설정
		//작성일시작
		//달력객체 가 가지고 있는 메서드를 호출한다
		Calendar c = Calendar.getInstance();//달력객체 생성
		long times = c.getTimeInMillis();//오늘까지의 초를 획득
		Timestamp ts = new Timestamp(times);//초를 이용해서 객체생성
		String ymdhms = String.valueOf(ts);//위의 객체를 문자열로 전환
		bbs.setRegister_date(ymdhms);
		this.writeCatalog.putBBS(bbs);
		//작성일 종료
		return new ModelAndView("redirect:/write/read.html");//리다이렉트를 안해주면 포워드로 된다
	}
	@RequestMapping(value="/write/read.html")
	public ModelAndView read(Integer pageNo) {
		int currentPage = 0;
		if(pageNo == null) currentPage = 1;
		else currentPage = pageNo;
		List<Bbs> bbsList = this.writeCatalog.getBBS(currentPage);
		Integer totalCount = this.writeCatalog.getBBSCnt();
		int pageCount = totalCount / 5;
		if(totalCount%5>0) pageCount++;
		int startRow = (currentPage -1)*5 +1;//페이지별 게시물의 시작번호
		int endRow = currentPage*5;
		if(endRow > totalCount) endRow = totalCount;
		ModelAndView mav = new ModelAndView("home/home");
		mav.addObject("STARTROW",startRow);mav.addObject("ENDROW",endRow);
		mav.addObject("COUNT",totalCount);
		mav.addObject("BBSS",bbsList);
		mav.addObject("PAGES",pageCount);
		mav.addObject("BODY","bbsList.jsp");
		return mav;
	}
	
	@RequestMapping(value="/write/writeForm.html")
	public ModelAndView writeForm(HttpSession session) {// 로그인 검사위한 세션
		User user = (User)session.getAttribute("LOGINUSER");
		ModelAndView mav = new ModelAndView("home/home");
		if(user == null) {//로그인을 안한경우
			mav.addObject("MSG","게시글을 올리려면 로그인을 해야합니다");//메세지 전달
			mav.addObject("BODY","login.jsp");
			mav.addObject(new Loginuser());
		}else {//로그인을 한 경우
			mav.addObject("BODY","bbsInput.jsp");
			mav.addObject(new Bbs());
		}
		return mav;
	}
}
