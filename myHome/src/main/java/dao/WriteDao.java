package dao;

import java.util.List;

import model.Bbs;
import model.ImageBBS;

public interface WriteDao {
	void updateOrdeNo(ImageBBS image);
	//게시글 등록에 관련된 메서드
	Integer getBBSCount();//전체글의갯수검색->페이지수를 구하기 위함
	Integer getMaxSeqno();//가장큰 글번호를 찾는 메서드
	void putBBS(Bbs bbs);// 게시글 등록
	List<Bbs> getBBS(Integer pageNo);//페이지에 해당하는 글검색
}
