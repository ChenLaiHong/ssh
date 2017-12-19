package cn.lh.tieba.user.adminaction;

import cn.lh.tieba.user.service.UserService;
import cn.lh.tieba.user.vo.User;
import cn.lh.tieba.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAdminAction extends ActionSupport implements ModelDriven<User> {
	// ģ������ʹ�õĶ���
	private User user = new User();

	public User getModel() {
		return user;
	}

	// ע���û���Service
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// ����page����
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// ����ҳ��ѯ�û��ķ���
	public String findAll() {
		// ����Service��ɲ�ѯ
		PageBean<User> pageBean = userService.findByPage(page);
		// �����ݴ���ҳ���ϣ�ʹ��ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// ҳ����ת
		return "findAll";
	}

}
