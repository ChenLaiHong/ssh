package cn.lh.tieba.index.action;

import java.util.List;

import cn.lh.tieba.category.service.CategoryService;
import cn.lh.tieba.category.vo.Category;
import cn.lh.tieba.informations.service.InformationsService;
import cn.lh.tieba.informations.vo.Informations;
import cn.lh.tieba.topic.service.TopicService;
import cn.lh.tieba.topic.vo.Topic;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//��ҳ���ʵ�Action
public class IndexAction extends ActionSupport {

	// ע��һ�������service
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// ע������service������Ҫ����ҳ��ʾ
	private TopicService topicService;

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	// ע��������Ϣ��service����ϢҲ�в�������ҳ��ʾ
	private InformationsService informationsService;

	public void setInformationsService(InformationsService informationsService) {
		this.informationsService = informationsService;
	}

	// ִ�з�����ҳ�ķ���
	public String execute() {
		// ��ѯ����һ�����༯��
		List<Category> cList = categoryService.findAll();
		// ��һ������浽session��Χ��ÿ��ҳ�涼Ҫ��ʾ��
		ActionContext.getContext().getSession().put("cList", cList);
		// ������浽session��Χ������ֵջ�У�������ȡ��ֵջ�е����ݺ�������ԭҳ��ֵ��û���ˣ�
		List<Topic> tList = topicService.findAll();
		ActionContext.getContext().getSession().put("tList", tList);

		// ��ѯ���µ�������Ϣ
		List<Informations> nList = informationsService.findNew();
		// ���浽ֵջ��
		ActionContext.getContext().getValueStack().set("nList", nList);
		// ҳ����ת
		return "index";
	}

}
