package cn.lh.tieba.category.vo;

import java.util.HashSet;
import java.util.Set;

import cn.lh.tieba.categorysecond.vo.CategorySecond;

//һ�������ʵ�������
public class Category {

	private Integer cid;
	private String cname;

	// һ��������Ӧ�ô�Ŷ�������ļ���
	private Set<CategorySecond> categorySeconds = new HashSet<CategorySecond>();

	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}

	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}
