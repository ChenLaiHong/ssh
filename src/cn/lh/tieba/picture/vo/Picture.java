package cn.lh.tieba.picture.vo;

import java.util.Date;

import cn.lh.tieba.categorysecond.vo.CategorySecond;

//图片的实体类
public class Picture {

	private Integer pid;
	private String pname;
	private String image;
	private String pdesc;
	private Date pdate;

	// 二级分类外键

	private CategorySecond categorySecond;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public CategorySecond getCategorySecond() {
		return categorySecond;
	}

	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}

}
