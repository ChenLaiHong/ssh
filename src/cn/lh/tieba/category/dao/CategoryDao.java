package cn.lh.tieba.category.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lh.tieba.category.vo.Category;

//一级分类的持久层对象
public class CategoryDao extends HibernateDaoSupport {
	// DAO层查询所有一级分类的方法
	public List<Category> findAll() {
		String hql = "from Category";
		List<Category> list = this.getHibernateTemplate().find(hql);

		return list;
	}

	// Dao保存一级分类的方法
	public void save(Category category) {
		// 把一级分类的对象往save方法里面存，进行保存
		this.getHibernateTemplate().save(category);

	}

	// Dao层根据cid查询一级分类的方法
	public Category findByCid(Integer cid) {
		return this.getHibernateTemplate().get(Category.class, cid);
	}

	// dao层删除一级分类
	public void delete(Category category) {
		this.getHibernateTemplate().delete(category);

	}

	// Dao层修改一级分类的方法
	public void update(Category category) {
		this.getHibernateTemplate().update(category);
	}

}
