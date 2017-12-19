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

	// 接收评论的id
	private Integer inid;

	public Integer getInid() {
		return inid;
	}

	public void setInid(Integer inid) {
		this.inid = inid;
	}

	// 接受当前页数
	private int page;

	public void setPage(int page) {
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

	public String findByInid() {
		// 根据评论查询相应的回复
		PageBean<Replies> pageBean = repliesService.findByPageInid(inid, page);
		// 将PageBean的信息存到值栈中带到页面上
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// 页面跳转
		return "findByInid";
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
			replies.setImage("pictures/" + uploadFileName);// 数据库中的图片的路径
		}
		replies.setRdate(new Date());// 获取系统时间
		replies.setInformations(informations);
		repliesService.save(replies);// 保存
		// 页面跳转
		return "saveSuccess";
	}

}
