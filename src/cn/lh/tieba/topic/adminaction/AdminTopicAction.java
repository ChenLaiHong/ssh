package cn.lh.tieba.topic.adminaction;

import java.util.List;

import cn.lh.tieba.topic.service.TopicService;
import cn.lh.tieba.topic.vo.Topic;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//��̨�Ի���Ĺ���
public class AdminTopicAction extends ActionSupport implements
		ModelDriven<Topic> {
	// ģ������ʹ�õ���
	private Topic topic = new Topic();

	public Topic getModel() {
		return topic;
	}

	private TopicService topicService;

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	// ��ִ̨�в�ѯ���л���ķ���
	public String findAll() {
		// ��ѯ���л���
		List<Topic> tList = topicService.findAll();
		// �����ϵ�������ʾ��ҳ��
		ActionContext.getContext().getValueStack().set("tList", tList);
		return "findAll";
	}

	// ��̨���滰��ķ���
	public String save() {
		// ����Service���б���
		topicService.save(topic);
		return "saveSuccess";
	}

	// ��̨ɾ������ķ���
	public String delete() {
		// ����ҳ�洫������tid����ģ������
		topic = topicService.findByTid(topic.getTid());
		// ɾ��
		topicService.delete(topic);
		// ҳ����ת
		return "deleteSuccess";
	}

	// ��̨�༭����ķ��������ǲ�ѯ
	public String edit() {
		// ���ݻ�������ѯ����
		topic = topicService.findByTid(topic.getTid());
		// ҳ����ת
		return "editSuccess";
	}

	// ��̨�޸Ļ���ķ���
	public String update() {
		topicService.update(topic);
		// ҳ����ת
		return "updateSuccess";
	}

}
