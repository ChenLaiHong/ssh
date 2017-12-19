package cn.lh.tieba.categorysecond.service;

import java.util.List;

import cn.lh.tieba.categorysecond.dao.CategorySecondDao;
import cn.lh.tieba.categorysecond.vo.CategorySecond;
import cn.lh.tieba.utils.PageBean;

//二级分类管理的业务层类
public class CategorySecondService {
	// 注入二级分类的Dao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	// 业务层分页查询二级分类的方法
	public PageBean<CategorySecond> findByPage(Integer page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		// 设置当前页数
		pageBean.setPage(page);
		// 设置每页显示的记录数
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;

		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合
		int begin = (page - 1) * limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// 业务层保存二级分类的方法
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);

	}

	// 业务层根据二级分类的id去查询二级分类
	public CategorySecond findByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}

	// 业务层删除二级分类的方法
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);

	}

	// 业务层修改二级分类的方法
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);

	}

	// 业务层查询所有二级分类的方法
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}

}
