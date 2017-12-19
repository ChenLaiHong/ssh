package cn.lh.tieba.topic.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lh.tieba.topic.vo.Topic;

//继承HibernateDaoSupport里面就有了sessionFactory方法
//在spring的DAO配置文件中注入sessionFactory

//一级分类的持久层对象
public class TopicDao extends HibernateDaoSupport {
	// DAO层查询所有话题的方法
	public List<Topic> findAll() {
		String hql = "from Topic";
		List<Topic> list = this.getHibernateTemplate().find(hql);

		return list;
	}

	// Dao层保存一级分类的方法
	public void save(Topic topic) {
		this.getHibernateTemplate().save(topic);

	}

	// Dao层根据tid查询话题
	public Topic findByTid(int tid) {
		return this.getHibernateTemplate().get(Topic.class, tid);
	}

	// Dao层删除话题
	public void delete(Topic topic) {
		this.getHibernateTemplate().delete(topic);

	}

	// Dao层修改话题的方法
	public void update(Topic topic) {
		this.getHibernateTemplate().update(topic);

	}
}
