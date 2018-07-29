package ncwu.zyj.bos.dao;

import java.util.List;

import ncwu.zyj.bos.domain.Region;

public interface IRegionDao extends IBaseDao<Region> {

	List<Region> findListByQ(String q);

}
