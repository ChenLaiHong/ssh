package cn.lh.tieba.categorysecond.service;

import java.util.List;

import cn.lh.tieba.categorysecond.dao.CategorySecondDao;
import cn.lh.tieba.categorysecond.vo.CategorySecond;
import cn.lh.tieba.utils.PageBean;

//������������ҵ�����
public class CategorySecondService {
	// ע����������Dao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	// ҵ����ҳ��ѯ��������ķ���
	public PageBean<CategorySecond> findByPage(Integer page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();
		// ���õ�ǰҳ��
		pageBean.setPage(page);
		// ����ÿҳ��ʾ�ļ�¼��
		int limit = 10;
		pageBean.setLimit(limit);
		// �����ܼ�¼��
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		// ������ҳ��
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;

		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ����ÿҳ��ʾ���ݼ���
		int begin = (page - 1) * limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// ҵ��㱣���������ķ���
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);

	}

	// ҵ�����ݶ��������idȥ��ѯ��������
	public CategorySecond findByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}

	// ҵ���ɾ����������ķ���
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);

	}

	// ҵ����޸Ķ�������ķ���
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);

	}

	// ҵ����ѯ���ж�������ķ���
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}

}
