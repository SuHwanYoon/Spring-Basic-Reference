package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs;
import model.ImageBBS;

@Repository//자동생성
public class ReadDaoImpl implements ReadDao {
	@Autowired//자동주입
	private SqlSession session;
	
	
	
	public void deleteImage(Integer no) {
		session.delete("mapper.home.deleteImage",no);
	}

	public void updateImage(ImageBBS bbs) {
		session.update("mapper.home.updateImage",bbs);
	}

	public ImageBBS getImageDetail(Integer no) {
		return session.selectOne("mapper.home.getImageById",no);
	}

	public Bbs getBBSDetail(Integer no) {
		return session.selectOne("mapper.home.getBBS",no);
	}

}
