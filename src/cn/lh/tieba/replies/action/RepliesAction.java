package cn.lh.tieba.replies.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.lh.tieba.informations.service.InformationsService;
import cn.lh.tieba.informations.vo.Informations;
import cn.lh.tieba.replies.service.RepliesService;
import cn.lh.tieba.replies.vo.Replies;
import cn.lh.tieba.user.service.UserService;
import cn.lh.tieba.user.vo.User;
import cn.lh.tieba.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class RepliesAction extends ActionSupport implements
		ModelDriven<Replies> {

	private Replies replies = new Replies();

	public Replies getModel() {
		return replies;
	}

	private RepliesService repliesService;

	public void setRepliesService(RepliesService repliesService) {
		this.repliesService = repliesService;
	}

	private UserService userService;
	private InformationsService informationsService;
	private Informations informations;

	// public void setInformations(Informations informations) {
	// this.informations = informations;
	// }

	public void setInformationsService(InformationsService informationsService) {
		this.informationsService = informationsService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private Integer uid;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	// �������۵�id
	private Integer inid;

	public Integer getInid() {
		return inid;
	}

	public void setInid(Integer inid) {
		this.inid = inid;
	}

	// ���ܵ�ǰҳ��
	private int page;

	public void setPage(int page) {
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

	public String findByInid() {
		// �������۲�ѯ��Ӧ�Ļظ�
		PageBean<Replies> pageBean = repliesService.findByPageInid(inid, page);
		// ��PageBean����Ϣ�浽ֵջ�д���ҳ����
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// ҳ����ת
		return "findByInid";
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
			replies.setImage("pictures/" + uploadFileName);// ���ݿ��е�ͼƬ��·��
		}
		replies.setRdate(new Date());// ��ȡϵͳʱ��
		replies.setInformations(informations);
		repliesService.save(replies);// ����
		// ҳ����ת
		return "saveSuccess";
	}

}
