package cn.lh.tieba.picture.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.lh.tieba.picture.dao.PictureDao;
import cn.lh.tieba.picture.vo.Picture;
import cn.lh.tieba.utils.PageBean;

@Transactional
public class PictureService {
	// 注入PictureDao
	private PictureDao pictureDao;

	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}

	// 根据商品ID查询商品
	public Picture findByPid(Integer pid) {
		return pictureDao.findByPid(pid);
	}

	// 根据一级分类的cid带有分页查询商品
	public PageBean<Picture> findByPageCid(Integer cid, int page) {
		PageBean<Picture> pageBean = new PageBean<Picture>();
		// 设置当前页数
		pageBean.setPage(page);
		// 设置每页显示记录数
		int limit = 8;
		pageBean.setLimit(limit);
		// 设置总记录数
		int totalCount = 0;
		totalCount = pictureDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合
		int begin = (page - 1) * limit;
		List<Picture> list = pictureDao.findByPageCid(cid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// 根据二级分类查询
	public PageBean<Picture> findByPageCsid(Integer csid, int page) {
		PageBean<Picture> pageBean = new PageBean<Picture>();
		// 设置当前页数
		pageBean.setPage(page);
		// 设置每页显示记录数
		int limit = 4;
		pageBean.setLimit(limit);
		// 设置总记录数
		int totalCount = 0;
		totalCount = pictureDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合
		int begin = (page - 1) * limit;
		List<Picture> list = pictureDao.findByPageCsid(csid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// 业务层带分页查询图片
	public PageBean<Picture> findByPage(Integer page) {
		PageBean<Picture> pageBean = new PageBean<Picture>();
		// 设置当前的页数
		pageBean.setPage(page);
		// 设置每页显示的记录数
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数
		int totalCount = pictureDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置显示到页面的数据的集合
		int begin = (page - 1) * limit;
		List<Picture> list = pictureDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// 业务层保存图片的方法
	public void save(Picture picture) {
		pictureDao.save(picture);

	}

	// 业务层删除图片信息的方法
	public void delete(Picture picture) {
		pictureDao.delete(picture);

	}

	// 业务层修改图片的方法
	public void update(Picture picture) {
		pictureDao.update(picture);

	}

}
