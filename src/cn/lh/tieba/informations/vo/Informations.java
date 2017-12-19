package cn.lh.tieba.informations.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import cn.lh.tieba.replies.vo.Replies;
import cn.lh.tieba.user.vo.User;

//贴吧评论的实体类
public class Informations {

	private Integer inid;
	private String contents;
	private String topic;
	private String author;
	private String image;
	private Date idate;
	// 评论的外键
	private User user;

	// 配置回复集合
	private Set<Replies> replie = new HashSet<Replies>();

	public Set<Replies> getReplie() {
		return replie;
	}

	public void setReplie(Set<Replies> replie) {
		this.replie = replie;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getInid() {
		return inid;
	}

	public void setInid(Integer inid) {
		this.inid = inid;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getIdate() {
		return idate;
	}

	public void setIdate(Date idate) {
		this.idate = idate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
