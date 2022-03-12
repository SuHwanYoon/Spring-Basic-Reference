package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Bbs;
import model.ImageBBS;

@Repository
public class WriteDaoImpl implements WriteDao {
	@Autowired
	private SqlSession session;
	
	public void updateOrdeNo(ImageBBS image) {
		session.update("mapper.home.updateOrderNo",image);
	}

	public Integer getBBSCount() {
		return session.selectOne("mapper.home.getBBSCount");
	}

	public List<Bbs> getBBS(Integer pageNo) {
		return session.selectList("mapper.home.getAllBBS",pageNo);
	}

	public Integer getMaxSeqno() {
		Integer max = session.selectOne("mapper.home.maxBBS");
		if(max == null) return 0;
		else return max;
	}

	public void putBBS(Bbs bbs) {
		session.insert("mapper.home.putBBS",bbs);
	}

}
