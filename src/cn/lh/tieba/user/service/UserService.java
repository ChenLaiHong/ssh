package cn.lh.tieba.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.lh.tieba.user.dao.UserDao;
import cn.lh.tieba.user.vo.User;
import cn.lh.tieba.utils.PageBean;

@Transactional
public class UserService {
	// 注入UserDAO
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// 按用户名查询用户的方法
	public User fingByUsername(String username) {
		return userDao.findByUserName(username);
	}

	// 业务层完成用户注册
	public void save(User user) {

		userDao.save(user);
	}

	// 用户登录
	public User login(User user) {

		return userDao.login(user);
	}

	// 业务层查询用户的方法
	public PageBean<User> findByPage(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		// 设置当前的页数
		pageBean.setPage(page);
		// 设置每页显示的记录数
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数
		int totalCount = userDao.findCount();
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
		List<User> list = userDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}
}
