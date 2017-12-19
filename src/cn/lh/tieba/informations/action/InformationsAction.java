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

	// 文件上传需要的参数
	private File upload;// 上传的文件（文件名要与表单中的名字一致）
	private String uploadFileName;// 接收文件上传的文件名
	private String uploadContextType;// 接收文件的文件的类型

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}

	// 保存信息到数据库
	public String save() throws IOException {
		// 获取到已经登录的用户
		User existUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		if (existUser == null) {// 如果还没有登录
			this.addActionError("您还没有登录！请先登录！");
			// 还没登录则先跳转到登录页面
			return "login";
		}
		if (upload != null) {
			// 获得文件上传的磁盘绝对路径
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/pictures");// 图片存放的路径
			// 创建一个文件
			File diskFile = new File(realPath + "//" + uploadFileName);
			// 文件上传
			FileUtils.copyFile(upload, diskFile);
			informations.setImage("pictures/" + uploadFileName);// 数据库中的图片的路径
		}
		informations.setIdate(new Date());// 获取系统时间
		informations.setUser(existUser);// 把所属的用户存进去
		informationsService.save(informations);// 保存
		// 页面跳转
		return "saveSuccess";
	}

	public String findAll() {
		// 查询数据库中贴吧评论
		PageBean<Informations> pageBean = informationsService.findByPage(page);
		// 将数据传递到页面上
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}

	// 我的贴的查询
	public String findByUid() {
		// 获得当前用户的id查询(用户登录的时候就存到session中）
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		// 调用service
		PageBean<Informations> pageBean = informationsService.findByPageUid(
				user.getUid(), page);// 通过用户获得对应的id
		// 将分页数据放到值栈显示到页面
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// 页面跳转
		return "findByUidSuccess";
	}

	public String delete() {
		// 先根据id查询再删除
		informations = informationsService.findByInid(informations.getInid());
		// 删除已经上传到文件夹中的图片，根据路径来删除
		String path = informations.getImage();// 获得图片上传的路径，即数据库中保存的路径
		if (path != null) {// 如果有上传图片（因为还存在没有上传图片的情况）
			// 获取磁盘绝对路径
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/" + path);
			File file = new File(realPath);// 文件对象
			file.delete();// 把上传的那张图片删除
		}

		// 删除图片
		informationsService.delete(informations);
		// 页面跳转
		return "deleteSuccess";
	}
}
