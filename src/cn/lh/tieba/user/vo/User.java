package cn.lh.tieba.user.vo;

import java.util.HashSet;
import java.util.Set;

import cn.lh.tieba.informations.vo.Informations;

public class User {

	private Integer uid;
	private String username;
	private String password;
	private String name;
	private String email;
	private String sex;
	private String phone;
	private String addr;
	// 配置评论的集合
	private Set<Informations> information = new HashSet<Informations>();

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Set<Informations> getInformation() {
		return information;
	}

	public void setInformation(Set<Informations> information) {
		this.information = information;
	}

}
