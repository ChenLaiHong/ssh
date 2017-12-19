package cn.lh.tieba.replies.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lh.tieba.replies.vo.Replies;
import cn.lh.tieba.utils.PageHibernateCallback;

public class RepliesDao extends HibernateDaoSupport {
	// 根据评论查询回复个数
	public int findCountInid(Integer inid) {
		String hql = "select count(*) from Replies r where r.informations.inid =?";
		List<Long> list = this.getHibernateTemplate().find(hql, inid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// 根据评论查询回复信息
	public List<Replies> findByPageInid(Integer inid, int begin, int limit) {
		String hql = "select r from Replies r join r.informations i where i.inid =? order by rdate desc";
		List<Replies> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Replies>(hql, new Object[] { inid },
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public void save(Replies replies) {
		this.getHibernateTemplate().save(replies);

	}

}
