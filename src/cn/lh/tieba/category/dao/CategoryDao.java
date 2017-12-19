package cn.lh.tieba.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lh.tieba.category.vo.Category;

//һ������ĳ־ò����
public class CategoryDao extends HibernateDaoSupport {
	// DAO���ѯ����һ������ķ���
	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);

		return list;
	}

	// Dao����һ������ķ���
	public void save(Category category) {
		// ��һ������Ķ�����save��������棬���б���
		this.getHibernateTemplate().save(category);

	}

	// Dao�����cid��ѯһ������ķ���
	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	// dao��ɾ��һ������
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);

	}

	// Dao���޸�һ������ķ���
	public void update(Category category) {
		this.getHibernateTemplate().update(category);
	}

}
