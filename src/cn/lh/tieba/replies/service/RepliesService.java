package cn.lh.tieba.replies.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.lh.tieba.replies.dao.RepliesDao;
import cn.lh.tieba.replies.vo.Replies;
import cn.lh.tieba.utils.PageBean;

@Transactional
public class RepliesService {

	private RepliesDao repliesDao;

	public void setRepliesDao(RepliesDao repliesDao) {
		this.repliesDao = repliesDao;
	}

	// 根据评论查询相应回复
	public PageBean<Replies> findByPageInid(Integer inid, int page) {
		PageBean<Replies> pageBean = new PageBean<Replies>();
		// 设置当前页数
		pageBean.setPage(page);
		// 设置每页显示记录数
		int limit = 8;
		pageBean.setLimit(limit);
		// 设置总记录数
		int totalCount = 0;
		totalCount = repliesDao.findCountInid(inid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合
		int begin = (page - 1) * limit;
		List<Replies> list = repliesDao.findByPageInid(inid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	public void save(Replies replies) {
		repliesDao.save(replies);

	}

}
