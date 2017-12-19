package cn.lh.tieba.picture.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.lh.tieba.picture.dao.PictureDao;
import cn.lh.tieba.picture.vo.Picture;
import cn.lh.tieba.utils.PageBean;

@Transactional
public class PictureService {
	// ע��PictureDao
	private PictureDao pictureDao;

	public void setPictureDao(PictureDao pictureDao) {
		this.pictureDao = pictureDao;
	}

	// ������ƷID��ѯ��Ʒ
	public Picture findByPid(Integer pid) {
		return pictureDao.findByPid(pid);
	}

	// ����һ�������cid���з�ҳ��ѯ��Ʒ
	public PageBean<Picture> findByPageCid(Integer cid, int page) {
		PageBean<Picture> pageBean = new PageBean<Picture>();
		// ���õ�ǰҳ��
		pageBean.setPage(page);
		// ����ÿҳ��ʾ��¼��
		int limit = 8;
		pageBean.setLimit(limit);
		// �����ܼ�¼��
		int totalCount = 0;
		totalCount = pictureDao.findCountCid(cid);
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
		List<Picture> list = pictureDao.findByPageCid(cid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// ���ݶ��������ѯ
	public PageBean<Picture> findByPageCsid(Integer csid, int page) {
		PageBean<Picture> pageBean = new PageBean<Picture>();
		// ���õ�ǰҳ��
		pageBean.setPage(page);
		// ����ÿҳ��ʾ��¼��
		int limit = 4;
		pageBean.setLimit(limit);
		// �����ܼ�¼��
		int totalCount = 0;
		totalCount = pictureDao.findCountCsid(csid);
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
		List<Picture> list = pictureDao.findByPageCsid(csid, begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// ҵ������ҳ��ѯͼƬ
	public PageBean<Picture> findByPage(Integer page) {
		PageBean<Picture> pageBean = new PageBean<Picture>();
		// ���õ�ǰ��ҳ��
		pageBean.setPage(page);
		// ����ÿҳ��ʾ�ļ�¼��
		int limit = 10;
		pageBean.setLimit(limit);
		// �����ܼ�¼��
		int totalCount = pictureDao.findCount();
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
		List<Picture> list = pictureDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// ҵ��㱣��ͼƬ�ķ���
	public void save(Picture picture) {
		pictureDao.save(picture);

	}

	// ҵ���ɾ��ͼƬ��Ϣ�ķ���
	public void delete(Picture picture) {
		pictureDao.delete(picture);

	}

	// ҵ����޸�ͼƬ�ķ���
	public void update(Picture picture) {
		pictureDao.update(picture);

	}

}
