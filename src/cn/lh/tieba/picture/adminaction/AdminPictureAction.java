package cn.lh.tieba.picture.adminaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.lh.tieba.categorysecond.service.CategorySecondService;
import cn.lh.tieba.categorysecond.vo.CategorySecond;
import cn.lh.tieba.picture.service.PictureService;
import cn.lh.tieba.picture.vo.Picture;
import cn.lh.tieba.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminPictureAction extends ActionSupport implements
		ModelDriven<Picture> {

	// ģ������ʹ�õĶ���
	private Picture picture = new Picture();

	public Picture getModel() {
		return picture;
	}

	// ע����������Service
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	// ע��ͼƬ��service
	private PictureService pictureService;

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
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

	// ����ҳ�Ĳ�ѯͼƬ��ִ�еķ���
	public String findAll() {
		// ����service��ɲ�ѯ����
		PageBean<Picture> pageBean = pictureService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// ҳ�����ת
		return "findAll";
	}

	// ��ת�����ҳ��
	public String addPage() {
		// ��ѯ��������ļ���
		List<CategorySecond> csList = categorySecondService.findAll();
		// ͨ��ֵջ����������������
		ActionContext.getContext().getValueStack().set("csList", csList);
		// ҳ����ת
		return "addPageSuccess";
	}

	// ����ͼƬ�ķ���
	public String save() throws IOException {
		// ����service��ɱ������
		picture.setPdate(new Date());
		if (upload != null) {
			// ����ļ��ϴ��Ĵ��̾���·��
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/pictures");// ͼƬ��ŵ�·��
			// ����һ���ļ�
			File diskFile = new File(realPath + "//" + uploadFileName);
			// �ļ��ϴ�
			FileUtils.copyFile(upload, diskFile);
			picture.setImage("pictures/" + uploadFileName);// ���ݿ��е�ͼƬ��·��
		}
		// �����ݱ��浽���ݿ�
		pictureService.save(picture);
		// ҳ����ת
		return "saveSuccess";
	}

	// ģ�������Ѿ����յ�id��ͨ��id��ɾ����Ӧ��ͼƬ
	public String delete() {
		// �ȸ���id��ѯ��ɾ��
		picture = pictureService.findByPid(picture.getPid());
		// ɾ���Ѿ��ϴ����ļ����е�ͼƬ������·����ɾ��
		String path = picture.getImage();// ���ͼƬ�ϴ���·���������ݿ��б����·��
		if (path != null) {// ������ϴ�ͼƬ����Ϊ������û���ϴ�ͼƬ�������
			// ��ȡ���̾���·��
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/" + path);
			File file = new File(realPath);// �ļ�����
			file.delete();// ���ϴ�������ͼƬɾ��
		}

		// ɾ��ͼƬ
		pictureService.delete(picture);
		// ҳ����ת
		return "deleteSuccess";
	}

	// �༭ͼƬ�ķ���
	public String edit() {
		// ���ݴ�������id��ѯ
		picture = pictureService.findByPid(picture.getPid());
		// ��ѯ���еĶ�������ļ���
		List<CategorySecond> csList = categorySecondService.findAll();
		// �����ݱ��浽ҳ�棬�����Ž�ֵջ��
		ActionContext.getContext().getValueStack().set("csList", csList);
		// ҳ����ת
		return "editSuccess";
	}

	// �޸ķ���
	public String update() throws IOException {// ���Ѿ�����������
		picture.setPdate(new Date());
		// �ļ��ϴ�
		if (upload != null) {
			// ȡ��ԭ��ͼƬ�ϴ���·��
			String path = picture.getImage();
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
			picture.setImage("pictures/" + uploadFileName);
		}
		// �޸�ͼƬ�����ݵ����ݿ�
		pictureService.update(picture);
		// ҳ����ת
		return "updateSuccess";
	}
}
