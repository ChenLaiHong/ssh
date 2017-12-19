package cn.lh.tieba.group.vo;

import java.util.Date;

public class Group {
	private Integer gid;
	private String gname;
	private String image;
	private String gdesc;
	private Integer gmember;
	private Date gdate;

	public Date getGdate() {
		return gdate;
	}

	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getGdesc() {
		return gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

	public Integer getGmember() {
		return gmember;
	}

	public void setGmember(Integer gmember) {
		this.gmember = gmember;
	}

}
