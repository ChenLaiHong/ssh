package cn.lh.tieba.picture.action;

import cn.lh.tieba.category.service.CategoryService;
import cn.lh.tieba.picture.service.PictureService;
import cn.lh.tieba.picture.vo.Picture;
import cn.lh.tieba.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PictureAction extends ActionSupport implements
		ModelDriven<Picture> {
	// ģ��������Ҫ�õ��Ķ���
	private Picture picture = new Picture();

	public Picture getModel() {
		return picture;
	}

	private PictureService pictureService;

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	// ���ܷ����cid
	private Integer cid;
	private Integer csid;

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCid() {
		return cid;
	}

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	// ע��һ�������service
	private CategoryService categoryService;
	// ���ܵ�ǰҳ��
	private int page;

	public void setPage(int page) {
		this.page = page;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// ����ID���в�ѯͼƬ:ִ�з���:
	public String findByPid() {
		// ����Service�ķ�����ɲ�ѯ.
		picture = pictureService.findByPid(picture.getPid());
		return "findByPid";
	}

	// ���ݷ����id��ѯ
	public String findByCid() {

		PageBean<Picture> pageBean = pictureService.findByPageCid(cid, page);// ����һ�������ѯ������ҳ��ѯ
		// ��PageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}

	// ���ݶ��������idȥ��ѯ
	public String findByCsid() {
		PageBean<Picture> pageBean = pictureService.findByPageCsid(csid, page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
	}

}
