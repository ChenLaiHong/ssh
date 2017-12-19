package cn.lh.tieba.group.adminaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.lh.tieba.group.service.GroupService;
import cn.lh.tieba.group.vo.Group;
import cn.lh.tieba.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminGroupAction extends ActionSupport implements
		ModelDriven<Group> {
	private Group group = new Group();

	public Group getModel() {
		return group;
	}

	// ע��group��service
	private GroupService groupService;

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	// ����page����
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

	// ��̨��ѯ����Ⱥ��ķ���
	public String findAll() {
		// ����Service��ɲ�ѯ
		PageBean<Group> pageBean = groupService.findByPage(page);
		// �����ݴ���ҳ���ϣ�ʹ��ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// ҳ����ת
		return "findAll";
	}

	// ��ת�����ҳ��
	public String addPage() {

		// ҳ����ת
		return "addPageSuccess";
	}

	// ����Ⱥ��ķ���
	public String save() throws IOException {
		// ����service��ɱ������
		group.setGdate(new Date());
		if (upload != null) {
			// ����ļ��ϴ��Ĵ��̾���·��
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/pictures");// ͼƬ��ŵ�·��
			// ����һ���ļ�
			File diskFile = new File(realPath + "//" + uploadFileName);
			// �ļ��ϴ�
			FileUtils.copyFile(upload, diskFile);
			group.setImage("pictures/" + uploadFileName);// ���ݿ��е�ͼƬ��·��
		}
		// �����ݱ��浽���ݿ�
		groupService.save(group);
		// ҳ����ת
		return "saveSuccess";
	}

	// ģ�������Ѿ����յ�id��ͨ��id��ɾ����Ӧ��ͼƬ
	public String delete() {
		// �ȸ���id��ѯ��ɾ��
		group = groupService.findByGid(group.getGid());
		// ɾ���Ѿ��ϴ����ļ����е�ͼƬ������·����ɾ��
		String path = group.getImage();// ���ͼƬ�ϴ���·���������ݿ��б����·��
		if (path != null) {// ������ϴ�ͼƬ����Ϊ������û���ϴ�ͼƬ�������
			// ��ȡ���̾���·��
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/" + path);
			File file = new File(realPath);// �ļ�����
			file.delete();// ���ϴ�������ͼƬɾ��
		}

		// ɾ��ͼƬ
		groupService.delete(group);
		// ҳ����ת
		return "deleteSuccess";
	}

	// �༭ͼƬ�ķ���
	public String edit() {
		// ���ݴ�������id��ѯ
		group = groupService.findByGid(group.getGid());

		// ҳ����ת
		return "editSuccess";
	}

	// �޸ķ���
	public String update() throws IOException {// ���Ѿ�����������
		group.setGdate(new Date());
		// �ļ��ϴ�
		if (upload != null) {
			// ȡ��ԭ��ͼƬ�ϴ���·��
			String path = group.getImage();
			File file = new File(ServletActionContext.getServletContext()
					.getRealPath("/" + path));
			file.delete();// ��ԭ���ϴ���ͼƬɾ��
			// ����ļ��ϴ����̵ľ���·��
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/pictures");
			// �����������ϵ��ļ�
			File diskFile = new File(realPath + "//" + uploadFileName);
			// ʹ�ù�����
			FileUtils.copyFile(upload, diskFile);
			// ����ϴ�����Ҫ�ı�ԭ����ͼƬ·��������
			group.setImage("pictures/" + uploadFileName);
		}
		// �޸�ͼƬ�����ݵ����ݿ�
		groupService.update(group);
		// ҳ����ת
		return "updateSuccess";
	}

}
