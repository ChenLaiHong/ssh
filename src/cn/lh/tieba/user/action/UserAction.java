package cn.lh.tieba.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.lh.tieba.user.service.UserService;
import cn.lh.tieba.user.vo.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//�û�ģ��Action����
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();// ģ������ʹ�õĶ���

	public User getModel() {
		return user;
	}

	// ������֤��
	private String checkcode;

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	private UserService userService;// ע��UserService

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// ��ת��ע��ҳ���ִ�з���
	public String registPage() {

		return "registPage";
	}

	// AJAX�����첽У���û�����ִ�з���
	public String findByName() throws IOException {
		// ����Service���в�ѯ
		User existUser = userService.fingByUsername(user.getUsername());

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// �ж�
		if (existUser != null) {
			// ��ѯ���û����û����Ѿ�����
			response.getWriter().println("<font color='red'>�û����Ѿ�����</font>");
		} else {
			// û�в�ѯ�����û����û�������ʹ��
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
		}
		return NONE;
	}

	// �û�ע��ķ���
	public String regist() {
		// �ж���֤��
		// ��session�л����֤������ֵ
		String checkcode1 = (String) ServletActionContext.getRequest()
				.getSession().getAttribute("checkcode");
		if (!checkcode.equalsIgnoreCase(checkcode1)) {
			this.addActionError("��֤���������");
			return "checkcodeFail";
		}
		userService.save(user);
		this.addActionMessage("ע��ɹ�����ȥ��¼��");
		return "msg";
	}

	// ��ת����¼ҳ��
	public String loginPage() {

		return "loginPage";
	}

	// ��¼�ķ���
	public String login() {
		User existUser = userService.login(user);
		// �ж�
		if (existUser == null) {
			// ��½ʧ��
			this.addActionError("��½ʧ�ܣ��û������������");
			return LOGIN;
		} else {
			// ��¼�ɹ�
			// ���û���Ϣ�浽session��
			ServletActionContext.getRequest().getSession()
					.setAttribute("existUser", existUser);
			// ҳ����ת
			return "loginSuccess";
		}

	}

	// �û��˳�
	public String quit() {
		// ����session
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
}
