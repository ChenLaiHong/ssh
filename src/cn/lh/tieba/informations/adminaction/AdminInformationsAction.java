package cn.lh.tieba.informations.adminaction;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import cn.lh.tieba.informations.service.InformationsService;
import cn.lh.tieba.informations.vo.Informations;
import cn.lh.tieba.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//��̨����������Ϣ��Action
public class AdminInformationsAction extends ActionSupport implements
		ModelDriven<Informations> {
	// ģ��������Ҫ�õ��Ķ���
	private Informations informations = new Informations();

	public Informations getModel() {
		return informations;
	}

	// ע����Service
	private InformationsService informationsService;

	public void setInformationsService(InformationsService informationsService) {
		this.informationsService = informationsService;
	}

	// ����page
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// ��ѯ����������Ϣ�ķ���
	public String findAll() {
		PageBean<Informations> pageBean = informationsService.findByPage(page);
		// ��pageBean�����ݴ浽ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// ҳ����ת
		return "findAll";
	}

	// ģ�������Ѿ����յ�id��ͨ��id��ɾ����Ӧ��ͼƬ
	public String delete() {
		// �ȸ���id��ѯ��ɾ��
		informations = informationsService.findByInid(informations.getInid());
		// ɾ���Ѿ��ϴ����ļ����е�ͼƬ������·����ɾ��
		String path = informations.getImage();// ���ͼƬ�ϴ���·���������ݿ��б����·��
		if (path != null) {// ������ϴ�ͼƬ����Ϊ������û���ϴ�ͼƬ�������
			// ��ȡ���̾���·��
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/" + path);
			File file = new File(realPath);// �½�һ���ļ�����
			file.delete();// ���ϴ�������ͼƬɾ��
		}
		informationsService.delete(informations);// ����Ӧ����Ϣɾ��
		// ҳ����ת
		return "deleteSuccess";
	}

}
