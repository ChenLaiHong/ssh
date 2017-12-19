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

	// ����������Ϣ�����ݿ⣨ͨ��Dao��ֵ���ȥ��
	public void save(Informations informations) {
		informationsDao.save(informations);

	}

	public PageBean<Informations> findByPage(Integer page) {
		PageBean<Informations> pageBean = new PageBean<Informations>();
		// ���õ�ǰҳ��
		pageBean.setPage(page);
		// ����ÿҳ��ʾ�ļ�¼��
		int limit = 10;
		pageBean.setLimit(limit);
		// �����ܼ�¼��
		int totalCount = informationsDao.findCount();
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
		List<Informations> list = informationsDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// ��ҳ����ʾ����������Ϣ
	public List<Informations> findNew() {
		return informationsDao.findNew();
	}

	// �ҵ�����ҵ���
	public PageBean<Informations> findByPageUid(Integer uid, Integer page) {
		PageBean<Informations> pageBean = new PageBean<Informations>();
		// ���õ�ǰҳ��
		pageBean.setPage(page);
		// ����ÿҳ��ʾ�ļ�¼��
		Integer limit = 10;
		pageBean.setLimit(limit);
		// �����ܼ�¼��
		Integer totalCount = null;
		totalCount = informationsDao.findByCountUid(uid);// �����û���idͳ�Ƹ��û��ж�����
		pageBean.setTotalCount(totalCount);
		// ������ҳ��
		Integer totalPage = null;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ����ÿҳ��ʾ���ݵļ���
		Integer begin = (page - 1) * limit;
		List<Informations> list = informationsDao.findByPageUid(uid, begin,
				limit);
		pageBean.setList(list);
		return pageBean;
	}

	// ���յ�Action��������id��ͨ�������ã��ڰ�id��Dao��ȥ��ѯ
	public Informations findByInid(Integer inid) {
		return informationsDao.findByInid(inid);
	}

	// ɾ��������Ϣ
	public void delete(Informations informations) {
		informationsDao.delete(informations);

	}

}
