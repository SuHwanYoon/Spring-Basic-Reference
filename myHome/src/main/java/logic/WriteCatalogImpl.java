package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReadDao;
import dao.UploadDao;
import dao.WriteDao;
import model.Bbs;
import model.Condition;
import model.ImageBBS;

@Service
public class WriteCatalogImpl implements WriteCatalog {
	@Autowired
	private WriteDao writeDao;//dao 를 쓰기 위해 선언해준다
	@Autowired
	private ReadDao readDao;
	@Autowired
	private UploadDao uploadDao;
	
	
	
	public void updateOrderNo(ImageBBS image) {
		this.writeDao.updateOrdeNo(image);
	}

	public void deleteImage(Integer no) {
		this.readDao.deleteImage(no);
	}

	public void updateImage(ImageBBS bbs) {
		this.readDao.updateImage(bbs);
	}

	public ImageBBS getImage(Integer no) {
		return this.readDao.getImageDetail(no);
	}

	public Integer getImageCount() {
		return uploadDao.getImageCount();
	}

	public List<ImageBBS> getImages(Condition c) {
		return uploadDao.getImageList(c);
	}

	public Integer getMaxId() {
		return this.uploadDao.getMaxId();
	}

	public void putImage(ImageBBS bbs) {
		this.uploadDao.putImageBBS(bbs);
	}

	public Bbs getBBSDetail(Integer seqno) {
		return this.readDao.getBBSDetail(seqno);
	}

	public Integer getBBSCnt() {
		return this.writeDao.getBBSCount();
	}

	public List<Bbs> getBBS(Integer page) {
		return this.writeDao.getBBS(page);
	}

	public Integer getMaxSeqno() {
		return this.writeDao.getMaxSeqno();
	}

	public void putBBS(Bbs bbs) {
		this.writeDao.putBBS(bbs);
	}

}
