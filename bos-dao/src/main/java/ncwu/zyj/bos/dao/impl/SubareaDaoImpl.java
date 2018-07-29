package ncwu.zyj.bos.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import ncwu.zyj.bos.dao.ISubareaDao;
import ncwu.zyj.bos.domain.Subarea;
@Repository
public class SubareaDaoImpl extends BaseDaoImpl<Subarea> implements ISubareaDao {

	@Override
	public List<Object> findSubareasGroupByProvince() {
		String hql = "select r.province , count(*) from Subarea s left outer join s.region r group by r.province";
		return (List<Object>) this.getHibernateTemplate().find(hql);
	}


}
