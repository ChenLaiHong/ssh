package cn.lh.tieba.group.action;

import cn.lh.tieba.group.service.GroupService;
import cn.lh.tieba.group.vo.Group;
import cn.lh.tieba.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class GroupAction extends ActionSupport implements ModelDriven<Group> {
	private GroupService groupService;
	private Group group = new Group();

	// 模型驱动使用到的对象
	public Group getModel() {
		return group;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	public String findAll() {
		PageBean<Group> pageBean = groupService.findByPage(page);
		// 将数据保存到值栈传递到页面上
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// 页面跳转
		return "findAll";
	}

}
