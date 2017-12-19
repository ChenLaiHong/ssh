package cn.lh.tieba.interceptor;

import org.apache.struts2.ServletActionContext;

import cn.lh.tieba.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

//后台权限检验的拦截器
//对后台没有登录的用户没有权限访问
public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	// 执行拦截的方法
	protected String doIntercept(ActionInvocation actionInvocation)
			throws Exception {
		// 判断session中是否保存了后台用户登录的信息，如果没有登录则session中是没有信息的
		AdminUser existAdminUser = (AdminUser) ServletActionContext
				.getRequest().getSession().getAttribute("existAdminUser");
		if (existAdminUser == null) {
			// 还没有登录
			ActionSupport actionSupport = (ActionSupport) actionInvocation
					.getAction();// getAction是获得到正在执行的Action，所有的Action都继承了ActionSupport这个类
			actionSupport.addActionError("您还没有登录！没有权限访问！");
			return "loginFail";
		} else {
			// 已经登录
			return actionInvocation.invoke();
		}

	}

}
