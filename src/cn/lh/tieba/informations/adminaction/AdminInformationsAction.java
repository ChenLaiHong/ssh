package cn.lh.tieba.informations.adminaction;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import cn.lh.tieba.informations.service.InformationsService;
import cn.lh.tieba.informations.vo.Informations;
import cn.lh.tieba.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//后台管理贴吧信息的Action
public class AdminInformationsAction extends ActionSupport implements
		ModelDriven<Informations> {
	// 模型驱动需要用到的对象
	private Informations informations = new Informations();

	public Informations getModel() {
		return informations;
	}

	// 注入其Service
	private InformationsService informationsService;

	public void setInformationsService(InformationsService informationsService) {
		this.informationsService = informationsService;
	}

	// 接收page
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// 查询贴吧所有信息的方法
	public String findAll() {
		PageBean<Informations> pageBean = informationsService.findByPage(page);
		// 将pageBean的数据存到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// 页面跳转
		return "findAll";
	}

	// 模型驱动已经接收到id，通过id来删除相应的图片
	public String delete() {
		// 先根据id查询再删除
		informations = informationsService.findByInid(informations.getInid());
		// 删除已经上传到文件夹中的图片，根据路径来删除
		String path = informations.getImage();// 获得图片上传的路径，即数据库中保存的路径
		if (path != null) {// 如果有上传图片（因为还存在没有上传图片的情况）
			// 获取磁盘绝对路径
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/" + path);
			File file = new File(realPath);// 新建一个文件对象
			file.delete();// 把上传的那张图片删除
		}
		informationsService.delete(informations);// 把相应的信息删除
		// 页面跳转
		return "deleteSuccess";
	}

}
