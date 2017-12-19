package cn.lh.tieba.adminuser.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lh.tieba.adminuser.vo.AdminUser;

//后台登录Dao的类
public class AdminUserDao extends HibernateDaoSupport {
	// dao中登录的方法
	public AdminUser login(AdminUser adminUser) {// from后面跟的是后台用户的对象而不是数据库表名，hql是面向对象的
		String hql = "from AdminUser where username=? and password=?";// 根据用户名和密码查找到一个用户
		List<AdminUser> list = this.getHibernateTemplate().find(hql,
				adminUser.getUsername(), adminUser.getPassword());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
