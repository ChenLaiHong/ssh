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

	// 注入group的service
	private GroupService groupService;

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	// 接收page参数
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

	// 后台查询所有群组的方法
	public String findAll() {
		// 调用Service完成查询
		PageBean<Group> pageBean = groupService.findByPage(page);
		// 将数据传到页面上（使用值栈）
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// 页面跳转
		return "findAll";
	}

	// 跳转到添加页面
	public String addPage() {

		// 页面跳转
		return "addPageSuccess";
	}

	// 保存群组的方法
	public String save() throws IOException {
		// 调用service完成保存操作
		group.setGdate(new Date());
		if (upload != null) {
			// 获得文件上传的磁盘绝对路径
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/pictures");// 图片存放的路径
			// 创建一个文件
			File diskFile = new File(realPath + "//" + uploadFileName);
			// 文件上传
			FileUtils.copyFile(upload, diskFile);
			group.setImage("pictures/" + uploadFileName);// 数据库中的图片的路径
		}
		// 将数据保存到数据库
		groupService.save(group);
		// 页面跳转
		return "saveSuccess";
	}

	// 模型驱动已经接收到id，通过id来删除相应的图片
	public String delete() {
		// 先根据id查询再删除
		group = groupService.findByGid(group.getGid());
		// 删除已经上传到文件夹中的图片，根据路径来删除
		String path = group.getImage();// 获得图片上传的路径，即数据库中保存的路径
		if (path != null) {// 如果有上传图片（因为还存在没有上传图片的情况）
			// 获取磁盘绝对路径
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/" + path);
			File file = new File(realPath);// 文件对象
			file.delete();// 把上传的那张图片删除
		}

		// 删除图片
		groupService.delete(group);
		// 页面跳转
		return "deleteSuccess";
	}

	// 编辑图片的方法
	public String edit() {
		// 根据传过来的id查询
		group = groupService.findByGid(group.getGid());

		// 页面跳转
		return "editSuccess";
	}

	// 修改方法
	public String update() throws IOException {// 表单已经传过来数据
		group.setGdate(new Date());
		// 文件上传
		if (upload != null) {
			// 取得原来图片上传的路径
			String path = group.getImage();
			File file = new File(ServletActionContext.getServletContext()
					.getRealPath("/" + path));
			file.delete();// 将原来上传的图片删除
			// 获得文件上传磁盘的绝对路径
			String realPath = ServletActionContext.getServletContext()
					.getRealPath("/pictures");
			// 服务器本地上的文件
			File diskFile = new File(realPath + "//" + uploadFileName);
			// 使用工具类
			FileUtils.copyFile(upload, diskFile);
			// 如果上传了则要改变原来的图片路径跟名字
			group.setImage("pictures/" + uploadFileName);
		}
		// 修改图片的数据到数据库
		groupService.update(group);
		// 页面跳转
		return "updateSuccess";
	}

}
