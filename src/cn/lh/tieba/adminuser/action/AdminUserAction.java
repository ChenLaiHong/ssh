package cn.lh.tieba.adminuser.action;

import org.apache.struts2.ServletActionContext;

import cn.lh.tieba.adminuser.service.AdminUserService;
import cn.lh.tieba.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//后台用户管理的action
public class AdminUserAction extends ActionSupport implements
		ModelDriven<AdminUser> {
	// 模型驱动需要用的对象
	private AdminUser adminUser = new AdminUser();

	public AdminUser getModel() {
		return adminUser;
	}

	// 注入Service
	private AdminUserService adminUserService;

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	// 后台登录的方法
	public String login() {
		// 调用service完成登录
		// 在页面中的信息存到模型驱动里面了，把对象传到service里
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if (existAdminUser == null) {
			// 不存在该用户则登录失败
			this.addActionError("对不起，你的用户名或密码错误！");
			return "loginFail";
		} else {
			// 存在该用户，登录成功
			// 把用户信息存到session里面，在JSP页面中可以取出其用户名
			ServletActionContext.getRequest().getSession()
					.setAttribute("existAdminUser", existAdminUser);
		}
		return "loginSuccess";
	}

	// 用户退出
	public String quit() {
		// 销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quitSuccess";
	}
}
