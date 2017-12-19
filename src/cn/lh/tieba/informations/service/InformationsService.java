package cn.lh.tieba.informations.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.lh.tieba.informations.dao.InformationsDao;
import cn.lh.tieba.informations.vo.Informations;
import cn.lh.tieba.utils.PageBean;

@Transactional
public class InformationsService {

	private InformationsDao informationsDao;

	public void setInformationsDao(InformationsDao informationsDao) {
		this.informationsDao = informationsDao;
	}

	// 保存贴吧信息到数据库（通过Dao把值存进去）
	public void save(Informations informations) {
		informationsDao.save(informations);

	}

	public PageBean<Informations> findByPage(Integer page) {
		PageBean<Informations> pageBean = new PageBean<Informations>();
		// 设置当前页数
		pageBean.setPage(page);
		// 设置每页显示的记录数
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数
		int totalCount = informationsDao.findCount();
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
		List<Informations> list = informationsDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// 首页上显示最新贴吧信息
	public List<Informations> findNew() {
		return informationsDao.findNew();
	}

	// 我的贴的业务层
	public PageBean<Informations> findByPageUid(Integer uid, Integer page) {
		PageBean<Informations> pageBean = new PageBean<Informations>();
		// 设置当前页数
		pageBean.setPage(page);
		// 设置每页显示的记录数
		Integer limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数
		Integer totalCount = null;
		totalCount = informationsDao.findByCountUid(uid);// 根据用户的id统计该用户有多少贴
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		Integer totalPage = null;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据的集合
		Integer begin = (page - 1) * limit;
		List<Informations> list = informationsDao.findByPageUid(uid, begin,
				limit);
		pageBean.setList(list);
		return pageBean;
	}

	// 接收到Action传过来的id（通过对象获得）在把id给Dao层去查询
	public Informations findByInid(Integer inid) {
		return informationsDao.findByInid(inid);
	}

	// 删除贴吧信息
	public void delete(Informations informations) {
		informationsDao.delete(informations);

	}

}
