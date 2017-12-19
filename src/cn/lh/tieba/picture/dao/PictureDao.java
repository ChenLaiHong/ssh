package cn.lh.tieba.picture.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lh.tieba.picture.vo.Picture;
import cn.lh.tieba.utils.PageHibernateCallback;

public class PictureDao extends HibernateDaoSupport {

	// 根据ID查询图片
	public Picture findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Picture.class, pid);
	}

	// 根据分类的ID查询个数
	public int findCountCid(Integer cid) {

		String hql = "select count(*) from Picture p where p.categorySecond.category.cid=?";
		List<Long> list = this.getHibernateTemplate().find(hql, cid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;

	}

	public List<Picture> findByPageCid(Integer cid, int begin, int limit) {

		String hql = "select p from Picture p join p.categorySecond cs join cs.category c where c.cid=?";
		// 分页
		List<Picture> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Picture>(hql, new Object[] { cid },
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// 根据二级分类查询个数
	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Picture p where p.categorySecond.csid=?";
		List<Long> list = this.getHibernateTemplate().find(hql, csid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// 根据二级分类查询
	public List<Picture> findByPageCsid(Integer csid, int begin, int limit) {
		String hql = "select p from Picture p join p.categorySecond cs where cs.csid =?";
		List<Picture> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Picture>(hql, new Object[] { csid },
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// Dao层查找图片统计个数
	public int findCount() {
		String hql = "select count(*) from Picture";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// 带分页查询图片的方法
	public List<Picture> findByPage(int begin, int limit) {
		String hql = "from Picture order by pdate desc";// 按上传时间倒序排
		List<Picture> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Picture>(hql, null, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// Dao层保存图片的方法
	public void save(Picture picture) {
		this.getHibernateTemplate().save(picture);

	}

	// Dao层删除图片
	public void delete(Picture picture) {
		this.getHibernateTemplate().delete(picture);

	}

	// Dao层修改图片
	public void update(Picture picture) {
		this.getHibernateTemplate().update(picture);
	}

}
