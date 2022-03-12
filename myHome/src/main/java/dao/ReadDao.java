package dao;

import model.Bbs;
import model.ImageBBS;

public interface ReadDao {
	Bbs getBBSDetail(Integer no);//글번호로 글정보 조회
	ImageBBS getImageDetail(Integer no);// 글번호로 이미지게시글 조회
	void deleteImage(Integer no);
	void updateImage(ImageBBS bbs);
}
