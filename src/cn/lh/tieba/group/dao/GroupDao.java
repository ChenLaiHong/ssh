package cn.lh.tieba.group.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lh.tieba.group.vo.Group;
import cn.lh.tieba.utils.PageHibernateCallback;

public class GroupDao extends HibernateDaoSupport {

	// public List<Group> findAll() {
	// String hql = "from Group";
	// List<Group> list = this.getHibernateTemplate().find(hql);
	// return list;
	// }
	// ��ѯ����
	public int findCount() {
		String hql = "select count(*) from Group";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Group> findByPage(int begin, int limit) {
		String hql = "from Group order by gdate desc";// �����
		List<Group> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Group>(hql, null, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// Dao�㱣��Ⱥ��ķ���
	public void save(Group group) {
		this.getHibernateTemplate().save(group);

	}

	// Dao�����id��ѯȺ��
	public Group findByGid(Integer gid) {
		return this.getHibernateTemplate().get(Group.class, gid);
	}

	// Dao��ɾ��Ⱥ��
	public void delete(Group group) {
		this.getHibernateTemplate().delete(group);

	}

	// Dao���޸�Ⱥ��
	public void update(Group group) {
		this.getHibernateTemplate().update(group);

	}

}
