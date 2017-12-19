package cn.lh.tieba.category.adminaction;

import java.util.List;

import cn.lh.tieba.category.service.CategoryService;
import cn.lh.tieba.category.vo.Category;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminCategoryAction extends ActionSupport implements
		ModelDriven<Category> {
	// ģ��������Ҫʹ�õ��Ķ���
	private Category category = new Category();

	public Category getModel() {
		return category;
	}

	// ע��һ�������Service
	private CategoryService categoryService;

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	// ��ִ̨�в�ѯ����һ������ķ���
	public String findAll() {
		// ��ѯ����һ������
		List<Category> cList = categoryService.findAll();
		// �����ݴ浽ֵջ��Ȼ����ҳ������ʾ
		ActionContext.getContext().getValueStack().set("cList", cList);

		return "findAll";
	}

	// ��̨����һ������ķ���
	public String save() {
		// �ύ������һ����������ƣ�ֱ����ģ��������һ��������յ���
		// ֱ�ӵ���Service���б���
		//
		categoryService.save(category);
		// ҳ����ת
		return "saveSuccess";
	}

	// ��̨ɾ��һ������ķ���
	// ���ݹ�����cidģ���������Խ��յ�
	public String delete() {
		// ����cid������ʹ��ģ��������ɾ��һ�����࣬ͬʱɾ���������࣬�ȸ���id��ѯ�ٽ���ɾ��
		category = categoryService.findByCid(category.getCid());
		// ɾ��
		categoryService.delete(category);
		// ҳ����ת
		return "deleteSuccess";
	}

	// ��̨�༭һ������ķ���
	public String edit() {// ��������·�������action��׺�Ǹ�������ͬ
		// ����һ����������ѯһ������
		category = categoryService.findByCid(category.getCid());
		// ҳ����ת
		return "editSuccess";// ����ֵ��struts���Action��name������ͬ
	}

	// ��̨�޸�һ������ķ���
	public String update() {
		categoryService.update(category);
		// ҳ����ת
		return "updateSuccess";
	}
}
