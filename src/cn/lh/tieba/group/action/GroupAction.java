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

	// ģ������ʹ�õ��Ķ���
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
		// �����ݱ��浽ֵջ���ݵ�ҳ����
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// ҳ����ת
		return "findAll";
	}

}
