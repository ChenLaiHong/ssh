package cn.lh.tieba.category.adminaction;

import java.util.List;

import cn.lh.tieba.category.service.CategoryService;
import cn.lh.tieba.category.vo.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminCategoryAction extends ActionSupport implements
		ModelDriven<Category> {
	// 模型驱动需要使用到的对象
	private Category category = new Category();

	public Category getModel() {
		return category;
	}

	// 注入一级分类的Service
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// 后台执行查询所有一级分类的方法
	public String findAll() {
		// 查询所有一级分类
		List<Category> cList = categoryService.findAll();
		// 将数据存到值栈中然后再页面上显示
		ActionContext.getContext().getValueStack().set("cList", cList);

		return "findAll";
	}

	// 后台保存一级分类的方法
	public String save() {
		// 提交过来的一级分类的名称，直接用模型驱动的一个对象接收到了
		// 直接调用Service进行保存
		//
		categoryService.save(category);
		// 页面跳转
		return "saveSuccess";
	}

	// 后台删除一级分类的方法
	// 传递过来的cid模型驱动可以接收到
	public String delete() {
		// 接收cid，可以使用模型驱动，删除一级分类，同时删除二级分类，先根据id查询再进行删除
		category = categoryService.findByCid(category.getCid());
		// 删除
		categoryService.delete(category);
		// 页面跳转
		return "deleteSuccess";
	}

	// 后台编辑一级分类的方法
	public String edit() {// 方法名与路径那里的action后缀那个名字相同
		// 根据一级分类管理查询一级分类
		category = categoryService.findByCid(category.getCid());
		// 页面跳转
		return "editSuccess";// 返回值与struts里的Action的name属性相同
	}

	// 后台修改一级分类的方法
	public String update() {
		categoryService.update(category);
		// 页面跳转
		return "updateSuccess";
	}
}
