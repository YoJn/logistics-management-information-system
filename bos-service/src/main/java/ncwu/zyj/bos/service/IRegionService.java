package ncwu.zyj.bos.service;

import java.util.List;

import ncwu.zyj.bos.domain.Region;
import ncwu.zyj.bos.utils.PageBean;

public interface IRegionService {

	void saveBatch(List<Region> list);

	void pageQuery(PageBean pageBean);

	List<Region> findAll();

	List<Region> findListByQ(String q);


}
