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
	// 查询个数
	public int findCount() {
		String hql = "select count(*) from Group";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Group> findByPage(int begin, int limit) {
		String hql = "from Group order by gdate desc";// 倒序查
		List<Group> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Group>(hql, null, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// Dao层保存群组的方法
	public void save(Group group) {
		this.getHibernateTemplate().save(group);

	}

	// Dao层根据id查询群组
	public Group findByGid(Integer gid) {
		return this.getHibernateTemplate().get(Group.class, gid);
	}

	// Dao层删除群组
	public void delete(Group group) {
		this.getHibernateTemplate().delete(group);

	}

	// Dao层修改群组
	public void update(Group group) {
		this.getHibernateTemplate().update(group);

	}

}
