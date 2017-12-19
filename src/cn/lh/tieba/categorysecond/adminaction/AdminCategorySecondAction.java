package cn.lh.tieba.categorysecond.adminaction;

import java.util.List;

import cn.lh.tieba.category.service.CategoryService;
import cn.lh.tieba.category.vo.Category;
import cn.lh.tieba.categorysecond.service.CategorySecondService;
import cn.lh.tieba.categorysecond.vo.CategorySecond;
import cn.lh.tieba.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//��̨������������Action
public class AdminCategorySecondAction extends ActionSupport implements
		ModelDriven<CategorySecond> {
	// ģ������ʹ�õĶ���
	private CategorySecond categorySecond = new CategorySecond();

	public CategorySecond getModel() {
		return categorySecond;
	}

	// ע����������Service
	private CategorySecondService categorySecondService;

	public void setCategorySecondService(
			CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	// ����page
	private Integer page;

	public void setPage(Integer page) {
		this.page = page;
	}

	// ��Ҫ֪����������������һ�����࣬����Ҫע��һ�������Service
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// ��ѯ��������ķ���
	public String findAll() {
		PageBean<CategorySecond> pageBean = categorySecondService
				.findByPage(page);
		// ��pageBean�����ݴ浽ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		// ҳ����ת
		return "findAll";
	}

	// ��ת�����ҳ��
	public String addPage() {
		// ��ѯ����һ������
		List<Category> cList = categoryService.findAll();
		// ��������ʾ��ҳ��������б���
		ActionContext.getContext().getValueStack().set("cList", cList);
		// ҳ����ת
		return "addPageSuccess";
	}

	// �����������ķ���
	public String save() {
		categorySecondService.save(categorySecond);
		// ҳ����ת
		return "saveSuccess";
	}

	// ɾ����������ķ���
	public String delete() {
		// �Ȳ�ѯ��ɾ��
		categorySecond = categorySecondService.findByCsid(categorySecond
				.getCsid());
		categorySecondService.delete(categorySecond);
		// ҳ����ת
		return "deleteSuccess";
	}

	// �༭��������ķ���
	public String edit() {
		// ���ݶ��������id�鵽�����������
		categorySecond = categorySecondService.findByCsid(categorySecond
				.getCsid());
		// ��ѯ����һ������
		List<Category> cList = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("cList", cList);// ���浽ֵջ��
		// ҳ����ת
		return "editSuccess";
	}

	// �޸Ķ�������ķ���
	public String update() {
		categorySecondService.update(categorySecond);
		// ҳ����ת
		return "updateSuccess";
	}
}
