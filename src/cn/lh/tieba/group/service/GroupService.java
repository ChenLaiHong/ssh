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
		// 设置当前页数
		pageBean.setPage(page);
		// 设置每页显示的记录数
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数
		int totalCount = groupDao.findCount();
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
		List<Group> list = groupDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// 业务层保存群组信息
	public void save(Group group) {
		groupDao.save(group);

	}

	// 根据id查询群组
	public Group findByGid(Integer gid) {
		return groupDao.findByGid(gid);
	}

	public void delete(Group group) {
		groupDao.delete(group);

	}

	// 业务层修改群组
	public void update(Group group) {
		groupDao.update(group);

	}

}
