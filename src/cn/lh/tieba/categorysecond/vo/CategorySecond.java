package cn.lh.tieba.categorysecond.vo;

import java.util.HashSet;
import java.util.Set;

import cn.lh.tieba.category.vo.Category;
import cn.lh.tieba.picture.vo.Picture;

public class CategorySecond {

	private Integer csid;
	private String csname;
	// 所属一级分类，存的是一级分类的对象
	private Category category;

	// 配置图片集合
	// pictures要与在CategorySecond的映射文件中set属性中的name相同
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
