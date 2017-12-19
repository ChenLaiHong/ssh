package cn.lh.tieba.informations.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lh.tieba.informations.vo.Informations;
import cn.lh.tieba.utils.PageHibernateCallback;

public class InformationsDao extends HibernateDaoSupport {

	public void save(Informations informations) {
		this.getHibernateTemplate().save(informations);

	}

	// 统计个数
	public int findCount() {
		String hql = "select count(*) from Informations";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;

	}

	// 分页查，按时间倒序查
	public List<Informations> findByPage(int begin, int limit) {
		String hql = "from Informations order by idate desc";
		List<Informations> list = this.getHibernateTemplate()
				.execute(
						new PageHibernateCallback<Informations>(hql, null,
								begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// Dao层查询最新信息显示到首页
	public List<Informations> findNew() {
		// 使用离线条件查询
		DetachedCriteria criteria = DetachedCriteria
				.forClass(Informations.class);
		// 按日期进行倒序排序
		criteria.addOrder(Order.desc("idate"));
		// 执行查询
		List<Informations> list = this.getHibernateTemplate().findByCriteria(
				criteria, 0, 10);
		return list;
	}

	// Dao层的我的贴的个数统计
	public Integer findByCountUid(Integer uid) {// 根据用户的id查询
		String hql = "select count(*) from Informations i where i.user.uid =?";
		// String hql = "SELECT count(*) FROM Informations i WHERE i.uid=?";
		List<Long> list = this.getHibernateTemplate().find(hql, uid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return null;
	}

	// Dao层的我的贴的查询
	public List<Informations> findByPageUid(Integer uid, Integer begin,
			int limit) {
		String hql = "from Informations i where i.user.uid =? order by idate desc";// Informations是对应的实体类
		List<Informations> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Informations>(hql,
						new Object[] { uid }, begin, limit));
		return list;
	}

	// 根据ID查找
	public Informations findByInid(Integer inid) {
		return this.getHibernateTemplate().get(Informations.class, inid);// 调用模板
	}

	// 删除贴吧信息
	public void delete(Informations informations) {
		this.getHibernateTemplate().delete(informations);

	}

}
