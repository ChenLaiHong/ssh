package cn.lh.tieba.categorysecond.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lh.tieba.categorysecond.vo.CategorySecond;
import cn.lh.tieba.utils.PageHibernateCallback;

//二级分类管理的Dao层
public class CategorySecondDao extends HibernateDaoSupport {
	// Dao层统计二级分类的个数的方法
	public int findCount() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// Dao层分页查询二级分类的方法
	public List<CategorySecond> findByPage(int begin, int limit) {
		String hql = "from CategorySecond order by csid desc";// 根据csid倒序查找
		List<CategorySecond> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<CategorySecond>(hql, null, begin,
						limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// Dao层保存二级分类的方法
	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);

	}

	// Dao层根据二级分类的ID查询二级分类
	public CategorySecond findByCsid(Integer csid) {
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}

	// Dao层删除二级分类
	public void delete(CategorySecond categorySecond) {
		this.getHibernateTemplate().delete(categorySecond);

	}

	// Dao层修改二级分类的方法
	public void update(CategorySecond categorySecond) {
		this.getHibernateTemplate().update(categorySecond);

	}

	// Dao层查询所有二级分类的方法
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond";
		return this.getHibernateTemplate().find(hql);
	}

}
