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
	// 模型驱动需要用到的对象
	private Picture picture = new Picture();

	public Picture getModel() {
		return picture;
	}

	private PictureService pictureService;

	public void setPictureService(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	// 接受分类的cid
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

	// 注入一级分类的service
	private CategoryService categoryService;
	// 接受当前页数
	private int page;

	public void setPage(int page) {
		this.page = page;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// 根据ID进行查询图片:执行方法:
	public String findByPid() {
		// 调用Service的方法完成查询.
		picture = pictureService.findByPid(picture.getPid());
		return "findByPid";
	}

	// 根据分类的id查询
	public String findByCid() {

		PageBean<Picture> pageBean = pictureService.findByPageCid(cid, page);// 根据一级分类查询，带分页查询
		// 将PageBean存入值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCid";
	}

	// 根据二级分类的id去查询
	public String findByCsid() {
		PageBean<Picture> pageBean = pictureService.findByPageCsid(csid, page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByCsid";
	}

}
