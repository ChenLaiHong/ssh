package cn.lh.tieba.informations.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.lh.tieba.informations.service.InformationsService;
import cn.lh.tieba.informations.vo.Informations;
import cn.lh.tieba.user.service.UserService;
import cn.lh.tieba.user.vo.User;
import cn.lh.tieba.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class InformationsAction extends ActionSupport implements
		ModelDriven<Informations> {

	private Informations informations = new Informations();

	public Informations getModel() {
		return informations;
	}

	private UserService userService;
	private InformationsService informationsService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setInformationsService(InformationsService informationsService) {
		this.informationsService = informationsService;
	}

	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// �ļ��ϴ���Ҫ�Ĳ���
	private File upload;// �ϴ����ļ����ļ���Ҫ����е�����һ�£�
	private String uploadFileName;// �����ļ��ϴ����ļ���
	private String uploadContextType;// �����ļ����ļ�������

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}

	// ������Ϣ�����ݿ�
	public String save() throws IOException {
		// ��ȡ���Ѿ���¼���û�
		User existUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		if (existUser == null) {// �����û�е�¼
			this.addActionError("����û�е�¼�����ȵ�¼��");
			// ��û��¼������ת����¼ҳ��
			return "login";
		}
		if (upload != null) {
			// ����ļ��ϴ��Ĵ��̾���·��
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/pictures");// ͼƬ��ŵ�·��
			// ����һ���ļ�
			File diskFile = new File(realPath + "//" + uploadFileName);
			// �ļ��ϴ�
			FileUtils.copyFile(upload, diskFile);
			informations.setImage("pictures/" + uploadFileName);// ���ݿ��е�ͼƬ��·��
		}
		informations.setIdate(new Date());// ��ȡϵͳʱ��
		informations.setUser(existUser);// ���������û����ȥ
		informationsService.save(informations);// ����
		// ҳ����ת
		return "saveSuccess";
	}

	public String findAll() {
		// ��ѯ���ݿ�����������
		PageBean<Informations> pageBean = informationsService.findByPage(page);
		// �����ݴ��ݵ�ҳ����
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}

	// �ҵ����Ĳ�ѯ
	public String findByUid() {
		// ��õ�ǰ�û���id��ѯ(�û���¼��ʱ��ʹ浽session�У�
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		// ����service
		PageBean<Informations> pageBean = informationsService.findByPageUid(
				user.getUid(), page);// ͨ���û���ö�Ӧ��id
		// ����ҳ���ݷŵ�ֵջ��ʾ��ҳ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// ҳ����ת
		return "findByUidSuccess";
	}

	public String delete() {
		// �ȸ���id��ѯ��ɾ��
		informations = informationsService.findByInid(informations.getInid());
		// ɾ���Ѿ��ϴ����ļ����е�ͼƬ������·����ɾ��
		String path = informations.getImage();// ���ͼƬ�ϴ���·���������ݿ��б����·��
		if (path != null) {// ������ϴ�ͼƬ����Ϊ������û���ϴ�ͼƬ�������
			// ��ȡ���̾���·��
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/" + path);
			File file = new File(realPath);// �ļ�����
			file.delete();// ���ϴ�������ͼƬɾ��
		}

		// ɾ��ͼƬ
		informationsService.delete(informations);
		// ҳ����ת
		return "deleteSuccess";
	}
}
