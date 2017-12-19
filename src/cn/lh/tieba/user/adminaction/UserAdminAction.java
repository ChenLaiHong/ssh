package cn.lh.tieba.user.adminaction;

import cn.lh.tieba.user.service.UserService;
import cn.lh.tieba.user.vo.User;
import cn.lh.tieba.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAdminAction extends ActionSupport implements ModelDriven<User> {
	// 模型驱动使用的对象
	private User user = new User();

	public User getModel() {
		return user;
	}

	// 注入用户的Service
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 接收page参数
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// 带分页查询用户的方法
	public String findAll() {
		// 调用Service完成查询
		PageBean<User> pageBean = userService.findByPage(page);
		// 将数据传到页面上（使用值栈）
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// 页面跳转
		return "findAll";
	}

}
