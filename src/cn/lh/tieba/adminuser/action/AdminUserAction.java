package cn.lh.tieba.adminuser.action;

import org.apache.struts2.ServletActionContext;

import cn.lh.tieba.adminuser.service.AdminUserService;
import cn.lh.tieba.adminuser.vo.AdminUser;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//��̨�û������action
public class AdminUserAction extends ActionSupport implements
		ModelDriven<AdminUser> {
	// ģ��������Ҫ�õĶ���
	private AdminUser adminUser = new AdminUser();

	public AdminUser getModel() {
		return adminUser;
	}

	// ע��Service
	private AdminUserService adminUserService;

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	// ��̨��¼�ķ���
	public String login() {
		// ����service��ɵ�¼
		// ��ҳ���е���Ϣ�浽ģ�����������ˣ��Ѷ��󴫵�service��
		AdminUser existAdminUser = adminUserService.login(adminUser);
		if (existAdminUser == null) {
			// �����ڸ��û����¼ʧ��
			this.addActionError("�Բ�������û������������");
			return "loginFail";
		} else {
			// ���ڸ��û�����¼�ɹ�
			// ���û���Ϣ�浽session���棬��JSPҳ���п���ȡ�����û���
			ServletActionContext.getRequest().getSession()
					.setAttribute("existAdminUser", existAdminUser);
		}
		return "loginSuccess";
	}

	// �û��˳�
	public String quit() {
		// ����session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quitSuccess";
	}
}
