package cn.lh.tieba.picture.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lh.tieba.picture.vo.Picture;
import cn.lh.tieba.utils.PageHibernateCallback;

public class PictureDao extends HibernateDaoSupport {

	// ����ID��ѯͼƬ
	public Picture findByPid(Integer pid) {
		return this.getHibernateTemplate().get(Picture.class, pid);
	}

	// ���ݷ����ID��ѯ����
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
		// ��ҳ
		List<Picture> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Picture>(hql, new Object[] { cid },
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// ���ݶ��������ѯ����
	public int findCountCsid(Integer csid) {
		String hql = "select count(*) from Picture p where p.categorySecond.csid=?";
		List<Long> list = this.getHibernateTemplate().find(hql, csid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// ���ݶ��������ѯ
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

	// Dao�����ͼƬͳ�Ƹ���
	public int findCount() {
		String hql = "select count(*) from Picture";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// ����ҳ��ѯͼƬ�ķ���
	public List<Picture> findByPage(int begin, int limit) {
		String hql = "from Picture order by pdate desc";// ���ϴ�ʱ�䵹����
		List<Picture> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Picture>(hql, null, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// Dao�㱣��ͼƬ�ķ���
	public void save(Picture picture) {
		this.getHibernateTemplate().save(picture);

	}

	// Dao��ɾ��ͼƬ
	public void delete(Picture picture) {
		this.getHibernateTemplate().delete(picture);

	}

	// Dao���޸�ͼƬ
	public void update(Picture picture) {
		this.getHibernateTemplate().update(picture);
	}

}
