package cn.lh.tieba.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.lh.tieba.user.service.UserService;
import cn.lh.tieba.user.vo.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//用户模块Action的类
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();// 模型驱动使用的对象

	public User getModel() {
		return user;
	}

	// 接收验证码
	private String checkcode;

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	private UserService userService;// 注入UserService

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 跳转到注册页面的执行方法
	public String registPage() {

		return "registPage";
	}

	// AJAX进行异步校验用户名的执行方法
	public String findByName() throws IOException {
		// 调用Service进行查询
		User existUser = userService.fingByUsername(user.getUsername());

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// 判断
		if (existUser != null) {
			// 查询该用户：用户名已经存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		} else {
			// 没有查询到该用户：用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}

	// 用户注册的方法
	public String regist() {
		// 判断验证码
		// 从session中获得验证码的随机值
		String checkcode1 = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("checkcode");
		if (!checkcode.equalsIgnoreCase(checkcode1)) {
			this.addActionError("验证码输入错误！");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("注册成功，请去登录！");
		return "msg";
	}

	// 跳转到登录页面
	public String loginPage() {

		return "loginPage";
	}

	// 登录的方法
	public String login() {
		User existUser = userService.login(user);
		// 判断
		if (existUser == null) {
			// 登陆失败
			this.addActionError("登陆失败：用户名或密码错误！");
			return LOGIN;
		} else {
			// 登录成功
			// 将用户信息存到session中
			ServletActionContext.getRequest().getSession()
					.setAttribute("existUser", existUser);
			// 页面跳转
			return "loginSuccess";
		}

	}

	// 用户退出
	public String quit() {
		// 销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
