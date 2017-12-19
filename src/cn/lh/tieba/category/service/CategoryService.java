package cn.lh.tieba.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.lh.tieba.category.dao.CategoryDao;
import cn.lh.tieba.category.vo.Category;

@Transactional
public class CategoryService {
	// 注入CategoryDao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	// 业务层查询所有一级分类的方法
	public List<Category> findAll() {

		return categoryDao.findAll();
	}

	// 业务层保存一级分类的方法
	public void save(Category category) {
		// 通过调用Dao完成保存的操作
		categoryDao.save(category);

	}

	// 业务层根据cid查询一级分类
	public Category findByCid(Integer cid) {

		return categoryDao.findByCid(cid);
	}

	// 业务层删除一级分类的方法
	public void delete(Category category) {
		categoryDao.delete(category);

	}

	// 业务层修改一级分类的方法
	public void update(Category category) {
		categoryDao.update(category);

	}

}
