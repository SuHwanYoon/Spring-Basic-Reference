package dao;

import java.util.List;

import model.Condition;
import model.ImageBBS;

public interface UploadDao {
	Integer getImageCount();
	List<ImageBBS> getImageList(Condition c);
	Integer getMaxId();
	void putImageBBS(ImageBBS bbs);//결과를 반환하지 않으니깐 보이드
}
