package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Condition;
import model.ImageBBS;

@Repository
public class UploadDaoImpl implements UploadDao {
	@Autowired
	private SqlSession session;
	
	public Integer getImageCount() {
		return session.selectOne("mapper.home.getImageCount");
	}

	public List<ImageBBS> getImageList(Condition c) {
		return session.selectList("mapper.home.getImages",c);
	}

	public Integer getMaxId() {
		return session.selectOne("mapper.home.maxId");
	}

	public void putImageBBS(ImageBBS bbs) {
		session.insert("mapper.home.putImageBBS",bbs);
	}

}
