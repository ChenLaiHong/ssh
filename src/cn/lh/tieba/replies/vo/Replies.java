package cn.lh.tieba.replies.vo;

import java.util.Date;

import cn.lh.tieba.informations.vo.Informations;

public class Replies {

	private Integer rid;
	private String rcontents;
	private String authors;
	private String image;
	private Date rdate;
	// 回帖的外键是某一个评论
	private Informations informations;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRcontents() {
		return rcontents;
	}

	public void setRcontents(String rcontents) {
		this.rcontents = rcontents;
	}

	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public Informations getInformations() {
		return informations;
	}

	public void setInformations(Informations informations) {
		this.informations = informations;
	}

}
