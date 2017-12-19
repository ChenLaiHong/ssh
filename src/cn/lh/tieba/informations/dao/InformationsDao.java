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

	// ͳ�Ƹ���
	public int findCount() {
		String hql = "select count(*) from Informations";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;

	}

	// ��ҳ�飬��ʱ�䵹���
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

	// Dao���ѯ������Ϣ��ʾ����ҳ
	public List<Informations> findNew() {
		// ʹ������������ѯ
		DetachedCriteria criteria = DetachedCriteria
				.forClass(Informations.class);
		// �����ڽ��е�������
		criteria.addOrder(Order.desc("idate"));
		// ִ�в�ѯ
		List<Informations> list = this.getHibernateTemplate().findByCriteria(
				criteria, 0, 10);
		return list;
	}

	// Dao����ҵ����ĸ���ͳ��
	public Integer findByCountUid(Integer uid) {// �����û���id��ѯ
		String hql = "select count(*) from Informations i where i.user.uid =?";
		// String hql = "SELECT count(*) FROM Informations i WHERE i.uid=?";
		List<Long> list = this.getHibernateTemplate().find(hql, uid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return null;
	}

	// Dao����ҵ����Ĳ�ѯ
	public List<Informations> findByPageUid(Integer uid, Integer begin,
			int limit) {
		String hql = "from Informations i where i.user.uid =? order by idate desc";// Informations�Ƕ�Ӧ��ʵ����
		List<Informations> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Informations>(hql,
						new Object[] { uid }, begin, limit));
		return list;
	}

	// ����ID����
	public Informations findByInid(Integer inid) {
		return this.getHibernateTemplate().get(Informations.class, inid);// ����ģ��
	}

	// ɾ��������Ϣ
	public void delete(Informations informations) {
		this.getHibernateTemplate().delete(informations);

	}

}
