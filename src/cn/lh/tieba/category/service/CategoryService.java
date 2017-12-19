package cn.lh.tieba.category.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.lh.tieba.category.dao.CategoryDao;
import cn.lh.tieba.category.vo.Category;

@Transactional
public class CategoryService {
	// ע��CategoryDao
	private CategoryDao categoryDao;

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	// ҵ����ѯ����һ������ķ���
	public List<Category> findAll() {

		return categoryDao.findAll();
	}

	// ҵ��㱣��һ������ķ���
	public void save(Category category) {
		// ͨ������Dao��ɱ���Ĳ���
		categoryDao.save(category);

	}

	// ҵ������cid��ѯһ������
	public Category findByCid(Integer cid) {

		return categoryDao.findByCid(cid);
	}

	// ҵ���ɾ��һ������ķ���
	public void delete(Category category) {
		categoryDao.delete(category);

	}

	// ҵ����޸�һ������ķ���
	public void update(Category category) {
		categoryDao.update(category);

	}

}
