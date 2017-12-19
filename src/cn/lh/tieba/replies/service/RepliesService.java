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

	// �������۲�ѯ��Ӧ�ظ�
	public PageBean<Replies> findByPageInid(Integer inid, int page) {
		PageBean<Replies> pageBean = new PageBean<Replies>();
		// ���õ�ǰҳ��
		pageBean.setPage(page);
		// ����ÿҳ��ʾ��¼��
		int limit = 8;
		pageBean.setLimit(limit);
		// �����ܼ�¼��
		int totalCount = 0;
		totalCount = repliesDao.findCountInid(inid);
		pageBean.setTotalCount(totalCount);
		// ������ҳ��
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ÿҳ��ʾ�����ݼ���
		int begin = (page - 1) * limit;
		List<Replies> list = repliesDao.findByPageInid(inid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	public void save(Replies replies) {
		repliesDao.save(replies);

	}

}
