package cn.lh.tieba.categorysecond.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lh.tieba.categorysecond.vo.CategorySecond;
import cn.lh.tieba.utils.PageHibernateCallback;

//������������Dao��
public class CategorySecondDao extends HibernateDaoSupport {
	// Dao��ͳ�ƶ�������ĸ����ķ���
	public int findCount() {
		String hql = "select count(*) from CategorySecond";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// Dao���ҳ��ѯ��������ķ���
	public List<CategorySecond> findByPage(int begin, int limit) {
		String hql = "from CategorySecond order by csid desc";// ����csid�������
		List<CategorySecond> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<CategorySecond>(hql, null, begin,
						limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// Dao�㱣���������ķ���
	public void save(CategorySecond categorySecond) {
		this.getHibernateTemplate().save(categorySecond);

	}

	// Dao����ݶ��������ID��ѯ��������
	public CategorySecond findByCsid(Integer csid) {
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}

	// Dao��ɾ����������
	public void delete(CategorySecond categorySecond) {
		this.getHibernateTemplate().delete(categorySecond);

	}

	// Dao���޸Ķ�������ķ���
	public void update(CategorySecond categorySecond) {
		this.getHibernateTemplate().update(categorySecond);

	}

	// Dao���ѯ���ж�������ķ���
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond";
		return this.getHibernateTemplate().find(hql);
	}

}
