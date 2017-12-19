package cn.lh.tieba.adminuser.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.lh.tieba.adminuser.vo.AdminUser;

//��̨��¼Dao����
public class AdminUserDao extends HibernateDaoSupport {
	// dao�е�¼�ķ���
	public AdminUser login(AdminUser adminUser) {// from��������Ǻ�̨�û��Ķ�����������ݿ������hql����������
		String hql = "from AdminUser where username=? and password=?";// �����û�����������ҵ�һ���û�
		List<AdminUser> list = this.getHibernateTemplate().find(hql,
				adminUser.getUsername(), adminUser.getPassword());
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
