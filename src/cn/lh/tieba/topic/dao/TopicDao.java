package cn.lh.tieba.topic.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lh.tieba.topic.vo.Topic;

//�̳�HibernateDaoSupport���������sessionFactory����
//��spring��DAO�����ļ���ע��sessionFactory

//һ������ĳ־ò����
public class TopicDao extends HibernateDaoSupport {
	// DAO���ѯ���л���ķ���
	public List<Topic> findAll() {
		String hql = "from Topic";
		List<Topic> list = this.getHibernateTemplate().find(hql);

		return list;
	}

	// Dao�㱣��һ������ķ���
	public void save(Topic topic) {
		this.getHibernateTemplate().save(topic);

	}

	// Dao�����tid��ѯ����
	public Topic findByTid(int tid) {
		return this.getHibernateTemplate().get(Topic.class, tid);
	}

	// Dao��ɾ������
	public void delete(Topic topic) {
		this.getHibernateTemplate().delete(topic);

	}

	// Dao���޸Ļ���ķ���
	public void update(Topic topic) {
		this.getHibernateTemplate().update(topic);

	}
}
