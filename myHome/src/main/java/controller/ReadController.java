package controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import logic.WriteCatalog;
import model.Bbs;
import model.ImageBBS;

@Controller
public class ReadController {
	@Autowired
	private WriteCatalog writeCatalog;
	
	@RequestMapping(value="/read/updateImageDo.html")
	public ModelAndView UpdateImageDo(ImageBBS imageBBS,
			HttpSession session,HttpServletRequest request) throws Exception {
		ServletContext ctx = session.getServletContext();
		//HttpSession session = request.getSession();
		//ServletContext ctx = session.getServletContext();
		//ServletContext는 절대경로(upload폴더)를 획득하기위해서 생성한다
		//ServletContext객체의 getRealPath라는 메서드를 호출해서 절대경로 획득
		String filePath = ctx.getRealPath("/upload");//upload폴더의 절대경로
		System.out.println("업로드 경로:"+filePath);
		String encType = "euc-kr";
		MultipartRequest multipart = new MultipartRequest(request,filePath,
				5*1024*1024,encType,new DefaultFileRenamePolicy());//cos라이브러리 업로드객체생성
		String fileName = multipart.getFilesystemName("IMAGENAME");//파일가지고있는 파라미터 업로드실행
		Integer seqno = Integer.parseInt(multipart.getParameter("writing_id"));
		ImageBBS origin = 
				this.writeCatalog.getImage(seqno);
		ModelAndView mav = new ModelAndView("home/home");
		if(origin.getPassword().equals(multipart.getParameter("password"))) {
			//등록된 암호와 입력한 암호가 일치하는 경우
	
			//파일업로드가 성공한 경우 fileName에 파일이름이 들어간다
			//fileName에 파일이름이 있으면 이미지 변경
			//fileName 에 파일이름이 없으면 이미지는 변경하지 않겠다는것
			if(fileName == null || fileName.equals("")) {//파일이름이 없는경우
				imageBBS.setImage_name(origin.getImage_name());//기존의 이름설정
			}else {//파일이름이 있는경우
				imageBBS.setImage_name(fileName);//새파일 이름 설정
			}
			imageBBS.setTitle(multipart.getParameter("title"));//새제목
			imageBBS.setEmail(multipart.getParameter("email"));//새 이메일
			imageBBS.setContent(multipart.getParameter("content"));//새내용
			imageBBS.setWriting_id(seqno);//글번호설정
			this.writeCatalog.updateImage(imageBBS);//db에서 update실행
			mav.addObject("BODY","imageUpdateResult.jsp?seqno="+seqno);
		}else {//암호가 일치하지 않는경우
			mav.addObject("BODY","imageUpdateResult.jsp?id="+seqno);
		}
		return mav;
	}
	
	@RequestMapping(value="/read/updateImage.html")
	public ModelAndView UpdateImage(Integer id) {
		ModelAndView mav = new ModelAndView("home/home");
		ImageBBS imageBBS = this.writeCatalog.getImage(id);
		mav.addObject(imageBBS);
		mav.addObject("BODY","updateForm.jsp");
		return mav;
	}
	
	@RequestMapping(value="/read/deleteImageDo.html",method=RequestMethod.POST)
	public ModelAndView deleteImageDo(ImageBBS imageBBS) {
		//글번호로 해당들의 암호를 찾는다.
		//탐색한 암호와 입력한 암호가 동일한 경우 삭제를 진행한다
		ModelAndView mav = new ModelAndView("home/home");
		ImageBBS origin = this.writeCatalog.getImage(imageBBS.getWriting_id());
		if(origin.getPassword().equals(imageBBS.getPassword())) {
			//등록된 암호와 입력된 암호가 동일한 경우
			this.writeCatalog.deleteImage(imageBBS.getWriting_id());//삭제
			mav.addObject("BODY","imageDeleteResult.jsp");//삭제결과  jsp로 전환
		}else {//등록된 암호와 입력된 암호가 일치하지 않는경우
			mav.addObject("BODY","imageDeleteResult.jsp?id="+imageBBS.getWriting_id());
		}
		return mav;
	}
	
	@RequestMapping(value="/read/deleteImage.html")
	public ModelAndView deleteImage(Integer id) {
		ModelAndView mav = new ModelAndView("home/home");
		ImageBBS imageBBS = this.writeCatalog.getImage(id);
		mav.addObject(imageBBS);
		mav.addObject("BODY","deleteForm.jsp");
		return mav;
	}
	
	
	@RequestMapping(value="/read/imageRead.html")
	public ModelAndView imageDetail(Integer pid) {
		ModelAndView mav = new ModelAndView("home/home");
		ImageBBS imageBBS = this.writeCatalog.getImage(pid);
		mav.addObject("IMG",imageBBS);
		mav.addObject("BODY","imageRead.jsp");
		return mav;
	}
	
	@RequestMapping(value="/read/readDetail.html")
	public ModelAndView bbsDetail(Integer SEQNO) {
		ModelAndView mav = new ModelAndView("home/home");
		Bbs bbs = this.writeCatalog.getBBSDetail(SEQNO);
		mav.addObject("BBS",bbs);//조회결과를 모델앤뷰에저장
		mav.addObject("BODY","bbsRead.jsp");
		return mav;
	}
}
