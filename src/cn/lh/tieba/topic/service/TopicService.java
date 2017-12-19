package cn.lh.tieba.topic.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.lh.tieba.topic.dao.TopicDao;
import cn.lh.tieba.topic.vo.Topic;

@Transactional
public class TopicService {
	// ע��TopicDao
	private TopicDao topicDao;

	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

	// ҵ����ѯ���еķ���
	public List<Topic> findAll() {

		return topicDao.findAll();
	}

	// ҵ��㱣�滰��ķ���
	public void save(Topic topic) {
		topicDao.save(topic);

	}

	// ҵ������tid��ѯ����
	public Topic findByTid(int tid) {
		return topicDao.findByTid(tid);
	}

	// ҵ���ɾ������
	public void delete(Topic topic) {
		topicDao.delete(topic);

	}

	// ҵ����޸Ļ���ķ���
	public void update(Topic topic) {
		topicDao.update(topic);

	}

}
