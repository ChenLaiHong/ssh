package cn.lh.tieba.topic.adminaction;

import java.util.List;

import cn.lh.tieba.topic.service.TopicService;
import cn.lh.tieba.topic.vo.Topic;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//后台对话题的管理
public class AdminTopicAction extends ActionSupport implements
		ModelDriven<Topic> {
	// 模型驱动使用的类
	private Topic topic = new Topic();

	public Topic getModel() {
		return topic;
	}

	private TopicService topicService;

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	// 后台执行查询所有话题的方法
	public String findAll() {
		// 查询所有话题
		List<Topic> tList = topicService.findAll();
		// 将集合的数据显示到页面
		ActionContext.getContext().getValueStack().set("tList", tList);
		return "findAll";
	}

	// 后台保存话题的方法
	public String save() {
		// 调用Service进行保存
		topicService.save(topic);
		return "saveSuccess";
	}

	// 后台删除话题的方法
	public String delete() {
		// 接收页面传过来的tid，用模型驱动
		topic = topicService.findByTid(topic.getTid());
		// 删除
		topicService.delete(topic);
		// 页面跳转
		return "deleteSuccess";
	}

	// 后台编辑话题的方法，仅是查询
	public String edit() {
		// 根据话题管理查询话题
		topic = topicService.findByTid(topic.getTid());
		// 页面跳转
		return "editSuccess";
	}

	// 后台修改话题的方法
	public String update() {
		topicService.update(topic);
		// 页面跳转
		return "updateSuccess";
	}

}
