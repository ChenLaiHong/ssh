package cn.lh.tieba.group.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.lh.tieba.group.dao.GroupDao;
import cn.lh.tieba.group.vo.Group;
import cn.lh.tieba.utils.PageBean;

@Transactional
public class GroupService {

	private GroupDao groupDao;

	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	// public List<Group> findAll() {
	// return groupDao.findAll();
	// }

	public PageBean<Group> findByPage(Integer page) {
		PageBean<Group> pageBean = new PageBean<Group>();
		// ���õ�ǰҳ��
		pageBean.setPage(page);
		// ����ÿҳ��ʾ�ļ�¼��
		int limit = 10;
		pageBean.setLimit(limit);
		// �����ܼ�¼��
		int totalCount = groupDao.findCount();
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
		List<Group> list = groupDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// ҵ��㱣��Ⱥ����Ϣ
	public void save(Group group) {
		groupDao.save(group);

	}

	// ����id��ѯȺ��
	public Group findByGid(Integer gid) {
		return groupDao.findByGid(gid);
	}

	public void delete(Group group) {
		groupDao.delete(group);

	}

	// ҵ����޸�Ⱥ��
	public void update(Group group) {
		groupDao.update(group);

	}

}
