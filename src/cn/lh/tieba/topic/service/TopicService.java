package cn.lh.tieba.topic.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.lh.tieba.topic.dao.TopicDao;
import cn.lh.tieba.topic.vo.Topic;

@Transactional
public class TopicService {
	// 注入TopicDao
	private TopicDao topicDao;

	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	// 业务层查询所有的方法
	public List<Topic> findAll() {

		return topicDao.findAll();
	}

	// 业务层保存话题的方法
	public void save(Topic topic) {
		topicDao.save(topic);

	}

	// 业务层根据tid查询话题
	public Topic findByTid(int tid) {
		return topicDao.findByTid(tid);
	}

	// 业务层删除话题
	public void delete(Topic topic) {
		topicDao.delete(topic);

	}

	// 业务层修改话题的方法
	public void update(Topic topic) {
		topicDao.update(topic);

	}

}
