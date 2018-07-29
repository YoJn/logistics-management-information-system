package ncwu.zyj.bos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ncwu.zyj.bos.dao.IRegionDao;
import ncwu.zyj.bos.domain.Region;
import ncwu.zyj.bos.service.IRegionService;
import ncwu.zyj.bos.utils.PageBean;
@Service
@Transactional
public class RegionServiceImpl implements IRegionService{
	@Autowired 
	private IRegionDao regionDao;
	@Override
	public void saveBatch(List<Region> list) {
		for (Region region : list) {
			regionDao.saveOrUpdate(region);
		}
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		regionDao.pageQuery(pageBean);
	}
	@Override
	public List<Region> findAll() {
		return regionDao.findAll();
	}
	@Override
	public List<Region> findListByQ(String q) {
		
		return regionDao.findListByQ(q);
	}

}
