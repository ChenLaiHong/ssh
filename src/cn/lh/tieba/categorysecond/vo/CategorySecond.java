package cn.lh.tieba.categorysecond.vo;

import java.util.HashSet;
import java.util.Set;

import cn.lh.tieba.category.vo.Category;
import cn.lh.tieba.picture.vo.Picture;

public class CategorySecond {

	private Integer csid;
	private String csname;
	// ����һ�����࣬�����һ������Ķ���
	private Category category;

	// ����ͼƬ����
	// picturesҪ����CategorySecond��ӳ���ļ���set�����е�name��ͬ
	private Set<Picture> pictures = new HashSet<Picture>();

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}

}
