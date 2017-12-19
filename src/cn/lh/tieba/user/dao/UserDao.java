package cn.lh.tieba.user.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lh.tieba.user.vo.User;
import cn.lh.tieba.utils.PageHibernateCallback;

public class UserDao extends HibernateDaoSupport {
	// 按名查询是否有该用户
	public User findByUserName(String username) {
		String hql = "from User where username=?";
		List<User> list = this.getHibernateTemplate().find(hql, username);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 注册用户存进数据库的实现
	public void save(User user) {
		this.getHibernateTemplate().save(user);

	}

	// 用户登录的方法
	public User login(User user) {
		String hql = "from User where username = ? and password=?";
		List<User> list = this.getHibernateTemplate().find(hql,
				user.getUsername(), user.getPassword());
		if (list != null && list.size() > 0) {
			// get(0)就是放回User对象
			return list.get(0);
		}
		return null;
	}

	// Dao层统计所以用户的个数的方法
	public int findCount() {
		String hql = "select count(*) from User";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	// Dao层带分页查询用户的方法
	public List<User> findByPage(int begin, int limit) {
		String hql = "from User order by uid desc";
		List<User> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<User>(hql, null, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}
}
