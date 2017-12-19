package cn.lh.tieba.user.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.lh.tieba.user.dao.UserDao;
import cn.lh.tieba.user.vo.User;
import cn.lh.tieba.utils.PageBean;

@Transactional
public class UserService {
	// ע��UserDAO
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	// ���û�����ѯ�û��ķ���
	public User fingByUsername(String username) {
		return userDao.findByUserName(username);
	}

	// ҵ�������û�ע��
	public void save(User user) {

		userDao.save(user);
	}

	// �û���¼
	public User login(User user) {

		return userDao.login(user);
	}

	// ҵ����ѯ�û��ķ���
	public PageBean<User> findByPage(Integer page) {
		PageBean<User> pageBean = new PageBean<User>();
		// ���õ�ǰ��ҳ��
		pageBean.setPage(page);
		// ����ÿҳ��ʾ�ļ�¼��
		int limit = 10;
		pageBean.setLimit(limit);
		// �����ܼ�¼��
		int totalCount = userDao.findCount();
		pageBean.setTotalCount(totalCount);
		// ������ҳ��
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ������ʾ��ҳ������ݵļ���
		int begin = (page - 1) * limit;
		List<User> list = userDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}
}
