package cn.lh.tieba.adminuser.service;

import org.springframework.transaction.annotation.Transactional;

import cn.lh.tieba.adminuser.dao.AdminUserDao;
import cn.lh.tieba.adminuser.vo.AdminUser;

//后台登录的业务层类
@Transactional
public class AdminUserService {
	// 注入Dao
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	// 业务层登录的方法
	public AdminUser login(AdminUser adminUser) {

		return adminUserDao.login(adminUser);
	}

}
