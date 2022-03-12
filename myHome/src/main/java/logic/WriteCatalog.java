package logic;

import java.util.List;

import model.Bbs;
import model.Condition;
import model.ImageBBS;

public interface WriteCatalog {//  dao가 가지고 있는 메서드
	
	void updateOrderNo(ImageBBS image);
	
	Integer getImageCount();
	List<ImageBBS> getImages(Condition c);
	ImageBBS getImage(Integer no);
	
	void deleteImage(Integer no);
	void updateImage(ImageBBS bbs);
	
	Integer getMaxId();
	void putImage(ImageBBS bbs);
	
	Integer getBBSCnt();
	Integer getMaxSeqno();
	void putBBS(Bbs bbs);
	List<Bbs> getBBS(Integer page);
	Bbs getBBSDetail(Integer seqno);
}
