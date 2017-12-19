package cn.lh.tieba.interceptor;

import org.apache.struts2.ServletActionContext;

import cn.lh.tieba.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

//��̨Ȩ�޼����������
//�Ժ�̨û�е�¼���û�û��Ȩ�޷���
public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	// ִ�����صķ���
	protected String doIntercept(ActionInvocation actionInvocation)
			throws Exception {
		// �ж�session���Ƿ񱣴��˺�̨�û���¼����Ϣ�����û�е�¼��session����û����Ϣ��
		AdminUser existAdminUser = (AdminUser) ServletActionContext
				.getRequest().getSession().getAttribute("existAdminUser");
		if (existAdminUser == null) {
			// ��û�е�¼
			ActionSupport actionSupport = (ActionSupport) actionInvocation
					.getAction();// getAction�ǻ�õ�����ִ�е�Action�����е�Action���̳���ActionSupport�����
			actionSupport.addActionError("����û�е�¼��û��Ȩ�޷��ʣ�");
			return "loginFail";
		} else {
			// �Ѿ���¼
			return actionInvocation.invoke();
		}

	}

}
