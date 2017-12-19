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

//首页访问的Action
public class IndexAction extends ActionSupport {

	// 注入一级分类的service
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// 注入分类的service，话题要在主页显示
	private TopicService topicService;

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}

	// 注入贴吧信息的service，信息也有部分在首页显示
	private InformationsService informationsService;

	public void setInformationsService(InformationsService informationsService) {
		this.informationsService = informationsService;
	}

	// 执行访问首页的方法
	public String execute() {
		// 查询所有一级分类集合
		List<Category> cList = categoryService.findAll();
		// 将一级分类存到session范围（每个页面都要显示）
		ActionContext.getContext().getSession().put("cList", cList);
		// 将话题存到session范围（放在值栈中，我在提取过值栈中的内容后再跳回原页面值就没有了）
		List<Topic> tList = topicService.findAll();
		ActionContext.getContext().getSession().put("tList", tList);

		// 查询最新的贴吧信息
		List<Informations> nList = informationsService.findNew();
		// 保存到值栈中
		ActionContext.getContext().getValueStack().set("nList", nList);
		// 页面跳转
		return "index";
	}

}
