package cn.lh.tieba.adminuser.service;

import org.springframework.transaction.annotation.Transactional;

import cn.lh.tieba.adminuser.dao.AdminUserDao;
import cn.lh.tieba.adminuser.vo.AdminUser;

//��̨��¼��ҵ�����
@Transactional
public class AdminUserService {
	// ע��Dao
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	// ҵ����¼�ķ���
	public AdminUser login(AdminUser adminUser) {

		return adminUserDao.login(adminUser);
	}

}
